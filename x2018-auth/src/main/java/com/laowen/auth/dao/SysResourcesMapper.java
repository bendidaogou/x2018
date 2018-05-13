package com.laowen.auth.dao;

import com.laowen.auth.domain.SysResources;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * 系统资源操作
 */
@Repository
public interface SysResourcesMapper {

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

}