package com.kh.app.member.service;

import org.apache.ibatis.session.SqlSession;

import com.kh.app.common.db.JDBCTemplate;
import com.kh.app.member.dao.MemberDao;
import com.kh.app.member.dao.MemberDao2;
import com.kh.app.member.dao.MemberDaoImpl;
import com.kh.app.member.dao.MemberDaoInterface;
import com.kh.app.member.vo.MemberVo;

public class MemberService {
	
	private MemberDaoInterface dao = new MemberDao();
	
	//회원가입 (찐)
	public int join(MemberVo vo) {
		
		// 디비 연결
		SqlSession ss = JDBCTemplate.getSqlSession();
		
		// SQL 실행
		int result = dao.join(ss, vo);
		
		// 트랜잭션 , 자원반납
		if(result == 1) {
			ss.commit();
		}else {
			ss.rollback();
		}
		
		ss.close();
		
		//결과 리턴
		return result;
		
	}

	//로그인 (찐)
	public MemberVo login(MemberVo vo) {
		//디비 연결
		SqlSession ss = JDBCTemplate.getSqlSession();
		
		//SQL 실행
		MemberVo loginMember = dao.login(ss , vo);
		
		//트랜잭션 , 자원반납
		ss.close();
		
		//결과 리턴
		return loginMember;
	}

}//class



























