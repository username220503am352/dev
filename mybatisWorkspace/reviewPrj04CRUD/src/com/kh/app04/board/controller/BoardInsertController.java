package com.kh.app04.board.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/board/insert")
public class BoardInsertController extends HttpServlet {
	
	/**
	 * 게시글 작성 화면
	 */
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		//내보낼 문자열 타입 지정하기
		resp.setContentType("text/html; charset=UTF-8;");
		
		//(게시글 작성 화면) 문자열 내보내기
		// 직접 하지말고 ,,, JSP한테 맡기자 ,,,(바톤터치)
		req.getRequestDispatcher("/WEB-INF/views/boardInsertView.jsp").forward(req, resp);
		
//		PrintWriter out = resp.getWriter();
//		out.write("<form action=\"board/insert\" method=\"get\">");
//		out.write("<input type=\"text\" name=\"title\">");
//		out.write("<br>");
//		out.write("<input type=\"text\" name=\"content\">");
//		out.write("<br>");
//		out.write("<input type=\"submit\">");
//		out.write("</form>");
		
	}

}//class















