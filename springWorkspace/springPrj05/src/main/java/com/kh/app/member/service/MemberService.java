package com.kh.app.member.service;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.kh.app.member.dao.MemberDao;
import com.kh.app.member.vo.MemberVo;

@Service
public class MemberService {
	
	@Autowired
	private SqlSessionTemplate sst;
	
	@Autowired
	private MemberDao dao;
	
	//회원가입
	public int join(MemberVo vo) {
		return dao.join(sst , vo);
	}

	//로그인
	public MemberVo login(MemberVo vo) {
		return dao.login(sst, vo);
	}

}//class






























