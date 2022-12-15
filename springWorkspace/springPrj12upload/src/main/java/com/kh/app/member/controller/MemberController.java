package com.kh.app.member.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.kh.app.member.vo.MemberVo;

@Controller
@RequestMapping("member")
public class MemberController {
	
	@GetMapping("join")
	public String join() {
		return "member/join";
	}
	
	@PostMapping("join")
	public String join(MemberVo vo) {
		return "";
	}
	
	@GetMapping("login")
	public String login() {
		return "member/login";
	}
	
	@PostMapping("login")
	public String login(MemberVo vo) {
		return "";
	}

}//class


























