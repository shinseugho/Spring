package com.sist.spring;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MainClass {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		//1. XML�Ľ�	
		ApplicationContext app=new ClassPathXmlApplicationContext("app.xml");
		
		//2. ��ϵ� Ŭ���� ���
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
		System.out.println("���:"+sa.getSabun());
		System.out.println("�̸�:"+sa.getName());
		System.out.println("�μ�:"+sa.getDept());
		//sa.display();
		//sa.setSabun(1);
		//sa.setName("ȫ�浿");
		//sa.setDept("���ߺ�");
		
		//sawon sa1=(sawon)app.getBean("sa");
		//System.out.println("sa1="+sa1);
		//sa1.display();
		//sa1.setSabun(2);
		//sa1.setName("��û��");
		//sa1.setDept("������");
		
		//sysout�� ���� �ּҰ��� �����Ѵ� �̷� ����� �̱����̶�� �Ѵ�.
		//System.out.println(sa.getName());
		//System.out.println(sa1.getName());
		
	}

}
