package com.kh.app.member.service;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kh.app.member.dao.MemberDao;
import com.kh.app.member.vo.MemberVo;

@Service
public class MemberService {
	
	@Autowired
	private SqlSessionTemplate sst;
	
	@Autowired
	private MemberDao dao;

	public int join(MemberVo vo) {
		return dao.insertOne(sst, vo);
	}

	public MemberVo login(MemberVo vo) {
		return dao.selectOne(sst , vo);
	}

}//class
























