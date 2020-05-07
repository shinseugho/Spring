package com.sist.spring02;

import java.util.*;

public class EmpDAO {

	private EmpMapper mapper;

	public void setMapper(EmpMapper mapper) {
		this.mapper = mapper;
	}
	
	public List<EmpVO> empAllData()
	{
		return mapper.empAllData();
	}
	
}
