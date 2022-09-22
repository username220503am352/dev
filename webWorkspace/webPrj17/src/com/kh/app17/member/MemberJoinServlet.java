package com.kh.app17.member;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns = "/member/join")
public class MemberJoinServlet extends HttpServlet {
	
	//회원가입 (화면)
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//req.getRequestDispatcher("/views/member/join.jsp").forward(req, resp);
		RequestDispatcher view = req.getRequestDispatcher("/views/member/join.jsp");
		view.forward(req, resp);
	}
	
	//회원가입
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		// 데이터 꺼내기
		String memberId = req.getParameter("memberId");
		String memberPwd = req.getParameter("memberPwd");
		String memberNick = req.getParameter("memberNick");
		
		// 데이터 뭉치기 (vo)
		MemberVo vo = new MemberVo();
		vo.setMemberId(memberId);
		vo.setMemberPwd(memberPwd);
		vo.setMemberNick(memberNick);
		
		
		// 디비 다녀오기 ( == 비지니스 로직 == 서비스 로직)
		/*
		 * 커넥션 준비
		 * 	- 라이브러리 : WebContnet/WEB-INF/lib 경로에 원하는 jar파일 추가
		 *  - 드라이버 경로 : 검색
		 *  - URL : 디비에 접속할 때 필요한 경로
		 *  - username : 디비에 접속할 때 사용할 계정명
		 *  - password : 디비에 접속할 때 사용할 계정 비밀번호
		 *  - 커넥션 얻기
		 *  - autocommit 설정
		 * SQL 준비
		 * SQL 완성
		 * SQL 실행 및 결과저장
		 * 트랜잭션 처리 (커밋,롤백)
		 * 자원 반납
		 */
		
		//커넥션 준비 (라이브러리 , 클래스 등록(드라이버 경로) , 디비접속URL , 디비접속아이디 , 디비접속패스워드)
		
		String driver = "oracle.jdbc.driver.OracleDriver";
		String url = "jdbc:oracle:thin:@localhost:1521:xe";
		String username = "C##SEMI";
		String password = "SEMI";
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		int result = 0;
		
		try {
			Class.forName(driver);
			
			conn = DriverManager.getConnection(url, username, password);
			conn.setAutoCommit(false);
			
			//SQL 준비
			String sql = "INSERT INTO MEMBER ( MEMBER_ID , MEMBER_PWD , MEMBER_NICK ) VALUES ( ? , ? , ? )";
			pstmt = conn.prepareStatement(sql);
			
			//SQL 완성
			pstmt.setString(1, vo.getMemberId());
			pstmt.setString(2, vo.getMemberPwd());
			pstmt.setString(3, vo.getMemberNick());
			
			//SQL 실행
			result = pstmt.executeUpdate();
			
			conn.commit();
			
		} catch (Exception e) {
			try {if(conn != null && !conn.isClosed())conn.rollback();} catch (SQLException e1) {e1.printStackTrace();}
			e.printStackTrace();
		} finally {
			try {if(pstmt != null && !pstmt.isClosed()) {pstmt.close();}} catch (SQLException e) {}
			try {if(conn != null && !conn.isClosed()) {conn.close();}} catch (SQLException e) {}
		}
		
		// 화면 선택
		if(result == 1) {
			resp.sendRedirect("/app17");
		}else {
			resp.sendRedirect("/app17/error");
		}
		
	}

}//class



















