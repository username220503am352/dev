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
import com.kh.app.board.vo.SearchVo;

@WebServlet("/board/list")
public class BoardListController extends HttpServlet {
	
	//게시글 목록 조회
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		// 데이터 꺼내기
		String category = req.getParameter("category");
		String keyword = req.getParameter("keyword");
		
		// 데이터 뭉치기 (vo || map)
//		SearchVo vo = new SearchVo();
//		vo.setCategory(category);
//		vo.setKeyword(keyword);
		Map<String , String> map = new HashMap<>();
		map.put("category", category);
		map.put("keyword", keyword);
		
		
		// 디비 다녀오기
		BoardService bs = new BoardService();
		List<BoardVo> voList = bs.searchBoardList(map);
		
		// 문자열 내보내기 (디비에서 얻은 결과를 이용해서)
		req.setAttribute("voList", voList);
		req.getRequestDispatcher("/WEB-INF/views/board/list.jsp").forward(req, resp);
		
	}

}//class
































