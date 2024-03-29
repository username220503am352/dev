package com.kh.semi.member.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns = "/member/logout")
public class MemberLogoutController extends HttpServlet {
	
	// 로그아웃
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		//세션 만료
		req.getSession().invalidate();
		
		//화면 선택
		resp.sendRedirect("/semi");
		
	}

}//class






























