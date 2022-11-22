package com.kh.app.board.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.RowBounds;
import org.apache.ibatis.session.SqlSession;

import com.kh.app.board.vo.BoardVo;
import com.kh.app.common.page.PageVo;

public class BoardDao {
	
	//게시글 작성 (찐)
	public int write(SqlSession ss , BoardVo vo) {
		return ss.insert("boardMapper.write" , vo);
	}

	//게시글 목록 조회
	public List<BoardVo> selectBoardList(SqlSession ss, Map<String, String> map, PageVo pv) {
		
		int offset = (pv.getCurrentPage() -1) * pv.getBoardLimit();
		int limit = pv.getBoardLimit();
		RowBounds rb = new RowBounds(offset , limit);
		
		return ss.selectList("boardMapper.selectBoardList" , map , rb);
	}

	//게시글 갯수 조회
	public int selectCount(SqlSession ss) {
		return ss.selectOne("boardMapper.selectCnt");
	}

}//class























