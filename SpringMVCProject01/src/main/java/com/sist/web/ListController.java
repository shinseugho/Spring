package com.sist.web;

import javax.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ListController {

	@RequestMapping("main/list.do")
	public String main_list(HttpServletRequest request)
	{
		request.setAttribute("msg", "Hello Spring!!");
		return "list";
	}
	
	/*
	 * public class Model
	 * {
	 * 		public void addAttribute(String Key, Object obj)
	 * 		{
	 * 			request.setAttribute(key,obj);
	 *		} 
	 * }
	 */
	@RequestMapping("main/list2.do")
	public String main_list2(Model model)
	{
		//model�� jsp�� �߰��� �����͸� ����
		model.addAttribute("msg","Hello Spring~~");
		return "list2";
	}
	
	@GetMapping("/main/input.do")
	public String main_input()
	{
		return "input";
	}

	/*	
	 * ���� ���
	 */
	@PostMapping("/main/output.do")
	public String main_output(HttpServletRequest request)
	{
		try
		{
			request.setCharacterEncoding("UTF-8");
		}catch(Exception ex){}
		
		String name=request.getParameter("name");
		String sex=request.getParameter("sex");
		String addr=request.getParameter("addr");
		String tel=request.getParameter("tel");
		String content=request.getParameter("content");
		
		MemberVO vo=new MemberVO();
		vo.setName(name);
		vo.setSex(sex);
		vo.setAddr(addr);
		vo.setTel(tel);
		vo.setContent(content);
		
		request.setAttribute("vo", vo);
		
		return "output";
	}
	
	/*
	 * Spring ���: request�� ��������ʴ´�.
	 * 
	 * list.do?p=2
	 *        ===
	 * board_list(Model model, int p)
	 *                            ===
	 * find.do?title=��ȭ
	 * movie_find(Model model, @RequestParam("title") String title)
	 * 
	 * 1. VO�� INPUT-name�� �����ؾ��Ѵ�.
	 * 2. ����===�κ��� �����ؾ��Ѵ�.
	 */
	@PostMapping("main/output2.do")
	public String main_output2(Model model,MemberVO vo)
	{
		model.addAttribute("vo",vo);
		return "output";
	}
}
