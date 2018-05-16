package com.laowen.common.utils;

import lombok.Data;

import java.io.Serializable;

/**
 * 操作返回对象
 */
@Data
public class Result<T> implements Serializable {

    private static final long serialVersionUID = -6429648732879323650L;

    /**
     * true:成功， false:失败
     */
    private Boolean successTag = false;

    /**
     * 返回内容
     */
    private T data;

    /**
     * 错误码
     */
    private String code;

    /**
     * 提示信息
     */
    private String msg;


}
