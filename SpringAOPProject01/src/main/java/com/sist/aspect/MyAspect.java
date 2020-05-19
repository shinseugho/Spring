package com.sist.aspect;

import java.security.Signature;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class MyAspect {
	
	@Before(value = "execution(* com.sist.dao.EmpDAO.emp_*(..))")
	public void getConnection()
	{
		System.out.println("오라클 연결");
	}
	
	@After(value = "execution(* com.sist.dao.EmpDAO.emp_*(..))")
	public void disConnection()
	{
		System.out.println("오라클 해제");
	}
	
	//정상수행
	@AfterReturning(value="execution(* com.sist.dao.EmpDAO.emp_*(..))",returning="ret")
	public void returnValue(Object ret)
	{
		if(ret!=null)
			System.out.println(ret);
	}
	
	//오류발생
	@AfterThrowing(value="execution(* com.sist.dao.EmpDAO.emp_*(..))",throwing="ex")
	public void exceptionValue(Throwable ex)
	{
		System.out.println(ex.getMessage());
	}
	
	//log파일 제작
	@Around(value = "execution(* com.sist.dao.EmpDAO.display())")
	public Object display(ProceedingJoinPoint jp) throws Throwable
	{
		System.out.println(jp.getSignature().getName());
		long start=System.currentTimeMillis();
		//setAutoCommit(false);
		Object obj=jp.proceed();
		//conn.commit();
		long end=System.currentTimeMillis();
		System.out.println("수행시간: "+(end-start));
		return obj;
	}
}
