package com.kh.app.member.dao;

import org.apache.ibatis.session.SqlSession;

import com.kh.app.member.vo.MemberVo;

public class MemberDao {
	
	//회원가입 (찐)
	public int join(SqlSession ss , MemberVo vo) {
		return ss.insert("memberMapper.join" , vo);
	}

	//로그인 (찐)
	public MemberVo login(SqlSession ss, MemberVo vo) {
		return ss.selectOne("memberMapper.login" , vo);
	}

}//class




























