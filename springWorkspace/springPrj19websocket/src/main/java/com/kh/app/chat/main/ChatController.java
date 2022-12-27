package com.kh.app.chat.main;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("chat")
public class ChatController {
	
	@GetMapping("main")
	public String main() {
		return "chat/main";
	}

}//class


























