package com.kh.app.board.controller;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kh.app.board.service.BoardService;
import com.kh.app.board.vo.BoardVo;
import com.kh.app.common.JDBCTemplate;

@WebServlet(urlPatterns = "/board/write")
public class BoardWriteServlet extends HttpServlet {
	
	//게시글 작성 (화면)
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.getRequestDispatcher("/views/board/write.jsp").forward(req, resp);
	}
	
	//게시글 작성
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		//인코딩
		req.setCharacterEncoding("UTF-8");
		
		// 데이터 꺼내기
		String title = req.getParameter("title");
		String content = req.getParameter("content");
		
		// 데이터 뭉치기
		BoardVo vo = new BoardVo(title, content);
//		vo.setTitle(title);
//		vo.setContent(content);
		
		// 디비 다녀오기
		BoardService bs = new BoardService();
		int result = bs.write(vo);
		
		
		// 화면 선택
		if(result == 1) {
			//리다이렉트 , 게시글 목록
			resp.sendRedirect("/app19/board/list");
		}else {
			// 에러페이지 , 에러메세지 담아서 , 포워딩
			req.setAttribute("errorMsg", "게시글 작성 실패 ...");
			req.getRequestDispatcher("/views/common/errorPage.jsp").forward(req, resp);
		}
		
	}
	
}//class
































