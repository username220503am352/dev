package com.kh.app.member.dao;

import org.mybatis.spring.SqlSessionTemplate;

import com.kh.app.member.vo.MemberVo;

public interface MemberDao {
	
	//insert member
	public int insertMember(SqlSessionTemplate sst , MemberVo vo);
	
	//select member one
	public MemberVo selectOneMember(SqlSessionTemplate sst , MemberVo vo);

}
