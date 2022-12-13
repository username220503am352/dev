package com.kh.app.member.service;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kh.app.member.dao.MemberDao;
import com.kh.app.member.vo.MemberVo;

@Service
public class MemberServiceImpl implements MemberService {
	
	@Autowired
	private SqlSessionTemplate sst;
	
	@Autowired
	private MemberDao dao;

	@Override
	public int join(MemberVo vo) {
		
		//vo 의 pwd 를 암호화
		// ~~~~~
		
		return dao.insertMember(sst, vo);
	}

	@Override
	public MemberVo login(MemberVo vo) {
		return null;
	}

}//class



























