package com.sist.dao;

import org.apache.commons.dbcp.BasicDataSource;
import org.springframework.stereotype.Component;
/*
 * 메모리할당시 사용되는 어노테이션
 * @Component, 			: 일반클래스
 * @Repository, 		: DAO 
 * @Service, 			: BI=> DAO+DAO=> SERVICE VS DAO 
 * @Controller, 		: Model(JSP파일명)
 * @RestController, 	: Restful(필요한 데이터전송,AJAX,XML.JSON)
 * @ControllerAdvice 	: AOP
 */
@Component("ds")
public class MyBasicDataSource extends BasicDataSource{

	
	
}
