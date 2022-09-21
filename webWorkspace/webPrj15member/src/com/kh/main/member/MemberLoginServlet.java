package com.kh.main.member;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns = "/member/login")
public class MemberLoginServlet extends HttpServlet {

	// 로그인 화면
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.getRequestDispatcher("/member/loginView.jsp").forward(req, resp);
	}
	
	// 로그인
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		//데이터 꺼내기
		String memberId = req.getParameter("memberId");
		String memberPwd = req.getParameter("memberPwd");
		
		//디비에 가서 조회(select)
		if(memberId.equalsIgnoreCase("admin") && memberPwd.equals("1234")) {
			//성공
			req.setAttribute("nick", "관리자");
			//req.getRequestDispatcher("/").forward(req, resp);	//포워딩 방식
			resp.sendRedirect("/app15/index.jsp");				//리다이렉트 방식
		}else {
			//실패
			req.getRequestDispatcher("/loginFail.jsp").forward(req, resp);
		}
		
		
		
		
		
	}
	
}//class



































