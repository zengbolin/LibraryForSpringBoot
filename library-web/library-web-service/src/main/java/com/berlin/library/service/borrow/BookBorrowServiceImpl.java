package com.berlin.library.service.borrow;

import com.berlin.library.api.constants.ResultDTO;
import com.berlin.library.api.enums.HttpCode;
import com.berlin.library.api.enums.ValidFlagEnum;
import com.berlin.library.api.model.book.BookDTO;
import com.berlin.library.api.model.borrow.BookBorrowDTO;
import com.berlin.library.api.service.borrow.BookBorrowService;
import com.berlin.library.dao.mapper.book.BookMapper;
import com.berlin.library.dao.mapper.borrow.BookBorrowMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.Date;

/**
 * 借书service接口实现类
 *
 * @author ZengBerlin
 * @date 2020/12/23 10:51
 * @Email: 15102019493@163.com
 */
@Service
public class BookBorrowServiceImpl implements BookBorrowService {

    @Autowired
    private BookBorrowMapper mapper;

    @Autowired
    private BookMapper bookMapper;

    // 设置最大借阅时长
    final long lengthOfDay = 60;


    @Override
    public ResultDTO doBookBorrow(String bookName, int bookId, Date startDate, Date endDate, int borrowCount, int userId, String userName) {
        // 判断借书编号合法性
        if (0 >= bookId) {
            return new ResultDTO(HttpCode.FAIL.getCode(), "书籍编号不合法，请确认所选书籍是否存在！");
        }

        // 检验日期合法性
        if (startDate.after(endDate)) {
            return new ResultDTO(HttpCode.FAIL.getCode(), "起始日期不能晚于归还日期！");
        }

        // Step2: 查找书籍信息
        if (borrowCount <= 0) {
            return new ResultDTO(HttpCode.FAIL.getCode(), "借书数量需要大于0~");
        }

        BookDTO bookDTO = bookMapper.findById(bookId);
        // 书籍存在性判断
        if (null == bookDTO) {
            return new ResultDTO(HttpCode.FAIL.getCode(), "书籍不存在");
        }
        // 书籍数量判断
        int bookCount = bookDTO.getBookCount();
        if (0 >= bookCount) {
            // TODO 在查找书籍的时候如果返回书籍数量为0，前端直接禁用租借按钮，同时加一个效果：当前书籍可租借数量为0
            return new ResultDTO(HttpCode.FAIL.getCode(), "当前书籍已被租借光了，请看看别的书吧~");
        }

        int result = doInsertBookBorrowRecord(bookId, bookName, borrowCount, startDate,
                endDate, userId, userName, bookDTO);
        if (result <= 0) {
            // 新增失败
            return new ResultDTO(HttpCode.FAIL.getCode(), "借书失败，您可以尝试重新借书，或者联系图书管理员处理。");
        }
        // Step4: 新增成功，减少书籍数量
        bookDTO.setBookCount(bookCount - borrowCount);
        bookDTO.setUpdateDate(new Date());
        bookMapper.updateBookDTO(bookDTO);

        return new ResultDTO(HttpCode.SUCCESS.getCode(), "借书成功。");
    }

    private int doInsertBookBorrowRecord(int bookId, String bookName, int borrowCount, Date startDate,
                                         Date endDate, int userId, String userName, BookDTO bookDTO) {
        // Step3: 真正借书操作
        BookBorrowDTO newBorrowDTO = new BookBorrowDTO();
        newBorrowDTO.setBookId(bookId);
        newBorrowDTO.setBookName(bookName);
        newBorrowDTO.setCount(borrowCount);
        newBorrowDTO.setStartDate(startDate);
        newBorrowDTO.setEndDate(endDate);
        // 回传用户信息，可以从前端获取(session)
        newBorrowDTO.setUserId(userId);
        newBorrowDTO.setUserName(userName);
        // 设置借书书籍价格
        BigDecimal bookBorrowPrice = bookDTO.getBookBorrowPrice();
        // 转换时间
        long day = (endDate.getTime() - startDate.getTime()) / (24 * 60 * 60 * 1000);
        // 借书价格
        BigDecimal tradeFee = new BigDecimal(day * bookBorrowPrice.doubleValue());
        newBorrowDTO.setPrice(tradeFee);
        // 真实借书价格
        if (day > lengthOfDay) {
            newBorrowDTO.setTradeFee(new BigDecimal(0));
        } else {
            newBorrowDTO.setTradeFee(tradeFee);
        }
        // 设置创建时间
        newBorrowDTO.setCreatDate(new Date());
        // 设置数据有效性标识
        newBorrowDTO.setValidFlag(ValidFlagEnum.ENABLE);
        // 将数据新增到数据库
        return mapper.insertBookBorrowDTO(newBorrowDTO);
    }
}
