package com.kh.app.chat.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ChatController {
	
	@GetMapping("chat/main")
	public String main() {
		return "chat/main";
	}

}//class





























