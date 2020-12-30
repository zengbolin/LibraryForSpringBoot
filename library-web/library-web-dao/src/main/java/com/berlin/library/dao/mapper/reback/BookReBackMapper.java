package com.berlin.library.dao.mapper.reback;

import com.berlin.library.api.model.borrow.BookBorrowDTO;
import org.apache.ibatis.annotations.Mapper;

/**
 * 还书接口类
 *
 * @author ZengBerlin
 * @date 2020/12/30 11:21
 * @Email: 15102019493@163.com
 */
@Mapper
public interface BookReBackMapper {
    /**
     * 更新借书信息
     *
     * @param bookBorrowDTO 借书实体类
     * @return 借书成功是否标识
     */
    int updateBorrowInfo(BookBorrowDTO bookBorrowDTO);
}
