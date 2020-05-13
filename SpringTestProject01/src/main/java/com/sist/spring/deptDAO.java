package com.sist.spring;

import java.util.*;

public class deptDAO {

	private deptMapper mapper;

	public void setMapper(deptMapper mapper) {
		this.mapper = mapper;
	}
	
	public List<deptVO> deptAllData()
	{
		return mapper.deptAllData();
	}
}
