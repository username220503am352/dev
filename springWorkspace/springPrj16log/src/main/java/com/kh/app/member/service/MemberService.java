package com.kh.app.member.service;

import org.mybatis.spring.SqlSessionTemplate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kh.app.member.controller.MemberController;
import com.kh.app.member.dao.MemberDao;
import com.kh.app.member.vo.MemberVo;

import lombok.extern.log4j.Log4j2;
import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class MemberService {
	
	@Autowired
	private MemberDao dao;
	
	@Autowired
	private SqlSessionTemplate sst;

	public MemberVo login(MemberVo vo) {
		
		log.debug("서비스 에서 vo : " + vo);
		
		MemberVo loginMember = dao.selectOne(sst , vo);
		
		log.debug("서비스 > 리턴받은 로그인 멤버 : " + loginMember);
		
		return loginMember;
	}
	
	
}//class























