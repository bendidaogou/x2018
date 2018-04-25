package com.laowen.auth.service.impl;

import com.laowen.auth.dao.SysUserMapper;
import com.laowen.auth.domain.SysUser;
import com.laowen.auth.service.SysUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.UUID;

@Service
public class SysUserServiceImpl implements SysUserService {

    @Autowired
    private SysUserMapper sysUserMapper;
    @Value("${test_key}")
    private String testKey1;
    @Value("${test_key2}")
    private String testKey2;

    @Override
    @Transactional(rollbackFor = Exception.class)
    public int insert(SysUser sysUser) {
        return sysUserMapper.insert(new SysUser() {{
            setUserId(UUID.randomUUID().toString().replaceAll("-", ""));
            setUserName("wenshiwei");
        }});
    }
}
