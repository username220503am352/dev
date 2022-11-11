package com.kh.app.test;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet(urlPatterns = "/test")
public class TestController extends HttpServlet {
	
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("hello ~~~");
		
		int x = 10;
		
		//request 에 담기
		req.setAttribute("x", x);
		
		//session 에 담기
		HttpSession session = req.getSession();
		session.setAttribute("name", "IU");
		
		
		
		req.getRequestDispatcher("/abc.jsp").forward(req, resp);
	}

}//class















