package com.laowen.auth.domain;

import lombok.Data;

import java.util.Date;

/**
 * 系统资源(菜单/操作)
 */
@Data
public class SysResources {
    /**
     * 资源id
     */
    private String resourcesId;

    /**
     * 资源名
     */
    private String resourcesName;

    /**
     * 菜单父id
     */
    private String resourcesPid;

    /**
     * 类型[0:菜单, 1:功能]
     */
    private Integer resourcesType;

    /**
     * 排序
     */
    private Integer resourcesSeq;

    /**
     * 菜单url
     */
    private String resourcesUrl;

    /**
     * 操作code
     */
    private String resourcesCode;

    /**
     * 图标
     */
    private String resourcesIcon;

    /**
     * 状态[0:可用, 1:不可用]
     */
    private Integer resourcesStatus;

    /**
     * 备注
     */
    private String resourcesNote;

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