package org.jsp.springMVC.dao;

import org.jsp.springMVC.entity.Student;

public interface StudentDAO 
{
	int insert(Student student);
	Student displayOperation(int rollNo);
	void delete(Student student);
}
