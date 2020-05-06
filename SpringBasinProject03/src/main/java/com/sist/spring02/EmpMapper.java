package com.sist.spring02;

import org.apache.ibatis.annotations.Select;
import java.util.*;

public interface EmpMapper {
	
	@Select("SELECT * FROM emp")
	public List<EmpVO> empAllData();
}
