package com.berlin.library.dao.mapper.book;

import com.berlin.library.api.model.book.BookDTO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * 书籍实体信息接口
 *
 * @author ZengBerlin
 * @date 2020/12/20 14:34
 * @Email: 15102019493@163.com
 */
@Mapper
public interface BookMapper {
    /**
     * 根据名称模糊查找所有的书籍信息
     *
     * @param name 分类名称
     * @return 匹配的所有数据集
     */
    List<BookDTO> findListByName(String name);

    /**
     * 根据id查找书籍
     *
     * @param id id
     * @return 查找的数据集
     */
    BookDTO findById(int id);

    /**
     * 新增书籍
     *
     * @param bookDTO 书籍实体类信息(不包含id)
     * @return 影响行数
     */
    int insertBookDTO(BookDTO bookDTO);

    /**
     * 更新书籍
     *
     * @param bookDTO 书籍实体类信息(包含id)
     * @return 影响的行数
     */
    int updateBookDTO(BookDTO bookDTO);

    /**
     * 删除书籍
     *
     * @param id 书籍id
     * @return 影响的行数
     */
    int deleteBookDTO(int id);
}
