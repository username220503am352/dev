package com.kh.temp.api;

import java.io.IOException;
import java.util.HashMap;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

@WebServlet(urlPatterns = "/today")
public class TodayApi extends HttpServlet {
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		MemberVo[] voArr = new MemberVo[3];
		
		for(int i = 0 ; i < 3; ++i) {
			MemberVo vo = new MemberVo();
			vo.setId("user01");
			vo.setPwd("1234");
			voArr[i] = vo;
		}
		
		Gson gson = new Gson();
		String result = gson.toJson(voArr);
		
		
		resp.getWriter().write(result);
	}

}//class





























