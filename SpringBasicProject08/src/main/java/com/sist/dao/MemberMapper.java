package com.sist.dao;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.SelectKey;
import java.util.*;

public interface MemberMapper {

	@SelectKey(keyProperty="no",resultType=int.class,before=true,statement="SELECT NVL(MAX(no)+1,1) as no FROM spring_member")
	
	@Insert("INSERT INTO spring_member VALUES("
			+"#{no},#{name},#{sex},#{addr},#{tel})"
			)
	//resultType: ������, parameterType: �Ű�����, id: �޼ҵ��
	public void memberInsert(MemberVO vo);
	
	/*
	 *  <select id="memberAllData" resultType="MemberVo">
	 *  	SELECT * FROM spring_member
	 *  </select>
	 */
	@Select("SELECT * FROM spring_member")
	public List<MemberVO> memberAllData();
	
	@Select("SELECT * FROM spring_member"
			+ "WHERE no=#{no}")
	public MemberVO memberDetailData(int no);
	
}
