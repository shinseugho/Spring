package com.sist.spring;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import java.util.*;

public class MainClass {

	private EmpDAO dao;
	
	public void setDao(EmpDAO dao) {
		this.dao = dao;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		//DL: ��ϵ� Ŭ������ �о�ö� ����Ѵ�.
		ApplicationContext app=new ClassPathXmlApplicationContext("app.xml");	
		MainClass mc=(MainClass)app.getBean("mc"); 
		/*EmpDAO dao=(EmpDAO)app.getBean("dao");*/
		List<EmpVO> list=mc.dao.empAllData();
		
		for(EmpVO vo:list)
		{
			System.out.println
			(
					 vo.getEmpno()+" "
					+vo.getEname()+" "
					+vo.getJob()+" "
					+vo.getHiredate().toString()+" "
					+vo.getSal()
			);
		}
	}

}
