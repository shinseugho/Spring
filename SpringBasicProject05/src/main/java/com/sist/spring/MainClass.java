package com.sist.spring;

import java.util.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Component;
import com.sist.dao.*;

/*
 * @Component가 없으면 메모리 할당을 하지않으므로, EmpDAO에 null값이 들어간다.
 */
@Component("mc")
public class MainClass {

	@Autowired
	private EmpDAO dao;
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ApplicationContext app=new ClassPathXmlApplicationContext("app.xml");
		
		/*EmpDAO dao=(EmpDAO)app.getBean("empDAO");
		List<EmpVO> list=dao.empAllData();
		
		for(EmpVO vo:list)
		{
			System.out.println(vo.getEname()+" "+vo.getJob()+" "+vo.getSal());
		}*/
		
		MainClass mc=(MainClass)app.getBean("mc");
		List<EmpVO> list=mc.dao.empAllData();
		System.out.println(mc.dao);
		for(EmpVO vo:list)
		{
			System.out.println(vo.getEname()+" "+vo.getJob()+" "+vo.getSal());
		}
	}

}
