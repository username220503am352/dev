package com.kh.app.board.service;

import java.util.List;
import java.util.Map;

import com.kh.app.board.vo.BoardVo;
import com.kh.app.common.page.PageVo;

public interface BoardService {
	
	// 게시글 작성하기
	public int insertBoard(BoardVo vo);
	
	// 게시글 조회수 증가
	public int increaseHit(int boardNo);
	
	// 게시글 목록 조회하기 (전체)
	public List<BoardVo> selectBoardList(PageVo pv);
	
	// 게시글 상세 조회하기
	public BoardVo selectBoardOne(int boardNo);
	
	// 게시글 수정하기
	public int updateBoard(BoardVo vo);
	
	// 게시글 삭제하기
	public int deleteBoard(int boardNo);

	// 게시글 갯수 조회
	public int selectCnt();
	
}//class

















