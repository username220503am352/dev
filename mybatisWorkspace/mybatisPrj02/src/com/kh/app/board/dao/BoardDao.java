package com.kh.app.board.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;

import com.kh.app.board.vo.BoardVo;
import com.kh.app.board.vo.SearchVo;

public class BoardDao {
	
	//게시글 작성하기 (찐)
	public int write(SqlSession ss , BoardVo vo) {
		//SQL 실행
		return ss.insert("boardMapper.write" , vo);
	}

	//게시글 목록 조회
	public List<BoardVo> selectBoardList(SqlSession ss) {
		return ss.selectList("boardMapper.selectList");
	}

	//게시글 목록 조회 (검색)
	public List<BoardVo> searchBoardList(SqlSession ss, Map<String, String> map) {
		return ss.selectList("boardMapper.searchList" , map);
	}
	
}//class


















