package com.kh.app.board.service;

import org.apache.ibatis.session.SqlSession;

import com.kh.app.board.vo.BoardVo;
import com.kh.app.common.db.JDBCTemplate;

public class BoardService {

	//게시글 작성하기 (찐)
	public int write(BoardVo vo) {
		
		// 커넥션준비 (conn -> sqlSession)
		// SQL 실행
		// 자원반납 || 트랜잭션
		// 결과 리턴
		
		SqlSession ss = JDBCTemplate.getSqlSession();
		
		
		
		
	}
	
	

}//class





















