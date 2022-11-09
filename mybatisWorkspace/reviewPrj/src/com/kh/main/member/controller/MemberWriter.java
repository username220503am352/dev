package com.kh.main.member.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("temp/writer")
public class MemberWriter extends HttpServlet {
	
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		writeString(req, resp);
	}
	
	private void writeString(HttpServletRequest req, HttpServletResponse resp) throws IOException {
		//동적으로 문자열 만들고 그 문자열 내보내기 (응답)
		
		String str = "";
		str += "<!DOCTYPE html>";
		str += "<html>";
		str += "<head>";
		str += "</head>";
		str += "<body>";
		str = "<h1>hi World ~~~</h1>";
		int sum = (int)req.getAttribute("sum");
		str += "<h2>";
		str += "공격력 + 방어력 : "; 
		str += sum;
		str += "</h2>";
		str += "</body>";
		str += "</html>";
		
		PrintWriter w = resp.getWriter();
		w.write(str);
	}
	
}






