package main;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
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
		
		boolean isValid = checkValid(id, pwd);
		if(isValid) {
			//입력받은 데이터 파일에 저장하기
			saveData(id, pwd);
			
			//결과
			System.out.println("회원가입 성공");
		}else {
			System.out.println("회원가입 실패");
		}
		
		
	}//join
	
	private boolean checkValid(String id, String pwd) {
		//아이디 검사
		if(id.length() < 2) return false;
		//아이디 중복검사
		if(!checkDup(id)) return false;
		
		//비번 검사
		if(pwd.length() < 4) return false;
		
		//결과 리턴
		return true;
	}

	private boolean checkDup(String id) {
		
		File f = new File("D:\\dev\\member.txt");
		
		try (BufferedReader br = new BufferedReader(new FileReader(f));)
		{
			//메모장에서 모든 줄 읽기
			while(true) {
				String data = br.readLine();
				if(data == null) break;
				String idData = data.split(" ")[0];
				if(idData.equals(id)) {
					System.out.println("아이디 중복 !!!!!");
					return false;//아이디 중복
				}
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return true;	//중복된 아이디가 없음
	}

	/*
	 * 파일에 데이터 저장하기
	 */
	private void saveData(String id, String pwd) {
		//파일 준비
		File f = new File("D:\\dev\\member.txt");
		
		//스트림 만들기 (파일에 대해서. 2바이트 단위 처리 . 메인 + 보조)
		try (
				FileWriter fw = new FileWriter(f, true);
				BufferedWriter bw = new BufferedWriter(fw);
			)
		{
			//스트림 사용하기 (데이터 저장)
			bw.write(id);
			bw.write(" ");
			bw.write(pwd);
			bw.write("\n");
			bw.flush();
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		//스트림 정리하기 (위에서 처리함)
	}

}//class





























