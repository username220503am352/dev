package com.kh.app.member.controller;

import java.io.File;
import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.io.FileUtils;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;

import com.kh.app.member.vo.MemberVo;

@Controller
@RequestMapping("member")
public class MemberController {
	
	@GetMapping("join")
	public String join() {
		return "member/join";
	}
	
	@PostMapping("join")
	public String join(MemberVo vo , HttpSession session) throws IllegalStateException, IOException {
		
		MultipartFile f = vo.getF();
		
		//f 를 D:\dev\profile 여기에 저장
		
		// 원하는 파일객체를 만들기 (목적지파일)
		File targetFile = new File("D:/dev/upload/zzz.png");
		
		// 목적지파일 에다가 f를 집어넣기
		f.transferTo(targetFile);
		
		return "main";
	}
	
	@GetMapping("down-old")
	public void down(HttpServletResponse resp) throws IOException {
		
		File f = new File("D:/dev/upload/zzz.png");
		
		resp.setHeader("Content-Type", "application/octet-stream");
		resp.setHeader("Content-Disposition", "attachment; filename=test1216.png");
		resp.setHeader("Content-Length", String.valueOf(f.length()));
		
		byte[] fileData = FileUtils.readFileToByteArray(f);
		resp.getOutputStream().write(fileData);
	}
	
	@GetMapping("down/{x}")
	public ResponseEntity<ByteArrayResource> down(@PathVariable String x) throws IOException {
		
		File f = new File("D:/dev/img/" + x);
		byte[] fileData = FileUtils.readFileToByteArray(f);
		ByteArrayResource data = new ByteArrayResource(fileData);
		
		return ResponseEntity
				.ok()
				.contentType(MediaType.APPLICATION_OCTET_STREAM)
				.contentLength(f.length())
				.header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=test1137.png")
				.body(data)
				;
		
	}
	
	

}//class
























