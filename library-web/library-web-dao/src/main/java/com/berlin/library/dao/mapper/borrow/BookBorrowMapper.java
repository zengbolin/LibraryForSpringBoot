package com.berlin.library.dao.mapper.borrow;

import com.berlin.library.api.model.borrow.BookBorrowDTO;
import org.apache.ibatis.annotations.Mapper;

/**
 * 借书mapper接口
 *
 * @author ZengBerlin
 * @date 2020/12/23 10:41
 * @Email: 15102019493@163.com
 */
@Mapper
public interface BookBorrowMapper {

    /**
     * 插入借书信息
     *
     * @param newBorrowDTO 借书记录
     * @return 修改影响条数
     */
    int insertBookBorrowDTO(BookBorrowDTO newBorrowDTO);
}
