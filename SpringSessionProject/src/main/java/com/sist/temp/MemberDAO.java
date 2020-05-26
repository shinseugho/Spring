package com.sist.temp;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class MemberDAO {

	private Connection conn;
	private PreparedStatement ps;
	private String URL="jdbc:oracle:thin:@localhost:1521:XE";
	
	public MemberDAO()
	{
		try
		{
			Class.forName("oracle.jdbc.driver.OracleDriver");
		}catch(Exception ex){}
	}
	
	public void getConection()
	{
		try
		{
			conn=DriverManager.getConnection(URL,"hr","happy");
		}catch(Exception ex){}
	}
	
	public void disConection()
	{
		try
		{
			if(ps!=null) ps.close();
			if(conn!=null) conn.close();
		}catch(Exception ex){}
	}
	
	public List<MemberVO> memberListData()
	{
		List<MemberVO> list=new ArrayList<MemberVO>();
		try
		{
			getConection();
			String sql="SELECT * FROM trans_member";
			ps=conn.prepareStatement(sql);
			ResultSet rs=ps.executeQuery();
			while(rs.next())
			{
				MemberVO vo=new MemberVO();
				vo.setNo(rs.getInt("no"));	
				vo.setName(rs.getString("name"));
				vo.setSex(rs.getString("sex"));	
				list.add(vo);
			}
			rs.close();
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
		}
		finally 
		{
			disConection();
		}
		return list;
	}
	
	public void memberInsert(MemberVO vo1, MemberVO vo2)
	{
		try
		{
			getConection();
			String sql="INSERT INTO trans_member VALUES(?,?,?)";
			ps=conn.prepareStatement(sql);
			ps.setInt(1, vo1.getNo());
			ps.setString(2, vo1.getName());
			ps.setString(3, vo1.getSex());
			ps.executeUpdate();
			
			sql="INSERT INTO trans_member VALUES(?,?,?)";
			ps=conn.prepareStatement(sql);
			ps.setInt(1, vo2.getNo());
			ps.setString(2, vo2.getName());
			ps.setString(3, vo2.getSex());
			ps.executeUpdate();
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
		}
		finally
		{
			disConection();
		}
	}
}
