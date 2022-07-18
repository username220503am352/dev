package member;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.Scanner;

import util.JDBCTemplate;

public class MemberController {

	/*
	 * <회원가입>
	 * 
	 * 아이디, 패스워드, 닉네임 전달받고
	 * 
	 * 아이디, 닉네임 검사 (중복, 글자수, 특수문자)
	 * 
	 * DB에 insert
	 * 
	 * insert 성공 ? 성공했다고 알려주기 : 실패 했다고 알려주기
	 */
	public int join() {
		
		MemberDto dto = showJoinView();
		
		Connection conn = JDBCTemplate.getConnection();
		
		//커넥션 이용해서 SQL 실행
		String sql = "INSERT INTO MEMBER(ID, PWD, NICK, ENROLL_DATE, QUIT_YN) VALUES(?,?,?,SYSDATE,'N')";
		
		int result = 0;
		PreparedStatement pstmt = null;
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, dto.getId());
			pstmt.setString(2, dto.getPwd());
			pstmt.setString(3, dto.getNick());
			
			result = pstmt.executeUpdate();
			
			if(result > 0) {
				JDBCTemplate.commit(conn);
			}else {
				JDBCTemplate.rollback(conn);
			}
			
		} catch (SQLException e) {
			JDBCTemplate.rollback(conn);
			System.out.println("회원가입 중 예외 발생 !");
			e.printStackTrace();
		} finally {
			//close 전부 진행
			JDBCTemplate.close(conn);
			JDBCTemplate.close(pstmt);
		}
		
		return result;
		
	}

	private MemberDto showJoinView() {
		
		Scanner sc = new Scanner(System.in);
		
		System.out.print("아이디:");
		String id = sc.nextLine();
		
		System.out.print("비밀번호:");
		String pwd = sc.nextLine();
		
		System.out.print("닉네임:");
		String nick = sc.nextLine();
		
		MemberDto dto = new MemberDto();
		dto.setId(id);
		dto.setPwd(pwd);
		dto.setNick(nick);
		
		return dto;
		
	}//showJoinView

	/*
	 * 아이디 패스워드 받기
	 * 
	 * 아이디,패스워드 일치하는 행 찾기
	 * 
	 * 회원정보(아이디,닉네임,회원가입일시) 가져오기
	 * 
	 * 회원정보 리턴
	 */
	public MemberDto login() {
		
		MemberDto result = showLoginView();
		String id = result.getId();
		String pwd = result.getPwd();
		
		//디비와 연결, 아이디 패스워드로 조회
		
		//드라이버 등록
		//드라이버 이용해서 연결 가져오기
		Connection conn = JDBCTemplate.getConnection();
		
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		//연결된 정보를 이용해서, SQL 실행
		String sql = "SELECT * FROM MEMBER WHERE ID = ? AND PWD = ? AND QUIT_YN = 'N'";
		MemberDto loginMember = null;
		try {
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, id);
			pstmt.setString(2, pwd);
			
			//지금 실행하는 쿼리는? SELECT 쿼리 -> 결과집합(ResultSet)
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				String nick = rs.getString("NICK");
				String memberId = rs.getString("ID");
				Timestamp enrollDate = rs.getTimestamp("ENROLL_DATE");
				
				loginMember = new MemberDto();
				loginMember.setId(memberId);
				loginMember.setNick(nick);
				loginMember.setEnrollDate(enrollDate);
			}
			
		} catch (SQLException e) {
			System.out.println("로그인 에러 !!!");
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(conn);
			JDBCTemplate.close(pstmt);
			JDBCTemplate.close(rs);
		}
		
		return loginMember;
		
	}//login
	
	public MemberDto showLoginView() {
		Scanner sc = new Scanner(System.in);
		String id = sc.nextLine();
		String pwd = sc.nextLine();
		
//		String[] strArr = {id, pwd};
		
		MemberDto dto = new MemberDto();
		dto.setId(id);
		dto.setPwd(pwd);
		
		return dto;
	}

	public void edit() {
		// TODO Auto-generated method stub
		
	}
	
	public void loginCheck(MemberDto dto) {
		if(dto != null) {
			System.out.println("----- 로그인유저정보 -----");
			System.out.println(dto);
		}else {
			System.out.println("로그인 실패 ...");
		}
	}//loginCheck
	
	

}//class





























