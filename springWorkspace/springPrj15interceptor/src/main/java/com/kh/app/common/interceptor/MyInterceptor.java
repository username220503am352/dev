package com.kh.app.common.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import oracle.net.aso.m;

//public class MyFilter extends HandlerInterceptorAdapter {
public class MyInterceptor implements HandlerInterceptor {

	// DS -> C
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		System.out.println("preHandle 호출됨 ...");
		System.out.println(handler);
		return true;
	}

	// C -> DS
	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
		System.out.println("postHandle 호출됨 ...");
		System.out.println(handler);
		System.out.println(modelAndView);
	}

	// 화면 만든 이후
	@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
			throws Exception {
		System.out.println("afterCompletion 호출됨 ...");
		System.out.println("###############" + handler);
		System.out.println("@@@@@@@@@@@@@@@" + ex);
	}
	
	

}//class





















