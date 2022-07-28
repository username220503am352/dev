package com.kh.member;

import java.sql.Connection;

import com.kh.common.JDBCTemplate;

public class MemberService {
	
	public int join(MemberVo vo) {
		//아이디 4글자 이상인지
		if(vo.getId().length() < 4) {
			// 다음단계 진행하면 안됨. 실패라고 알려줘야함.
			return -1;
		}
		
		//패스워드 4글자 이상인지
		if(vo.getPwd().length() < 4) {
			// 다음단계 진행하면 안됨. 실패라고 알려줘야함.
			return -2;
		}
		
		//패스워드 일치하는지 (비밀번호 확인)
		if(vo.getPwd().equals(vo.getPwd2()) == false) {
			// 다음단계 진행하면 안됨. 실패라고 알려줘야함.
			return -3;
		}
		
		//아이디 중복확인
		
		
		
		//위의 조건들 모두 통과하면? -> insert 진행
		
		Connection conn = null;
		int result = 0;
		
		try {
			conn = JDBCTemplate.getConnection();
			result = new MemberDao().join(vo, conn);
			
			if(result == 1) {
				JDBCTemplate.commit(conn);
			}else {
				JDBCTemplate.rollback(conn);
			}
			
		} catch (Exception e) {
			//롤백해야하는 상황
			JDBCTemplate.rollback(conn);
		} finally {
			JDBCTemplate.close(conn);
		}
		
		return result;
	}//join

}//class

























