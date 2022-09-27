package com.kh.app.board.service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import com.kh.app.board.dao.BoardDao;
import com.kh.app.board.vo.BoardVo;
import com.kh.app.common.JDBCTemplate;

public class BoardService {
	
	public int write(BoardVo vo) {
		/*
		 * 커넥션 준비 (라이브러리, 클래스등록, driver , url , username, password , 오토커밋)
		 * SQL (준비 , 완성 , 실행 및 결과저장)
		 * 트랜잭션 , 자원정리
		 */
		
		Connection conn = JDBCTemplate.getConnection();
		
		BoardDao dao = new BoardDao();
		int result = dao.insertBoard(conn , vo);
		
		if(result == 1) {
			JDBCTemplate.commit(conn);
		}else {
			JDBCTemplate.rollback(conn);
		}
		
		JDBCTemplate.close(conn);
		
		return result;
	}

	public List<BoardVo> selectBoardList() {
		
		//커넥션 준비
		//SQL
		//트랜잭션, 자원반납
		
		Connection conn = JDBCTemplate.getConnection();
		
		BoardDao dao = new BoardDao();
		List<BoardVo> list = dao.selectBoardList(conn);
		
		JDBCTemplate.close(conn);
		
		return list;
	}
	
}//class

































