package com.vamsi.sba.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class LoggingAspect {
	
	Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Before("execution(* com.vamsi.sba.controllers.*.*(..))")
	public void before(JoinPoint joinPoint) {
		System.out.println("Inside Before for conntrollers interception.....");
		logger.info("{} intercepted and logged", joinPoint.getSignature().getName());
	}
	
	@After("execution(* com.vamsi.sba.service.*.*(..))")
	public void after(JoinPoint joinPoint) {
		System.out.println("Inside After Advice for service interception....");
		logger.info("After {} intercepted and logged", joinPoint.getTarget());
	}
	
	@AfterReturning(value = "execution(* com.vamsi.sba.dao.*.*(..))", returning = "result")
	public void afterReturning(JoinPoint joinPoint, Object result) {
		logger.info("DAO returned result :: {} ", result);
	}
	
	@AfterThrowing(value = "execution(* com.vamsi.sba.dao.*.*(..))", throwing = "result")
	public void afterThrows(JoinPoint joinPoint, Throwable result) {
		logger.info("DAO returned with Exception :: {} ", result);
	}
	
}
