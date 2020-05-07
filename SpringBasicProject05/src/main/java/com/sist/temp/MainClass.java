package com.sist.temp;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Component;

@Component
public class MainClass {

	/*	@Autowired
	 * ����� ���� ��ü�� ������ �ִ� Ŭ������ ������ ���, � Ŭ������ �� ������ �����ϰ� �����ؾ��Ѵ�.
	 * =>@Qualifier("boardDAO")�� ������ �Ѵ�.
	 * =>@Resource(name="noticeDAO")�� �� �ٸ� ���ƴ�.
	 */
	@Resource(name="noticeDAO")
	private MyDAO dao;
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ApplicationContext app=new ClassPathXmlApplicationContext("app.xml");
		MainClass mc=(MainClass)app.getBean("mainClass");
		//MainClass mc1=new MainClass();
		mc.dao.select();
		//mc1.dao.select();
	}

}
