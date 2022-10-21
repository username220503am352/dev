package com.kh.app;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns = "/data")
public class DataController extends HttpServlet {
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		//데이터 꺼내기
		String msg = req.getParameter("msg");
		String msg2 = req.getParameter("msg2");
		
		//데이터 뭉치기
		
		//디비 다녀오기
		
		//화면선택 (==화면에 보여줄 긴 문자열을 응답) ㄴㄴ , 문자열 응답 ㅇㅇ
		
		System.out.println("클라한테 받은 msg : " + msg);
		System.out.println("클라한테 받은 msg2 : " + msg2);
		
		PrintWriter out = resp.getWriter();
		out.write("hello world ~~~");
		
	}

}//class




























