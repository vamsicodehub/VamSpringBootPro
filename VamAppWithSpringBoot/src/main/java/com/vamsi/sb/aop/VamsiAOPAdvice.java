package com.vamsi.sb.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Aspect
public class VamsiAOPAdvice {
	Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Before("execution(*com.vamsi.sb.web.*.*(..))")
	public void before(JoinPoint joinpoint) {
		
		logger.info("{} intercepted ", joinpoint.getSignature().getName());
		
	}

}
