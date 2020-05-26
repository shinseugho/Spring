package com.sist.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;

@Repository
public class ReplyDAO {

	@Autowired
	private ReplyMapper mapper;
	
	public void replyInsert(ReplyVO vo)
	{
		mapper.replyInsert(vo);
	}
	
	public List<ReplyVO> replyListData(int mno)
	{
		return mapper.replyListData(mno);
	}
	
	@Transactional(propagation=Propagation.REQUIRED,rollbackFor=Exception.class)
	public void replyReplyInsert(int pno,ReplyVO vo)
	{
		ReplyVO pvo=mapper.replyParentInfoData(pno);
		mapper.replyGroupStepIncrement(pvo);
		vo.setGroup_id(pvo.getGroup_id());
		vo.setGroup_step(pvo.getGroup_step()+1);
		vo.setGroup_tab(pvo.getGroup_tab()+1);
		vo.setRoot(pno);
		mapper.replyReplyInsert(vo);
		mapper.replyDepthIncrement(pno);
	}
	
	public void replyUpdate(ReplyVO vo)
	{
		mapper.replyUpdate(vo);
	}
	
	@Transactional(propagation=Propagation.REQUIRED,rollbackFor=Exception.class)
	public void replyDelete(int no)
	{
		ReplyVO vo=mapper.replyInfoData(no);
		if(vo.getDepth()==0)
		{
			mapper.replyDelete(no);
		}
		else
		{
			ReplyVO rvo=new ReplyVO();
			rvo.setNo(no);
			rvo.setMsg("관리자가 삭제한 댓글입니다");
			mapper.replyMsgUpdate(rvo);
			System.out.println("1");
		}
		mapper.replyDepthDecrement(vo.getRoot());
	}
}
