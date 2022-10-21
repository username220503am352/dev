package com.kh.app;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns = "/test2")
public class AgeController extends HttpServlet {
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.getRequestDispatcher("/WEB-INF/views/test2.jsp").forward(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		//데이터 꺼내기
		String age = req.getParameter("age");
		
		//응답 내용 인코딩
		resp.setContentType("text/plain; charset=UTF-8;");
		
		//화면선택 아니고, 그냥 문자열 응답
		if(Integer.parseInt(age) >= 20) {
			resp.getWriter().write("성인 ㅇㅋ");
		}else {
			resp.getWriter().write("성인 X");
		}
		
	}

}//class























