package com.kh.app.board.service;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.kh.app.board.dao.BoardDao;
import com.kh.app.board.vo.BoardVo;

@Service
public class BoardService {
	
	@Autowired
	private BoardDao dao;
	
	@Autowired
	private SqlSessionTemplate sst;

	//게시글 작성
	@Transactional
	public int write(BoardVo vo) {
		
		int result1 = dao.write(sst, vo);
		int result2 = dao.updateCnt(sst);
		
		return dao.write(sst , vo);
	}

}//class





























