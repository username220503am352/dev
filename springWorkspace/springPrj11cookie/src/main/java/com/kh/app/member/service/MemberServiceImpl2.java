package com.kh.app.member.service;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.kh.app.member.dao.MemberDao;
import com.kh.app.member.vo.MemberVo;

@Service
public class MemberServiceImpl2 implements MemberService {
	
	@Autowired
	private BCryptPasswordEncoder enc;
	
	@Autowired
	private SqlSessionTemplate sst;
	
	@Autowired
	private MemberDao dao;

	@Override
	public int join(MemberVo vo) {
		
		//암호화
		String newPwd = enc.encode(vo.getMemberPwd());
		vo.setMemberPwd(newPwd);
		
		return dao.insertMember(sst , vo);
	}

	@Override
	public MemberVo login(MemberVo vo) {
		
		// 디비가서 객체 조회
		MemberVo dbMember = dao.selectMemberOneById(sst , vo);
		
		// 비번 일치 체크
		boolean isMatch = enc.matches(vo.getMemberPwd(), dbMember.getMemberPwd());
		
		if(isMatch) {
			return dbMember;
		}else {
			return null;
		}
		
	}

}//class



















