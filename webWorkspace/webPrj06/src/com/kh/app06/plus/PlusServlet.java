package com.kh.app06.plus;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns = "/plus")
public class PlusServlet extends HttpServlet {
	
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		//값 꺼내기
		String n1 = req.getParameter("num1");
		String n2 = req.getParameter("num2");
		
		System.out.println("n1 : " + n1);
		System.out.println("n2 : " + n2);
		
		int a = Integer.parseInt(n1);
		int b = Integer.parseInt(n2);
		
		//응답
		PrintWriter pw = resp.getWriter();
		pw.write("더하기 결과 : " + (a + b));
		
	}

}


















