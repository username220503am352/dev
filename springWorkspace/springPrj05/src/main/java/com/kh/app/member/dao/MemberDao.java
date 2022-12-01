package com.kh.app.member.dao;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import com.kh.app.member.vo.MemberVo;

@Repository
public class MemberDao {
	
	//회원가입
	public int join(SqlSessionTemplate sst , MemberVo vo) {
		return sst.insert("memberMapper.join" , vo);
	}

	//로그인
	public MemberVo login(SqlSessionTemplate sst, MemberVo vo) {
		return sst.selectOne("memberMapper.login" , vo);
	}
	

}//class




























