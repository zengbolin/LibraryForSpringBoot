package com.berlin.library.api.service.borrow;

import com.berlin.library.api.constants.ResultDTO;

import java.util.Date;

/**
 * 借书接口
 *
 * @author ZengBerlin
 * @date 2020/12/23 10:55
 * @Email: 15102019493@163.com
 */
public interface BookBorrowService {
    /**
     * @param bookName    书籍名字
     * @param bookId      书籍信息id
     * @param startDate   借书开始时间
     * @param endDate     借书结束时间
     * @param borrowCount 借书数量
     * @param userId      用户id
     * @param userName    用户名
     * @return 结果集
     */
    ResultDTO doBookBorrow(String bookName, int bookId, Date startDate, Date endDate, int borrowCount, int userId, String userName);
}
