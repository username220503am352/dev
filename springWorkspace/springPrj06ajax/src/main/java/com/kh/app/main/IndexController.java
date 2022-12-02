package com.kh.app.main;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class IndexController {
	
	//인덱스 페이지 (화면)
	@GetMapping("/")
	public String index() {
		return "index";
	}

}//class

























