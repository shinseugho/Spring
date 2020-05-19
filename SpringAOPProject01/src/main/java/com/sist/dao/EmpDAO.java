package com.sist.dao;

import org.springframework.stereotype.Repository;

@Repository
public class EmpDAO {

	public void emp_select()
	{
		//getConnection();
		System.out.println("SELECT * FROM emp;");
		//disConnection();
	}
	
	public void emp_insert(String name)
	{
		//getConnection();
		System.out.println("INSERT INTO emp values "+name+";");
		//disConnection();
	}
	
	public void emp_update(int sabun,String name)
	{
		//getConnection();
		//오류발생코드
		//int a=10/0;
		System.out.println("UPDATE emp SET name="+name+" WHERE sabun="+sabun+";");
		//disConnection();
	}
	
	public String emp_delete(int sabun)
	{
		//getConnection();
		System.out.println("DELETE FROM emp WHERE sabun="+sabun+";");
		//disConnection();
		
		return "삭제완료";
	}
	
	public void driverClassNameConfig()
	{
		System.out.println("오라클 드라이버 등록!!");
	}
	
	public void display()
	{
		for(int i=0;i<1000000000;i++)
		{
			
		}
		System.out.println("for문 종료 ");
	}
}

