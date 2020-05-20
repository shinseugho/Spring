package com.sist.common;


import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class LogAspect {
   @Around("execution(* com.sist.web.EmpController.*(..))")
   public Object around(ProceedingJoinPoint jp) throws Throwable
   {
	   System.out.println("����� ��û ���:"+jp.getSignature().getName());
	   long start=System.currentTimeMillis();
	   Object obj=jp.proceed();
	   long end=System.currentTimeMillis();
	   System.out.println("����ð�:"+(end-start));
	   System.out.println(jp.getSignature().getName()+":����");
	   return obj;
   }
}
