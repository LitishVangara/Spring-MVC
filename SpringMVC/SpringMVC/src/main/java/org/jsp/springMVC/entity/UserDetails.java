package org.jsp.springMVC.entity;

import org.springframework.stereotype.Component;

@Component
public class UserDetails 
{
	private String firstName;
	private String lastName;
	private String email;
	private int mobileNumber;
	private String password;
	public String getFirstName() 
	{
		return firstName;
	}
	public void setFirstName(String firstName) 
	{
		this.firstName = firstName;
	}
	public String getLastName() 
	{
		return lastName;
	}
	public void setLastName(String lastName) 
	{
		this.lastName = lastName;
	}
	public String getEmail() 
	{
		return email;
	}
	public void setEmail(String email) 
	{
		this.email = email;
	}
	public int getMobileNumber() 
	{
		return mobileNumber;
	}
	public void setMobileNumber(int mobileNumber) 
	{
		this.mobileNumber = mobileNumber;
	}
	public String getPassword() 
	{
		return password;
	}
	public void setPassword(String password) 
	{
		this.password = password;
	}
	@Override
	public String toString() 
	{
		return "UserDetails [firstName=" + firstName + ", lastName=" + lastName + ", email=" + email + ", mobileNumber="
				+ mobileNumber + ", password=" + password + "]";
	}
}
