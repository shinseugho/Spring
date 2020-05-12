package com.sist.myapp2;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sist.mgr.MovieManager;

@RestController
public class MovieRestController {

	@Autowired
	private MovieManager mm;
	
	@RequestMapping("main/def.do")
	public String main_def(int no)
	{
		String url="";
		/*
		 * http://www.kobis.or.kr/kobis/business/main/main.do
		 * view-source:http://www.kobis.or.kr/kobis/business/main/main.do���� ������
		 */
		switch (no) {
		//���� �ڽ����ǽ�
		case 1:
			url="searchMainDailyBoxOffice.do";
			break;
		//�ǽð� ������
		case 2:
			url="searchMainRealTicket.do";
			break;
		//�¼�����������	
		case 3:
			url="searchMainDailySeatTicket.do";	
			break;
		//�¶��λ󿵰� ���� 	
		case 4:
			url="searchMainOnlineDailyBoxOffice.do";
			break;
		}
		String json=mm.movieGetJson(url);
		return json;
	}
}
