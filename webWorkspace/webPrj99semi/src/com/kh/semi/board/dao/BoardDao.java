package com.kh.semi.board.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.kh.semi.board.vo.AttachmentVo;
import com.kh.semi.board.vo.BoardVo;
import com.kh.semi.board.vo.CategoryVo;
import com.kh.semi.common.JDBCTemplate;
import com.kh.semi.common.PageVo;

public class BoardDao {

	//카테고리 목록 조회
	public List<CategoryVo> selectCategoryList(Connection conn) {
		//SQL
		
		String sql = "SELECT NO, NAME FROM CATEGORY";
		
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		List<CategoryVo> list = new ArrayList<CategoryVo>();
		
		try {
			pstmt = conn.prepareStatement(sql);
			
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				String no = rs.getString("NO");
				String name = rs.getString("NAME");
				
				CategoryVo vo = new CategoryVo(no , name);
				
				list.add(vo);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(rs);
			JDBCTemplate.close(pstmt);
		}
		
		return list;
	}

	//게시글 작성
	public int insertBoard(Connection conn, BoardVo vo) {
		//SQL
		
		String sql = "INSERT INTO BOARD ( NO ,TYPE ,CATEGORY ,TITLE ,CONTENT ,WRITER ) VALUES ( SEQ_BOARD_NO.NEXTVAL , 1 , ? , ? , ? , ? )";
		
		PreparedStatement pstmt = null;
		int result = 0;
		
		try {
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, vo.getCategory());
			pstmt.setString(2, vo.getTitle());
			pstmt.setString(3, vo.getContent());
			pstmt.setString(4, vo.getWriter());
			
			result = pstmt.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(pstmt);
		}
		
