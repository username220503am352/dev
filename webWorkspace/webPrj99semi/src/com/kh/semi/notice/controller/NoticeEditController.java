package com.kh.semi.notice.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kh.semi.notice.service.NoticeService;
import com.kh.semi.notice.vo.NoticeVo;

@WebServlet(urlPatterns = "/notice/edit")
public class NoticeEditController extends HttpServlet {
	
	//공지사항 수정하기 (화면)
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		//데이터 꺼내기
		String no = req.getParameter("no");
		
		//데이터 뭉치기
		
		//디비 다녀오기
		NoticeVo vo = new NoticeService().selectNoticeOne(no);
		
		//화면 선택
		req.setAttribute("vo", vo);
		req.getRequestDispatcher("/views/notice/edit.jsp").forward(req, resp);
		
	}
	
	//공지사항 수정하기
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		//인코딩
		req.setCharacterEncoding("UTF-8");
		
		// 데이터 꺼내기
		String title = req.getParameter("title");
		String content = req.getParameter("content");
		String no = req.getParameter("no");
		
		// 데이터 뭉치기
		NoticeVo vo = new NoticeVo();
		vo.setTitle(title);
		vo.setContent(content);
		vo.setNo(no);
		
		// 디비 다녀오기
		int result = new NoticeService().edit(vo);
		
		// 화면선택
		if(result == 1) {
			//성공 => 공지사항 상세조회 //성공 알람
			req.getSession().setAttribute("alertMsg", "공지사항 수정 성공!");
			resp.sendRedirect("/semi/notice/detail?no=" + no);
		}else {
			//실패 => 에러페이지
			req.setAttribute("msg", "공지사항 수정 실패 ...");
			req.getRequestDispatcher("/views/common/errorPage.jsp").forward(req, resp);
		}
		
	}

}//class























