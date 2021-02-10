package com.kve.talent_management_system.service.Impl;

import com.kve.talent_management_system.pojo.SysUser;
import com.kve.talent_management_system.mapper.SysUserMapper;
import com.kve.talent_management_system.service.EmployeeService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class EmployeeServiceImpl implements EmployeeService {
    @Resource
    SysUserMapper sysUserMapper;

    @Override
    public SysUser getOneEmployee(String username) {
        return sysUserMapper.findByUserName(username);
    }

}
