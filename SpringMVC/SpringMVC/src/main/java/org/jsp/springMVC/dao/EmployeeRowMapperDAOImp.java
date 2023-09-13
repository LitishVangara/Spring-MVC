package org.jsp.springMVC.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.jsp.springMVC.entity.Employee;
import org.springframework.jdbc.core.RowMapper;

public class EmployeeRowMapperDAOImp implements RowMapper<Employee>
{
	@Override
	public Employee mapRow(ResultSet rs, int rowNum) throws SQLException 
	{
		Employee employee = new Employee();
		employee.setEmpid(rs.getInt("eid"));
		employee.setEmpname(rs.getString("ename"));
		employee.setEmpsalary(rs.getDouble("esalary"));
		employee.setEmpdept(rs.getInt("deptNo"));
		return employee;
	}

}
