package com.kh.app.member.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.kh.app.member.service.MemberService;
import com.kh.app.member.vo.MemberVo;

@Controller
public class MemberController {
	
	private MemberService ms;
	
	@Autowired
	public MemberController(MemberService ms) {
		this.ms = ms;
	}
	
	//회원가입 (화면)
	@GetMapping("member/join")
	public String join() {
		return "member/join";
	}
	
	//회원가입 (찐)
	@PostMapping("member/join")
	public String join(MemberVo vo) {
		//디비
		int result = ms.join(vo);
		
		//문자열 내보내기
		return "main";
	}
	
}//class



























