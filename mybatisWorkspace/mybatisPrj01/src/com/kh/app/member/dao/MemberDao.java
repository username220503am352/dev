package com.kh.app.member.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

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

	//전체 회원 목록 조회
	public List<MemberVo> selectMemberListAll(SqlSession ss) {
		
		return ss.selectList("memberMapper.selectAll");
		
		//SQL실행 (준비, 완성, 실행)
		//rs -> 객체
		//여러개의 객체를 list 로 변환
		//return list
		
//		String sql = "~~~~~~~~~~~~~~~~~~";
//		PreparedStatement pstmt = null;
//		ResultSet rs = null;
//		List<MemberVo> list = new ArrayList<>();
//		try {
//			pstmt = conn.prepareStatement(sql);
//			
//			pstmt.setString(1, vo.getXXX);
//			pstmt.setString(2, "검색할키워드");
//			
//			rs = pstmt.executeQuery();
//			
//			while(rs.next()) {
//				String memberId = rs.getString("memberId");
//				String memberPWd = rs.getString("memberPwd");
//				String memberNick = rs.getString("memberNick");
//				
//				MemberVo vo = new MemberVo();
//				vo.setMemberId(memberId);
//				vo.setMemberPwd(memberPWd);
//				//vo.setMemberNick(memberNick);
//				
//				list.add(vo);
//			}
//			
//		} catch (SQLException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		
//		return list;
	}

}//class

























