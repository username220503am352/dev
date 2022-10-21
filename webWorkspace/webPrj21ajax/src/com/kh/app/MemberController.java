package com.kh.app;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

@WebServlet(urlPatterns = "/member")
public class MemberController extends HttpServlet {
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.getRequestDispatcher("/WEB-INF/views/member.jsp").forward(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		PrintWriter out = resp.getWriter();
		
		MemberVo vo = new MemberVo();
		vo.setId("user01");
		vo.setNick("nick01");
		
		MemberVo vo2 = new MemberVo();
		vo2.setId("user02");
		vo2.setNick("nick02");
		
		MemberVo vo3 = new MemberVo();
		vo3.setId("user03");
		vo3.setNick("nick03");
		
		ArrayList<MemberVo> list = new ArrayList<MemberVo>();
		list.add(vo);
		list.add(vo2);
		list.add(vo3);
		
		Gson gson = new Gson();
		
		//String str = "{\"id\":\"" + vo.getId() + "\",\"nick\":\"" + vo.getNick() +"\"}";
		String str = gson.toJson(list);
		
		out.write(str);
		
	}

}//class






















