package tn.esprit.demo.configuration;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class LoggingAspect {
private static final Logger l = LoggerFactory.getLogger(LoggingAspect.class);
@Before("execution(* tn.esprit.demo.service.StockServiceImpl.*(..))")
public void logMethodEntry(JoinPoint joinPoint) {
	String name = joinPoint.getSignature().getName();
	l.info("In method " + name + " : ");
}
@After("execution(* tn.esprit.demo.service.StockServiceImpl.*(..))")
public void logMethodExit(JoinPoint joinPoint) {
	String name = joinPoint.getSignature().getName();
	l.info("After method " + name);
}
}