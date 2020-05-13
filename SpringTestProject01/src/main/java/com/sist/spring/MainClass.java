package com.sist.spring;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import java.util.*;

public class MainClass {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ApplicationContext app=new ClassPathXmlApplicationContext("app.xml");
		deptDAO dao=(deptDAO)app.getBean("dao");
		List<deptVO> list=dao.deptAllData();
		for(deptVO vo:list)
		{
			System.out.println(vo.getDeptno()+" "+vo.getDname()+" "+vo.getLoc());
		}
	}

}
