package com.sist.dao;

import org.apache.commons.dbcp.BasicDataSource;
import org.springframework.stereotype.Component;
/*
 * 메모리할당시 사용되는 어노테이션
 * @Component, 
 * @Repository, 
 * @Service, 
 * @Controller, 
 * @RestController, 
 * @ControllerAdvice
 */
@Component("ds")
public class MyBasicDataSource extends BasicDataSource{

	
	
}
