package com.kh.app.main.controller;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("cookie")
@RestController
public class CookieController {
	
	@GetMapping("create")
	public String create(HttpServletResponse resp) {
		
		Cookie c = new Cookie("x", "10");
		c.setMaxAge(60 * 60 * 24);
		c.setPath("/app");
		
		resp.addCookie(c);
		
		return "cookie create ~~~ !";
	}
	
	@GetMapping("delete")
	public String delete(HttpServletResponse resp) {
		
		Cookie c = new Cookie("x" , "~~~");
		c.setMaxAge(0);
		c.setPath("/app");
		
		resp.addCookie(c);
		
		return "쿠키 삭제~~~";
	}
	
	@GetMapping("check")
	public String check(@CookieValue Cookie x /* HttpServletRequest req */) {
		
//		Cookie[] cArr = req.getCookies();
//		for(Cookie c : cArr) {
//			System.out.println(c.getName());
//			System.out.println(c.getValue());
//		}
		
		System.out.println(x.getName());
		System.out.println(x.getValue());
		
		return "cookie check ~~~ !";
	}

}//class





















