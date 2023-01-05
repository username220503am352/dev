package com.kh.app;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.google.gson.Gson;

import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping("board")
@CrossOrigin
@Slf4j
public class MyController {
	
	@Autowired
	private Gson gson;

	@GetMapping("list")
	public String list() {
		
		log.info("게시글 조회 요청 받음 ~~~");
		
		BoardVo vo = new BoardVo();
		vo.setTitle("titlezzz");
		vo.setContent("contentzzz");
		
		return gson.toJson(vo);
	}

}//class







































