package client;

import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;

public class Main {

	public static void main(String[] args) throws Exception {
		
		Socket s = new Socket("127.0.0.1", 12345);
		System.out.println("연결 완료 !");
		
		OutputStream out = s.getOutputStream();
		PrintWriter pw = new PrintWriter(out);
		
		pw.println("메세지 ㅋㅋㅋ 클라이언트가 보냄 ㅋㅋ");
		pw.flush();
		
		
	}//main

}//class


























