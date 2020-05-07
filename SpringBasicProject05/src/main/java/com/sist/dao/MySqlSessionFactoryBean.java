package com.sist.dao;

import javax.annotation.Resource;
import javax.sql.DataSource;
import java.sql.*;
import java.util.*;
import java.util.Date;

import org.mybatis.spring.SqlSessionFactoryBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Component;

/* 
	 @Autowired: 자동주입(클래스의 메모리 주소만 주입, 스프링에 등록된 클래스만 사용이 가능하다.)
	 public class A
	 {
	 	@
	 	MyDAO dao; => field
	 	
	 	@
	 	public A(MyDAO dao){} => CONSTRUCTOR
	 	
	 	@
	 	public void setMyDAO(MyDAO dao){} => PARAMETER
	 	
	 	@
	 	public void display(MyDAO dao){}
	 }
	
	=> 클래스 메모리할당
	=> 멤버변수에 값을 주입
	=> 클래스의 메모리 해제
	=> 반복적 코딩 제거: 소스의 간결화

   <bean id="ssf" class="org.mybatis.spring.SqlSessionFactoryBean" 
		p:dataSource-ref="ds"
		p:configLocation="classpath:Config.xml"
	/>
 */
@Component("ssf")
public class MySqlSessionFactoryBean extends SqlSessionFactoryBean{

	/*
	 *	@Autowired는 생성된 것에 자동으로 값을 넣을때 사용한다.
	 *	@Qualifier("ds")
	 *	@Resource(name="ds")
	 *	@Resource는 @Autowired+@Qualifier("ds")이다
	 */
	@Autowired
	public void setDataSource(DataSource dataSource) {
		// TODO Auto-generated method stub
		super.setDataSource(dataSource);
	}
	
	public MySqlSessionFactoryBean()
	{
		try
		{
			org.springframework.core.io.Resource res=new ClassPathResource("Config.xml");
			setConfigLocation(res);
		}catch(Exception ex){}
	}
	
	
}
