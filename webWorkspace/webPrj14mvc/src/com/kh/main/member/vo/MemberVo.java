package com.kh.main.member.vo;

public class MemberVo {
	
	
	
	public MemberVo() {
		
	}
	
	
	
	public MemberVo(String memberId, String memberPwd) {
		this.memberId = memberId;
		this.memberPwd = memberPwd;
	}



	private String memberId;
	private String memberPwd;
	public String getMemberId() {
		return memberId;
	}



	public void setMemberId(String memberId) {
		this.memberId = memberId;
	}



	public String getMemberPwd() {
		return memberPwd;
	}



	public void setMemberPwd(String memberPwd) {
		this.memberPwd = memberPwd;
	}



	@Override
	public String toString() {
		return "MemberVo [memberId=" + memberId + ", memberPwd=" + memberPwd + "]";
	}
	
	

}
