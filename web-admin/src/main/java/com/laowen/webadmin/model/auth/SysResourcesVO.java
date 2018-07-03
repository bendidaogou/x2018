package com.laowen.webadmin.model.auth;

import com.laowen.auth.domain.SysResources;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
public class SysResourcesVO extends SysResources {

    /**
     * 菜单树
     */
    private List<SysResourcesVO> children;

}
