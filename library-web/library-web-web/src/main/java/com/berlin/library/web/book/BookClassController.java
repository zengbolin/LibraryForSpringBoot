package com.berlin.library.web.book;

import com.berlin.library.api.constants.ResultDTO;
import com.berlin.library.api.enums.HttpCode;
import com.berlin.library.api.model.book.BookClassDTO;
import com.berlin.library.api.service.book.BookClassService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * 书籍分类访问层
 *
 * @author ZengBerlin
 * @date 2020/12/18 17:07
 * @Email: 15102019493@163.com
 */
@RestController
@RequestMapping("/bookClass")
public class BookClassController {

    /**
     * 日志实体类
     */
    private Logger logger = LoggerFactory.getLogger(this.getClass());

    /**
     * 图书分类service
     */
    @Autowired
    private BookClassService service;

    /**
     * 根据名称模糊查找所有的书籍分类信息
     *
     * @param name 分类名称
     * @return 匹配的所有数据集
     */
    @GetMapping("/findListByName/name={name}")
    public ResultDTO findListByName(@PathVariable String name) {
        try {
            // 调用service层
            return service.findListByName(name);
        } catch (Exception e) {
            logger.error("系统异常: " + e);
            return new ResultDTO(HttpCode.EXCEPTION.getCode(), "系统异常");
        }
    }

    /**
     * 根据id查找书籍分类
     *
     * @param id id
     * @return 查找的数据集
     */
    @GetMapping("/findById/id={id}")
    public ResultDTO findById(@PathVariable int id) {
        try {
            // 调用service层
            return service.findById(id);
        } catch (Exception e) {
            logger.error("系统异常: " + e);
            return new ResultDTO(HttpCode.EXCEPTION.getCode(), "系统异常");
        }
    }

    /**
     * 新增书籍分类
     *
     * @param bookClassDTO 书籍实体类信息(不包含id)
     * @return 影响行数
     */
    @PostMapping("/insertBookClass")
    public ResultDTO insertBookClassDTO(@RequestBody BookClassDTO bookClassDTO) {
        try {
            // 调用service层
            return service.insertBookClassDTO(bookClassDTO);
        } catch (Exception e) {
            logger.error("系统异常: " + e);
            return new ResultDTO(HttpCode.EXCEPTION.getCode(), "系统异常");
        }
    }

    /**
     * 更新书籍分类
     *
     * @param bookClassDTO 书籍实体类信息(包含id)
     * @return 影响的行数
     */
    @PostMapping("/updateBookClass")
    public ResultDTO updateBookClassDTO(@RequestBody BookClassDTO bookClassDTO) {
        try {
            // 调用service层
            return service.updateBookClassDTO(bookClassDTO);
        } catch (Exception e) {
            logger.error("系统异常: " + e);
            return new ResultDTO(HttpCode.EXCEPTION.getCode(), "系统异常");
        }
    }

    /**
     * 删除书籍分类
     *
     * @param id 书籍分类id
     * @return 影响的行数
     */
    @GetMapping("/deleteBookClass/id={id}")
    public ResultDTO deleteBookDTO(@PathVariable int id) {
        try {
            // 调用service层
            return service.deleteBookClassDTO(id);
        } catch (Exception e) {
            logger.error("系统异常: " + e);
            return new ResultDTO(HttpCode.EXCEPTION.getCode(), "系统异常");
        }
    }
}
