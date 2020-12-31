package com.berlin.library.api.enums;

/**
 * 用户类型枚举值
 * 1-学生 2-教师 3-图书管理员 4-系统管理员
 *
 * @author ZengBerlin
 * @date 2020/12/23 10:34
 * @Email: 15102019493@163.com
 */
public enum UserTypeEnum {
    /**
     * 学生枚举值
     */
    STUDENT(1, "学生"),

    /**
     * 教师枚举值
     */
    TEACHER(2, "教师"),

    /**
     * 图书管理员枚举值
     */
    LIB_ADMIN(3, "图书管理员"),

    /**
     * 系统管理员枚举值
     */
    SYS_ADMIN(4, "系统管理员");

    private Integer num;
    private String name;

    public Integer getNum() {
        return num;
    }

    public void setNum(Integer num) {
        this.num = num;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    UserTypeEnum(Integer num, String name) {
        this.num = num;
        this.name = name;
    }
}
