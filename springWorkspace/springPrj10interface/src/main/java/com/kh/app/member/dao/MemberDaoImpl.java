package com.kh.app.member.dao;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;

import com.kh.app.member.vo.MemberVo;

@Repository
public class MemberDaoImpl implements MemberDao {

	@Override
	public int insertMember(SqlSessionTemplate sst, MemberVo vo) {
		return sst.insert("memberMapper.insertMember" , vo);
	}

	@Override
	public MemberVo selectOneMember(SqlSessionTemplate sst, MemberVo vo) {
		System.out.println(vo);
		return sst.selectOne("memberMapper.selectOneMember" , vo);
	}

}//class



















