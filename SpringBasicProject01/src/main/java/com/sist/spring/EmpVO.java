package com.sist.spring;

import java.util.*;

//Spring ���� Ŭ������ �ƴϴ�: �Ϲ� ��������(int ...)���� �����ϸ� �ȴ�.
public class EmpVO {
//BeanŬ������ �Ǳ����ؼ� ���(insert, delete��...)�� �־���Ѵ�.
/*
 * ��Ͻ� 3���� ���
 * 1. XML
 * 2. Annotation
 * 3. XML + Annotation => ���� ���� ���� ���δ�.
 *  						XML: ���̺귯�� ���(MyBatis, JDBC ...)
 *  						Annotation: ��������� Ŭ����
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
