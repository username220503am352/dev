package com.kh.semi.member.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns = "/member/mypage")
public class MemberMypageController extends HttpServlet {
	
	// 마이페이지 (화면)
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		
		//화면
		//resp.sendRedirect("/semi/views/member/mypage.jsp");
		req.getRequestDispatcher("/views/member/mypage.jsp").forward(req, resp);
	}

}//class

























