package com.berlin.library.api.constants;

import lombok.Data;

/**
 * 基本返回数据结构
 *
 * @author ZengBerlin
 * @date 2020/12/18 16:14
 * @Email: 15102019493@163.com
 */
@Data
public class ResultDTO {
    /**
     * system
     */
    private String system;

    /**
     * 返回数据的状态
     */
    private Integer code;

    /**
     * 返回数据的信息
     */
    private String msg;

    /**
     * 返回数据
     */
    private Object data;

    /**
     * code和msg的构造参数
     *
     * @param code 状态码
     * @param msg  信息
     */
    public ResultDTO(Integer code, String msg) {
        this.system = "lib";
        this.code = code;
        this.msg = msg;
    }

    /**
     * 三者的构造函数
     *
     * @param code 状态码
     * @param msg  信息
     * @param data 数据
     */
    public ResultDTO(Integer code, String msg, Object data) {
        this.system = "lib";
        this.code = code;
        this.msg = msg;
        this.data = data;
    }
}
