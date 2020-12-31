package com.berlin.library.api.model;

import com.berlin.library.api.enums.ValidFlagEnum;
import lombok.Data;

import java.util.Date;

/**
 * 实体类父类
 *
 * @author ZengBerlin
 * @date 2020/12/17 17:21
 * @Email: 15102019493@163.com
 */
@Data
public class BaseDTO {

    /**
     * 数据主键
     */
    private Integer id;

    /**
     * 临时字段1
     */
    private String tmp1;

    /**
     * 临时字段2
     */
    private String tmp2;

    /**
     * 入库时间
     */
    private Date creatDate;

    /**
     * 最近一次更新时间
     */
    private Date updateDate;

    /**
     * 标识数据有效性
     */
    private ValidFlagEnum validFlag;
}
