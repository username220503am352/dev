package com.kh.app04.board.service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import static com.kh.app04.common.JDBCTemplate.*;

import com.kh.app04.board.dao.BoardDao;
import com.kh.app04.board.vo.BoardVo;
import com.kh.app04.common.JDBCTemplate;

public class BoardService {
	
	//private final BoardDao dao = new BoardDao();
	
	private final BoardDao dao;
	
	public BoardService() {
		dao = new BoardDao();
	}
	
	
	
	//게시글 작성하기 (insert : int)
	public int insertBoard(BoardVo vo) {
		
		//Connection 준비 (ip, port, url , sid, username, pwd)
		Connection conn = getConnection();
		
		//디비 다녀오기 (SQL 실행)
		int result = dao.insertBoard(conn, vo);
		
		//커밋 || 롤백
		if(result == 1) {
			commit(conn);
		}
		
		//자원반납
		close(conn);
		
		return result;
		
	}//method

}//class












