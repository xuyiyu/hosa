package com.hosa.web.service.aspect;

import java.lang.reflect.Proxy;

import org.apache.commons.lang3.ClassUtils;
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
@Order(1)
public class MultipleDataSourceInterceptor  {

	private static final Logger log = LoggerFactory.getLogger(MultipleDataSourceInterceptor.class);
	
	@Before("execution(* com..service.impl.*Service.save*(..))"
			+ "|| execution(* com..service.impl.*Service.update*(..))"
			+ "|| execution(* com..service.impl.*Service.delete*(..))")
	public void dynamicSetDataSoruce(JoinPoint joinPoint) throws Exception {
//		 Class<?> clazz = joinPoint.getTarget().getClass();
//	        String className = clazz.getName();
//	        if (ClassUtils.isAssignable(clazz, Proxy.class)) {
//	        	className = joinPoint.getSignature().getDeclaringTypeName();
//	        }
//	        String methodName = joinPoint.getSignature().getName();
//	        Object[] arguments = joinPoint.getArgs();
//	        
//		log.debug("-------------------execute {}.{}({})---------------------", className, methodName, arguments);
//		
		DbContextHolder.setDbType(DbContextHolder.DATA_SOURCE_1);
		log.debug("----------------DbContextHolder: {}------------------------", DbContextHolder.getDbType());
		
		log.debug("----------------------------------------");
	}
}
