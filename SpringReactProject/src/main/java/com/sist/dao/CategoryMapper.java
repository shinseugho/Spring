package com.sist.dao;

import java.util.*;
import org.apache.ibatis.annotations.Select;

public interface CategoryMapper {

	@Select("SELECT * FROM category")
	public List<CategoryVO> categoryListData();
	
}
