package com.sist.dao;

import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class MemberDAO {

	/*
	 * Model 
	 * VO
	 * DAO
	 * Service
	 * Manager
	 * ========�� ������ļ� model
	 * 
	 * @Component:�Ϲ�
	 * @Repository:dao
	 * @Service
	 * @Controller:controller
	 * @RestController:controller
	 * 
	 * 
	 * 
	 * ��ü���� (LifeCycle)
	 * 1. �޸��Ҵ�: ��ϵ� ��� Ŭ����(Map�� ����)
	 * 	  c:<constructor-arg>
	 * 2. p: <property> Ȯ��(DI�� ���翩�� Ȯ��)
	 * 3. �����ϸ� setXxx()�޼ҵ忡 ����
	 * 4. �޼ҵ� DI�� �����ϴ� �� ���� Ȯ��(init-method)
	 * 5. �����ϸ� method ȣ��
	 * 6. ���α׷��Ӱ� �ʿ��� �޼ҵ� ȣ��(����� ���)
	 * 7. �޼ҵ� ���翩�� Ȯ��(destory-method)
	 * 8. ��ü�Ҹ�
	 */
	@Autowired
	private MemberMapper mapper;
	
	public List<MemberVO> memberAllData()
	{
		return mapper.memberAllData();
	}
	
	public MemberVO memberDetailData(int no)
	{
		return mapper.memberDetailData(no);
	}
	
	public void memberInsert(MemberVO vo)
	{
		mapper.memberInsert(vo);
	}
}
