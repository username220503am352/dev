package com.kh.app.board.service;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kh.app.board.dao.BoardDao;
import com.kh.app.board.vo.BoardVo;

@Service
public class BoardService {
	
	@Autowired
	private BoardDao dao;
	
	@Autowired
	private SqlSessionTemplate sst;

	//게시글 작성
	public int write(BoardVo vo) {
		return dao.write(sst , vo);
	}

	//게시글 조회
	public List<BoardVo> selectList() {
		return dao.selectList(sst);
	}

}//class































