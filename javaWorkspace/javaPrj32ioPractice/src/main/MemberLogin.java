package main;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class MemberLogin {
	
	/*
	 * 로그인
	 * 
	 * - 아래 내용 지울거
	 * 파일 열기
	 * 파일에서 읽기
	 * 비교하기
	 * split
	 * 입력받기
	 * equals
	 * 결과출력
	 * 스트림 생성, 사용, 정리
	 * 
	 */
	public void login() {
		// 안내문 + 입력받기
		System.out.println("아이디 : ");
		String id = Main.sc.nextLine();
		
		System.out.println("비밀번호 : ");
		String pwd = Main.sc.nextLine();
		
		
		//로그인 처리
		boolean isLogin = processLogin(id, pwd);
		
		//결과 출력
		if(isLogin) {
			System.out.println("로그인 성공");
		}else {
			System.out.println("로그인 실패");
		}
		
	}//join
	
	/*
	 * 로그인 처리
	 */
	private boolean processLogin(String id, String pwd) {
		boolean result = false;
		//파일에서 데이터 읽기
		
		//파일 준비
		File f = new File("D:\\dev\\member.txt");
		//스트림 생성
		try (BufferedReader br = new BufferedReader(new FileReader(f));)
		{
			//스트림 사용
			String data = br.readLine();
			String[] idPwdArr = data.split(" ");
			String idData = idPwdArr[0];
			String pwdData = idPwdArr[1];
			result =  id.equals(idData) && pwd.equals(pwdData);
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return result;
		//로그인 성공 여부 판단
		
	}

}//class



























