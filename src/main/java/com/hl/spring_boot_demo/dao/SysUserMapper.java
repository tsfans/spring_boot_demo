package com.hl.spring_boot_demo.dao;

import org.springframework.security.core.userdetails.UserDetails;

import com.hl.spring_boot_demo.domain.SysUser;

public interface SysUserMapper {
    int deleteByPrimaryKey(Integer userId);

    int insert(SysUser record);

    int insertSelective(SysUser record);

    SysUser selectByPrimaryKey(Integer userId);

    int updateByPrimaryKeySelective(SysUser record);

    int updateByPrimaryKey(SysUser record);

    SysUser selectByUsername(String username);
}