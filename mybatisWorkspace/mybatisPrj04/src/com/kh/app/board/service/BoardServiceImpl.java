package com.kh.app.board.service;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.kh.app.board.vo.BoardVo;
import com.kh.app.common.db.JDBCTemplate;
import com.kh.app.common.page.PageVo;

public class BoardServiceImpl implements BoardService {
	
	private BoardDao dao = new BoardDao();

	@Override
	public int insertBoard(BoardVo vo) {
		//DB연결
		SqlSession ss = JDBCTemplate.getSqlSession();
		
		//SQL 실행
		dao
		
		//트랜잭션 , 자원반납
		
		//결과리턴
	}

	@Override
	public int increaseHit(int boardNo) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public List<BoardVo> selectBoardList(PageVo pv) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public BoardVo selectBoardOne(int boardNo) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int updateBoard(BoardVo vo) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int deleteBoard(int boardNo) {
		// TODO Auto-generated method stub
		return 0;
	}

}
