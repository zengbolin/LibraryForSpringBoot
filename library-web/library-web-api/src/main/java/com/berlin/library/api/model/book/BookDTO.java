package com.berlin.library.api.model.book;

import com.berlin.library.api.model.BaseDTO;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;

import java.math.BigDecimal;
import java.util.Date;

/**
 * 书籍实体类
 *
 * @author ZengBerlin
 * @date 2020/12/17 17:14
 * @Email: 15102019493@163.com
 */
@EqualsAndHashCode(callSuper = true)
@Data
public class BookDTO extends BaseDTO implements Serializable {

    private static final long serialVersionUID = 5403897608997056085L;

    /**
     * 书籍名称
     */
    private String bookName;

    /**
     * 分类主键
     */
    private Integer bookClassId;

    /**
     * 书籍价格
     */
    private BigDecimal bookPrice;

    /**
     * 借书一天的价格
     */
    private BigDecimal bookBorrowPrice;

    /**
     * 书籍数量
     */
    private Integer bookCount;

    /**
     * 书籍出版社名称
     */
    private String bookPublish;

    /**
     * 作者名字
     */
    private String bookAuthor;

    /**
     * 书籍封面等图片（多个图片用；隔开）
     */
    private String bookImg;

    /**
     * 出版日期
     */
    private Date publishDate;

}
