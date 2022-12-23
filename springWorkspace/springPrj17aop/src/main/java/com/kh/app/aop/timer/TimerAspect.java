package com.kh.app.aop.timer;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.stereotype.Component;

import lombok.extern.slf4j.Slf4j;

@EnableAspectJAutoProxy
@Aspect
@Slf4j
public class TimerAspect {
	
//	@Before("target(com.kh.app.member.dao.MemberDao)")
//	public void myAdvice() {
//		log.info("SQL 실행 전 : " + System.currentTimeMillis());
//	}
//	
//	@After("target(com.kh.app.member.dao.MemberDao)")
//	public void myAdvice2() {
//		log.info("SQL 실행 후 : " + System.currentTimeMillis());
//	}
	
	//@Around("target(com.kh.app.member.dao.MemberDao)")
	//@Around("execution(접근제한자 리턴타입 패키지경로.클래스명.메소드(파라미터) )")
	@Around("execution(public com.kh.app.member.vo.MemberVo com.kh.app.member.dao.MemberDao.*One(..) )")	//리턴타입 지정
	//@Around("execution(public * com.kh.app.member.dao.MemberDao.*One(*) )")	//파라미터 상관없음 (1개)
	//@Around("execution(public * com.kh.app.member.dao.MemberDao.*One(패키지.클래스명 , 패키지.클래스명) )")	//매개변수 지정
	//@Around("execution(public * com.kh.app.member.dao.MemberDao.*One(..) )")	//메소드 지정
	//@Around("execution(public * com.kh.app.member.dao.MemberDao.selectOne(..) )")	//메소드 지정
	//@Around("execution(public * com.kh.app.member.dao.MemberDao.*(..) )")	//클래스 지정
	//@Around("execution(public * com.kh.app.member.dao.*.*(..) )")	//패키지 지정
	//@Around("execution(public * com..*.*(..) )")
	//@Around("execution( * com..*.*(..) )")		
	//접근제한자 아무거나 , 리턴타입 아무거나 , 패키지는 com 하위 , 클래스명 아무거나 , 메소드명 아무거나 , 파라미터 아무거나
	public Object myAdvice3(ProceedingJoinPoint jp) throws Throwable {
		long start = System.currentTimeMillis();
		Object obj = jp.proceed();	//타겟 메소드 실행
		log.error("jp의 시그니처 : " + jp.getSignature());
		long end = System.currentTimeMillis();
		long time = end - start;
		log.info("time : " + time);
		return obj;
	}
	
	

}//class


























