package com.kh.app.member.dao;

import org.apache.ibatis.session.SqlSession;

import com.kh.app.member.vo.MemberVo;

public interface MemberDaoInterface {
	
	//회원가입
	public int join(SqlSession ss , MemberVo vo);
	
	//로그인
	public MemberVo login(SqlSession ss, MemberVo vo);

}
