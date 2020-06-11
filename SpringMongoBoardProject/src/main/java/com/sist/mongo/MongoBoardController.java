package com.sist.mongo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.*;
import com.sist.dao.*;

@Controller
public class MongoBoardController {

	@Autowired
	private BoardDAO dao;
	
	@RequestMapping("board/list.do")
	public String board_list(String page,Model model)
	{
		if(page==null)
			page="1";
		int curpage=Integer.parseInt(page);
		List<BoardVO> list=dao.boardListData(curpage);
		int totalpage=dao.baordTotalPage();
		model.addAttribute("list",list);
		model.addAttribute("totalpage",totalpage);
		model.addAttribute("curpage",curpage);
		return "board/list";
	}
	
	//화면만 연결=> 화면띄우는 역활
	@RequestMapping("board/insert.do")
	public String board_insert()
	{
		return "board/insert";
	}
	
	@RequestMapping("board/insert_ok.do")
	public String board_insert_ok(BoardVO vo)
	{
		dao.boardInsert(vo);
		return "redirect:list.do";
	}
	
	@RequestMapping("board/detail.do")
	public String board_detail(int no,Model model)
	{
		BoardVO vo=dao.boardDetailData(no);
		model.addAttribute("vo",vo);
		return "board/detail";
	}
	
	@RequestMapping("board/update.do")
	public String board_update(int no,Model model)
	{
		BoardVO vo=dao.boardUpdateData(no);
		model.addAttribute("vo",vo);
		return "board/update";
	}
	
	@RequestMapping("board/update_ok.do")
	@ResponseBody
	public String board_update_ok(BoardVO vo)
	{
		String result="";
		
		boolean bCheck=dao.boardUpdate(vo);
		if(bCheck==true)
		{
			result="<script>location.href=\"detail.do?no="+vo.getNo()+"\";</script>";
		}
		else
		{
			result="<script>alert(\"비밀번호가 틀립니다!\");history.back();</script>";
		}
		return result;
		/*return "redirect:detail.do?no="+vo.getNo();*/
	}
	
	@RequestMapping("board/delete.do")
	public String board_delete(int no,Model model)
	{
		model.addAttribute("no",no);
		return "board/delete";
	}
	
	@RequestMapping("board/delete_ok.do")
	@ResponseBody
	public String board_delete_ok(int no,String pwd)
	{
		String result="";
		
		boolean bCheck=dao.boardDelete(no, pwd);
		if(bCheck==true)
		{
			result="OK";
		}
		else
		{
			result="NOPWD";
		}
		return result;
	}
}
