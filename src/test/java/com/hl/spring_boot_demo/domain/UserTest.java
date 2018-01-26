package com.hl.spring_boot_demo.domain;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;

import com.hl.spring_boot_demo.BaseJunit4Test;
import com.hl.spring_boot_demo.dao.SysUserMapper;

public class UserTest extends BaseJunit4Test{

	@Autowired
	SysUserMapper mapper;
	
	@Test
	@Transactional
	@Rollback(true)
	public void testInsert() {
		SysUser user = new SysUser();
		user.setUsername("admin");
		user.setPassword("123456");
		mapper.insertSelective(user);
	}
	
	@Test
	public void testSelect() {
		SysUser user = mapper.selectByPrimaryKey(1);
		if(user != null)
			System.out.println("username:"+user.getUsername()+",password:"+user.getPassword());
	}
}
