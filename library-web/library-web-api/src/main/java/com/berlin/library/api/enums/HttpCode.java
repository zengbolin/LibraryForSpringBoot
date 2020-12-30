package com.berlin.library.api.enums;

/**
 * 状态码code
 *
 * @author ZengBerlin
 * @date 2020/12/18 16:28
 * @Email: 15102019493@163.com
 */
public enum HttpCode {
    /**
     * 成功且有数据
     */
    SUCCESS(1, "成功"),

    /**
     * 成功无数据
     */
    FAIL(-1, "失败"),

    /**
     * 系统异常
     */
    EXCEPTION(500, "系统异常");

    /**
     * 状态码
     */
    private Integer code;

    /**
     * 响应信息
     */
    private String msg;

    /**
     * 构造函数
     *
     * @param code 状态码
     * @param msg  状态信息
     */
    HttpCode(Integer code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public Integer getCode() {
        return code;
    }

}
