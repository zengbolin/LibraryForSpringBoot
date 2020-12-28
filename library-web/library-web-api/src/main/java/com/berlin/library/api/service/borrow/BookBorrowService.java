package com.berlin.library.api.service.borrow;

import com.berlin.library.api.constants.ResultDTO;

import java.util.Date;

/**
 * 借书sevice接口
 * @author ZengBerlin
 * @date 2020/12/23 10:55
 * @Email: 15102019493@163.com
 */
public interface BookBorrowService {
    ResultDTO doBookBorrow(String bookName, int bookId, Date startDate, Date endDate, int borrowCount, int userId, String userName);
}
