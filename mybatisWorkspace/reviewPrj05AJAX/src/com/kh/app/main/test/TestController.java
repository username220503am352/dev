package com.kh.app.main.test;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/test")
public class TestController extends HttpServlet {
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		//데이터 꺼내기
		String age  = req.getParameter("age");
		String nick = req.getParameter("nick");
		
		System.out.println("nick : " + nick);
		System.out.println("age : " + age);
		
		System.out.println("service called....");
		
		PrintWriter out = resp.getWriter();
		out.write("hello~~~");
		
	}

}//class


























