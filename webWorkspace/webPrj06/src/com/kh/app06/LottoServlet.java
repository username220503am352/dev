package com.kh.app06;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns = "/study/lotto")
public class LottoServlet extends HttpServlet {
	
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		System.out.println("lotto ~~~~~");
		
		int[] lotto = new int[6];
		
		for(int i = 0 ; i < 6 ; ++i) {
			lotto[i] = (int)(Math.random() * 45 + 1);
			//resp.getWriter().write(i + " num : " + lotto[i] + "<br>");
		}
		
		//응답
		PrintWriter pw = resp.getWriter();
		
		String str = "";
		for(int i = 0; i < lotto.length; ++i) {
			str += lotto[i];
			if(i != lotto.length-1) str += ",";
		}
		
		//pw.write("<h1>" + str + "</h1>");
		pw.write("<h1>" + Arrays.toString(lotto) + "</h1>");
		
		
	}

}//class




























