package com.laowen.auth.service.impl;

import com.laowen.auth.dao.SysResourcesMapper;
import com.laowen.auth.domain.SysResources;
import com.laowen.auth.service.SysResourcesService;
import com.laowen.common.enums.DelStatusEnum;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
@Slf4j
public class SysResourcesServiceImpl implements SysResourcesService {

    @Autowired
    private SysResourcesMapper sysResourcesMapper;

    @Override
    public int insertOne(SysResources sysResources) {
        sysResources.setCreateTime(new Date());
        sysResources.setUpdateTime(new Date());
        return sysResourcesMapper.insertOne(sysResources);
    }

    @Override
    public SysResources selectById(String resourcesId) {
        return sysResourcesMapper.selectById(resourcesId);
    }

    @Override
    public List<SysResources> selectList(SysResources sysResources) {
        return sysResourcesMapper.selectList(sysResources);
    }

    @Override
    public int updateById(SysResources sysResources) {
        sysResources.setUpdateTime(new Date());
        return sysResourcesMapper.updateById(sysResources);
    }

    @Override
    public int deleteById(String resourcesId) {
        return sysResourcesMapper.updateById(new SysResources() {{
            setResourcesId(resourcesId);
            setResourcesStatus(DelStatusEnum.DISABLE.getVal());
            setUpdateTime(new Date());
        }});
    }

}
