package com.kh.app18.board.controller;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kh.app18.board.vo.BoardVo;

@WebServlet(urlPatterns = "/board/list")
public class BoardListServlet extends HttpServlet {
	
	//게시글 목록 조회
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		// 데이터 꺼내기
		// 데이터 뭉치기
		
		// 디비 다녀오기
		
		/*
		 * 커넥션 준비 (라이브러리 , 클래스 등록 , driver , url, username , password)
		 * SQL (준비, 완성, 실행 및 결과저장)
		 * 트랜잭션 처리, 자원반납
		 */
		
		String driver = "oracle.jdbc.driver.OracleDriver";
		String url = "jdbc:oracle:thin:@localhost:1521:xe";
		String username = "C##SEMI";
		String password = "SEMI";
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		ArrayList<BoardVo> voList = new ArrayList<BoardVo>(); 
		
		try {
			Class.forName(driver);
			conn = DriverManager.getConnection(url, username, password);
			conn.setAutoCommit(false);
			
			String sql = "SELECT TITLE, CONTENT FROM BOARD";
			pstmt = conn.prepareStatement(sql);
			
			rs = pstmt.executeQuery();
			
			//rs -> data -> vo
			while(rs.next()) {
				String title = rs.getString("TITLE");
				String content = rs.getString("CONTENT");
				
				BoardVo vo = new BoardVo();
				vo.setTitle(title);
				vo.setContent(content);
				
				voList.add(vo);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {if(rs != null && !rs.isClosed())rs.close();} catch (SQLException e) {}
			try {if(pstmt != null && !pstmt.isClosed())pstmt.close();} catch (SQLException e) {}
			try {if(conn != null && !conn.isClosed())conn.close();} catch (SQLException e) {}
		}
		
		
		// 화면선택
		req.setAttribute("voList", voList);
		req.getRequestDispatcher("/views/board/list.jsp").forward(req, resp);
		
	}

}//class






























