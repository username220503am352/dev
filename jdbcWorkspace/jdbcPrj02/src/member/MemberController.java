package member;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
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
		
		try {
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, dto.getId());
			pstmt.setString(2, dto.getPwd());
			pstmt.setString(3, dto.getNick());
			
			result = pstmt.executeUpdate();
			
		} catch (SQLException e) {
			System.out.println("회원가입 중 예외 발생 !");
			e.printStackTrace();
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

	public void login() {
		// TODO Auto-generated method stub
		
	}

	public void edit() {
		// TODO Auto-generated method stub
		
	}
	
	

}//class





























