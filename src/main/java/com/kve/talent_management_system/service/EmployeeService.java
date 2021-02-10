package com.kve.talent_management_system.service;

import com.kve.talent_management_system.pojo.SysUser;

public interface EmployeeService {
    SysUser getOneEmployee(String username);
}
