package com.berlin.library.service.reback;

import com.berlin.library.api.constants.ResultDTO;
import com.berlin.library.api.enums.HttpCode;
import com.berlin.library.api.enums.ValidFlagEnum;
import com.berlin.library.api.model.book.BookDTO;
import com.berlin.library.api.model.borrow.BookBorrowDTO;
import com.berlin.library.api.service.reback.BookReBackService;
import com.berlin.library.dao.mapper.book.BookMapper;
import com.berlin.library.dao.mapper.borrow.BookBorrowMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

/**
 * 还书实现类
 *
 * @author ZengBerlin
 * @date 2020/12/30 11:31
 * @Email: 15102019493@163.com
 */
@Service("bookReBackService")
public class BookReBackServiceImpl implements BookReBackService {

    /**
     * 书籍mapper： 查找还书信息
     */
    @Autowired
    private BookMapper bookMapper;

    /**
     * 借书mapper： 查找借书信息
     */
    @Autowired
    private BookBorrowMapper bookBorrowMapper;

    /**
     * @param bookBorrowDTO 借书实体类
     * @return 结果集
     */
    @Override
    public ResultDTO updateBorrowInfo(BookBorrowDTO bookBorrowDTO) {

        // 获取书籍id
        int bookId = bookBorrowDTO.getBookId();
        // 获取借书id
        int bookBorrowId = bookBorrowDTO.getId();
        // 查找书信息是否存在
        BookDTO bookDTO = bookMapper.findById(bookId);
        // 本地借书信息查询
        BookBorrowDTO localBookBorrowDTO = bookBorrowMapper.findById(bookBorrowId);

        // id非法校验
        if (0 >= bookId) {
            return new ResultDTO(HttpCode.FAIL.getCode(), "书籍编号不合法，请确认所选书籍是否存在！");
        }
        // 借书id非法校验
        if (0 >= bookBorrowId) {
            return new ResultDTO(HttpCode.FAIL.getCode(), "数据主键不合法！");
        }
        // 书籍非法校验
        if (null == bookDTO) {
            return new ResultDTO(HttpCode.FAIL.getCode(), "所归还书籍不存在！");
        }
        // 借书信息非法校验
        if (null == localBookBorrowDTO) {
            return new ResultDTO(HttpCode.FAIL.getCode(), "借书信息不存在，请确认信息合法或联系系统管理员！");
        }

        // 还书真正操作
        return doBookReBackRecord(bookBorrowDTO, localBookBorrowDTO, bookDTO);
    }

    /**
     * 真正还书操作
     *
     * @param bookBorrowDTO      还书信息实体类
     * @param localBookBorrowDTO 本地借书信息实体类
     * @param bookDTO            书籍信息实体类
     * @return 结果
     */
    private ResultDTO doBookReBackRecord(BookBorrowDTO bookBorrowDTO, BookBorrowDTO localBookBorrowDTO, BookDTO bookDTO) {
        // 还书数量
        int reBackCount = bookBorrowDTO.getCount();
        // 本地借书数量
        int borrowCount = localBookBorrowDTO.getCount();
        // 获取上次借书的数量，判断是否还需要归还
        int tmp1Count = Integer.parseInt(localBookBorrowDTO.getTmp1() == null ? "0" : localBookBorrowDTO.getTmp1());
        if (tmp1Count == borrowCount) {
            return new ResultDTO(HttpCode.FAIL.getCode(), "你已经归还所有书籍，无需归还！");
        }

        // 计算要还的书
        int flagCount = borrowCount - tmp1Count;
        // 数量上的非法校验以及合法校验
        if (reBackCount > flagCount) {
            return new ResultDTO(HttpCode.FAIL.getCode(), "归还数量大于借阅数量，请确保归还数量正确！");
        } else if (reBackCount == flagCount) {
            localBookBorrowDTO.setValidFlag(ValidFlagEnum.DISABLE);
            updateBookAndBookBorrow(localBookBorrowDTO, bookDTO, reBackCount, tmp1Count);
        } else {
            updateBookAndBookBorrow(localBookBorrowDTO, bookDTO, reBackCount, tmp1Count);
        }
        return new ResultDTO(HttpCode.SUCCESS.getCode(), "归还成功！" + ((reBackCount == flagCount) ?
                "已经没有要归还的书籍" : "还剩余" + (flagCount - reBackCount) + "本书要还！"));
    }

    /**
     * 更新book表和借书表
     *
     * @param localBookBorrowDTO 本地借书记录
     * @param bookDTO            书籍记录
     * @param reBackCount        还书数量
     * @param tmp1Count          已经还书数量
     */
    private void updateBookAndBookBorrow(BookBorrowDTO localBookBorrowDTO, BookDTO bookDTO, int reBackCount, int tmp1Count) {
        // 还书数量低于借书数量，将借书数量-还书数量->更新book表以及book_borrow表
        // step1: 操作还书信息表
        // count为借书书籍数量，tmp1为还书数量,tmp2为还书时间
        localBookBorrowDTO.setTmp1(String.valueOf(reBackCount + tmp1Count));
        localBookBorrowDTO.setTmp2(String.valueOf(new Date()));
        bookBorrowMapper.updateBorrow(localBookBorrowDTO);
        // step2: 追加book信息表剩余数量
        bookDTO.setBookCount(bookDTO.getBookCount() + reBackCount);
        bookDTO.setUpdateDate(new Date());
        bookMapper.updateBookDTO(bookDTO);
    }
}
