package com.kh.app.member.dao;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;

import com.kh.app.member.vo.MemberVo;

@Repository
public class MemberDao {

	public int insertMemberOne(SqlSessionTemplate sst, MemberVo vo) {
		return sst.insert("memberMapper.insertMemberOne" , vo);
	}

	public MemberVo selectMemberOneById(SqlSessionTemplate sst, String memberId) {
		return sst.selectOne("memberMapper.selectOneById" , memberId);
	}

}//class




























