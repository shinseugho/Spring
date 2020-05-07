package com.sist.dao;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import java.util.*;
/*
 * 皋葛府积己
 */
@Repository
public class EmpDAO extends SqlSessionDaoSupport{
	/*
	 * 单捞磐 林涝
	 */
	@Autowired
	public void setSqlSessionFactory(SqlSessionFactory sqlSessionFactory) {
		// TODO Auto-generated method stub
		super.setSqlSessionFactory(sqlSessionFactory);
	}

	public List<EmpVO> empAllData()
	{
		return getSqlSession().selectList("empAllData");
	}
	
	public EmpVO empFindData(int empno)
	{
		return getSqlSession().selectOne("empFindData",empno);
	}
	
}
