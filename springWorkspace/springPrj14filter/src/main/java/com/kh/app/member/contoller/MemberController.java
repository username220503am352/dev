package com.kh.app.member.contoller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.kh.app.member.vo.MemberVo;

@Controller
@RequestMapping("member")
public class MemberController {
	
	@GetMapping("join")
	public String join() {
		return "member/join";
	}
	
	@PostMapping("join")
	public ModelAndView join(MemberVo vo , ModelAndView mv) {
		
		//model.addAttribute("msg", "로그인 성공!");
		
		mv
		.addObject("msg", "로그인 성공 ~~~")
		.addObject("name", "swy")
		.addObject("age", "20")
		.setViewName("main");
		
		return mv;
	}
	
	

}
