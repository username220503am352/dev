package com.kh.common;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class JDBCTemplate {
	
	//커넥션 가져오기
	public static Connection getConnection() throws Exception {
		
		String driver = "oracle.jdbc.driver.OracleDriver";
		String url = "jdbc:oracle:thin:@localhost:1521:xe";
		String id = "C##MINI";
		String pwd = "MINI";
		
		Class.forName(driver);
		Connection conn = DriverManager.getConnection(url, id, pwd);
		conn.setAutoCommit(false);
		
		return conn;
	}
	
	//커밋
	
	//롤백
	
	//close : conn , rs, stmt

}//class







































