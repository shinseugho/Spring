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
	 * 실행시 같은 객체를 가지고 있는 클래스가 존재할 경우, 어떤 클래스로 갈 것인지 세세하게 지정해야한다.
	 * =>@Qualifier("boardDAO")로 지정을 한다.
	 * =>@Resource(name="noticeDAO")는 둘 다를 합쳤다.
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
