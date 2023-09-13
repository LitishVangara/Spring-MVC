package org.jsp.springMVC.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.jsp.springMVC.entity.UserDetails;
import org.springframework.jdbc.core.RowMapper;

public class UserDetailsRowMapperDAOImp implements RowMapper<UserDetails>
{
	@Override
	public UserDetails mapRow(ResultSet rs, int rowNum) throws SQLException 
	{
		UserDetails userDetails = new UserDetails();
		userDetails.setFirstName(rs.getString("firstname"));
		userDetails.setLastName(rs.getString("lastname"));
		userDetails.setEmail(rs.getString("email"));
		userDetails.setMobileNumber(rs.getInt("mobilenumber"));
		userDetails.setPassword(rs.getString("password"));
		return userDetails;
	}
}
