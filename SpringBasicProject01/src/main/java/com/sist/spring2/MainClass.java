package com.sist.spring2;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import java.util.*;

public class MainClass {

	//5.0 version은 이렇게 작성한다. 
	public static void main(String[] args) {
		
		AnnotationConfigApplicationContext ctx=new AnnotationConfigApplicationContext(Config.class);
		
		//2가지 방식을 사용할 수도 있다. 
		/* 형변환 방식
		 * EmpDAO dao=(EmpDAO)ctx.getBean("empDAO");
		 */
		//제네릭스 방식
		EmpDAO dao=ctx.getBean("empDAO",EmpDAO.class);
		
		List<EmpVO> list=dao.empAllData();
		for(EmpVO vo:list)
		{
			System.out.println(vo.getEname()+" "+vo.getJob()+" "+vo.getSal());
		}
	}

}
