package com.kh.main.member;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns = "/member/join")
public class MemberJoinServlet extends HttpServlet {
	
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/html; charset=UTF-8;");
		PrintWriter out = resp.getWriter();
		
		out.write("<!DOCTYPE html>\r\n"
				+ "<html>\r\n"
				+ "<head>\r\n"
				+ "<meta charset=\"UTF-8\">\r\n"
				+ "<title>Insert title here</title>\r\n"
				+ "</head>\r\n"
				+ "<body>\r\n"
				+ "\r\n"
				+ "	<h1>회원가입</h1>\r\n"
				+ "	\r\n"
				+ "	<form action=\"\" method=\"post\">\r\n"
				+ "		아이디 : <input type=\"text\" name=\"memberId\">\r\n"
				+ "		<br>\r\n"
				+ "		비밀번호 : <input type=\"password\" name=\"memberPwd\">\r\n"
				+ "		<br>\r\n"
				+ "		닉네임 : <input type=\"text\" name=\"memberNick\">\r\n"
				+ "		<br>\r\n"
				+ "		<input type=\"submit\" value=\"회원가입\">\r\n"
				+ "	</form>\r\n"
				+ "\r\n"
				+ "</body>\r\n"
				+ "</html>\r\n"
				+ "\r\n"
				+ "\r\n"
				+ "\r\n"
				+ "");
	}//doGet
	
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		// 데이터 꺼내기
		String memberId = req.getParameter("memberId");
		String memberPwd = req.getParameter("memberPwd");
		String memberNick = req.getParameter("memberNick");
		
		// 비니지스 로직
		// 디비 가서 insert ....
		
		int result = 1; //실제로는 DB에 insert 한 결과
		
		// 결과에 따라, 응답
		if(result == 1) {
			//회원가입 성공
			createJoinResultView(resp);
		}else {
			//회원가입 실패
			System.out.println("실패 ...");
		}
		
	}//doPost
	
	
	
	//화면 보여주는 메소드
	private void createJoinResultView(HttpServletResponse resp) throws IOException {
		resp.setContentType("text/html; charset=UTF-8;");
		PrintWriter out = resp.getWriter();
		out.write("<!DOCTYPE html>\r\n"
				+ "<html lang=\"ko\">\r\n"
				+ "<head>\r\n"
				+ "    <meta charset=\"UTF-8\">\r\n"
				+ "    <meta http-equiv=\"X-UA-Compatible\" content=\"IE=edge\">\r\n"
				+ "    <meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">\r\n"
				+ "    <title>회원가입 결과</title>\r\n"
				+ "    <style>\r\n"
				+ "        h1{\r\n"
				+ "            background-color: blue;\r\n"
				+ "        }\r\n"
				+ "    </style>\r\n"
				+ "</head>\r\n"
				+ "<body>\r\n"
				+ "    <h1>회원가입 성공</h1>\r\n"
				+ "</body>\r\n"
				+ "</html>");
	}
	
	

}//class




















