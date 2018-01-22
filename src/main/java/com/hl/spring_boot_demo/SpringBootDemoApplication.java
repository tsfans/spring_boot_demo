package com.hl.spring_boot_demo;

import org.springframework.boot.Banner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;



@SpringBootApplication
@RestController
public class SpringBootDemoApplication {
	
	@RequestMapping("/say")
	public String say(String msg) {
		return "Hello "+msg;
	}
	
	
	public static void main(String[] args) {
//		SpringApplication.run(SpringBootDemoApplication.class, args);
		SpringApplication app = new SpringApplication(SpringBootDemoApplication.class);
		app.setBannerMode(Banner.Mode.CONSOLE);
		app.run(args);
	}
}
