package org.jsp.springMVC.dao;

import org.jsp.springMVC.entity.UserDetails;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

@Component
public class UserDetailsDAOImp implements UserDetailsDAO
{
	@Autowired
	private JdbcTemplate jdbcTemplate3;
	public int insert(UserDetails userDetails) 
	{
		String insert2 = "insert into userdetails values(?,?,?,?,?)";
		int record2 = jdbcTemplate3.update(insert2, userDetails.getFirstName(), userDetails.getLastName(), userDetails.getEmail(), userDetails.getMobileNumber(), userDetails.getPassword());
		return record2;
	}
	public UserDetails displayOperation(int mobileNumber) 
	{	
		String display2 = "select * from userdetails where mobilenumber = ?";
		RowMapper<UserDetails> rm = new UserDetailsRowMapperDAOImp();
		try 
		{
			UserDetails u1 = jdbcTemplate3.queryForObject(display2, rm, mobileNumber);
			return u1;
		} 
		catch (Exception e) 
		{
			return null;
		}
		
	}
	public void delete(UserDetails userDetails) 
	{
		String delete2 = "delete from userdetails where mobilenumber = ?";
		jdbcTemplate3.update(delete2, userDetails.getMobileNumber());
	}
}
