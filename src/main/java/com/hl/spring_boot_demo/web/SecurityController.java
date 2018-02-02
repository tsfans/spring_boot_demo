package com.hl.spring_boot_demo.web;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class SecurityController {

	@RequestMapping("/home")
	public ModelAndView home(String msg) {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("home");
		mv.addObject("msg", msg);
		return mv;
	}
}
