package com.kh.main.member.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kh.main.member.vo.MemberVo;

@WebServlet(urlPatterns = "/member/login")
public class MemberLoginServlet extends HttpServlet {
	
	//로그인
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		//데이터 꺼내기
		String memberId = req.getParameter("memberId");
		String memberPwd = req.getParameter("memberPwd");
		
		//데이터 뭉치기 (VO)
		MemberVo vo = new MemberVo();
		vo.setMemberId(memberId);
		vo.setMemberPwd(memberPwd);
		
		
		//화면
		req.setAttribute("vo", vo);
		req.getRequestDispatcher("/result.jsp").forward(req, resp);
		
		
		
		
	}

}
