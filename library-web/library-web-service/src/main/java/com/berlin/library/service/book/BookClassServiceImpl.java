package com.berlin.library.service.book;

import com.berlin.library.api.constants.ResultDTO;
import com.berlin.library.api.enums.HttpCode;
import com.berlin.library.api.model.book.BookClassDTO;
import com.berlin.library.api.service.book.BookClassService;
import com.berlin.library.dao.mapper.book.BookClassMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;
import org.springframework.util.StringUtils;

import java.util.List;

/**
 * 书籍分类Service实现类
 *
 * @author ZengBerlin
 * @date 2020/12/18 16:19
 * @Email: 15102019493@163.com
 */
@Service
public class BookClassServiceImpl implements BookClassService {

    /**
     * 日志实体类
     */
    private Logger logger = LoggerFactory.getLogger(this.getClass());

    /**
     * 图书分类mapper
     */
    @Autowired
    private BookClassMapper mapper;

    /**
     * 根据名称模糊查找所有的书籍分类信息
     *
     * @param name 分类名称
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
        List<BookClassDTO> bookClassDTOList = mapper.findListByName(name);

        logger.info("出参: " + bookClassDTOList);

        // 判断是否为空
        if (CollectionUtils.isEmpty(bookClassDTOList)) {
            return new ResultDTO(HttpCode.FAIL.getCode(), "暂无对应分类数据");
        }

        // 成功
        return new ResultDTO(HttpCode.SUCCESS.getCode(), "查找成功", bookClassDTOList);
    }

    /**
     * 根据id查找书籍分类
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
        BookClassDTO bookClassDTO = mapper.findById(id);

        logger.info("出参： " + bookClassDTO);

        // 判断是否为空
        if (null == bookClassDTO) {
            return new ResultDTO(HttpCode.FAIL.getCode(), "暂无分类数据");
        }

        // 成功
        return new ResultDTO(HttpCode.SUCCESS.getCode(), "查找成功", bookClassDTO);
    }

    /**
     * 新增书籍分类
     *
     * @param bookClassDTO 书籍实体类信息(不包含id)
     * @return 影响行数
     */
    @Override
    public ResultDTO insertBookClassDTO(BookClassDTO bookClassDTO) {
        logger.info("入参: " + bookClassDTO);
        // 校验数据合法性
        if (!StringUtils.hasText(bookClassDTO.getName())) {
            return new ResultDTO(HttpCode.FAIL.getCode(), "分类名称不能为空");
        }

        // 使用mapper进行插入
        int flag = mapper.insertBookClassDTO(bookClassDTO);

        // 判断flag
        if (flag <= 0) {
            // 新增失败
            return new ResultDTO(HttpCode.FAIL.getCode(), "新增失败");
        }

        // 成功
        return new ResultDTO(HttpCode.SUCCESS.getCode(), "新增数据成功");
    }

    /**
     * 更新书籍分类
     *
     * @param bookClassDTO 书籍实体类信息(包含id)
     * @return 影响的行数
     */
    @Override
    public ResultDTO updateBookClassDTO(BookClassDTO bookClassDTO) {
        logger.info("入参: " + bookClassDTO);
        // 校验数据合法性
        if (!StringUtils.hasText(bookClassDTO.getId().toString())) {
            return new ResultDTO(HttpCode.FAIL.getCode(), "数据ID不能为空");
        }

        // 使用mapper进行更新
        int flag = mapper.updateBookClassDTO(bookClassDTO);

        // 判断flag
        if (flag <= 0) {
            // 更新失败
            return new ResultDTO(HttpCode.FAIL.getCode(), "更新失败");
        }

        // 成功
        return new ResultDTO(HttpCode.SUCCESS.getCode(), "更新数据成功");
    }

    /**
     * 删除书籍分类
     *
     * @param id 书籍分类id
     * @return 影响的行数
     */
    @Override
    public ResultDTO deleteBookClassDTO(int id) {
        logger.info("入参: " + id);
        // 校验数据合法性
        if (0 == id) {
            return new ResultDTO(HttpCode.FAIL.getCode(), "数据ID不能为空");
        }

        // 使用mapper进行删除
        int flag = mapper.deleteBookClassDTO(id);

        // 判断flag
        if (flag <= 0) {
            // 删除失败
            return new ResultDTO(HttpCode.FAIL.getCode(), "删除失败");
        }

        // 成功
        return new ResultDTO(HttpCode.SUCCESS.getCode(), "删除数据成功");
    }
}
