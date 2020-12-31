package com.berlin.library.dao.mapper.borrow;

import com.berlin.library.api.model.borrow.BookBorrowDTO;
import org.apache.ibatis.annotations.Mapper;

/**
 * 借书mapper接口
 * @author ZengBerlin
 * @date 2020/12/23 10:41
 * @Email: 15102019493@163.com
 */
@Mapper
public interface BookBorrowMapper {

    int insertBookBorrowDTO(BookBorrowDTO newBorrowDTO);
}
