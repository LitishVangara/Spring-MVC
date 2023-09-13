package org.jsp.springMVC.dao;

import org.jsp.springMVC.entity.Employee;

public interface EmployeeDAO 
{
	int insert(Employee employee);
	Employee displayOperation(int empId);
	void delete(Employee employee);
}
