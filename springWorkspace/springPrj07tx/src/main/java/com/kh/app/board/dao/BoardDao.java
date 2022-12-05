package com.kh.app.board.dao;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;

import com.kh.app.board.vo.BoardVo;

@Repository
public class BoardDao {

	//게시글 작성
	public int write(SqlSessionTemplate sst, BoardVo vo) {
		return sst.insert("boardMapper.write" , vo);
	}

	//게시글 갯수 업데이트
	public int updateCnt(SqlSessionTemplate sst) {
		return sst.update("boardMapper.updateCnt");
	}

}//class


























