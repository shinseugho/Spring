package com.sist.dao;

import java.text.SimpleDateFormat;
import java.util.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.BasicQuery;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
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
		query.with(new Sort(Sort.Direction.ASC,"no"));//정렬: ORDER BY no DESC
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
	
	public BoardVO boardDetailData(int no)
	{
		BoardVO vo=new BoardVO();
		
		BasicQuery query=new BasicQuery("{no:"+no+"}");
		
		//조회수 증가
		Update update=new Update();
		//find=list, findOne=Object
		vo=mt.findOne(query, BoardVO.class,"board");
		update.set("hit", vo.getHit()+1);
		mt.updateFirst(query, update, "board");
		
		//조회수증가된 version 호출
		vo=mt.findOne(query, BoardVO.class,"board");
		
		return vo;
	}
	
	public BoardVO boardUpdateData(int no)
	{
		BoardVO vo=new BoardVO();
		
		BasicQuery query=new BasicQuery("{no:"+no+"}");
		
		//content update
		//update version call
		vo=mt.findOne(query, BoardVO.class,"board");
		
		return vo;
	}
	
	public boolean boardUpdate(BoardVO vo)
	{
		boolean bCheck=false;
		BasicQuery query=new BasicQuery("{no:"+vo.getNo()+"}");
		BoardVO dbvo=mt.findOne(query, BoardVO.class, "board");
		if(vo.getPwd().equals(dbvo.getPwd()))
		{
			bCheck=true;
			Update update=new Update();
			update.set("name", vo.getName());
			update.set("subject", vo.getSubject());
			update.set("content", vo.getContent());
			mt.updateFirst(query, update, "board");
		}
		return bCheck;
	}
	
	public boolean boardDelete(int no,String pwd)
	{
		boolean bCheck=false;
		BasicQuery query=new BasicQuery("{no:"+no+"}");
		BoardVO dbvo=mt.findOne(query, BoardVO.class, "board");
		if(pwd.equals(dbvo.getPwd()))
		{
			bCheck=true;
			mt.remove(query,"board");
		}
		return bCheck;
	}
}
