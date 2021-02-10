package com.kve.talent_management_system.controller;

import com.alibaba.fastjson.JSON;
import com.kve.talent_management_system.pojo.SysUser;
import com.kve.talent_management_system.config.exception.AjaxResponse;
import com.kve.talent_management_system.service.EmployeeService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;

/**
 * 员工页面
 */

@RequestMapping("/employee")
@Controller
public class EmployeeController {
    @Resource
    EmployeeService employeeService;

    /**
     * 员工查看个人信息
     * @param str
     * @return
     */
    @RequestMapping("/getEmployee")
    public @ResponseBody
    AjaxResponse getOneEmployee(@RequestBody String str) {
        String username = JSON.parseObject(str).get("username").toString();
        SysUser user = employeeService.getOneEmployee(username);
        return AjaxResponse.success(user);
    }
}
