package com.kh.app.member.service;

import com.kh.app.member.vo.MemberVo;

public interface MemberService {
	
	//회원가입
	public int join(MemberVo vo);
	
	//로그인
	public MemberVo login(MemberVo vo);
	
}
