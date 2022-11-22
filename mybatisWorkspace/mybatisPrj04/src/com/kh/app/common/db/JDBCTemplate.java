package com.kh.app.common.db;

import java.io.InputStream;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class JDBCTemplate {

	//디비연결
	public static SqlSession getSqlSession() {
		
		SqlSession ss = null;
		try {
			String resource = "/config.xml";
			InputStream inputStream = Resources.getResourceAsStream(resource);
			SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
			ss = sqlSessionFactory.openSession(false);
		}catch(Exception e) {
			e.printStackTrace();
		}
		return ss;
	}//method
	
}//class

































