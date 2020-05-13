package com.sist.spring;

import org.apache.ibatis.annotations.Select;
import java.util.*;

public interface deptMapper {

	@Select("SELECT * FROM dept")
	public List<deptVO> deptAllData();
		
}
