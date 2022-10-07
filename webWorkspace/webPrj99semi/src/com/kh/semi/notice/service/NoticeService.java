package com.kh.semi.notice.service;

import java.sql.Connection;
import java.util.List;

import static com.kh.semi.common.JDBCTemplate.*;
import com.kh.semi.notice.dao.NoticeDao;
import com.kh.semi.notice.vo.NoticeVo;

public class NoticeService {
	
	private final NoticeDao dao = new NoticeDao();

	// 공지사항 작성
	public int write(NoticeVo vo) {
		
		//커넥션 준비
		//SQL
		//트랜잭션 , 자원반납
		
		Connection conn = getConnection();
		
		int result = dao.insertNotice(conn , vo);
		
		if(result == 1) {
			commit(conn);
		}else {
			rollback(conn);
		}
		
		close(conn);
		
		return result;
	}

	//공지사항 목록 조회
	public List<NoticeVo> selectNoticeList() {
		// 커넥션 준비
		// SQL
		// 트랜잭션 처리 , 자원반납
		
		Connection conn = getConnection();
		
		List<NoticeVo> voList = dao.selectNoticeList(conn);
		
		close(conn);
		
		
		return voList;
		
	}

	//상세조회
	public NoticeVo selectNoticeOne(String no) {
		
		//커넥션 준비
		//SQL (조회수증가 , 상세조회)
		//트랜잭션 처리 , 자원반납
		
		Connection conn = getConnection();
		NoticeVo vo = null;
		
		int result = dao.increaseHit(conn, no);
		if(result == 1) {
			commit(conn);
			vo = dao.selectNoticeOne(conn , no);
		}
		
		close(conn);
		
		return vo;
		
	}

	//공지사항 수정하기
	public int edit(NoticeVo vo) {
		// 커넥션 준비
		// SQL
		// 트랜잭션 , 자원반납
		
		Connection conn = getConnection();
		
		int result = dao.updateOneByNo(conn , vo);
		
		if(result == 1) {
			commit(conn);
		}else {
			rollback(conn);
		}
		
		close(conn);
		
		return result;
	}

	//공지사항 삭제
	public int delete(String no) {
		
		// 커넥션 준비
		// SQL
		// 트랜잭션 처리 , 자원반납
		
		Connection conn = getConnection();
		
		int result = dao.delete(conn , no);
		
		if(result == 1) {
			commit(conn);
		}else {
			rollback(conn);
		}
		
		close(conn);
		
		return result;
	}
	
	

}//class
























