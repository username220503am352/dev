package com.kh.app.member.service;

import java.sql.Connection;
import java.util.List;

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

	//전체 회원 목록 조회
	public List<MemberVo> selectMemberListAll() {
		//커넥션 준비
		SqlSession ss = JDBCTemplate.getSqlSession();
		
		//SQL 실행
		MemberDao dao = new MemberDao();
		List<MemberVo> list = dao.selectMemberListAll(ss);
		
		//자원정리
		ss.close();
		
		//리턴
		return list;
	}

}//class















