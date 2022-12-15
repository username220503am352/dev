package com.kh.app.member.vo;

import java.util.List;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.multipart.MultipartFile;

import lombok.Data;

@Data
public class MemberVo {
	
	private String memberId;
	private String memberPwd;
	private String memberNick;
	private String enrollDate;
	private String changeName;
	private List<MultipartFile> profile;
	
	public void encode(BCryptPasswordEncoder pwdEnc) {
		this.memberPwd = pwdEnc.encode(this.memberPwd);
	}
	
	public boolean isEmpty() {
		
		if(profile.get(0).isEmpty()) {return true;}
		if(profile == null) return true;
		if(profile.size() == 0) return true;
			
		return false;
		
	}//method

}//class


























