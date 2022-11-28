package com.kh.app.member.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.kh.app.member.vo.MemberVo;

@Controller
public class MemberController {

	//회원가입 (화면)
	@RequestMapping(value = "join" , method = RequestMethod.GET)
	public String memberJoin() {
		return "member/join"; 
	}
	
	//회원가입 (찐)
	@RequestMapping(value = "join" , method = RequestMethod.POST)
	public String memberJoin(MemberVo vo) {
		
		System.out.println(vo);
		
		return "~~~";
	}
	
	@RequestMapping("login")
	public String memberLogin() {
		return "member/login";
	}
	
}//class

























