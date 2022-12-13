package com.kh.app.member.service;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.kh.app.member.dao.MemberDao;
import com.kh.app.member.vo.MemberVo;

@Service
public class MemberServiceImpl implements MemberService {
	
	@Autowired
	private BCryptPasswordEncoder enc;
	
	@Autowired
	private SqlSessionTemplate sst;
	
	@Autowired
	private MemberDao dao;

	//회원가입
	@Override
	public int join(MemberVo vo) {
		
		//암호화
		String pwd = vo.getMemberPwd();
		String newPwd = enc.encode(pwd);
		vo.setMemberPwd(newPwd);
		
		return dao.insertMember(sst, vo);
	}

	//로그인
	@Override
	public MemberVo login(MemberVo vo) {
		
		MemberVo dbMember = dao.selectOneMember(sst, vo);
		
		String a = vo.getMemberPwd();
		String b = dbMember.getMemberPwd();
		
		boolean isMatch = enc.matches(a, b);
		
		if(isMatch) {
			return dbMember;
		}else {
			return null;
		}
	}

}//class














