package com.sist.web;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import com.sist.dao.*;

@Controller
public class MainController {
	
	@Autowired
	private MusicDAO dao;
	
	@Autowired
	private ReplyDAO rDao;
	
    @RequestMapping("main/list.do")
    public String main_list()
    {
    	return "main/list";
    }
    
    @RequestMapping("main/detail.do")
    public String main_detail(int mno,Model model)
    {
    	model.addAttribute("mno",mno);
    	
    	List<ReplyVO> rList=rDao.replyListData(mno);
    	model.addAttribute("rList",rList);
    	
    	return "main/detail";
    }
    
    @GetMapping("main/login.do")
    public String main_login()
    {
    	return "main/login";
    }
    
    @PostMapping("main/login_ok.do")
    public String main_login_ok(String id,String pwd,Model model,HttpSession session)
    {
    	String result="";
  
    	int count=dao.idCount(id);
    	if(count==0)
    	{
    		result="NOID";
    	}
    	else
    	{
    		String db_pwd=dao.memberGetPassword(id);
    		if(db_pwd.equals(pwd))
    		{
    			result="OK";
    			session.setAttribute("id", id);
    		}
    		else
    		{
    			result="NOPWD";
    		}
    	}
    	model.addAttribute("result",result);		
    	return "main/login_ok";
    }
    
    @RequestMapping("main/logout.do")
    public String main_logout(HttpSession session)
    {
    	session.invalidate();
    	return "redirect:list.do";
    }
    
    @RequestMapping("main/reply_insert.do")
    public String reply_insert(ReplyVO vo,HttpSession session)
    {
    	String id=(String)session.getAttribute("id");
    	vo.setId(id);
    	rDao.replyInsert(vo);
    	return "redirect:detail.do?mno="+vo.getMno();
    }
    
    @RequestMapping("main/reply_reply_insert.do")
    public String reply_reply_insert(int pno, int mno, String msg, HttpSession session)
    {
    	ReplyVO vo=new ReplyVO();
    	String id=(String)session.getAttribute("id");
    	vo.setMno(mno);
    	vo.setMsg(msg);
    	vo.setId(id);
    	rDao.replyReplyInsert(pno, vo);
    	
    	return "redirect:detail.do?mno="+mno;
    }
    
    
    @RequestMapping("main/reply_update.do")
    public String reply_update(ReplyVO vo)
    {
    	rDao.replyUpdate(vo);
    	return "redirect:detail.do?mno="+vo.getMno();
    }
    
    @RequestMapping("main/reply_delete.do")
    public String reply_delete(int no,int mno)
    {
    	rDao.replyDelete(no);
    	return "redirect:detail.do?mno="+mno;
    }
    
}
