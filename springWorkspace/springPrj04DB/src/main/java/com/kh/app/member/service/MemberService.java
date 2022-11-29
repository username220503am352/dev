package com.kh.app.member.service;

import org.apache.ibatis.session.SqlSession;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.kh.app.member.dao.MemberDao;
import com.kh.app.member.vo.MemberVo;

@Component
public class MemberService {
	
	@Autowired
	private SqlSessionTemplate sst;
	
	@Autowired
	private MemberDao dao;
	
	// 회원가입 
	public int join(MemberVo vo) {
		
		// SQL
		dao.join(sst , vo);
		
		// 트랜잭션 , 자원반납
		// 결과리턴
		System.out.println("service called ~~~");
		return 1;
	}

}//class



























