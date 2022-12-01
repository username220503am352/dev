package com.kh.app.board.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.kh.app.board.service.BoardService;
import com.kh.app.board.vo.BoardVo;

@RequestMapping("board")
@Controller
public class BoardController {
	
	@Autowired
	private BoardService bs;
	
	//게시글 작성 (화면)
	@GetMapping("write")
	public String write() {
		return "board/write";
	}
	
	//게시글 작성 (찐)
	@PostMapping("write")
	public String write(BoardVo vo) {
		int result = bs.write(vo);
		
		if(result == 1) {
			return "common/success";
		}else {
			return "common/error";
		}
	}
	
	//게시글 목록
	@GetMapping("list")
	public String list(Model model) {
		
		List<BoardVo> voList = bs.selectList();
		
		model.addAttribute("voList", voList);
		
		return "board/list";
	}

}























