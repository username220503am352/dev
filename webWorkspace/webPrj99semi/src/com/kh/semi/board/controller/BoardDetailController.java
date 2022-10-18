package com.kh.semi.board.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kh.semi.board.service.BoardService;
import com.kh.semi.board.vo.AttachmentVo;
import com.kh.semi.board.vo.BoardVo;

@WebServlet(urlPatterns = "/board/detail")
public class BoardDetailController extends HttpServlet {
	
	//게시글 상세조회
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		//데이터 꺼내기
		String bno = req.getParameter("bno");
		
		//데이터 뭉치기
		
		//디비 다녀오기
		BoardVo vo = new BoardService().selectOne(bno);
		AttachmentVo attachmentVo = new BoardService().selectAttachment(bno);
		
		//화면선택
		req.setAttribute("vo", vo);
		req.setAttribute("attachmentVo", attachmentVo);
		req.getRequestDispatcher("/views/board/detail.jsp").forward(req, resp);
		
	}

}//class






























