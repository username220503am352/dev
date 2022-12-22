package com.kh.app.member.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.kh.app.member.service.MemberService;
import com.kh.app.member.vo.MemberVo;

import lombok.extern.slf4j.Slf4j;

@Controller
@RequestMapping("member")
@Slf4j
public class MemberController {
	
	@Autowired
	private MemberService service;
	
	@GetMapping("join")
	public String join() {
		return "member/join";
	}
	
	@PostMapping("join")
	public String join(MemberVo vo) {
		
		int result = service.join(vo);
		log.info("회원가입 결과 : " + result);
		
		if(result != 1) {
			log.warn("(ERROR M-0001) 회원가입 실패");
			return "errorPage";
		}
		
		return "main";
	}
	
	@GetMapping("login")
	public String login() {
		return "member/login";
	}
	
	@PostMapping("login")
	public String login(MemberVo vo , HttpSession session){
		
		MemberVo loginMember = service.login(vo);
		log.debug("loginMember : " + loginMember);
		
		session.setAttribute("loginMember", loginMember);
		
		if( loginMember == null) {
			return "errorPage";
		}
		
		return "main";
	}
	
	

}//class
