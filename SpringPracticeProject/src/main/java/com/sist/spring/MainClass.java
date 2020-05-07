package com.sist.spring;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MainClass {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		//1. XML파싱	
		ApplicationContext app=new ClassPathXmlApplicationContext("app.xml");
		
		//2. 등록된 클래스 사용
		//sawon sa=(sawon)app.getBean("sa");
		//sawon sa=(sawon)app.getBean("sa1");
		//sawon sa=(sawon)app.getBean("sa2");
		//sawon sa=(sawon)app.getBean("sa3");
		//sawon sa=(sawon)app.getBean("sa4");
		sawon sa=(sawon)app.getBean("sa5");
		//System.out.println("sa="+sa);
		//System.out.println("sa1="+sa1);
		//System.out.println("sa2="+sa2);
		//System.out.println("sa3="+sa3);
		//System.out.println("sa4="+sa4);
		System.out.println("sa5="+sa);
		System.out.println("사번:"+sa.getSabun());
		System.out.println("이름:"+sa.getName());
		System.out.println("부서:"+sa.getDept());
		//sa.display();
		//sa.setSabun(1);
		//sa.setName("홍길동");
		//sa.setDept("개발부");
		
		//sawon sa1=(sawon)app.getBean("sa");
		//System.out.println("sa1="+sa1);
		//sa1.display();
		//sa1.setSabun(2);
		//sa1.setName("심청이");
		//sa1.setDept("영업부");
		
		//sysout을 보면 주소값이 동일한대 이런 방식을 싱글턴이라고 한다.
		//System.out.println(sa.getName());
		//System.out.println(sa1.getName());
		
	}

}
