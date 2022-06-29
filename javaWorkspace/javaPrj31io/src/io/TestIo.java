package io;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class TestIo {
	
	public void test() throws Exception {
		
		File f = new File("D:\\dev\\hello.txt");
		
		//파일 맞는지 확인
		System.out.println(f.isFile());
		
		//데이터 읽기 (1byte)
//		FileInputStream fis = new FileInputStream(f);
//		
//		int result = 0;
//		while((result = fis.read()) != -1) {
//			System.out.print((char)result);
//		}
		
		//데이터 읽기 (보조스트림)
		BufferedReader br = new BufferedReader(new FileReader(f));
		String s = "";
		while((s = br.readLine()) != null ) {
			System.out.println(s);
		}
//		for(int i = 0 ; i < 3; ++i) {
//			String s = br.readLine();
//			System.out.println(s);
//		}
		//사용한 자원 반납
		br.close();
		
	}//method
	
	public void test2() throws Exception {
		//문자열입력받기
		System.out.print("문자열을 입력하세요 : ");
		Scanner sc = new Scanner(System.in);
		String str = sc.nextLine();
		
		//출력 테스트
		
		//파일 가져오기
		File f = new File("D:\\dev\\hello.txt");
		System.out.println(f.isFile());
		
		//통로 만들기
		FileWriter fw = new FileWriter(f);
		BufferedWriter bw = new BufferedWriter(fw);
		
		//통로 이용해서 보내기
		bw.write(str);
		bw.flush();
		bw.close();//사용한 자원 반납
		System.out.println("write 완료함");
	}

}//class






























