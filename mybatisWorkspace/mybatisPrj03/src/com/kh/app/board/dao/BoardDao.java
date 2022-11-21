package com.kh.app.board.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;

import com.kh.app.board.vo.BoardVo;

public class BoardDao {
	
	//게시글 작성 (찐)
	public int write(SqlSession ss , BoardVo vo) {
		return ss.insert("boardMapper.write" , vo);
	}

	//게시글 목록 조회
	public List<BoardVo> selectBoardList(SqlSession ss, Map<String, String> map) {
		return ss.selectList("boardMapper.selectBoardList" , map);
	}

	//게시글 갯수 조회
	public int selectCount(SqlSession ss) {
		return ss.selectOne("boardMapper.selectCnt");
	}

}//class























