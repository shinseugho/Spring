package com.sist.dao;

import org.apache.commons.dbcp.BasicDataSource;
import org.springframework.stereotype.Component;
/*
 * �޸��Ҵ�� ���Ǵ� ������̼�
 * @Component 			: �Ϲ�Ŭ����
 * @Repository 			: DAO 
 * @Service 			: BI=> DAO+DAO=> SERVICE VS DAO 
 * @Controller 			: Model(JSP���ϸ�)
 * @RestController 		: Restful(�ʿ��� ����������,AJAX,XML.JSON)
 * @ControllerAdvice 	: AOP
 * 
   <bean id="ds" class="org.apache.commons.dbcp.BasicDataSource"
		p:driverClassName="oracle.jdbc.driver.OracleDriver"
		p:url="jdbc:oracle:thin:@localhost:1521:XE"
		p:username="hr"
		p:password="happy"
		p:maxActive="20"
		p:maxIdle="10"
		p:maxWait="-1"
	/>
 */
@Component("ds")
public class MyBasicDataSource extends BasicDataSource{

	public MyBasicDataSource()
	{
		setDriverClassName("oracle.jdbc.driver.OracleDriver");
		setUrl("jdbc:oracle:thin:@localhost:1521:XE");
		setUsername("hr");
		setPassword("happy");
		setMaxActive(20);
		setMaxIdle(10);
		setMaxWait(-1);
	}
	
}
