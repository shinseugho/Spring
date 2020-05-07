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
	 @Autowired: �ڵ�����(Ŭ������ �޸� �ּҸ� ����, �������� ��ϵ� Ŭ������ ����� �����ϴ�.)
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
	
	=> Ŭ���� �޸��Ҵ�
	=> ��������� ���� ����
	=> Ŭ������ �޸� ����
	=> �ݺ��� �ڵ� ����: �ҽ��� ����ȭ

   <bean id="ssf" class="org.mybatis.spring.SqlSessionFactoryBean" 
		p:dataSource-ref="ds"
		p:configLocation="classpath:Config.xml"
	/>
 */
@Component("ssf")
public class MySqlSessionFactoryBean extends SqlSessionFactoryBean{

	/*
	 *	@Autowired�� ������ �Ϳ� �ڵ����� ���� ������ ����Ѵ�.
	 *	@Qualifier("ds")
	 *	@Resource(name="ds")
	 *	@Resource�� @Autowired+@Qualifier("ds")�̴�
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
