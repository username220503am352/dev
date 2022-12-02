package com.kh.app.board.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.kh.app.board.vo.BoardVo;

@RequestMapping("board")
@Controller
public class BoardController {
	
	//게시글 작성
	@GetMapping("write")
	public String write() {
		return "board/write";
	}
	
	//게시글 작성 (찐)
	@PostMapping("write")
	public String write(BoardVo vo) {
		return "main";
	}
	
	//게시글 목록
	@GetMapping("list")
	public String list() {
		return "board/list";
	}

}//class

































