package com.laowen.auth.service;

import com.laowen.auth.domain.SysResources;

import java.util.List;

public interface SysResourcesService {

    /**
     * 添加
     *
     * @param sysResources
     * @return
     */
    int insertOne(SysResources sysResources);

    /**
     * 根据id查询
     *
     * @param resourcesId
     * @return
     */
    SysResources selectById(String resourcesId);

    /**
     * 查询菜单list
     *
     * @return
     */
    List<SysResources> selectMenuList();

    /**
     * 查询菜单权限list
     *
     * @param menuId
     * @return
     */
    List<SysResources> selectPermList(String menuId);

    /**
     * 更新
     *
     * @param sysResources
     * @return
     */
    int updateById(SysResources sysResources);

    /**
     * 根据id删除
     *
     * @param resourcesId
     * @return
     */
    int deleteById(String resourcesId);

}
