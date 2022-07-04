package main;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class MemberJoin {
	
	/*
	 * 회원가입
	 */
	public void join() {
		//아이디, 비번 입력받기
		System.out.print("아이디 : ");
		String id = Main.sc.nextLine();
		
		System.out.print("비밀번호 : ");
		String pwd = Main.sc.nextLine();
		
		//입력받은 데이터 파일에 저장하기
		saveData(id, pwd);
		
		//결과
		System.out.println("회원가입 성공");
	}//join
	
	/*
	 * 파일에 데이터 저장하기
	 */
	private void saveData(String id, String pwd) {
		//파일 준비
		File f = new File("D:\\dev\\member.txt");
		
		//스트림 만들기 (파일에 대해서. 2바이트 단위 처리 . 메인 + 보조)
		try (
				FileWriter fw = new FileWriter(f);
				BufferedWriter bw = new BufferedWriter(fw);
			)
		{
			//스트림 사용하기 (데이터 저장)
			bw.write(id);
			bw.write(" ");
			bw.write(pwd);
			bw.flush();
			
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		//스트림 정리하기 (위에서 처리함)
	}

}//class





























