package com.kh.app.aop.timer;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.stereotype.Component;

import lombok.extern.slf4j.Slf4j;

@EnableAspectJAutoProxy
@Component
@Aspect
@Slf4j
public class TimerAspect {
	
	@Before("target(com.kh.app.member.dao.MemberDao)")
	public void myAdvice() {
		log.info("hello ~~~");
	}

}//class


























