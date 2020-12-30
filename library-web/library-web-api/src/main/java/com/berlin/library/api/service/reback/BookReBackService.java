package com.berlin.library.api.service.reback;

import com.berlin.library.api.constants.ResultDTO;
import com.berlin.library.api.model.borrow.BookBorrowDTO;

/**
 * 还书接口
 *
 * @author ZengBerlin
 * @date 2020/12/30 11:32
 * @Email: 15102019493@163.com
 */
public interface BookReBackService {
    /**
     * 更新借书信息
     *
     * @param bookBorrowDTO 借书实体类
     * @return 借书成功是否标识
     */
    ResultDTO updateBorrowInfo(BookBorrowDTO bookBorrowDTO);
}
