package com.laowen.auth.domain;

import lombok.Data;

import java.util.Date;

/**
 * 行政区划
 */
@Data
public class SysArea {
    /**
     * area_id
     */
    private Integer areaId;

    /**
     * area_name
     */
    private String areaName;

    /**
     * area_pid
     */
    private Integer areaPid;

    /**
     * area_seq
     */
    private Integer areaSeq;

    /**
     * area_level
     */
    private Integer areaLevel;

    /**
     * area_status[0:可用, 1:不可用]
     */
    private Integer areaStatus;

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