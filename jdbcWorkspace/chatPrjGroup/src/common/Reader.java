package common;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;

public class Reader implements Runnable {
	
	private final Socket s;

	

	public Reader(Socket s) {
		this.s = s;
	}



	@Override
	public void run() {
		try {
			BufferedReader br = new BufferedReader(new InputStreamReader(s.getInputStream(), "utf-8"));
			while(true) {
				String msg = br.readLine();
				System.out.println(msg);
				Thread.sleep(100);
			}
		} catch (IOException | InterruptedException e) {
			e.printStackTrace();
		}
	}

}
