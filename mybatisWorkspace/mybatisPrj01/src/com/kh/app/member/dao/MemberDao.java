package com.kh.app.member.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import org.apache.ibatis.session.SqlSession;

import com.kh.app.common.db.JDBCTemplate;
import com.kh.app.member.vo.MemberVo;

public class MemberDao {
	
	//회원가입
	public int join(SqlSession ss, MemberVo vo) {
		
		return ss.insert("memberMapper.join" , vo);
		
//		PreparedStatement pstmt = null;
//		int result = 0;
//		
//		//SQL 준비 
//		String sql = "INSERT INTO MEMBER(ID, PWD) VALUES(?,?)";
//		try {
//			pstmt = ss.prepareStatement(sql);
//			
//			//SQL 완성
//			pstmt.setString(1, vo.getMemberId());
//			pstmt.setString(2, vo.getMemberPwd());
//			
//			//SQL 실행
//			result = pstmt.executeUpdate();
//			
//		} catch (SQLException e) {
//			e.printStackTrace();
//		} finally {
//			JDBCTemplate.close(pstmt);
//		}
//		
//		//결과 리턴
//		return result;
		
	}//method

}//class

























