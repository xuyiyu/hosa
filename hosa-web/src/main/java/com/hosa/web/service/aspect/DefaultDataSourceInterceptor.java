package com.hosa.web.service.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import com.hosa.core.support.context.DbContextHolder;

@Component
@Aspect
@Order(0)
public class DefaultDataSourceInterceptor {

	private static final Logger log = LoggerFactory.getLogger(DefaultDataSourceInterceptor.class);
	
	@Before("execution(* com..service.impl.*Service.*(..))")
	public void dynamicSetDataSoruce(JoinPoint joinPoint) throws Exception {
		DbContextHolder.clearDbType();
		log.debug("----------------DbContextHolder: {}------------------------", DbContextHolder.getDbType());
		
		log.debug("----------------------------------------");
	}
}
