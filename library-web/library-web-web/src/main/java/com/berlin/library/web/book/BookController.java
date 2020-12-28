package com.berlin.library.web.book;

import com.berlin.library.api.constants.ResultDTO;
import com.berlin.library.api.enums.HttpCode;
import com.berlin.library.api.model.book.BookDTO;
import com.berlin.library.api.service.book.BookService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * 书籍信息访问层
 * @author ZengBerlin
 * @date 2020/12/20 14:42
 * @Email: 15102019493@163.com
 */
@RestController
@RequestMapping("/book")
public class BookController {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private BookService service;

    /**
     * 根据名称模糊查找所有的书籍信息
     *
     * @param name 名称
     * @return 匹配的所有数据集
     */
    @GetMapping("/findListByName/name={name}")
    public ResultDTO findListByName(@PathVariable String name){
        try {
            // 调用service层
            return service.findListByName(name);
        } catch (Exception e) {
            logger.error("系统异常: " + e);
            return new ResultDTO(HttpCode.EXCEPTION.getCode(),"系统异常");
        }
    }

    /**
     * 根据id查找书籍
     *
     * @param id id
     * @return 查找的数据集
     */
    @GetMapping("/findById/id={id}")
    public ResultDTO findById(@PathVariable int id){
        try {
            // 调用service层
            return service.findById(id);
        } catch (Exception e) {
            logger.error("系统异常: " + e);
            return new ResultDTO(HttpCode.EXCEPTION.getCode(),"系统异常");
        }
    }

    /**
     * 新增书籍
     *
     * @param bookDTO 书籍实体类信息(不包含id)
     * @return 影响行数
     */
    @PostMapping("/insertBook")
    public ResultDTO insertBookDTO(@RequestBody BookDTO bookDTO){
        try {
            // 调用service层
            return service.insertBookDTO(bookDTO);
        } catch (Exception e) {
            logger.error("系统异常: " + e);
            return new ResultDTO(HttpCode.EXCEPTION.getCode(),"系统异常");
        }
    }

    /**
     * 更新书籍
     *
     * @param bookDTO 书籍实体类信息(包含id)
     * @return 影响的行数
     */
    @PostMapping("/updateBook")
    public ResultDTO updateBookDTO(@RequestBody BookDTO bookDTO){
        try {
            // 调用service层
            return service.updateBookDTO(bookDTO);
        } catch (Exception e) {
            logger.error("系统异常: " + e);
            return new ResultDTO(HttpCode.EXCEPTION.getCode(),"系统异常");
        }
    }

    /**
     * 删除书籍
     *
     * @param id 书籍id
     * @return 影响的行数
     */
    @GetMapping("/deleteBook/id={id}")
    public ResultDTO deleteBookDTO(@PathVariable int id){
        try {
            // 调用service层
            return service.deleteBookDTO(id);
        } catch (Exception e) {
            logger.error("系统异常: " + e);
            return new ResultDTO(HttpCode.EXCEPTION.getCode(),"系统异常");
        }
    }
}
