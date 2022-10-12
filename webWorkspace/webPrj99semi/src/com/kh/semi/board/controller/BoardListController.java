package com.kh.semi.board.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kh.semi.board.service.BoardService;
import com.kh.semi.board.vo.BoardVo;
import com.kh.semi.common.PageVo;

@WebServlet(urlPatterns = "/board/list")
public class BoardListController extends HttpServlet {
	
	//게시판 목록 조회 (화면)
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		//페이징처리
		int listCount;
		int currentPage;
		int pageLimit;
		int boardLimit;
		
		int maxPage;
		int startPage;
		int endPage;
		
		listCount = new BoardService().selectCount();
		currentPage = Integer.parseInt(req.getParameter("pno"));
		pageLimit = 5;
		boardLimit = 10;
		
		
		//maxPage : listCount , boardLimit 으로 계산
		/*
		 * 
		 * ex) 게시글이 10개씩 보여진다
		 * 
		 * listCount       boardLimit				  maxPage
		 * 	  100		/	   10          => 10.0		10
		 *    101		/	   10          => 10.1		11
		 *    102		/	   10          => 10.2		11
		 *    103		/	   10          => 10.3		11
		 *    
		 *    111		/	   10          => 11.1		12
		 */
		maxPage = (int)Math.ceil((double)listCount / boardLimit);
		
		//startPage : pageLimit , currentPage 로 계산
		/*
		 * ex) pageLimit 이 10 일 때,
		 * 		startPage 후보 : 1 , 11 , 21 , 31, 41 ...
		 * 						==> n * pageLimit + 1
		 * 
		 * 	currentPage     startPage       n * pageLimit + 1
		 *       1              1		=>  0 * pageLimit + 1
		 *       2              1		=>  0 * pageLimit + 1
		 *       5              1		=>  0 * pageLimit + 1
		 *       10             1		=>  0 * pageLimit + 1
		 *       11             11		=>  1 * pageLimit + 1
		 *       15             11		=>  1 * pageLimit + 1
		 *       20             11		=>  1 * pageLimit + 1
		 *       
		 *       
		 *       1  ~ 10 : 0
		 *       11 ~ 20 : 1
		 *       21 ~ 30 : 2
		 *       ...
		 *       
		 *       currentPage-1 / pageLimit    => n
		 *       
		 *       startPage =             n                   *       pageLimit + 1
		 *                 =  (currentPage-1) / pageLimit    *       pageLimit + 1
		 *       
		 * 	
		 */
		startPage = (currentPage-1) / pageLimit * pageLimit + 1;
		
		//endPage : startPage , pageLimit 으로 계산 ( + maxPage 도 고려하긴 해야함)
		/*
		 * 
		 * ex ) pageLimit : 10
		 * 
		 * startPage      =>   endPage
		 * 	   1          =>      10
		 * 	   11         =>      20
		 * 	   21          =>     30
		 */
		endPage = startPage + pageLimit - 1;
		
		if(endPage > maxPage) {
			endPage = maxPage;
		}
		
		PageVo pv = new PageVo();
		pv.setListCount(listCount);
		pv.setCurrentPage(currentPage);
		pv.setPageLimit(pageLimit);
		pv.setBoardLimit(boardLimit);
		pv.setMaxPage(maxPage);
		pv.setStartPage(startPage);
		pv.setEndPage(endPage);
		
		//디비다녀오기
		List<BoardVo> x = new BoardService().selectList(pv);
		
		req.setAttribute("voList", x);
		req.setAttribute("pv", pv);
		
		//화면선택
		req.getRequestDispatcher("/views/board/list.jsp").forward(req, resp);
		
	}

}//class



























