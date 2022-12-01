package com.kh.app.board.dao;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;

import com.kh.app.board.vo.BoardVo;

@Repository
public class BoardDao {

	//게시글 작성
	public int write(SqlSessionTemplate sst, BoardVo vo) {
		return sst.insert("boardMapper.write", vo);
	}

	//게시글 조회
	public List<BoardVo> selectList(SqlSessionTemplate sst) {
		return sst.selectList("boardMapper.selectList");
	}
	
}//class

























