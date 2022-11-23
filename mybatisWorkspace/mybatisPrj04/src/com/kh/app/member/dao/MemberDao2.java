package com.kh.app.member.dao;

import org.apache.ibatis.session.SqlSession;

import com.kh.app.member.vo.MemberVo;

public class MemberDao2 implements MemberDaoInterface {
	
	public int join(SqlSession ss , MemberVo vo) {
		return ss.insert("~~~",vo);
	}
	
	@Override
	public MemberVo login(SqlSession ss, MemberVo vo) {
		// TODO Auto-generated method stub
		return null;
	}

}//class






























