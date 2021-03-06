package com.kh.board;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.*;

import static com.kh.common.JDBCTemplate.*;

public class BoardDao {
	
	/*
	 * 게시글 작성
	 * 
	 * 데이터 받기 (컨트롤러)
	 * 
	 * 비지니스 로직 (서비스)
	 * 
	 * DB에 insert (DAO)
	 * 
	 */
	public int write(BoardVo vo, Connection conn) throws Exception {
		//커넥션 준비
		
		int result = 0;
		PreparedStatement pstmt = null;
		
		try {
			//SQL 작성
			String sql = "INSERT INTO BOARD(NO, TITLE, CONTENT, WRITER_NO) VALUES(SEQ_BOARD_NO.NEXTVAL, ?,?,?)";
			
			//SQL 객체에 담기 및 완성(물음표 채우기)
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, vo.getTitle());
			pstmt.setString(2, vo.getContent());
			pstmt.setString(3, vo.getWriter());
			
			//SQL 실행 및 결과 저장
			result = pstmt.executeUpdate();
		}finally {
			close(pstmt);
		}
		
		return result;
		
	}//method
	
	public List<BoardVo> showList(Connection conn) throws Exception {
		//CONN 준비
		
		//SQL 준비
		String sql = "SELECT B.NO , B.TITLE , B.CONTENT , B.WRITER_NO , B.ENROLL_DATE , B.MODIFY_DATE , M.NICK FROM BOARD B JOIN MEMBER M ON B.WRITER_NO = M.NO WHERE B.STATUS = 'Y' ORDER BY ENROLL_DATE DESC";
		
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		List<BoardVo> boardVoList = new ArrayList<BoardVo>();
		
		try {
			//SQL 담을 객체 준비 및 SQL 완성
			pstmt = conn.prepareStatement(sql);
			
			//SQL 실행 및 결과 저장
			rs = pstmt.executeQuery();
			
			//커서 내리고, 칼럼별로 읽어오기, 객체로 만들기  << 반복
			//  rs.next,  rs.getXXX("칼럼명"), vo.setXXX
			
			while(rs.next()) {
				int no = rs.getInt("NO");
				String title = rs.getString("TITLE");
				Timestamp enrollDate = rs.getTimestamp("ENROLL_DATE");
				String writer = rs.getString("NICK");
				
				BoardVo vo = new BoardVo();
				vo.setNo(no);
				vo.setTitle(title);
				vo.setEnrollDate(enrollDate);
				vo.setWriter(writer);
				
				boardVoList.add(vo);
			}
			
		}finally {
			close(rs);
			close(pstmt);
		}
		
		//SQL 실행 결과 리턴
		return boardVoList;
		
	}//method

	
	/*
	 * 게시글 상세 조회
	 */
	public BoardVo showDetailByNo(Connection conn, int num) throws Exception {
		//connection 준비
		
		//SQL 준비
		String sql = "SELECT B.NO , B.TITLE , B.CONTENT , B.WRITER_NO , B.ENROLL_DATE , B.MODIFY_DATE , M.NICK FROM BOARD B JOIN MEMBER M ON B.WRITER_NO = M.NO WHERE B.NO = ? AND B.STATUS = 'Y'";
		
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		BoardVo vo = null;
		
		try {
			//SQL 객체에 담기 및 쿼리 완성하기
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, num);
			
			//SQL 실행 및 결과 저장
			rs = pstmt.executeQuery();
			
			//ResultSet -> 자바객체
			if(rs.next()) {
				int no = rs.getInt("NO");
				String title = rs.getString("TITLE");
				String content = rs.getString("CONTENT");
				String writerNo = rs.getString("WRITER_NO");
				Timestamp enrollDate = rs.getTimestamp("ENROLL_DATE");
				Timestamp modifyDate = rs.getTimestamp("MODIFY_DATE");
				String nick = rs.getString("NICK");
				
				vo = new BoardVo();
				vo.setNo(no);
				vo.setTitle(title);
				vo.setContent(content);
				vo.setWriter(nick);
				vo.setEnrollDate(enrollDate);
				vo.setModifyDate(modifyDate);
			}
		}catch(Exception e) {
			e.printStackTrace();
			throw e;
		}finally {
			close(pstmt);
			close(rs);
		}
		
		//실행결과(자바객체) 리턴
		return vo;
	}
	
	

}//class





























