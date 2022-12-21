package com.kh.app.member.contoller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MemberController {
	
	@GetMapping("member/login")
	public String login() {
		System.out.println("로그인 페이지로 포워딩 ~~~");
		return "login";
	}

}
