package com.kh.app04.common;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class JDBCTemplate {
	
	/**
	 * @return Connection
	 */
	public static Connection getConnection() {
		
		Connection conn = null;
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			
			String url = "jdbc:oracle:thin:@127.0.0.1:1521:xe";
			String username = "C##MYBATIS";
			String password = "MYBATIS";
			
			conn = DriverManager.getConnection(url , username, password);
			conn.setAutoCommit(false);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return conn;
	}
	
	//commit
	public static void commit(Connection conn) {
		try {
			if(conn != null && !conn.isClosed()) {
				conn.commit();	
			}
		} catch (SQLException e) {
		}
	}
	
	//rollback
	public static void rollback(Connection conn) {
		
		try {
			if(conn != null && !conn.isClosed()) {
				conn.rollback();	
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}
	
	//close * 3  //conn , stmt , rs
	public static void close(Connection x) {
		try {
			
			if(x != null && !x.isClosed()) {
				x.close();
			}
			
		} catch (SQLException e) {
		}
	}
	
	public static void close(Statement x) {
		try {
			
			if(x != null && !x.isClosed()) {
				x.close();
			}
			
		} catch (SQLException e) {
		}
	}
	
	public static void close(ResultSet x) {
		try {
			
			if(x != null && !x.isClosed()) {
				x.close();
			}
			
		} catch (SQLException e) {
		}
	}

}//class





























