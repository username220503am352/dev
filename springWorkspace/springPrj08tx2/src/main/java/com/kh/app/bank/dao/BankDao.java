package com.kh.app.bank.dao;

import java.util.HashMap;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class BankDao {

	//마이너스
	public int minus(SqlSessionTemplate sst, HashMap<String, String> map) {
		return sst.update("bankMapper.minus", map);
	}

	//플러스
	public int plus(SqlSessionTemplate sst, HashMap<String, String> map) {
		return sst.update("bankMapper.plus", map);
	}

	
	

}//class































