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
		//model은 jsp에 추가된 데이터만 전송
		model.addAttribute("msg","Hello Spring~~");
		return "list2";
	}
	
	@GetMapping("/main/input.do")
	public String main_input()
	{
		return "input";
	}

	/*	
	 * 기존 방식
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
	 * Spring 방식: request를 사용하지않는다.
	 * 
	 * list.do?p=2
	 *        ===
	 * board_list(Model model, int p)
	 *                            ===
	 * find.do?title=영화
	 * movie_find(Model model, @RequestParam("title") String title)
	 * 
	 * 1. VO와 INPUT-name이 동일해야한다.
	 * 2. 위의===부분이 동일해야한다.
	 */
	@PostMapping("main/output2.do")
	public String main_output2(Model model,MemberVO vo)
	{
		model.addAttribute("vo",vo);
		return "output";
	}
}
