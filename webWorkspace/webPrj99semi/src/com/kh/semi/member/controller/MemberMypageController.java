package com.kh.semi.member.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.kh.semi.member.service.MemberService;
import com.kh.semi.member.vo.MemberVo;

@WebServlet(urlPatterns = "/member/mypage")
public class MemberMypageController extends HttpServlet {
	
	// 마이페이지 (화면)
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//화면
		//resp.sendRedirect("/semi/views/member/mypage.jsp");
		req.getRequestDispatcher("/views/member/mypage.jsp").forward(req, resp);
	}
	
	// 마이페이지 (정보수정)
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		//인코딩 , 세션 객체 준비
		req.setCharacterEncoding("UTF-8");
		HttpSession session = req.getSession();
		
		//데이터 꺼내기
		String memberId = req.getParameter("memberId");
		String memberPwd1 = req.getParameter("memberPwd1");
		String memberNick = req.getParameter("memberNick");
		String addr = req.getParameter("addr");
		String[] hobby = req.getParameterValues("hobby");
		
		MemberVo loginMember = (MemberVo)session.getAttribute("loginMember");
		String no = loginMember.getNo();
		
		//데이터 뭉치기
		MemberVo vo = new MemberVo();
		vo.setId(memberId);
		vo.setPwd(memberPwd1);
		vo.setNick(memberNick);
		vo.setAddr(addr);
		vo.setHobby(String.join(",", hobby));
		vo.setNo(no);
		
		//디비 다녀오기
		MemberVo updatedMember = new MemberService().edit(vo);
		
		//화면선택
		if(updatedMember != null) {
			// ㅇㅋ
			req.getSession().setAttribute("loginMember", updatedMember);
			resp.sendRedirect("/semi");
		}else {
			// ㄴㄴ
			req.getRequestDispatcher("/views/common/errorPage.jsp").forward(req, resp);
		}
	}
	

}//class

























