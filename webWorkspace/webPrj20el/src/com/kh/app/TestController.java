package com.kh.app;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet(urlPatterns = "/test")
public class TestController extends HttpServlet {
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		HttpSession s = req.getSession();
		
		s.setAttribute("id", "admin");
		s.setAttribute("name", "session심원용");
		req.setAttribute("name", "req심원용");
		req.setAttribute("age", "20");
		
		String[] arr = new String[] {"코딩" , "개발" , "프로그래밍"};
		req.setAttribute("hobby", arr);
		
		ArrayList<String> foodList = new ArrayList<String>();
		foodList.add("밥");
		foodList.add("빵");
		foodList.add("떡");
		req.setAttribute("foodList", foodList);
		
		HashMap<String, String> pet = new HashMap<String, String>();
		pet.put("자" , "쥐");
		pet.put("축" , "소");
		pet.put("인" , "호랑이");
		pet.put("묘" , "토끼");
		req.setAttribute("pet", pet);
		
		PokemonVo vo = new PokemonVo();
		vo.setName("피카츄");
		vo.setAtk("123");
		vo.setDef("77");
		req.setAttribute("pokemon", vo);
		
		
		req.getRequestDispatcher("/WEB-INF/views/test.jsp").forward(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

	}

}//class

































