package com.kh.board;

import com.kh.main.Main;
import com.kh.util.InputUtil;

public class BoardController {
	
	/*
	 * 게시글 작성
	 * 
	 * 데이터 받기 (컨트롤러)
	 * 
	 * 비지니스 로직 (서비스)
	 * 
	 * DB에 insert (DAO)
	 * 
	 */
	public void write() {
		
		//로그인 체크
		if(Main.loginMember == null) {
			System.out.println("로그인 먼저 해주세요");
			return; //다음 진행 하면 안되니까 return 
		}
		
		System.out.println("----- 게시글 작성 -----");
		
		//데이터 받기
		System.out.print("제목 : ");
		String title = InputUtil.sc.nextLine();
		System.out.print("내용 : ");
		String content = InputUtil.sc.nextLine();
		
		String memberNo = Main.loginMember.getNo();
		
		//데이터 뭉치기
		BoardVo vo = new BoardVo();
		vo.setTitle(title);
		vo.setContent(content);
		vo.setWriter(memberNo);
		
		//DB에 인서트 하기 위해서, DB insert 하는 서비스 메소드 호출
		int result = new BoardService().write(vo);
		
		//insert 결과에 따라 로직 처리
		if(result == 1) {
			//글 작성 성공
			System.out.println("게시글 작성 성공!");
		}else {
			//글 작성 실패
			System.out.println("게시글 작성 실패...");
		}
		
	}

}





































