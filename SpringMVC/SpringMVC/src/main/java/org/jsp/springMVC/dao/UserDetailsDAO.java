package org.jsp.springMVC.dao;

import org.jsp.springMVC.entity.UserDetails;

public interface UserDetailsDAO 
{
	int insert(UserDetails userDetails);
	UserDetails displayOperation(int mobileNumber);
	void delete(UserDetails userDetails);
}
