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

	
	/*
	 * id, pwd 받아서 회원 닉네임 조회
	 * 
	 * 닉네임 님 안녕하세요 출력
	 */
	public void login() {
		// TODO Auto-generated method stub
		
	}

	/*
	 * 0. 로그인 여부 체크
	 * 1. 현재 회원 정보 보여주기
	 * 2. 변경할건지 물어보기
	 * 3. 변경할 데이터 입력받기
	 * 4. SQL 실행
	 * 5. 실행 결과에 따라, 서비스 로직 실행
	 */
	public void edit() {
		// TODO Auto-generated method stub
		
	}
	
	

}//class





























