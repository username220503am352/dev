package com.kh.pizza.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns = "/pizza")
public class PizzaServlet extends HttpServlet {
	
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse resp) throws ServletException, IOException {
		
		request.setCharacterEncoding("UTF-8");
		String[] sideArr = request.getParameterValues("side");
		String str = String.join(",", sideArr);

		String topping = "";
		String toppingTemp = request.getParameter("topping");
		if("co".equals(toppingTemp)){
			topping = "콤비네이션피자";
		}else if("pp".equals(toppingTemp)){
			topping = "페페로니피자";
		}
		else if("ch".equals(toppingTemp)){
			topping = "치즈피자";
		}
		else if("sp".equals(toppingTemp)){
			topping = "고구마피자";
		}
		else if("hm".equals(toppingTemp)){
			topping = "하와이안민트초코";
		}

		String dough = "";
		String doughTemp = request.getParameter("dough");
		if("th".equals(doughTemp)){
			dough = "씬 도우";
		}else if("cc".equals(doughTemp)){
			dough = "치즈크러스트 도우";
		}else if("et".equals(doughTemp)){
			dough = "에그타르트 도우";
		}
		
		String side = "";
		String[] sideTemp = request.getParameterValues("side");
		for(int i = 0 ; i < sideTemp.length; ++i){
			if("sp".equals(sideTemp[i])){
				side += "스파게티 ";
			}else if("cs".equals(sideTemp[i])){
				side += "콘샐러드 ";
			}else if("cb".equals(sideTemp[i])){
				side += "치즈볼 ";
			}
		}
		
		String addr = request.getParameter("addr");
		String phone = request.getParameter("phone");
		
		//-------------------------------------------------------------
		
		//1. 변수 전달하기
		request.setAttribute("addr", addr);
		request.setAttribute("phone", phone);
		request.setAttribute("side", side);
		request.setAttribute("topping", topping);
		request.setAttribute("dough", dough);
		
		//2. 다음타자한테 넘기기
		request.getRequestDispatcher("/orderResult.jsp").forward(request, resp);
		
	}

}//class

















