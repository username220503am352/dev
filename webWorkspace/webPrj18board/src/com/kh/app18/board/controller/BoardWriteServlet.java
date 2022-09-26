package com.kh.app18.board.controller;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kh.app18.board.vo.BoardVo;

@WebServlet(urlPatterns = "/board/write")
public class BoardWriteServlet extends HttpServlet {
	
	//게시글 작성 (화면)
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.getRequestDispatcher("/views/board/write.jsp").forward(req, resp);
	}
	
	//게시글 작성
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		// 인코딩
		req.setCharacterEncoding("UTF-8");
		
		// 데이터 꺼내기
		String title = req.getParameter("title");
		String content = req.getParameter("content");
		
		// 데이터 뭉치기
		BoardVo vo = new BoardVo();
		vo.setTitle(title);
		vo.setContent(content);
		
		
		// DB다녀오기
		
		/*
		 * 커넥션 준비 (라이브러리 , 클래스등록 , driver , url , username , password)
		 * SQL (준비 , 완성 , 실행및저장)
		 * 트랜잭션 처리 , 자원반납
		 */
		
		//커넥션 준비
		
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
			
			//SQL (준비, 완성, 실행 및 결과저장)
			
			String sql = "INSERT INTO BOARD(TITLE, CONTENT) VALUES(?,?)";
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, vo.getTitle());
			pstmt.setString(2, vo.getContent());
			
			result = pstmt.executeUpdate();
			
			conn.commit();
			
		} catch (Exception e) {
			try {if(conn != null && !conn.isClosed())conn.rollback();} catch (SQLException e1) {}
			e.printStackTrace();
		} finally {
			try {if(pstmt != null && !pstmt.isClosed())pstmt.close();} catch (SQLException e) {}
			try {if(conn != null && !conn.isClosed())conn.close();} catch (SQLException e) {}
		}
		
		// 화면선택
		if(result == 1) {
			//게시글 작성 성공
			resp.sendRedirect("/app18");
		}else {
			//게시글 작성 실패
			req.setAttribute("errorMsg", "게시글 작성 실패 !!!");
			req.getRequestDispatcher("/views/common/error.jsp").forward(req, resp);
		}
		
	}

}//class





















