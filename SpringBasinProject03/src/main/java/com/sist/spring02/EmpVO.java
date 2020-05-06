package com.sist.spring02;

import java.util.*;

//Spring 관리 클래스가 아니다: 일반 데이터형(int ...)으로 생각하면 된다.
public class EmpVO {
//Bean클래스가 되기위해선 기능(insert, delete등...)이 있어야한다.
/*
 * 등록시 3가지 방법
 * 1. XML
 * 2. Annotation
 * 3. XML + Annotation => 현재 가장 많이 쓰인다.
 *  						XML: 라이브러리 등록(MyBatis, JDBC ...)
 *  						Annotation: 사용자정의 클래스
 */
	private int empno;
	private String ename;
	private String job;
	private int mgr;
	private Date hiredate;
	private int comm;
	private int sal;
	private int deptno;
	
	public int getEmpno() {
		return empno;
	}
	public void setEmpno(int empno) {
		this.empno = empno;
	}
	public String getEname() {
		return ename;
	}
	public void setEname(String ename) {
		this.ename = ename;
	}
	public String getJob() {
		return job;
	}
	public void setJob(String job) {
		this.job = job;
	}
	public int getMgr() {
		return mgr;
	}
	public void setMgr(int mgr) {
		this.mgr = mgr;
	}
	public Date getHiredate() {
		return hiredate;
	}
	public void setHiredate(Date hiredate) {
		this.hiredate = hiredate;
	}
	public int getComm() {
		return comm;
	}
	public void setComm(int comm) {
		this.comm = comm;
	}
	public int getSal() {
		return sal;
	}
	public void setSal(int sal) {
		this.sal = sal;
	}
	public int getDeptno() {
		return deptno;
	}
	public void setDeptno(int deptno) {
		this.deptno = deptno;
	}
	
	
}
