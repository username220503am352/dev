package com.kh.main;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns = "/calc/plusServlet")
public class PlusServlet extends HttpServlet {
	
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		//데이터 꺼내기
		String num1_ = req.getParameter("num1");
		String num2_ = req.getParameter("num2");
		
		//비지니스 로직 (더하기)
		int num1 = Integer.parseInt(num1_);
		int num2 = Integer.parseInt(num2_);
		
		int result = num1 + num2;
		
		//응답 		// (브라우저에, 결과 : ㅇㅇㅇ) 나오도록 해주면 됩니다.
		
		//인코딩
		resp.setContentType("text/html; charset=UTF-8;");
		
		PrintWriter out = resp.getWriter();
		out.write("<h2> 결과 : " + result + "</h2>");
	
	}

}//class














