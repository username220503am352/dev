package com.kh.app.member.dao;

import org.mybatis.spring.SqlSessionTemplate;

import com.kh.app.member.vo.MemberVo;

public interface MemberDao {
	
	//insertMember
	public int insertMember(SqlSessionTemplate sst , MemberVo vo);

	public MemberVo selectMemberOneById(SqlSessionTemplate sst, MemberVo vo);

}
