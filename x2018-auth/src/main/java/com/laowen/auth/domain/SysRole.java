package com.laowen.auth.domain;

import lombok.Data;

import java.util.Date;

/**
 * 系统角色
 */
@Data
public class SysRole {
    /**
     * 角色id
     */
    private String roleId;

    /**
     * 角色名
     */
    private String roleName;

    /**
     * 角色code
     */
    private String roleCode;

    /**
     * 备注
     */
    private String roleNote;

    /**
     * 状态[0:可用, 1:不可用]
     */
    private Integer roleStatus;

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