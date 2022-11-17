package com.kh.app.member.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kh.app.member.service.MemberService;
import com.kh.app.member.vo.MemberVo;

@WebServlet("/member/list")
public class MemberListController extends HttpServlet {
	
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		System.out.println("회원목록 조회...");
		
		//데이터 꺼내기
		//데이터 뭉치기
		
		//디비 다녀오기 (전체 목록 조회)
		MemberService ms = new MemberService();
		List<MemberVo> list = ms.selectMemberListAll();
		
		//문자열 만들어서 내보내기 (이거는 JSP한테 맡기자)
		req.setAttribute("list", list);
		req.getRequestDispatcher("/WEB-INF/views/member/list.jsp").forward(req, resp);
		
		
	}

}//class




























