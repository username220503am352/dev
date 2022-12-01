package com.kh.app.member.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.kh.app.member.service.MemberService;
import com.kh.app.member.vo.MemberVo;

@RequestMapping("member")
@Controller
public class MemberController {
	
	@Autowired
	private MemberService ms;
	
	//회원가입 (화면)
	@GetMapping("join")
	public String join() {
		return "member/join";
	}
	
	//회원가입 (찐)
	@PostMapping("join")
	public String join(MemberVo vo) {
		int result = ms.join(vo);
		
		if(result == 1) {
			return "common/success";
		}else {
			return "common/error";
		}
	}
	
	//로그인 (화면)
	@GetMapping("login")
	public String login() {
		return "member/login";
	}
	
	//로그인 (찐)
	@PostMapping("login")
	public String login(MemberVo vo) {
		MemberVo loginMember = ms.login(vo);
		if(loginMember != null) {
			return "common/success";
		}else {
			return "common/error";
		}
	}
	
	

}//class

























