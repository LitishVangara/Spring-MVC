package org.jsp.springMVC.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.jsp.springMVC.entity.Student;
import org.springframework.jdbc.core.RowMapper;

public class StudentRowMapperDAOImp implements RowMapper<Student>
{
	@Override
	public Student mapRow(ResultSet rs, int rowNum) throws SQLException 
	{
		Student student = new Student();
		student.setRollno(rs.getInt("RollNo"));
		student.setName(rs.getString("StudentName"));
		student.setPercentage(rs.getDouble("Percentage"));
		student.setStream(rs.getString("Stream"));
		return student;
	}
}
