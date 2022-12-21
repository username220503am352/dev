package com.kh.app.member.dao;

import org.mybatis.spring.SqlSessionTemplate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import com.kh.app.member.controller.MemberController;
import com.kh.app.member.vo.MemberVo;

import lombok.extern.log4j.Log4j2;
import lombok.extern.slf4j.Slf4j;

@Repository
@Slf4j
public class MemberDao {
	
	public MemberVo selectOne(SqlSessionTemplate sst, MemberVo vo) {
		
		log.debug("DAO 에서 vo : " + vo);
		
		//디비 가서 조회한 객체 라고 치고 ,,, 진행 ,,,
		MemberVo loginMember = new MemberVo();
		loginMember.setMemberId(vo.getMemberId());
		loginMember.setMemberPwd(vo.getMemberPwd());
		loginMember.setMemberNick(vo.getMemberNick());
		
		log.debug("DAO 에서 리턴하는 로그인멤버 : " + loginMember);
		return loginMember;
	}
	
	

}
