package com.sist.dao;

import org.apache.commons.dbcp.BasicDataSource;
import org.springframework.stereotype.Component;
/*
 * �޸��Ҵ�� ���Ǵ� ������̼�
 * @Component, 			: �Ϲ�Ŭ����
 * @Repository, 		: DAO 
 * @Service, 			: BI=> DAO+DAO=> SERVICE VS DAO 
 * @Controller, 		: Model(JSP���ϸ�)
 * @RestController, 	: Restful(�ʿ��� ����������,AJAX,XML.JSON)
 * @ControllerAdvice 	: AOP
 */
@Component("ds")
public class MyBasicDataSource extends BasicDataSource{

	
	
}
