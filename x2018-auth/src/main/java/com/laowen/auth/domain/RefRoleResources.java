package com.laowen.auth.domain;

import lombok.Data;

import java.util.Date;

/**
 * 角色-REF-资源
 */
@Data
public class RefRoleResources {
    /**
     * ref_id
     */
    private String refId;

    /**
     * 角色id
     */
    private String roleId;

    /**
     * 资源id
     */
    private String resourcesId;

    /**
     * create_time
     */
    private Date createTime;

    /**
     * create_user
     */
    private String createUser;

}