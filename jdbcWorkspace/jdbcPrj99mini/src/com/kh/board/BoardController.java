package com.kh.board;

import java.sql.Timestamp;
import java.util.List;

import com.kh.main.Main;
import com.kh.menu.Menu;
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
		
	}//method
	
	
	/*
	 * 게시글 목록 보여주기
	 * 
	 * 입력받을 데이터 : X
	 * 컨트롤러에서 데이터 받을 필요 X
	 * 조회 결과(List<BoardVo>) 보여주기
	 * 
	 * 서비스 : 특별히 할일 X
	 * 
	 * DAO : SQL 실행
	 * 
	 */
	public void showList() {
		
		List<BoardVo> boardVoList = new BoardService().showList();
		
		System.out.println("----- 게시판 글 목록 -----");
		
		for(int i = 0 ; i < boardVoList.size(); ++i) {
			BoardVo temp = boardVoList.get(i);
			
			int no = temp.getNo();
			String title = temp.getTitle();
			String writer = temp.getWriter();
			Timestamp enrollDate = temp.getEnrollDate();
			
			System.out.println(no + " | " + title + " | " + writer + " | " + enrollDate);
		}
		
		//상세조회 할건지 물어보기
		//출력문, 입력받기
		int no = new Menu().showBoardDetailMenu();
		
		//0번 입력받으면 ? -> 메인메뉴로 // return
		if(no == 0) {
			System.out.println("메인메뉴로 돌아갑니다.");
			return;
		}
		
		//글번호 받으면 ? -> 해당 글 상세조회 //새로운 service 호출
		//BoardVo x = new BoardService().showBoardDetail();
		
		
	}//method

}//class





































