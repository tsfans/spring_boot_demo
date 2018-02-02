package com.hl.spring_boot_demo.domain;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;

import com.hl.spring_boot_demo.BaseJunit4Test;
import com.hl.spring_boot_demo.dao.SysRoleMapper;
import com.hl.spring_boot_demo.dao.SysUserMapper;

public class UserTest extends BaseJunit4Test{

	@Autowired
	SysUserMapper userMapper;
	@Autowired
	SysRoleMapper roleMapper;
	@Autowired
	BCryptPasswordEncoder passwordEncoder;
	
	@Test
	@Transactional
	@Rollback(true)
	public void testInsertUser() {
		SysUser user = new SysUser();
		user.setUsername("zhangsan");
		user.setPassword("123456");
		user.setRoleId(2);
		userMapper.insertSelective(user);
	}
	@Test
	@Transactional
	@Rollback(true)
	public void testUpdateUser() {
		SysUser user = new SysUser();
		//数据库中user的主键id
		user.setUserId(8);	
		user.setPassword(passwordEncoder.encode("123456"));
		userMapper.updateByPrimaryKeySelective(user);
	}
	
	@Test
	@Transactional
	@Rollback(true)
	public void testInsertRole() {
		SysRole role = new SysRole();
		role.setRoleName("ROLE_USER");
		roleMapper.insertSelective(role);
	}
	
	@Test
	public void testSelect() {
		SysUser user = userMapper.selectByPrimaryKey(6);
		if(user != null)
			System.out.println("username:"+user.getUsername()+",password:"+user.getPassword());
	}
}
