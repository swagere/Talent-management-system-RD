package com.kve.talent_management_system.mapper;

import com.kve.talent_management_system.pojo.SysUser;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

public interface SysUserMapper {
    //根据username查询用户信息
    @Select("select id,username,org_id,phone,email from sys_user u where u.username = #{username}")
    SysUser findByUserName(@Param("username") String username);
}

