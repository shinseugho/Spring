package com.sist.myapp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import com.sist.dao.*;

@RestController
public class BoardRestController {
/*
 * controller는 jsp/do가 넘어가지만, 
 * RestController는 script파일/json도 넘어갈수 있다.
 */
	@Autowired
	private BoardDAO dao;
	
	@PostMapping("board/update_ok.do")
	public String board_update_ok(BoardVO vo)
	{
		String result="";
		boolean bCheck=dao.boardUpdate(vo);
		if(bCheck==true)
		{
			result="<script>location.href=\"detail.do?no="+vo.getNo()+"\"</script>";
		}
		else
		{
			result="<script>alert(\"Password Fail!!\");history.back();</script>";
		}
		return result;
	}
	
	@PostMapping("board/delete_ok.do")
	public String board_delete_ok(int no, String pwd)
	{
		String result="";
		boolean bCheck=dao.boardDelete(no, pwd);
		if(bCheck==true)
		{
			result="<script>location.href=\"list.do\"</script>";
		}
		else
		{
			result="<script>alert(\"Password Fail!!\");history.back();</script>";
		}
		return result;
	}
}
