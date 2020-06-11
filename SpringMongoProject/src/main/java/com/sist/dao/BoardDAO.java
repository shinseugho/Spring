package com.sist.dao;

import java.text.SimpleDateFormat;
import java.util.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Repository;

@Repository
public class BoardDAO {

	@Autowired
	private MongoTemplate mt;
	
	public List<BoardVO> boardListData(int page)
	{
		List<BoardVO> list=new ArrayList<BoardVO>();
		Query query=new Query();
		int rowSize=10;
		int skip=(rowSize*page)-rowSize;
		query.skip(skip).limit(rowSize);//페이지 구분
		query.with(new Sort(Sort.Direction.DESC,"no"));//정렬: ORDER BY no DESC
		//List<BoardVO>
		list=mt.find(query, BoardVO.class, "board");
		//list=SelectList() => NoSQL
		return list;
	}
	public int baordTotalPage()
	{
		int total=0;
		Query query=new Query();
		int count=(int)mt.count(query, "board");//SELECT COUNT(*) FROM board
		total=(int)(Math.ceil(count/10.0));
		return total;
	}
	
	public void boardInsert(BoardVO vo)
	{
		Query query=new Query();
		query.with(new Sort(Sort.Direction.DESC,"no"));
		BoardVO rvo=mt.findOne(query, BoardVO.class,"board");
		vo.setNo(rvo.getNo()+1);
		vo.setRegdate(new SimpleDateFormat("yyyy-MM-dd").format(new Date()));//sysdate
		vo.setHit(0);
		mt.insert(vo,"board");
	}
}
