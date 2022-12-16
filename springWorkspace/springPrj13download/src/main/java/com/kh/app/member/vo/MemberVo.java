package com.kh.app.member.vo;

import org.springframework.web.multipart.MultipartFile;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
public class MemberVo {
	
	private String memberId;
	private String memberPwd;
	private String memberNick;
	private String enrollDate;
	private MultipartFile f;

}
