package com.berlin.library.web.borrow;

import com.berlin.library.api.constants.ResultDTO;
import com.berlin.library.api.enums.HttpCode;
import com.berlin.library.api.model.borrow.BookBorrowDTO;
import com.berlin.library.api.service.borrow.BookBorrowService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Date;

/**
 * 借书还书控制层
 *
 * @author ZengBerlin
 * @date 2020/12/23 10:59
 * @Email: 15102019493@163.com
 */
@RestController
@RequestMapping("/borrow")
public class BookBorrowController {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private BookBorrowService service;

    @PostMapping("/doBorrow")
    public ResultDTO doBorrow(@RequestBody BookBorrowDTO bookBorrowDTO) {
        try {
            // 获取书名,TODO 个性化推荐(推荐这个分类下的下一本书)
            String bookName = bookBorrowDTO.getBookName() == null ? "知更鸟" : bookBorrowDTO.getBookName();
            // 借书编号
            int bookId = bookBorrowDTO.getBookId();
            // 获取起始以及结束时间(日期前后非法校验)
            Date startDate = bookBorrowDTO.getStartDate();
            Date endDate = bookBorrowDTO.getEndDate();
            // 获取借书数量
            int borrowCount = bookBorrowDTO.getCount();
            // 获取用户名以及用户id
            int userId = bookBorrowDTO.getUserId();
            String userName = bookBorrowDTO.getUserName();

            return service.doBookBorrow(bookName,bookId,startDate,endDate,borrowCount,userId,userName);
        } catch (Exception e) {
            logger.error("系统异常: " + e);
            return new ResultDTO(HttpCode.EXCEPTION.getCode(), "系统异常");
        }
    }
}
