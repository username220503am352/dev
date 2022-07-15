package util;

import java.sql.Connection;
import java.sql.DriverManager;

public class JDBCTemplate {
	
	public static Connection getConnection() {
		
		Connection conn = null;
		
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			
			String url = "jdbc:oracle:thin:@localhost:1521:xe";
	        String id = "C##KH";
	        String pwd = "KH";
			
			conn = DriverManager.getConnection(url, id, pwd);
			
		} catch (Exception e) {
			System.out.println("커넥션 가져오기 실패 !");
			e.printStackTrace();
		}
		
		return conn;
		
	}//getConnection

}//class


























