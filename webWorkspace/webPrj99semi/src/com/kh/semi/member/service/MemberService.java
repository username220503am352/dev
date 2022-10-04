package com.kh.semi.member.service;

import java.sql.Connection;

import com.kh.semi.common.JDBCTemplate;
import com.kh.semi.member.dao.MemberDao;
import com.kh.semi.member.vo.MemberVo;

public class MemberService {
	
	//회원가입
	public int join(MemberVo vo) {
		//커넥션 준비
		//SQL
		//트랜잭션 , 자원반납
		
		Connection conn = JDBCTemplate.getConnection();
		
		MemberDao dao = new MemberDao();
		int result = dao.insertOne(conn, vo);
		
		if(result == 1) {
			JDBCTemplate.commit(conn);
		}else {
			JDBCTemplate.rollback(conn);
		}
		
		JDBCTemplate.close(conn);
		
		return result;
	}

	public MemberVo login(MemberVo vo) {
		//커넥션 준비
		//SQL
		//트랜잭션 , 자원반납
		
		Connection conn = JDBCTemplate.getConnection();
		MemberVo loginMember = new MemberDao().selectOne(conn, vo);
		JDBCTemplate.close(conn);
		return loginMember;
	}

	//회원 정보 수정
	public MemberVo edit(MemberVo vo) {
		
		//커넥션준비
		//SQL(update , select)
		//트랜잭션처리 , 자원반납
		
		Connection conn = JDBCTemplate.getConnection();
		
		int result = new MemberDao().updateOneByNo(conn , vo);
		
		MemberVo updatedMember = null;
		if(result == 1) {
			JDBCTemplate.commit(conn);
			updatedMember = new MemberDao().selectOne(conn, vo);
		}else {
			JDBCTemplate.rollback(conn);
		}
		
		JDBCTemplate.close(conn);
		return updatedMember;
		
	}

	//회원탈퇴
	public int quit(String no) {
		//커넥션 준비
		//SQL
		//트랜잭션처리 , 자원반납
		
		Connection conn = JDBCTemplate.getConnection();
		
		int result = new MemberDao().quit(conn , no);
		
		if(result == 1) {
			JDBCTemplate.commit(conn);
		}else {
			JDBCTemplate.rollback(conn);
		}
		
		JDBCTemplate.close(conn);
		
		return result;
	}

}//class
























