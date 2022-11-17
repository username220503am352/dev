package com.kh.app.board.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kh.app.board.service.BoardService;
import com.kh.app.board.vo.BoardVo;

@WebServlet(urlPatterns = "/board/insert")
public class BoardInsertController extends HttpServlet {
	
	//게시글 작성하기 (화면)
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		//문자열 내보내기
		req.getRequestDispatcher("/WEB-INF/views/board/write.jsp").forward(req, resp);
		
	}
	
	//게시글 작성하기 (찐)
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		//데이터 꺼내기
		String title = req.getParameter("title");
		String content = req.getParameter("content");
		
		//데이터 뭉치기
		BoardVo vo = new BoardVo();
		vo.setTitle(title);
		vo.setContent(content);
		
		//디비 다녀오기
		BoardService bs = new BoardService();
		int result = bs.write(vo);
		
		//문자열 내보내기
		if(result == 1) {
			//성공
			//resp.getWriter().write("게시글 목록 보여주기 <script>alert('성공');</script>");
		}else {
			//실패
		}
		
	}

}//class






























