package com.sist.dao;

import org.apache.ibatis.annotations.Select;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import java.util.*;

@Repository
public class DataBoardDAO {
	@Autowired
	private DataBoardMapper mapper;
	
	public List<DataBoardVO> databoardListData(Map map)
	{
		return mapper.databoardListData(map);
	}
	
	public void databoardInsert(DataBoardVO vo)
	{
		mapper.databoardInsert(vo);
	}
	public int databoardTotalPage()
	{
		return mapper.databoardTotalPage();
	}
	
	public DataBoardVO databoardDetail(int no)
	{
		mapper.hitIncrement(no);
		return mapper.databoardDetail(no);
	}
}
