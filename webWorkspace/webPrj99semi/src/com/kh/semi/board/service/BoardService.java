package com.kh.semi.board.service;

import java.sql.Connection;
import java.util.List;

import com.kh.semi.board.dao.BoardDao;
import com.kh.semi.board.vo.BoardVo;
import com.kh.semi.board.vo.CategoryVo;
import com.kh.semi.common.JDBCTemplate;

public class BoardService {
	
	private final BoardDao dao = new BoardDao();

	// 카테고리 목록 조회
	public List<CategoryVo> selectCategoryList() {
		// 커넥션 준비
		// SQL
		// 트랜잭션 , 자원반납
		
		Connection conn = JDBCTemplate.getConnection();
		
		List<CategoryVo> list = dao.selectCategoryList(conn);
		
		JDBCTemplate.close(conn);
		
		return list;
	}

	//게시글 작성
	public int write(BoardVo vo) {
		//커넥션 준비
		//SQL
		//트랜잭션 , 자원반납
		
		Connection conn = JDBCTemplate.getConnection();
		
		int result = dao.insertBoard(conn , vo);
		
		if(result == 1) {
			JDBCTemplate.commit(conn);
		}else {
			JDBCTemplate.rollback(conn);
		}
		
		JDBCTemplate.close(conn);
		
		return result;
	}
	
	

}//class


























