package com.kh.app.member.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.kh.app.member.service.MemberService;
import com.kh.app.member.vo.MemberVo;

import lombok.extern.log4j.Log4j2;
import lombok.extern.slf4j.Slf4j;

@Controller
@Slf4j
public class MemberController {
	
	@Autowired
	private MemberService service;
	
	@GetMapping("member/login")
	public String login() {
		return "member/login";
	}
	
	@PostMapping("member/login")
	public String login(MemberVo vo , HttpSession session) {
		
		 log.debug("화면에서 받은 vo : " + vo);
		
		 MemberVo loginMember = service.login(vo);
		 log.debug("로그인멤버 : " + loginMember);
		 
		 session.setAttribute("loginMember", loginMember);
		 
		 if(loginMember == null) {
			 return "errorPage";
		 }
		 
		 return "main";
	}

}//class














