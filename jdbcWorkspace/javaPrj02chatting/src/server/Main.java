package server;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;

public class Main {

	public static void main(String[] args) throws IOException {
		
		 ServerSocket ss = new ServerSocket(12345);
		 
		 System.out.println("클라이언트의 연결요청이 오기를 기다리는중 ...");
		 Socket cs = ss.accept();
		 System.out.println("연결된 소켓 : " + cs.getInetAddress());
		 
		 InputStream in = cs.getInputStream();
		 InputStreamReader isr = new InputStreamReader(in);
		 BufferedReader br = new BufferedReader(isr);
		 
		 String msg = br.readLine();
		 System.out.println(msg);
		
	}//main

}//class






















