package com.kh.app.member.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kh.app.member.service.MemberService;
import com.kh.app.member.vo.MemberVo;

@WebServlet(urlPatterns = "/member/join")
public class MemberJoinController extends HttpServlet {
	
	//회원가입 화면
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.getRequestDispatcher("/WEB-INF/views/member/join.jsp").forward(req, resp);
	}
	
	//회원가입 찐
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("회원가입 찐 ... 시작 ...");
		
		// 데이터 꺼내기
		String memberId = req.getParameter("memberId");
		String memberPwd = req.getParameter("memberPwd");
		
		// 데이터 뭉치기
		MemberVo vo = new MemberVo();
		vo.setMemberId(memberId);
		vo.setMemberPwd(memberPwd);
		
		// 디비 다녀오기
		MemberService ms = new MemberService();
		int result = ms.join(vo);
		
		// 문자열 내보내기
		//resp.getWriter().write("<h1>실행결과 : " + result + "<h1>");
		req.setAttribute("result", result);
		req.getRequestDispatcher("/WEB-INF/views/common/result.jsp").forward(req, resp);
	}
	
	

}//class

























