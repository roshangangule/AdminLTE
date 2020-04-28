package com.javabykiran.aspect;

import java.util.Date;
import java.util.logging.Logger;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class Logging {

	Logger myLogger = Logger.getLogger(getClass().getName());

	@Pointcut("execution(* com.javabykiran.dao.*.*(..))")
	public void forDaoPackage() {

	}

	@Pointcut("execution(* com.javabykiran.service.*.*(..))")
	public void forServicePackage() {

	}

	@Pointcut("execution(* com.javabykiran.controller.*.*(..))")
	public void forControllerPackage() {

	}

	
	@Around("forDaoPackage() || forServicePackage() || forControllerPackage()")
	public Object forMyApp(ProceedingJoinPoint theProceedingJoinPoint) {

		String method = theProceedingJoinPoint.getSignature().toShortString();

		long start = (long) System.currentTimeMillis();
		Date date = new Date(start);

		myLogger.info("Started calling " + method + " at " + date + ".");

		Object result = null;

		try {

			result = theProceedingJoinPoint.proceed();
		} catch (Throwable e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		String method1 = theProceedingJoinPoint.getSignature().toShortString();

		long end = (long) System.currentTimeMillis();
		Date date1 = new Date(end);

		myLogger.info("Existing from " + method1 + " at " + date1 + ".");

		return result;
	}
}
