package com.sist.manager;

import java.util.*;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.stereotype.Component;

import com.sist.dao.MovieDAO;
import com.sist.dao.MovieVO;
/*
  	<td class="title">
		<div class="tit3">
			<a href="/movie/bi/mi/basic.nhn?code=193804" title="프리즌 이스케이프">프리즌 이스케이프</a>
		</div>
	</td>
 */
public class MovieManager {

	public List<String> movieLinkData()
	{
		List<String> list=new ArrayList<String>();
		try
		{
			for(int i=1;i<=40;i++)
			{
				Document doc=Jsoup.connect("https://movie.naver.com/movie/sdb/rank/rmovie.nhn?sel=pnt&date=20200513&page="+i).get();
				Elements link=doc.select("td.title div.tit5 a");
				//System.out.println(link.text());
				for(int j=0;j<link.size();j++)
				{
					String strLink=link.get(j).attr("href");
					list.add("https://movie.naver.com"+strLink);
					//System.out.println(strLink);
				}
			}
			
		}catch(Exception ex){}	
		return list;
	}
	
	public void movieAllData()
	{
		try
		{
			MovieDAO dao=new MovieDAO();
			List<String> list=movieLinkData();
			int k=1;
			for(String url:list)
			{
				try
				{
					Document doc=Jsoup.connect(url).get();
					
					Element title=doc.selectFirst("div.mv_info h3.h_movie a");
					Element poster=doc.selectFirst("div.poster a img");
					Element genre=doc.selectFirst("dl.info_spec span a");
					Element grade=doc.select("dl.info_spec dd").get(3);
					Element director=doc.select("div.info_spec2 dd a").get(0);
					Element actor=doc.select("div.info_spec2 dl a").get(1);
					Element story=doc.selectFirst("div.video div.story_area p.con_tx");
					
					MovieVO vo=new MovieVO();
					
					vo.setMno(Integer.parseInt(url.substring(url.lastIndexOf("=")+1)));
					System.out.println("==========영화정보==========");
					System.out.println("k="+k);
					System.out.println(title.text());
					System.out.println(poster.attr("src"));
					System.out.println(genre.text());
					System.out.println(grade.text());
					System.out.println(director.text());
					System.out.println(actor.text());
					System.out.println(story.text());
					
					vo.setTitle(title.text());
					vo.setPoster(poster.attr("src"));
					vo.setGenre(genre.text());
					vo.setGrade(grade.text());
					vo.setDirector(director.text());
					vo.setActor(actor.text());
					vo.setStory(story.text());
					
					dao.movieInsert(vo);
					k++;
				}catch(Exception ex){ex.printStackTrace();}
			}
		}catch(Exception ex){}
	}
	
	public static void main(String[] args) {
		MovieManager m=new MovieManager();
		m.movieAllData();
	}
}
