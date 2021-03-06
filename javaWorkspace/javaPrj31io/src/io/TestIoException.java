package io;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class TestIoException {
	
	//출력
	public void testOutput() {
		//파일 객체 생성
		File f = new File("D:\\dev\\hello.txt");
		System.out.println(f.isFile());
		
		try (FileWriter fw = new FileWriter(f);){
			//스트림 생성
			
			//스트림 사용
			fw.write("zzz");
			fw.flush();
			System.out.println("전송 완료 !");
			
		}catch(IOException e) {
			System.out.println("파일 스트림 생성 중 예외 발생 !");
			System.out.println("에러 메세지 ::: " + e.getMessage());
		}
		
	}
	
	
	//입력
	public void testInput() {
		//파일 객체 생성
		File f = new File("D:\\dev\\hello.txt");
		System.out.println("파일맞음?" + f.isFile());
		
		try (
				FileReader fr = new FileReader(f);
				BufferedReader br = new BufferedReader(fr);
			){
			//스트림 생성 (+보조스트림)
			
			//스트림 사용
			String s = "";
			while((s = br.readLine()) != null) {
				System.out.println(s);
			}
		} catch (IOException e) {
			System.out.println("입력 스트림 예외 발생 !");
			System.out.println("예외 메세지 ::: " + e.getMessage());
		}
		
	}
	
}//class
















