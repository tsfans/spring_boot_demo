package com.hl.spring_boot_demo.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import com.hl.spring_boot_demo.service.CustomUserDetailsService;


@Configuration
public class WebSecurityConfig extends WebSecurityConfigurerAdapter{

	@Bean
	public UserDetailsService customUserDetailsService() {
		return new CustomUserDetailsService();
	}
	@Bean
	public BCryptPasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http
			.authorizeRequests()	//定义权限配置
				.antMatchers("/admin").hasRole("ADMIN")	//角色为ROLE_ADMIN才能访问，可省略prefix
				.anyRequest().authenticated()	//任何请求都必须经过认证才能访问
		.and()
			.formLogin()	//定制登录表单
				.loginPage("/login")	//设置登录url
				.defaultSuccessUrl("/home")	//设置登录成功默认跳转url
				.permitAll()	//允许任何人访问登录url
		.and()
			.logout().permitAll();	//允许任何人访问登出url
		
	}
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth
			.userDetailsService(customUserDetailsService())
			.passwordEncoder(passwordEncoder());
//			.inMemoryAuthentication()
//				.withUser("admin").password("123456").roles("ADMIN");	//在内存中添加admin账号
	}
}
