package com.kh.app.test;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/test")
public class TestController extends HttpServlet {
	
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		//복잡한 연산,,,, 복잡한 자바코드 ,,,,
		int num = 10 + 5 - 3 - 100;
		
		//결과를 저장소에 담기
		req.setAttribute("n", num);
		
		List<String> list = new ArrayList<String>();
		list.add("one");
		list.add("two");
		list.add("three");
		
		req.setAttribute("numList", list);
		
		//JSP 한테 바톤 터치
		req.getRequestDispatcher("/WEB-INF/views/test.jsp").forward(req, resp);
		
	}
	
}





