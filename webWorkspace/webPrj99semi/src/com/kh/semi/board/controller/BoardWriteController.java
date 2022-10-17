package com.kh.semi.board.controller;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;

import com.kh.semi.board.service.BoardService;
import com.kh.semi.board.vo.BoardVo;
import com.kh.semi.board.vo.CategoryVo;
import com.kh.semi.member.vo.MemberVo;

@WebServlet(urlPatterns = "/board/write")
@MultipartConfig(
			//location = "/khtmp" ,
			fileSizeThreshold = 1024 * 1024 ,
			maxFileSize = 1024 * 1024 * 50 ,
			maxRequestSize = 1024 * 1024 * 50 * 5
		)
public class BoardWriteController extends HttpServlet {
	
	private final BoardService bs = new BoardService();
	
	//게시글 작성하기 (화면)
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		//화면 보여줘도 되는지 검사
		if(req.getSession().getAttribute("loginMember") == null) {
			req.setAttribute("msg", "로그인 후 이용해주세요");
			req.getRequestDispatcher("/views/common/errorPage.jsp").forward(req, resp);
			return;
		}
		
		//데이터 꺼내기
		
		//데이터 뭉치기
		
		//디비 다녀오기
		List<CategoryVo> cateList = bs.selectCategoryList();
		
		req.setAttribute("cateList", cateList);
		
		//화면선택
		req.getRequestDispatcher("/views/board/write.jsp").forward(req, resp);
		
	}
	
	//게시글 작성하기 + 파일
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//세션 가져오기
		HttpSession s = req.getSession();
		
		//로그인멤버 가져오기
		MemberVo loginMember = (MemberVo)s.getAttribute("loginMember");
		
		//인코딩
		req.setCharacterEncoding("UTF-8");
		
		//데이터 꺼내기
		String category = req.getParameter("category");
		String title = req.getParameter("title");
		String content = req.getParameter("content");
		Part f = req.getPart("f");
		
		// --------------파일업로드 start -------------------------
		
		// 1. 파일 객체 준비 (경로+파일명)
		String path = req.getServletContext().getRealPath("/upload/img/"); //최상단경로
		String fileName = "temp01.png";
		File target = new File(path + fileName);
		
		// 2. 데이터 넣기 (클라파일 -> 자바 -> 타겟파일)
		
		 InputStream fis = f.getInputStream();
		 
		 FileOutputStream fos = new FileOutputStream(target);
		 
		 while(true) {
			 int data = fis.read();
			 if(data == -1) break;
			 fos.write(data);
		 }
		
		//--------------파일업로드 end -------------------------
		
		//데이터 뭉치기
		BoardVo vo = new BoardVo();
		vo.setCategory(category);
		vo.setTitle(title);
		vo.setContent(content);
		vo.setWriter(loginMember.getNo());
		
		//디비 다녀오기
		int result = bs.write(vo);
		
		//화면선택
		if(result == 1) {
			//게시글 작성 성공 => 알람 , 게시글 목록
			s.setAttribute("alertMsg", "게시글 작성 성공!");
			resp.sendRedirect("/semi/board/list?pno=1");
		}else {
			//게시글 작성 실패 => 메세지 , 에러페이지
			req.setAttribute("msg", "게시글 작성 실패 ...");
			req.getRequestDispatcher("/views/common/errorPage.jsp").forward(req, resp);
		}
	}

}//class



















































