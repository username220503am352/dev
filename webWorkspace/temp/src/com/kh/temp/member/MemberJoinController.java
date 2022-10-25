package com.kh.temp.member;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns = "/join")
public class MemberJoinController extends HttpServlet {
	
	//회원가입 (화면)
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		req.getRequestDispatcher("/WEB-INF/views/join.jsp").forward(req, resp);
		
	}
	
	//회원가입 (찐)
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		//아이디 , 패스워드 받기
		String memberId = req.getParameter("memberId");
		String memberPwd = req.getParameter("memberPwd");
		
		//회원가입 진행
		System.out.println(memberId);
		System.out.println(memberPwd);
		
		//응답
		resp.getWriter().write("<h1>success!</h1>");
		//req.getRequestDispatcher("다음타자").forward(req, resp);
		
	}

}//class





















