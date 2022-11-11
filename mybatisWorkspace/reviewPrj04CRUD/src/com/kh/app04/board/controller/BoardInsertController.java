package com.kh.app04.board.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kh.app04.board.service.BoardService;
import com.kh.app04.board.vo.BoardVo;
import com.kh.app04.common.JDBCTemplate;

@WebServlet("/board/insert")
public class BoardInsertController extends HttpServlet {
	
	/**
	 * 게시글 작성 화면
	 */
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
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
		
	}//method
	
	
	/**
	 * 게시글 작성 처리
	 */
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//인코딩
		req.setCharacterEncoding("UTF-8");
		
		//데이터 꺼내기
		String title = req.getParameter("title");
		String content = req.getParameter("content");
		
		//데이터 뭉치기
		BoardVo vo = new BoardVo();
		vo.setTitle(title);
		vo.setContent(content);
		
		System.out.println(vo);
		
		//디비다녀오기
		BoardService service = new BoardService();
		service.insertBoard(vo);
		
		//화면선택 (문자열 내보내기) ,,, 서블릿이하기 힘듦 ,,,,, JSP한테 바톤터치 ... JSP야 부탁해 ...
		req.getRequestDispatcher("/WEB-INF/views/boardListView.jsp").forward(req, resp);
		
	}
	

}//class















