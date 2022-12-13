package com.kh.app.member.service;

import com.kh.app.member.vo.MemberVo;

public interface MemberService {
	
	//join
	public int join(MemberVo vo);

	//login
	public MemberVo login(MemberVo vo);

}
