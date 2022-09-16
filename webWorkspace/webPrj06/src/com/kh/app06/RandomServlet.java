package com.kh.app06;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns = "/study/random")
public class RandomServlet extends HttpServlet {
	
	//요청을 받으면, 1~45 사이의 랜덤숫자를 응답하기
	//"random : N"  라고 응답하기.
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		int random = (int) (Math.random() * 45 + 1);
		
		//응답
		PrintWriter pw = resp.getWriter();
		
		pw.write("<h1>");
		pw.write("random : " + random);
		pw.write("</h1>");
		
	}
	
	
	

}//class

























