package org.jsp.springMVC.entity;

import org.springframework.stereotype.Component;

@Component
public class Student 
{
	private int rollno;
	private String name;
	private double percentage;
	private String stream;
	public int getRollno() 
	{
		return rollno;
	}
	public void setRollno(int rollno) 
	{
		this.rollno = rollno;
	}
	public String getName() 
	{
		return name;
	}
	public void setName(String name) 
	{
		this.name = name;
	}
	public double getPercentage() 
	{
		return percentage;
	}
	public void setPercentage(double percentage) 
	{
		this.percentage = percentage;
	}
	public String getStream() 
	{
		return stream;
	}
	public void setStream(String stream) 
	{
		this.stream = stream;
	}
	@Override
	public String toString() 
	{
		return "Student [rollno=" + rollno + ", name=" + name + ", percentage=" + percentage + ", stream=" + stream
				+ "]   Registration Successfull.";
	}
}
