package com.berlin.library.dao.mapper.book;


import com.berlin.library.api.model.book.BookClassDTO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * @author ZengBerlin
 * @date 2020/12/18 10:57
 * @Email: 15102019493@163.com
 */
@Mapper
public interface BookClassMapper {

    /**
     * 根据名称模糊查找所有的书籍分类信息
     * @param name 分类名称
     * @return 匹配的所有数据集
     */
    List<BookClassDTO> findListByName(String name);

    /**
     * 根据id查找书籍分类
     * @param id id
     * @return 查找的数据集
     */
    BookClassDTO findById(int id);

    /**
     *新增书籍分类
     * @param bookClassDTO 书籍实体类信息(不包含id)
     * @return 影响行数
     */
    int insertBookClassDTO(BookClassDTO bookClassDTO);

    /**
     * 更新书籍分类
     * @param bookClassDTO 书籍实体类信息(包含id)
     * @return 影响的行数
     */
    int updateBookClassDTO(BookClassDTO bookClassDTO);

    /**
     * 删除书籍分类
     * @param id 书籍分类id
     * @return 影响的行数
     */
    int deleteBookClassDTO(int id);
}