		return result;
	}

	//게시글 목록 조회
	public List<BoardVo> selectList(Connection conn, PageVo pv) {
		//SQL
		
		String sql = "SELECT * FROM ( SELECT ROWNUM AS RNUM , T.* FROM ( SELECT B.NO ,B.TYPE ,B.CATEGORY ,B.TITLE ,B.CONTENT ,B.HIT ,B.ENROLL_DATE ,B.MODIFY_DATE ,B.STATUS ,M.NICK AS WRITER FROM BOARD B JOIN MEMBER M ON B.WRITER = M.NO WHERE B.STATUS = 'O' ORDER BY B.NO DESC ) T ) WHERE RNUM BETWEEN ? AND ?";
		
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		List<BoardVo> voList = new ArrayList<BoardVo>();
		
		try {
			pstmt = conn.prepareStatement(sql);
			
			int start = (pv.getCurrentPage() - 1) * pv.getBoardLimit() + 1;
			int end = start + pv.getBoardLimit() - 1;
			
			pstmt.setInt(1, start);
			pstmt.setInt(2, end);
			
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				String no = rs.getString("NO");
				String type = rs.getString("TYPE");
				String category = rs.getString("CATEGORY");
				String title = rs.getString("TITLE");
				String content = rs.getString("CONTENT");
				String writer = rs.getString("WRITER");
				String hit = rs.getString("HIT");
				String enrollDate = rs.getString("ENROLL_DATE");
				String modifyDate = rs.getString("MODIFY_DATE");
				String status = rs.getString("STATUS");
				
				BoardVo vo = new BoardVo();
				vo.setNo(no);
				vo.setType(type);
				vo.setCategory(category);
				vo.setTitle(title);
				vo.setContent(content);
				vo.setWriter(writer);
				vo.setHit(hit);
				vo.setEnrollDate(enrollDate);
				vo.setModifyDate(modifyDate);
				vo.setStatus(status);
				
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

	//게시글 갯수 조회
	public int selectCount(Connection conn) {
		//SQL
		
		String sql = "SELECT COUNT(*) AS CNT FROM BOARD WHERE STATUS = 'O'";
		
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		int result = 0;
		
		try {
			pstmt = conn.prepareStatement(sql);
			
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				result = rs.getInt("CNT");
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(rs);
			JDBCTemplate.close(pstmt);
		}
		
		return result;
	}

	//게시글 상세조회
	public BoardVo selectOne(Connection conn, String bno) {
		//SQL
		
		String sql = "SELECT B.NO ,B.TYPE ,B.TITLE ,B.CONTENT ,B.HIT ,B.ENROLL_DATE ,B.MODIFY_DATE ,B.STATUS ,M.NICK AS WRITER ,C.NAME AS CATEGORY FROM BOARD B JOIN MEMBER M ON B.WRITER = M.NO JOIN CATEGORY C ON B.CATEGORY = C.NO WHERE B.NO = ? AND B.STATUS = 'O'";
		
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		BoardVo vo = null;
		
		try {
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, bno);
			
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				String no = rs.getString("NO");
				String type = rs.getString("TYPE");
				String category = rs.getString("CATEGORY");
				String title = rs.getString("TITLE");
				String content = rs.getString("CONTENT");
				String writer = rs.getString("WRITER");
				String hit = rs.getString("HIT");
				String enrollDate = rs.getString("ENROLL_DATE");
				String modifyDate = rs.getString("MODIFY_DATE");
				String status = rs.getString("STATUS");
				
				vo = new BoardVo();
				vo.setNo(no);
				vo.setType(type);
				vo.setCategory(category);
				vo.setTitle(title);
				vo.setContent(content);
				vo.setWriter(writer);
				vo.setHit(hit);
				vo.setEnrollDate(enrollDate);
				vo.setModifyDate(modifyDate);
				vo.setStatus(status);
				
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
	public int increaseHit(Connection conn, String bno) {
		//SQL
		
		String sql = "UPDATE BOARD SET HIT = HIT + 1 WHERE NO = ? AND STATUS = 'O'";
		
		PreparedStatement pstmt = null;
		int result = 0;
		
		try {
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, bno);
			
			result = pstmt.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(pstmt);
		}
		return result;
	}

	//첨부파일 insert
	public int insertAttachment(Connection conn, AttachmentVo attachmentVo) {
		// SQL (준비 , 완성 , 실행)
		
		String sql = "INSERT INTO ATTACHMENT ( NO ,BOARD_NO ,ORIGIN_NAME ,CHANGE_NAME ,FILE_PATH ) VALUES ( SEQ_ATTACHMENT_NO.NEXTVAL , SEQ_BOARD_NO.CURRVAL , ? , ? , ? )";
		int result = 0;
		
		PreparedStatement pstmt = null;
		
		try {
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, attachmentVo.getOriginName());
			pstmt.setString(2, attachmentVo.getChangeName());
			pstmt.setString(3, attachmentVo.getFilePath());
			
			result = pstmt.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(pstmt);
		}
		return result;
	}

	//첨부파일 조회
	public AttachmentVo selectAttachment(Connection conn, String bno) {
		// SQL (준비 , 완성 , 실행)
		
		String sql = "zzzzzzzSELECT * FROM ATTACHMENT WHERE STATUS = 'O' AND BOARD_NO = ?";
		
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		AttachmentVo vo = null;
		
		try {
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, bno);
			
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				String no = rs.getString("NO");
				String board_no = rs.getString("BOARD_NO");
				String originName = rs.getString("ORIGIN_NAME");
				String changeName = rs.getString("CHANGE_NAME");
				String filePath = rs.getString("FILE_PATH");
				String enrollDate = rs.getString("ENROLL_DATE");
				String thumbYn = rs.getString("THUMB_YN");
				String status = rs.getString("STATUS");
				
				vo = new AttachmentVo();
				vo.setNo(no);
				vo.setBoardNo(board_no);
				vo.setOriginName(originName);
				vo.setChangeName(changeName);
				vo.setFilePath(filePath);
				vo.setEnrollDate(enrollDate);
				vo.setThumbYn(thumbYn);
				vo.setStatus(status);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(rs);
			JDBCTemplate.close(pstmt);
		}
		
		return vo;
	}

}//class





























