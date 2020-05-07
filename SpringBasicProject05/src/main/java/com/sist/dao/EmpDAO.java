package com.sist.dao;

import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.springframework.stereotype.Repository;
import java.util.*;

@Repository("eDao")
//<bean id="eDao" class="com.sist.dao.EmpDAO">
public class EmpDAO extends SqlSessionDaoSupport{
	
	public List<EmpVO> empAllData()
	{
		return getSqlSession().selectList("empAllData");
	}
	
	public EmpVO empFindData(int empno)
	{
		return getSqlSession().selectOne("empFindData",empno);
	}
	
}
