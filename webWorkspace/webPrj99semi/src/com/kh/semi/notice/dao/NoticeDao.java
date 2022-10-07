package com.kh.semi.notice.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.kh.semi.common.JDBCTemplate;
import com.kh.semi.notice.vo.NoticeVo;

public class NoticeDao {

	//공지사항 작성
	public int insertNotice(Connection conn, NoticeVo vo) {
		//SQL (준비 , 완성 , 실행)
		
		String sql = "INSERT INTO NOTICE ( NO ,TITLE ,CONTENT ,WRITER ) VALUES ( SEQ_NOTICE_NO.NEXTVAL , ? , ? , ? )";
		
		PreparedStatement pstmt = null;
		int result = 0;
		
		try {
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, vo.getTitle());
			pstmt.setString(2, vo.getContent());
			pstmt.setString(3, vo.getWriter());
			
			result = pstmt.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(pstmt);
		}
		
		return result;
	}//method

	//공지사항 목록 조회
	public List<NoticeVo> selectNoticeList(Connection conn) {
		//SQL
		
		String sql = "SELECT * FROM NOTICE WHERE STATUS = 'O' ORDER BY NO DESC";
		
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		List<NoticeVo> voList = new ArrayList<NoticeVo>();
		
		try {
			pstmt = conn.prepareStatement(sql);
			
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				String no = rs.getString("NO");
				String title = rs.getString("TITLE");
				String content = rs.getString("CONTENT");
				String writer = rs.getString("WRITER");
				String hit = rs.getString("HIT");
				String enrollDate = rs.getString("ENROLL_DATE");
				String modifyDate = rs.getString("MODIFY_DATE");
				
				NoticeVo vo = new NoticeVo();
				vo.setNo(no);
				vo.setTitle(title);
				vo.setContent(content);
				vo.setWriter(writer);
				vo.setHit(hit);
				vo.setEnrollDate(enrollDate);
				vo.setModifyDate(modifyDate);
				
				voList.add(vo);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(rs);
			JDBCTemplate.close(pstmt);
		}
		
		return voList;
		
	}

	//공지사항 상세조회
	public NoticeVo selectNoticeOne(Connection conn, String no) {
		//SQL (준비 , 완성 , 실행 및 결과저장)
		
		String sql = "SELECT N.NO , N.TITLE , N.CONTENT , N.HIT , N.ENROLL_DATE , N.MODIFY_DATE , N.STATUS , M.NICK AS WRITER FROM NOTICE N JOIN MEMBER M ON N.WRITER = M.NO WHERE N.NO = ? AND N.STATUS = 'O'";
		
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		NoticeVo vo = null;
		
		try {
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, no);
			
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				String title = rs.getString("TITLE");
				String content = rs.getString("CONTENT");
				String writer = rs.getString("WRITER");
				String hit = rs.getString("HIT");
				String enrollDate = rs.getString("ENROLL_DATE");
				String modifyDate = rs.getString("MODIFY_DATE");
				
				vo = new NoticeVo();
				vo.setNo(no);
				vo.setTitle(title);
				vo.setContent(content);
				vo.setWriter(writer);
				vo.setHit(hit);
				vo.setEnrollDate(enrollDate);
				vo.setModifyDate(modifyDate);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(rs);
			JDBCTemplate.close(pstmt);
		}
		
		return vo;
	}
	
	//조회수 증가
	public int increaseHit(Connection conn , String no) {
		//SQL
		
		String sql = "UPDATE NOTICE SET HIT = HIT + 1 WHERE NO = ?";
		
		PreparedStatement pstmt = null;
		int result = 0;
		
		try {
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, no);
			
			result = pstmt.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(pstmt);
		}
		
		return result;
		
	}

	//공지사항 수정하기
	public int updateOneByNo(Connection conn, NoticeVo vo) {
		// SQL (준비, 완성, 실행)
		
		String sql = "UPDATE NOTICE SET TITLE = ? , CONTENT = ? , MODIFY_DATE = SYSDATE WHERE NO = ?";

		
		PreparedStatement pstmt = null;
		int result = 0;
		
		try {
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, vo.getTitle());
			pstmt.setString(2, vo.getContent());
			pstmt.setString(3, vo.getNo());
			
			result = pstmt.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(pstmt);
		}
		
		return result;
	}

	//공지사항 삭제
	public int delete(Connection conn, String no) {
		//SQL (준비 , 완성 , 실행)
		
		String sql = "DELETE NOTICE WHERE NO = ?";
		
		PreparedStatement pstmt = null;
		int result = 0;
		
		try {
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, no);
			
			result = pstmt.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(pstmt);
		}
		
		return result;
	}
	
	

}//class





























