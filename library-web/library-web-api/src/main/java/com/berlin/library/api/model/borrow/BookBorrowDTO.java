package com.berlin.library.api.model.borrow;

import com.berlin.library.api.model.BaseDTO;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

/**
 *借书实体类
 *
 * @author ZengBerlin
 * @date 2020/12/23 10:04
 * @Email: 15102019493@163.com
 */
@EqualsAndHashCode(callSuper = true)
@Data
public class BookBorrowDTO extends BaseDTO implements Serializable {

    private static final long serialVersionUID = -3376317937346988009L;
    /**
     * 用户唯一标识id
     */
    private Integer userId;

    /**
     * 用户名字
     */
    private String userName;

    /**
     * 书籍的id
     */
    private Integer bookId;

    /**
     * 书籍名字
     */
    private String bookName;

    /**
     * 借书数量
     */
    private Integer count;

    /**
     * 借书开始时间
     */
    private Date startDate;

    /**
     * 还书时间
     */
    private Date endDate;

    /**
     * 借书时段的总价格
     */
    private BigDecimal price;

    /**
     * 实际成交价格
     */
    private BigDecimal tradeFee;

}
