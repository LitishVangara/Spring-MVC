package org.jsp.springMVC.dao;

import org.jsp.springMVC.entity.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

@Component
public class StudentDAOImp implements StudentDAO 
{
	@Autowired 
	private JdbcTemplate jdbcTemplate2;
	public int insert(Student student) 
	{
		String insert1 = "insert into student values(?,?,?,?)";
		int record1 = jdbcTemplate2.update(insert1, student.getRollno(), student.getName(), student.getPercentage(), student.getStream());
		return record1;
	}
	public Student displayOperation(int rollNo) 
	{
		String display1 = "select * from student where RollNo = ?";
		RowMapper<Student> rm = new StudentRowMapperDAOImp();
		try 
		{
			Student s1 = jdbcTemplate2.queryForObject(display1, rm, rollNo);
			return s1;
		} 
		catch (Exception e) 
		{
			return null;
		}
	}
	public void delete(Student student) 
	{
		String delete1 = "delete from student where RollNo = ?";
		jdbcTemplate2.update(delete1, student.getRollno());
	}	
}
