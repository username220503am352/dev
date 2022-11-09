package com.kh.main.member.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/temp/member")
public class MemberController extends HttpServlet {
	
	
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//data 꺼내기
		String atk = req.getParameter("atk");
		String def = req.getParameter("def");
		
		System.out.println("공격력 : " + atk);
		System.out.println("방어력 : " + def);
		
		System.out.println("서블릿이 요청을 받음 ~~~");
		
		int sum = Integer.parseInt(atk) + Integer.parseInt(def);
		
		req.setAttribute("sum", sum);
		
		
		req.getRequestDispatcher("temp/writer").forward(req, resp);
	}
	
	
	
	
	
	

}//class




























