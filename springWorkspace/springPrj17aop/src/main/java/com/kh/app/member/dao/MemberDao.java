package com.kh.app.member.dao;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;

import com.kh.app.member.vo.MemberVo;

import lombok.extern.slf4j.Slf4j;

@Repository
@Slf4j
public class MemberDao {
	
	public int insertOne(SqlSessionTemplate sst, MemberVo vo) {
		return sst.insert("memberMapper.insertOne" , vo);
	}

	public MemberVo selectOne(SqlSessionTemplate sst, MemberVo vo) {
		return sst.selectOne("memberMapper.selectOne" , vo);
	}

}//class


















