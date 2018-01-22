package com.hl.spring_boot_demo.web;

import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import com.hl.spring_boot_demo.domain.Person;

@Controller
public class ThymeleafController {

	
	@RequestMapping("/")
	public String toIndex(Model model) {
		Person p1 = new Person("aa",11);
		Person p2 = new Person("bb",22);
		Person p3 = new Person("cc",33);
		Person p4 = new Person("dd",44);
		Person p5 = new Person("ee",55);
		List<Person> plist = new ArrayList<Person>();
		plist.add(p1);
		plist.add(p2);
		plist.add(p3);
		plist.add(p4);
		plist.add(p5);
		model.addAttribute("person", p1);
		model.addAttribute("people", plist);
		return "index";
	}
}
