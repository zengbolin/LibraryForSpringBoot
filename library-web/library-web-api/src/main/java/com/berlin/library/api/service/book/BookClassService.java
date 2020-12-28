package com.berlin.library.api.service.book;

import com.berlin.library.api.constants.ResultDTO;
import com.berlin.library.api.model.book.BookClassDTO;


/**
 * 对mapper进行封装的service层
 *
 * @author ZengBerlin
 * @date 2020/12/18 16:12
 * @Email: 15102019493@163.com
 */
public interface BookClassService {

    /**
     * 根据名称模糊查找所有的书籍分类信息
     * @param name 分类名称
     * @return 匹配的所有数据集
     */
    ResultDTO findListByName(String name);

    /**
     * 根据id查找书籍分类
     * @param id id
     * @return 查找的数据集
     */
    ResultDTO findById(int id);

    /**
     *新增书籍分类
     * @param bookClassDTO 书籍实体类信息(不包含id)
     * @return 影响行数
     */
    ResultDTO insertBookClassDTO(BookClassDTO bookClassDTO);

    /**
     * 更新书籍分类
     * @param bookClassDTO 书籍实体类信息(包含id)
     * @return 影响的行数
     */
    ResultDTO updateBookClassDTO(BookClassDTO bookClassDTO);

    /**
     * 删除书籍分类
     * @param id 书籍分类id
     * @return 影响的行数
     */
    ResultDTO deleteBookClassDTO(int id);

}
