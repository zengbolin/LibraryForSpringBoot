package com.berlin.library.service.book;

import com.berlin.library.api.constants.ResultDTO;
import com.berlin.library.api.enums.HttpCode;
import com.berlin.library.api.model.book.BookDTO;
import com.berlin.library.api.service.book.BookService;
import com.berlin.library.dao.mapper.book.BookMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;
import org.springframework.util.StringUtils;

import java.util.List;

/**
 * 图书信息实体类
 *
 * @author ZengBerlin
 * @date 2020/12/20 14:38
 * @Email: 15102019493@163.com
 */
@Service
public class BookServiceImpl implements BookService {

    /**
     * 日志记录实体类
     */
    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private BookMapper mapper;

    /**
     * 根据名称模糊查找所有的书籍信息
     *
     * @param name 名称
     * @return 匹配的所有数据集
     */
    @Override
    public ResultDTO findListByName(String name) {
        logger.info("入参: " + name);
        // 校验数据的合法性
        if (!StringUtils.hasText(name)) {
            return new ResultDTO(HttpCode.FAIL.getCode(), "搜索关键字不能为空");
        }

        // 用mapper进行获取数据
        List<BookDTO> bookDTOList = mapper.findListByName(name);

        logger.info("出参: " + bookDTOList);

        // 判断是否为空
        if (CollectionUtils.isEmpty(bookDTOList)) {
            return new ResultDTO(HttpCode.FAIL.getCode(), "暂无对应书籍数据");
        }

        // 成功
        return new ResultDTO(HttpCode.SUCCESS.getCode(), "查找成功", bookDTOList);
    }

    /**
     * 根据id查找书籍
     *
     * @param id id
     * @return 查找的数据集
     */
    @Override
    public ResultDTO findById(int id) {
        logger.info("入参： " + id);
        // 校验数据合法性
        if (0 == id) {
            return new ResultDTO(HttpCode.FAIL.getCode(), "搜索ID不能为空");
        }

        // 使用mapper进行获取数据
        BookDTO bookDTO = mapper.findById(id);

        logger.info("出参： " + bookDTO);

        // 判断是否为空
        if (null == bookDTO) {
            return new ResultDTO(HttpCode.FAIL.getCode(), "暂无书籍数据");
        }

        // 成功
        return new ResultDTO(HttpCode.SUCCESS.getCode(), "查找成功", bookDTO);
    }

    /**
     * 新增书籍
     *
     * @param bookDTO 书籍实体类信息(不包含id)
     * @return 影响行数
     */
    @Override
    public ResultDTO insertBookDTO(BookDTO bookDTO) {
        logger.info("入参: " + bookDTO);
        // 校验数据合法性
        if (!StringUtils.hasText(bookDTO.getBookName())) {
            return new ResultDTO(HttpCode.FAIL.getCode(), "书籍名称不能为空");
        }
        if (bookDTO.getBookClassId() <= 0 || bookDTO.getBookClassId() == null) {
            return new ResultDTO(HttpCode.FAIL.getCode(), "书籍编号不能为空或者书籍编号不合法");
        }
        if (0 == bookDTO.getBookCount()) {
            return new ResultDTO(HttpCode.FAIL.getCode(), "书籍数量不能小于0");
        }

        // 使用mapper进行插入
        int flag = mapper.insertBookDTO(bookDTO);

        // 判断flag
        if (flag <= 0) {
            // 新增失败
            return new ResultDTO(HttpCode.FAIL.getCode(), "新增失败");
        }

        // 成功
        return new ResultDTO(HttpCode.SUCCESS.getCode(), "新增数据成功");
    }

    /**
     * 更新书籍
     *
     * @param bookDTO 书籍实体类信息(包含id)
     * @return 影响的行数
     */
    @Override
    public ResultDTO updateBookDTO(BookDTO bookDTO) {
        logger.info("入参: " + bookDTO);
        // 校验数据合法性
        if (!StringUtils.hasText(bookDTO.getId().toString())) {
            return new ResultDTO(HttpCode.FAIL.getCode(), "数据ID不能为空");
        }

        // 使用mapper进行更新
        int flag = mapper.updateBookDTO(bookDTO);

        // 判断flag
        if (flag <= 0) {
            // 更新失败
            return new ResultDTO(HttpCode.FAIL.getCode(), "更新失败");
        }

        // 成功
        return new ResultDTO(HttpCode.SUCCESS.getCode(), "更新数据成功");
    }

    /**
     * 删除书籍
     *
     * @param id 书籍分类id
     * @return 影响的行数
     */
    @Override
    public ResultDTO deleteBookDTO(int id) {
        logger.info("入参: " + id);
        // 校验数据合法性
        if (0 == id) {
            return new ResultDTO(HttpCode.FAIL.getCode(), "数据ID不能为空");
        }

        // 使用mapper进行删除
        int flag = mapper.deleteBookDTO(id);

        // 判断flag
        if (flag <= 0) {
            // 删除失败
            return new ResultDTO(HttpCode.FAIL.getCode(), "删除失败");
        }

        // 成功
        return new ResultDTO(HttpCode.SUCCESS.getCode(), "删除数据成功");
    }

}
