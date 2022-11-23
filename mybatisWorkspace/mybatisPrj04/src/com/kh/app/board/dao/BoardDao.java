package com.kh.app.board.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.kh.app.board.vo.BoardVo;
import com.kh.app.common.page.PageVo;

public interface BoardDao {
	
	// insertBoard
	public int insertBoard(SqlSession ss , BoardVo vo);
	
	// updateBoard
	public int updateBoard(SqlSession ss , BoardVo vo);
	
	// selectBoardList
	public List<BoardVo> selectBoardList(SqlSession ss , PageVo pv);
	
	// selectBoardOne
	public BoardVo selectBoardOne(SqlSession ss , int boardNo);
	
	// deleteBoard
	public int deleteBoard(SqlSession ss , int boardNo);
	
	// increaseHit
	public int increaseHit(SqlSession ss , int boardNo);

	// selectCount
	public int selectCnt(SqlSession ss);

}//class






















