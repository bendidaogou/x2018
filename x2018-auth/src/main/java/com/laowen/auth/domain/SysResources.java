package com.laowen.auth.domain;

import com.laowen.auth.enums.ResourcesTypeEnum;
import com.laowen.common.enums.DelStatusEnum;
import lombok.AccessLevel;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;
import java.util.List;

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

    /**
     * 枚举状态[0:可用, 1:不可用]
     */
    @Getter(AccessLevel.NONE)
    @Setter(AccessLevel.NONE)
    private String resourcesStatusName;

    /**
     * 枚举类型[0:菜单, 1:功能]
     */
    @Getter(AccessLevel.NONE)
    @Setter(AccessLevel.NONE)
    private String resourcesTypeName;

    //region getter

    /**
     * 状态[0:可用, 1:不可用]
     *
     * @return
     */
    public String getResourcesStatusName() {
        if (null == getResourcesStatus()) {
            return null;
        }
        DelStatusEnum _enum = DelStatusEnum.getEnum(getResourcesStatus());
        if (null != _enum) {
            return _enum.getDesc();
        }
        return null;
    }

    /**
     * 类型[0:菜单, 1:功能]
     */
    public String getResourcesTypeName() {
        if (null == getResourcesType()) {
            return null;
        }
        ResourcesTypeEnum _enum = ResourcesTypeEnum.getEnum(getResourcesType());
        if (null != _enum) {
            return _enum.getDesc();
        }
        return null;
    }
    //endregion


}