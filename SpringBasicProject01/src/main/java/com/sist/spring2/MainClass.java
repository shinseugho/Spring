package com.sist.spring2;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import java.util.*;

public class MainClass {

	//5.0 version�� �̷��� �ۼ��Ѵ�. 
	public static void main(String[] args) {
		
		AnnotationConfigApplicationContext ctx=new AnnotationConfigApplicationContext(Config.class);
		
		//2���� ����� ����� ���� �ִ�. 
		/* ����ȯ ���
		 * EmpDAO dao=(EmpDAO)ctx.getBean("empDAO");
		 */
		//���׸��� ���
		EmpDAO dao=ctx.getBean("empDAO",EmpDAO.class);
		
		List<EmpVO> list=dao.empAllData();
		for(EmpVO vo:list)
		{
			System.out.println(vo.getEname()+" "+vo.getJob()+" "+vo.getSal());
		}
	}

}
