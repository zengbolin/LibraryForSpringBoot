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
     * 借书类
     *
     * @param newBorrowDTO 借书的实体类
     * @return 数据是否插入成功
     */
    int insertBookBorrowDTO(BookBorrowDTO newBorrowDTO);

    /**
     * 根据id查找借书记录
     *
     * @param id id
     * @return 借书记录实体类
     */
    BookBorrowDTO findById(int id);

    /**
     * 更新借书实体类
     *
     * @param localBookBorrowDTO 本地借书实体类
     * @return 是否更新完成
     */
    int updateBorrow(BookBorrowDTO localBookBorrowDTO);
}
