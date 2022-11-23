package com.kh.app.board.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.kh.app.board.vo.BoardVo;
import com.kh.app.common.page.PageVo;

public class BoardDaoImpl implements BoardDao {

	@Override
	public int insertBoard(SqlSession ss, BoardVo vo) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int updateBoard(SqlSession ss, BoardVo vo) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public List<BoardVo> selectBoardList(SqlSession ss, PageVo pv) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public BoardVo selectBoardOne(SqlSession ss, int boardNo) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int deleteBoard(SqlSession ss, int boardNo) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int increaseHit(SqlSession ss, int boardNo) {
		// TODO Auto-generated method stub
		return 0;
	}

}
