package com.laowen.auth.domain;

import lombok.Data;

import java.util.Date;

/**
 * 用户-REF-角色
 */
@Data
public class RefUserRole {
    /**
     * ref_id
     */
    private String refId;

    /**
     * 用户ID
     */
    private String userId;

    /**
     * 角色id
     */
    private String roleId;

    /**
     * create_time
     */
    private Date createTime;

    /**
     * create_user
     */
    private String createUser;

}