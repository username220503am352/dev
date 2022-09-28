package com.kh.semi.member.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.kh.semi.common.JDBCTemplate;
import com.kh.semi.member.vo.MemberVo;

public class MemberDao {

	public int insertOne(Connection conn , MemberVo vo) {
		//SQL
		PreparedStatement pstmt = null;
		int result = 0;
		
		String sql = "INSERT INTO MEMBER ( NO ,ID ,PWD ,NICK ,ADDR ,HOBBY ) VALUES ( SEQ_MEMBER_NO.NEXTVAL , ? , ? , ? , ? , ? )";
		try {
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, vo.getId());
			pstmt.setString(2, vo.getPwd());
			pstmt.setString(3, vo.getNick());
			pstmt.setString(4, vo.getAddr());
			pstmt.setString(5, vo.getHobby());
			
			result = pstmt.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(pstmt);
		}
		
		return result;
	}//method
	
}
