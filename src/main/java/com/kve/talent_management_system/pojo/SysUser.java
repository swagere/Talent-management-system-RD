package com.kve.talent_management_system.pojo;

import lombok.Data;

@Data
public class SysUser {
    private Integer id;
    private String username;
    private String org_id;
    private String phone;
    private String email;
}
