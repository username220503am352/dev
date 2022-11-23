package com.kh.app.member.dao;

import org.apache.ibatis.session.SqlSession;

import com.kh.app.member.vo.MemberVo;

public class MemberDaoImpl implements MemberDaoInterface {

	@Override
	public int join(SqlSession ss, MemberVo vo) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public MemberVo login(SqlSession ss, MemberVo vo) {
		// TODO Auto-generated method stub
		return null;
	}

}
