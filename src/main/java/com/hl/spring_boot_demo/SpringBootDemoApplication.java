package com.hl.spring_boot_demo;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.Banner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;



@SpringBootApplication
@RestController
@MapperScan("com.hl.spring_boot_demo.dao")
public class SpringBootDemoApplication {
	
	@RequestMapping("/say")
	public String say(String msg) {
		return "Hello "+msg;
	}
	
	
	public static void main(String[] args) {
		SpringApplication app = new SpringApplication(SpringBootDemoApplication.class);
		app.setBannerMode(Banner.Mode.CONSOLE);
		app.run(args);
	}
}
