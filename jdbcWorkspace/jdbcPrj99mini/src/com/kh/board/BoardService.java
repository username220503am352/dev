package com.kh.board;

import java.sql.Connection;
import java.util.List;

import com.kh.common.JDBCTemplate;

import static com.kh.common.JDBCTemplate.*;

public class BoardService {
	
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
	public int write(BoardVo vo) {
		
		//비지니스 로직 (제목, 내용 1글자 이상인지)
		if(vo.getTitle().length() < 1) {
			//제목이 비어있음. 다음단계 진행 X
			return -1;
		}
		
		if(vo.getContent().length() < 1) {
			//내용이 비어있음. 다음단계 진행 X
			return -2;
		}
		
		
		Connection conn = null;
		int result = 0;
		
		try {
			conn = getConnection();
			result = new BoardDao().write(vo, conn);
			
			if(result == 1) {
				commit(conn);
			}else {
				rollback(conn);
			}
			
		}catch(Exception e) {
			rollback(conn);
		}finally {
			close(conn);
		}
		
		return result;
	}//method
	
	
	public List<BoardVo> showList() {
		
		Connection conn = null;
		List<BoardVo> boardVoList = null;
		try {
			conn = JDBCTemplate.getConnection();
			
			boardVoList = new BoardDao().showList(conn);
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			JDBCTemplate.close(conn);
		}
		
		return boardVoList;
	}


	/*
	 * 게시글 상세조회
	 */
	public BoardVo showDetailByNo(int num) {
		
		Connection conn = null;
		BoardVo vo = null;
		
		try {
			conn = getConnection();
			vo = new BoardDao().showDetailByNo(conn, num);
		}catch(Exception e) {
			System.out.println("[ERROR] 게시글 상세조회 중 예외 발생 !!!");
			e.printStackTrace();
		}finally {
			close(conn);
		}
		
		return vo;
	}
	

}//class






























