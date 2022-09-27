package com.kh.app.board.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kh.app.board.service.BoardService;
import com.kh.app.board.vo.BoardVo;

@WebServlet(urlPatterns = "/board/list")
public class BoardListServlet extends HttpServlet {
	
	//게시글 목록 조회 (화면)
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		//데이터 꺼내기
		//데이터 뭉치기
		
		//디비다녀오기
		BoardService bs = new BoardService();
		List<BoardVo> list = bs.selectBoardList();
		
		//화면선택
		req.setAttribute("voList", list);
		req.getRequestDispatcher("/views/board/list.jsp").forward(req, resp);
	}
	

}//class



























