package tn.esprit.demo.configuration;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.jboss.logging.Logger;

public class PerformanceAspect {
	private static Logger l = Logger.getLogger(PerformanceAspect.class.getName());
	
	@Around("execution(* tn.esprit.spring.service.*.*(..))")//we want to intercept any method aal service
	public Object profile(ProceedingJoinPoint pjp) throws Throwable {
	long start = System.currentTimeMillis();
	Object obj = pjp.proceed();
	long elapsedTime = System.currentTimeMillis() - start;
	l.info("Method execution time: " + elapsedTime + " milliseconds.");
	return obj;
	}
}
