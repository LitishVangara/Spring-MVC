package org.jsp.springMVC.entity;

import org.springframework.stereotype.Component;

@Component
public class Employee 
{
	private int empid;
	private String empname;
	private double empsalary;
	private int empdept;
	public int getEmpid() 
	{
		return empid;
	}
	public void setEmpid(int empid) 
	{
		this.empid = empid;
	}
	public String getEmpname() 
	{
		return empname;
	}
	public void setEmpname(String empname) 
	{
		this.empname = empname;
	}
	public double getEmpsalary() 
	{
		return empsalary;
	}
	public void setEmpsalary(double empsalary) 
	{
		this.empsalary = empsalary;
	}
	public int getEmpdept() 
	{
		return empdept;
	}
	public void setEmpdept(int empdept) 
	{
		this.empdept = empdept;
	}
	@Override
	public String toString() 
	{
		return "Employee [empid=" + empid + ", empname=" + empname + ", empsalary=" + empsalary + ", empdept=" + empdept
				+ "]   Registration Successfull.";
	}
}
