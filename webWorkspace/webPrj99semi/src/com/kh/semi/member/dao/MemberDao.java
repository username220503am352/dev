package com.kh.semi.member.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
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

	public MemberVo selectOne(Connection conn, MemberVo vo) {
		//SQL
		
		String sql = "SELECT NO ,ID ,PWD ,NICK ,ADDR ,HOBBY ,ENROLL_DATE ,MODIFY_DATE ,STATUS FROM MEMBER WHERE ID = ? AND PWD = ? AND STATUS = 'O'";
		
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		MemberVo loginMember = null;
		
		try {
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, vo.getId());
			pstmt.setString(2, vo.getPwd());
			
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				String id = rs.getString("ID");
				String pwd = rs.getString("PWD");
				String no = rs.getString("NO");
				String nick = rs.getString("NICK");
				String addr = rs.getString("ADDR");
				String hobby = rs.getString("HOBBY");
				String enrollDate = rs.getString("ENROLL_DATE");
				String modifyDate = rs.getString("MODIFY_DATE");
				String status = rs.getString("STATUS");
				
				loginMember = new MemberVo();
				loginMember.setNo(no);
				loginMember.setId(id);
				loginMember.setPwd(pwd);
				loginMember.setNick(nick);
				loginMember.setAddr(addr);
				loginMember.setHobby(hobby);
				loginMember.setEnrollDate(enrollDate);
				loginMember.setModifyDate(modifyDate);
				loginMember.setStatus(status);
				
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(rs);
			JDBCTemplate.close(pstmt);
		}
		
		return loginMember;
	}

	public int updateOneByNo(Connection conn, MemberVo vo) {
		//SQL
		
		PreparedStatement pstmt = null;
		int result = 0;
		
		String sql = "UPDATE MEMBER SET PWD = ? , NICK = ? , ADDR = ? , HOBBY = ? WHERE NO = ?";
		try {
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, vo.getPwd());
			pstmt.setString(2, vo.getNick());
			pstmt.setString(3, vo.getAddr());
			pstmt.setString(4, vo.getHobby());
			pstmt.setString(5, vo.getNo());
			
			result = pstmt.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(pstmt);
		}
		
		return result;
	}

	
	//회원탈퇴
	public int quit(Connection conn, String no) {
		//SQL
		
		PreparedStatement pstmt = null;
		int result = 0;
		
		String sql = "UPDATE MEMBER SET STATUS = 'X' WHERE NO = ?";
		try {
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, no);
			
			result = pstmt.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(pstmt);
		}
		
		return result;
	}
	
}//class




















