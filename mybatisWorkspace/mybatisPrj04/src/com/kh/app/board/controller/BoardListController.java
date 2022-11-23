package com.kh.app.board.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kh.app.board.service.BoardService;
import com.kh.app.board.service.BoardServiceImpl;
import com.kh.app.board.vo.BoardVo;
import com.kh.app.common.page.PageVo;
import com.kh.app.common.page.Pagination;

@WebServlet("/board/list")
public class BoardListController extends HttpServlet {
	
	@Override
	public void init() throws ServletException {
		System.out.println("init~~~");
	}
	
	@Override
	public void destroy() {
		System.out.println("파괴됨 ~~~");
	}
	
	private BoardService service = new BoardServiceImpl();
	
	//게시글 목록 보여주기
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		//데이터 꺼내기
		int p = Integer.parseInt(req.getParameter("p"));
		
		//PageVo 객체 만들기
		int listCount = service.selectCnt();
		int currentPage = p;
		int pageLimit = 5;
		int boardLimit = 10;
		PageVo pv = Pagination.getPageVo(listCount, currentPage, pageLimit, boardLimit);
		
		//디비 다녀오기
		List<BoardVo> voList = service.selectBoardList(pv);
		
		//문자열 내보내기
		req.setAttribute("voList", voList);
		req.getRequestDispatcher("/WEB-INF/views/board/list.jsp").forward(req, resp);
		
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doGet(req, resp);
	}

}//class































