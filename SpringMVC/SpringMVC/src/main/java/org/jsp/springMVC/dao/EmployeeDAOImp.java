package org.jsp.springMVC.dao;

import org.jsp.springMVC.entity.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

@Component
public class EmployeeDAOImp implements EmployeeDAO
{
	@Autowired
	private JdbcTemplate jdbcTemplate1;
	public int insert(Employee employee) 
	{
		String insert = "insert into employee (eid,ename,esalary,deptNo) values(?,?,?,?)";
		int record = jdbcTemplate1.update(insert, employee.getEmpid(), employee.getEmpname(), employee.getEmpsalary(), employee.getEmpdept());
		return record;
	}
	public Employee displayOperation(int empId) 
	{
		String display = "select * from employee where eid = ?";
		RowMapper<Employee> rm = new EmployeeRowMapperDAOImp();
		try 
		{
			Employee e1 = jdbcTemplate1.queryForObject(display, rm, empId);
			return e1;
		} 
		catch (Exception e) 
		{
			return null;
		}
	}
	public void delete(Employee employee) 
	{
		String delete = "delete from employee where eid = ?";
		jdbcTemplate1.update(delete, employee.getEmpid());
	}
}
