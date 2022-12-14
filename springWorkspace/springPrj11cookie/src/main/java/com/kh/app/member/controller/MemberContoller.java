package com.kh.app.member.controller;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.kh.app.member.service.MemberService;
import com.kh.app.member.vo.MemberVo;

@Controller
@RequestMapping("member")
public class MemberContoller {
	
	@Autowired
	@Qualifier("memberServiceImpl2")
	private MemberService ms;

	@GetMapping("join")
	public String join() {
		return "member/join";
	}
	
	@PostMapping("join")
	public String join(MemberVo vo) {
		
		int result = ms.join(vo);
		
		if(result == 1) {
			return "회원가입성공JSP로포워딩";
		}else {
			return "회원가입실패JSP로포워딩";
		}
	}
	
	@GetMapping("login")
	public String login() {
		return "member/login";
	}
	
	@PostMapping("login")
	public String login(MemberVo vo , String save , HttpSession session , HttpServletResponse resp) {
		MemberVo loginMember = ms.login(vo);
		
		if(loginMember == null) {return "실패페이지~~~";}
		
		session.setAttribute("loginMember", loginMember);
		
		Cookie c = new Cookie("saveId", loginMember.getMemberId());
		c.setPath("/app");
		
		if(save == null) { c.setMaxAge(0); }
		
		resp.addCookie(c);
		
		return "redirect:/main";
	}//method
	
	@GetMapping("logout")
	public String logout(HttpSession s) {
		s.invalidate();
		return "redirect:/main";
	}
	
	
	
	
	

}//class
























