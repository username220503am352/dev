package com.kh.main.member;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns = "/member/join")
public class MemberJoinServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.getRequestDispatcher("/member/joinView.jsp").forward(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		//데이터 꺼내기
		String memberId = req.getParameter("memberId");
		String memberPwd = req.getParameter("memberPwd");
		String memberNick = req.getParameter("memberNick");
		
		//디비에 저장
		//int result = insert 쿼리 실행
		int result = 1;
		
		//데이터 출력
		System.out.println(memberId);
		System.out.println(memberPwd);
		System.out.println(memberNick);
		
		//결과화면 보여주기
		if(result == 1) {
			//성공
			req.getRequestDispatcher("/member/joinOkResult.jsp").forward(req, resp);
		}else {
			//실패
			req.getRequestDispatcher("/member/joinFailResult.jsp").forward(req, resp);
		}
		
		
		
		
	
	}
	
	
	
}//class

































