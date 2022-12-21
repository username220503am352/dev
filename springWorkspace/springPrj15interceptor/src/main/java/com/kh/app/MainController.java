package com.kh.app;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MainController {
	
	@GetMapping(value = {"main" , "/"})
	public String main(Model model) {
		
		System.out.println("메인페이지로 포워딩 ~~~");
		
		model.addAttribute("nick", "swy");
		model.addAttribute("age", "20");
		
		return "main";
	}

}
