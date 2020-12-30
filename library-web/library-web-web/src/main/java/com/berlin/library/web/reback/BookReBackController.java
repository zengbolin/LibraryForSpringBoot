package com.berlin.library.web.reback;

import com.berlin.library.api.constants.ResultDTO;
import com.berlin.library.api.enums.HttpCode;
import com.berlin.library.api.model.borrow.BookBorrowDTO;
import com.berlin.library.api.service.reback.BookReBackService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 还书控制层
 *
 * @author ZengBerlin
 * @date 2020/12/30 19:52
 * @Email: 15102019493@163.com
 */
@RestController
@RequestMapping("/reBack")
public class BookReBackController {

    /**
     * logger 日志记录实体类
     */
    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private BookReBackService bookReBackService;

    @PostMapping("/doReBack")
    public ResultDTO bookReBack(@RequestBody BookBorrowDTO bookBorrowDTO){
        try {
            return bookReBackService.updateBorrowInfo(bookBorrowDTO);
        } catch (Exception e) {
            logger.error("系统异常: " + e);
            return new ResultDTO(HttpCode.EXCEPTION.getCode(), "系统异常");
        }
    }
}
