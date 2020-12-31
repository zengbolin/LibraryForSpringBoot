package com.berlin.library.api.service.book;

import com.berlin.library.api.constants.ResultDTO;
import com.berlin.library.api.model.book.BookDTO;

/**
 * book的数据接口
 *
 * @author ZengBerlin
 * @date 2020/12/20 14:43
 * @Email: 15102019493@163.com
 */
public interface BookService {
    /**
     * 根据名称模糊查找所有的书籍信息
     *
     * @param name 书籍名称
     * @return 匹配的所有数据集
     */
    ResultDTO findListByName(String name);

    /**
     * 根据id查找书籍
     *
     * @param id id
     * @return 查找的数据结果集
     */
    ResultDTO findById(int id);

    /**
     * 新增书籍
     *
     * @param bookDTO 书籍实体类信息(不包含id)
     * @return 影响行数
     */
    ResultDTO insertBookDTO(BookDTO bookDTO);

    /**
     * 更新书籍
     *
     * @param bookDTO 书籍实体类信息(包含id)
     * @return 影响的行数
     */
    ResultDTO updateBookDTO(BookDTO bookDTO);

    /**
     * 删除书籍
     *
     * @param id 书籍id
     * @return 影响的行数
     */
    ResultDTO deleteBookDTO(int id);
}
