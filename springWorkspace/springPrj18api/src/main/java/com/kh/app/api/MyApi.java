package com.kh.app.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import lombok.extern.slf4j.Slf4j;

@Controller
@Slf4j
public class MyApi {
	
	@Autowired
	private OpenApi oa;
	
	//1~6 사이의 랜덤 숫자 리턴하는 메소드
	@GetMapping("dice")
	@ResponseBody
	public String dice() {
		return "" + (int)(Math.random() * 6 + 1);
	}
	
	//전달받은 숫자에 맞는 데이터를 리턴하는 메소드
	@GetMapping("num")
	@ResponseBody
	public String num(int n) {
		
		String str = "";
		
		switch (n) {
		case 1:
			str = "ONE";
			break;

		default:
			str = "NaN";
			break;
		}
		
		return str;
	}
	
	//CCTV 날씨 정보 받아오는 메소드
	@GetMapping("cctv")
	@ResponseBody
	public String cctv() throws Exception {
		//open api 호출 결과(JSON) 리턴
		
		String result = oa.cctv();
		
		log.info(result);
		
		return result;
	}
	
	//미세먼지 조회
	@GetMapping(value = "mise" , produces = "application/json; charset=utf-8")
	@ResponseBody
	public String mise(String cnt) throws Exception {
		//open api 호출 결과
		String jsonStr = oa.mise(cnt);
		
		JsonObject jsonObj = JsonParser.parseString(jsonStr).getAsJsonObject();
		JsonObject responseObj = jsonObj.getAsJsonObject("response");
		JsonObject bodyObj = responseObj.getAsJsonObject("body");
		JsonArray items = bodyObj.getAsJsonArray("items");
		
		return items.toString();
	}

}//class
























