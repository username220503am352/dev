package com.kh.semi.notice.service;

import java.sql.Connection;
import java.util.List;

import com.kh.semi.common.JDBCTemplate;
import com.kh.semi.notice.dao.NoticeDao;
import com.kh.semi.notice.vo.NoticeVo;

public class NoticeService {

	// 공지사항 작성
	public int write(NoticeVo vo) {
		
		//커넥션 준비
		//SQL
		//트랜잭션 , 자원반납
		
		Connection conn = JDBCTemplate.getConnection();
		
		int result = new NoticeDao().insertNotice(conn , vo);
		
		if(result == 1) {
			JDBCTemplate.commit(conn);
		}else {
			JDBCTemplate.rollback(conn);
		}
		
		JDBCTemplate.close(conn);
		
		return result;
	}

	//공지사항 목록 조회
	public List<NoticeVo> selectNoticeList() {
		// 커넥션 준비
		// SQL
		// 트랜잭션 처리 , 자원반납
		
		Connection conn = JDBCTemplate.getConnection();
		
		List<NoticeVo> voList = new NoticeDao().selectNoticeList(conn);
		
		JDBCTemplate.close(conn);
		
		
		return voList;
		
	}

	//상세조회
	public NoticeVo selectNoticeOne(String no) {
		
		//커넥션 준비
		//SQL (조회수증가 , 상세조회)
		//트랜잭션 처리 , 자원반납
		
		Connection conn = JDBCTemplate.getConnection();
		NoticeVo vo = null;
		
		int result = new NoticeDao().increaseHit(conn, no);
		if(result == 1) {
			JDBCTemplate.commit(conn);
			vo = new NoticeDao().selectNoticeOne(conn , no);
		}
		
		JDBCTemplate.close(conn);
		
		return vo;
		
	}
	
	

}//class
























