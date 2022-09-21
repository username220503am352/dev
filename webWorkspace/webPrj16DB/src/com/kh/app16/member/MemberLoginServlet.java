package com.kh.app16.member;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns = "/member/login")
public class MemberLoginServlet extends HttpServlet {
	
	//로그인 (화면)
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.getRequestDispatcher("/views/member/login.jsp").forward(req, resp);
	}
	
	//로그인
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		//데이터 꺼내기
		String memberId = req.getParameter("memberId");
		String memberPwd = req.getParameter("memberPwd");
		
		//데이터 뭉치기
		MemberVo vo = new MemberVo();
		vo.setMemberId(memberId);
		vo.setMemberPwd(memberPwd);
		
		//디비 다녀오기
		/*
		 * 커넥션 준비 (라이브러리 준비, 클래스 등록,커넥션얻기-driver,url,username,userpwd)
		 * SQL 준비
		 * SQL 완성
		 * SQL 실행 및 결과저장
		 */
		
		//웹 프로젝트에 라이브러리 연결 : WebContent/WEB-INF/lib 폴더에 jar 파일 넣어주면 됨
		
		String driver = "oracle.jdbc.driver.OracleDriver";
		String url = "jdbc:oracle:thin:@127.0.0.1:1521:xe";
		String username= "C##SEMI";
		String password = "SEMI";
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		MemberVo loginMember = null;
		try {
			Class.forName(driver);
			
			//커넥션 준비
			conn = DriverManager.getConnection(url, username, password);
			
			//SQL 준비
			String sql = "SELECT MEMBER_ID, MEMBER_PWD, MEMBER_NICK FROM MEMBER WHERE MEMBER_ID = ? AND MEMBER_PWD = ?";
			pstmt = conn.prepareStatement(sql);
			
			//SQL 완성
			pstmt.setString(1, vo.getMemberId());
			pstmt.setString(2, vo.getMemberPwd());
			
			//SQL 실행 및 결과저장
			rs = pstmt.executeQuery();
			
			//rs -> obj
			if(rs.next()) {
				//rs -> data
				String data1 = rs.getString("MEMBER_ID");
				String data2 = rs.getString("MEMBER_PWD");
				String data3 = rs.getString("MEMBER_NICK");
				
				//data -> obj
				loginMember = new MemberVo();
				loginMember.setMemberId(data1);
				loginMember.setMemberPwd(data2);
				loginMember.setMemberNick(data3);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {if(rs != null && !rs.isClosed())rs.close();} catch (SQLException e) {}
			try {if(pstmt != null && !pstmt.isClosed())pstmt.close();} catch (SQLException e) {}
			try {if(conn != null && !conn.isClosed())conn.close();} catch (SQLException e) {}
		}
		
		//화면선택
		if(loginMember != null) {
			//성공
			System.out.println("로그인 성공 !!!");
			System.out.println(loginMember);
			resp.sendRedirect("/app16");
		}else {
			//실패
			resp.sendRedirect("/app16/error");
		}
		
	}

}//class






























