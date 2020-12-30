package com.berlin.library.api.model.book;

import com.berlin.library.api.model.BaseDTO;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;

/**
 * 书籍分类实体类
 *
 * @author ZengBerlin
 * @date 2020/12/17 17:24
 * @Email: 15102019493@163.com
 */
@EqualsAndHashCode(callSuper = true)
@Data
public class BookClassDTO extends BaseDTO implements Serializable {

    private static final long serialVersionUID = -4810591841408358053L;

    /**
     * 分类名称
     */
    private String name;
}
