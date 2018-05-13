package com.laowen.webadmin.model.auth;

import com.laowen.auth.domain.SysResources;
import com.laowen.auth.enums.ResourcesTypeEnum;
import com.laowen.common.enums.DelStatusEnum;

public class SysResourcesVO extends SysResources {

    /**
     * 状态[0:可用, 1:不可用]
     */
    private String resourcesStatusName;

    /**
     * 类型[0:菜单, 1:功能]
     */
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
