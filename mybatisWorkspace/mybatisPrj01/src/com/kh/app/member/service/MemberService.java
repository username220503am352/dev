package com.kh.app.member.service;

import java.sql.Connection;

import org.apache.ibatis.session.SqlSession;

import com.kh.app.common.db.JDBCTemplate;
import com.kh.app.member.dao.MemberDao;
import com.kh.app.member.vo.MemberVo;

public class MemberService {
	
	//회원가입
	public int join(MemberVo vo) {
		// 커넥션 준비
		//Connection conn = JDBCTemplate.getConnection();
		 SqlSession ss = JDBCTemplate.getSqlSession();
		
		// SQL 실행
		MemberDao dao = new MemberDao();
		int result = dao.join(ss , vo);
		
		// 트랜잭션 처리 및 자원반납
		if(result == 1) {
			//JDBCTemplate.commit(conn);
			ss.commit();
		}else {
			//JDBCTemplate.rollback(conn);
			ss.rollback();
		}
		
		//JDBCTemplate.close(conn);
		ss.close();
		
		// 결과 리턴
		return result;
	}//method

}//class
