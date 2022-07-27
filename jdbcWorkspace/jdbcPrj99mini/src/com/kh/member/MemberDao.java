package com.kh.member;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.kh.common.JDBCTemplate;

public class MemberDao {
	
	public MemberVo login(String inputId, String inputPwd) throws Exception {
		//DB 가서 , id pwd 일치하는 행 조회
		
		// CONNECTION 준비
		Connection conn = JDBCTemplate.getConnection();
		
		// SQL 작성
		String sql = "SELECT NO , ID , NICK FROM MEMBER WHERE ID = ? AND PWD = ? AND QUIT_YN = 'N'";
		
		// SQL 객체에 담기
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, inputId);
		pstmt.setString(2, inputPwd);
		
		// SQL 실행
		ResultSet rs = pstmt.executeQuery();
		
		MemberVo vo = null;
		
		if(rs.next()) {
			String no = rs.getString("NO");
			String id = rs.getString("ID");
			String nick = rs.getString("NICK");
			
			vo = new MemberVo();
			vo.setNo(no);
			vo.setId(id);
			vo.setNick(nick);
		}
		
		return vo;
	}

}//class



























