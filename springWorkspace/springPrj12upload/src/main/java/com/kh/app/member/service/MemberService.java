package com.kh.app.member.service;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.kh.app.member.dao.MemberDao;
import com.kh.app.member.vo.MemberVo;

@Service
public class MemberService {
	
	@Autowired
	private SqlSessionTemplate sst;
	
	@Autowired
	private MemberDao memberDao;
	
	@Autowired
	private BCryptPasswordEncoder pwdEnc;

	public int join(MemberVo vo) {
		
		vo.encode(pwdEnc);
		
		return memberDao.insertMemberOne(sst , vo);
	}

	public MemberVo login(MemberVo vo) {
		
		MemberVo dbMember = memberDao.selectMemberOneById(sst , vo.getMemberId());
		
		if(dbMember == null) {
			return null;
		}
		
		String rawPwd = vo.getMemberPwd();
		String encodedPwd = dbMember.getMemberPwd();
		
		boolean isMatch = pwdEnc.matches(rawPwd, encodedPwd);
		
		if(isMatch) {
			return dbMember;
		}else {
			return null;
		}
		
	}//method

}//class


























