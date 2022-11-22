package com.kh.app.board.controller;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kh.app.board.service.BoardService;
import com.kh.app.board.vo.BoardVo;
import com.kh.app.common.page.PageVo;
import com.kh.app.common.page.Pagination;

@WebServlet("/board/list")
public class BoardListController extends HttpServlet {
	
	private BoardService bs = new BoardService();
	
	//게시글 목록
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		//데이터 꺼내기
		String category = req.getParameter("category");
		String keyword = req.getParameter("keyword");
		String p = req.getParameter("p");
		
		// PageVo 객체 만들기 (boardLimit , pageLimit, currentPage , listCount)
		int listCount = bs.selectCount();
		int currentPage = Integer.parseInt(p);
		int boardLimit = 5;
		int pageLimit = 5;
		PageVo pv = Pagination.getPageVo(listCount, currentPage, pageLimit, boardLimit);
		
		//데이터 뭉치기
		Map<String , String> map = new HashMap<>();
		map.put("category", category);
		map.put("keyword", keyword);
		
		//디비 다녀오기
		List<BoardVo> list = bs.selectBoardList(map , pv);
		
		//문자열 내보내기
		req.setAttribute("list", list);
		req.getRequestDispatcher("/WEB-INF/views/board/list.jsp").forward(req, resp);
		
	}

}//class



























