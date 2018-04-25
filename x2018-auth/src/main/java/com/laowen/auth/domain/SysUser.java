package com.laowen.auth.domain;

import lombok.Data;

import java.util.Date;

/**
 * 系统用户
 */
@Data
public class SysUser {
    /**
     * 用户ID
     */
    private String userId;

    /**
     * 用户姓名
     */
    private String userName;

    /**
     * 账号
     */
    private String userAccount;

    /**
     * 密码
     */
    private String userPwd;

    /**
     * 性别[0:男, 1:女]
     */
    private Integer userSex;

    /**
     * 手机号
     */
    private String userPhone;

    /**
     * 状态[0:可用, 1:不可用]
     */
    private Integer userStatus;

    /**
     * 备注
     */
    private String userNote;

    /**
     * create_time
     */
    private Date createTime;

    /**
     * create_user
     */
    private String createUser;

    /**
     * update_time
     */
    private Date updateTime;

    /**
     * update_user
     */
    private String updateUser;

}