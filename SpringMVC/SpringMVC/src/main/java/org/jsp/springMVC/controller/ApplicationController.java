package org.jsp.springMVC.controller;

import java.text.SimpleDateFormat;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Controller;

import org.springframework.ui.Model;

import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import org.springframework.web.servlet.ModelAndView;

import org.jsp.springMVC.entity.Employee;
import org.jsp.springMVC.entity.Student;
import org.jsp.springMVC.entity.UserDetails;

import org.jsp.springMVC.dao.StudentDAO;
import org.jsp.springMVC.dao.UserDetailsDAO;
import org.jsp.springMVC.dao.EmployeeDAO;

//This Class will manage entire Application Request
@Controller
public class ApplicationController 
{
	//Main Page
	@RequestMapping("/mainPage")
	public String mainPage()
	{
		return "LitishDataBase";
	}
	
	
	
	//Index Page
	//@RequestMapping("/")
	//public String indexPage() 
	//{
	//	return "index";
	//}
	
	
	
	@Autowired
	private StudentDAO studentDAO;
	
	//To map Method With URl
	//Handler Mapping
	@RequestMapping(path = "/studentRegister", method = RequestMethod.POST)
	public String displayStudentRegistrationFile()
	{
		return "Student";
	}
	
	//To Perform Registration
	//public String displayStudentRegistrationDetails(@RequestParam("rollno") int roll, @RequestParam("name") String name, @RequestParam("percentage") double percent, @RequestParam("stream") String stream) { }
	//If you are using post method in jsp then this method syntax is used method = RequestMethod.POST and path =  "/studentDetails"
		//If you are using get method in jsp then this method syntax is used method = RequestMethod.GET and path =  "/studentDetails"
	@RequestMapping(path = "/studentDetails", method = RequestMethod.POST)
	@ResponseBody
	public String displayStudentRegistrationDetails(@ModelAttribute Student s1)
	{
		//Fetch Data from Student Object
		int roll = s1.getRollno();
		String name = s1.getName();
		double percent = s1.getPercentage();
		String stream = s1.getStream();
		System.out.println("Student [rollno = " + roll + ", name = " + name + ", percentage = " + percent + ", stream = " + stream + "]");
		System.out.println(s1.toString());
		studentDAO.insert(s1);   //int record = studentDAO.insert(s1);
		return s1.toString();    //return "Student [rollno=" + rollno + ", name=" + name + ", percentage=" + percentage + ", stream=" + stream + "]";    //you can use return "";     //return  s1.toString();
	}
	
	@RequestMapping(path = "/studentGetDetails", method = RequestMethod.POST)
	public ModelAndView displayStudentDetails(@RequestParam("rollno") int roll, @RequestParam("name") String name, @RequestParam("percentage") double percent, @RequestParam("stream") String stream)
	{
		Student student = new Student();
		student.setRollno(roll);
		student.setName(name);
		student.setPercentage(percent);
		student.setStream(stream);
		studentDAO.insert(student);
		System.out.println(student);
		ModelAndView mv = new ModelAndView();
		//To Transfer Data From Controller to View
		mv.addObject("studentObject1", student);
		//To Provide JSP File Name or view Name
		mv.setViewName("StuModel");
		return mv;
	}
	
	@RequestMapping(path = "/studentModelGetDetails", method = RequestMethod.POST)
	public String displayStudentRegistrationDetailsModel(@ModelAttribute Student s1, Model model1)
	{
		//Fetch Data from Student Object
		int roll = s1.getRollno();
		String name = s1.getName();
		double percent = s1.getPercentage();
		String stream = s1.getStream();
		System.out.println("Student [rollno = " + roll + ", name = " + name + ", percentage = " + percent + ", stream = " + stream + "]");
		System.out.println(s1.toString());
		studentDAO.insert(s1);
		model1.addAttribute("roll", roll);
		model1.addAttribute("name", name);
		model1.addAttribute("percentage", percent);
		model1.addAttribute("stream", stream);
		return "StudentModel";
	}
	
	@RequestMapping(path = "/studentLogin", method = RequestMethod.POST)
	public String displayStudentLoginFile()
	{
		return "StudentLogin";
	}
	
	@RequestMapping(path = "getStudentDetails", method = RequestMethod.POST)
	public ModelAndView getStudentDetailsUsingRollNumber(@RequestParam("rollNumber") int rollNumber, Model model2)
	{
		System.out.println("Student Roll Number : "+rollNumber);
		Student student3 = studentDAO.displayOperation(rollNumber);
		//model2.addAttribute("studentObject", student3);
		//return "StuLoginModel";
		ModelAndView mv = new ModelAndView();
		//To Transfer Data From Controller to View
		mv.addObject("studentObject2", student3);
		//To Provide JSP File Name or view Name
		mv.setViewName("StuLoginModel");
		return mv;
	}
	
	@RequestMapping(path = "/deleteStudent", method = RequestMethod.POST)
	public String displayStudentDeletionFile()
	{
		return "StudentDelete";
	}
	
	@RequestMapping(path = "getStudentDeleteDetails", method = RequestMethod.POST)
	public ModelAndView getStudentDeleteDetailsUsingRollNumber(@RequestParam("rollNumber") int rollNumber, Model model3)
	{
		System.out.println("Student Roll Number : "+rollNumber);
		Student student4 = studentDAO.displayOperation(rollNumber);
		Student student5 = student4;
		//model3.addAttribute("studentObject", student4);
		//return "StuDeleteModel";
		ModelAndView mv = new ModelAndView();
		//To Transfer Data From Controller to View
		mv.addObject("studentObject3", student5);
		//To Provide JSP File Name or view Name
		studentDAO.delete(student4);
		mv.setViewName("StuDeleteModel");
		return mv;
	}
	
	
	
	
	@Autowired
	private EmployeeDAO employeeDAO;
	
	@RequestMapping(path = "/employeeRegister", method = RequestMethod.POST)
	public String displayEmployeeRegistrationFile()
	{
		return "Employee";
	}
	
	//To Perform Registration
	//public String displayEmployeeRegistrationDetails(@RequestParam("empid") int empId, @RequestParam("empname") String empName, @RequestParam("empsalary") double empSalary, @RequestParam("empdept") int empDept) { }
	//If you are using post method in jsp then this method syntax is used method = RequestMethod.POST and path =  "/employeeDetails"
	//If you are using get method in jsp then this method syntax is used method = RequestMethod.GET and path =  "/employeeDetails"
	@RequestMapping(path = "/employeeDetails", method = RequestMethod.POST)
	@ResponseBody
	public String displayEmployeeRegistrationDetails(@ModelAttribute Employee e1)
	{
		//Fetch Data from Employee Object
		int id = e1.getEmpid();
		String name = e1.getEmpname();
		double sal = e1.getEmpsalary();
		int dept = e1.getEmpdept();
		System.out.println("Employee [empid = " + id + ", empname = " + name + ", empsalary = " + sal +  ", empdept = " + dept +  "]");
		System.out.println(e1.toString());
		employeeDAO.insert(e1);    //int record = employeeDAO.insert(e1);
		return e1.toString();      //return "Employee [empid=" + empid + ", empname=" + empname + ", empsalary=" + empsalary + ", empdept=" + empdept + "]";     //you can use return "";     //return  e1.toString();
	}
	
	@RequestMapping(path = "/employeeGetDetails", method = RequestMethod.POST)
	public ModelAndView displayEmployeeDetails(@RequestParam("empid") int empId, @RequestParam("empname") String empName, @RequestParam("empsalary") double empSalary, @RequestParam("empdept") int empDept, Model model4 )
	{
		Employee employee = new Employee();
		employee.setEmpid(empId);
		employee.setEmpname(empName);
		employee.setEmpsalary(empSalary);
		employee.setEmpdept(empDept);
		employeeDAO.insert(employee);
		System.out.println(employee);
		model4.addAttribute("id", empId);
		model4.addAttribute("name", empName);
		model4.addAttribute("sal", empSalary);
		model4.addAttribute("dept", empDept);
		ModelAndView mv = new ModelAndView();
		//To Transfer Data From Controller to View
		mv.addObject("employeeObject1", employee);
		//To Provide JSP File Name or view Name
		mv.setViewName("EmpModel");
		return mv;
	}
	
	@RequestMapping(path = "/employeeLogin", method = RequestMethod.POST)
	public String displayEmployeeLoginFile()
	{
		return "EmployeeLogin";
	}
	
	@RequestMapping(path = "getEmployeeDetails", method = RequestMethod.POST)
	public ModelAndView getEmployeeDetailsUsingEmployeeID(@RequestParam("employeeId") int employeeID, Model model5)
	{
		System.out.println("Employee Id : "+employeeID);
		Employee employee3 = employeeDAO.displayOperation(employeeID);
		//model5.addAttribute("employeeObject", employee3);
		//return "EmpLoginModel";
		ModelAndView mv = new ModelAndView();
		//To Transfer Data From Controller to View
		mv.addObject("employeeObject2", employee3);
		//To Provide JSP File Name or view Name
		mv.setViewName("EmpLoginModel");
		return mv;
	}
	
	@RequestMapping(path = "/deleteEmployee", method = RequestMethod.POST)
	public String displayEmployeeDeletionFile()
	{
		return "EmployeeDelete";
	}
	
	@RequestMapping(path = "getEmployeeDeleteDetails", method = RequestMethod.POST)
	public ModelAndView getEmployeeDeleteDetailsUsingEmployeeID(@RequestParam("employeeId") int employeeID, Model model6)
	{
		System.out.println("Employee Id : "+employeeID);
		Employee employee4 = employeeDAO.displayOperation(employeeID);
		Employee employee5 = employee4;
		//model6.addAttribute("employeeObject", employee4);
		//return "EmpLoginModel";
		ModelAndView mv = new ModelAndView();
		//To Transfer Data From Controller to View
		mv.addObject("employeeObject3", employee5);
		//To Provide JSP File Name or view Name
		mv.setViewName("EmpDeleteModel");
		employeeDAO.delete(employee4);
		return mv;
	}
	
	
	
	@Autowired
	private UserDetailsDAO userDetailsDAO;
	
	//To map Method With URl
	//Handler Mapping
	@RequestMapping(path = "/userDetailsRegister", method = RequestMethod.POST)
	public String displayUserDetailsRegistrationFile()
	{
		return "UserDetails";
	}
	
	//To Perform Registration
	//public String displayStudentRegistrationDetails(@RequestParam("rollno") int roll, @RequestParam("name") String name, @RequestParam("percentage") double percent, @RequestParam("stream") String stream) { }
	//If you are using post method in jsp then this method syntax is used method = RequestMethod.POST and path =  "/userDetails"
	//If you are using get method in jsp then this method syntax is used method = RequestMethod.GET and path =  "/userDetails"
	@RequestMapping(path = "/userDetails", method = RequestMethod.POST)
	@ResponseBody
	public String displayUserDetailsRegistrationDetails(@ModelAttribute UserDetails userDetails)
	{
		//Fetch Data from Student Object
		String firstName = userDetails.getFirstName();
		String lastName = userDetails.getLastName();
		String email = userDetails.getEmail();
		int mobileNumber = userDetails.getMobileNumber();
		String password = userDetails.getPassword();
		System.out.println("UserDetails [firstName = " + firstName + ", lastName = " + lastName + ", email = " + email + ", mobileNumber = " + mobileNumber + ", password=" + password + "]");
		System.out.println(userDetails.toString());
		userDetailsDAO.insert(userDetails);     //int record = userDetailsDAO.insert(userDetails);
		return userDetails.toString();          //return "UserDetails [firstName = " + firstName + ", lastName = " + lastName + ", email = " + email + ", mobileNumber = " + mobileNumber + ", password=" + password + "]";     //you can use return "";     //return userDetails.toString();
	}
	
	@RequestMapping(path = "/userDetailsGetDetails", method = RequestMethod.POST)
	public ModelAndView displayUserDetails(@RequestParam("firstName") String firstName, @RequestParam("lastName") String lastName, @RequestParam("email") String email, @RequestParam("mobileNumber") int number, @RequestParam("password") String password, Model model7)
	{
		UserDetails userDetails = new UserDetails();
		userDetails.setFirstName(firstName);
		userDetails.setLastName(lastName);
		userDetails.setEmail(email);
		userDetails.setMobileNumber(number);
		userDetails.setPassword(password);
		userDetailsDAO.insert(userDetails);
		System.out.println(userDetails);
		model7.addAttribute("fn", firstName);
		model7.addAttribute("ln", lastName);
		model7.addAttribute("mail", email);
		model7.addAttribute("mn", number);
		model7.addAttribute("pass", password);
		ModelAndView mv = new ModelAndView();
		//To Transfer Data From Controller to View
		mv.addObject("userDetailsObject1", userDetails);
		//To Provide JSP File Name or view Name
		mv.setViewName("UserDetaModel");
		return mv;
	}
	
	@RequestMapping(path = "/userDetailsLogin", method = RequestMethod.POST)
	public String displayUserDetailsLoginFile()
	{
		return "UserDetailsLogin";
	}
	
	@RequestMapping(path = "getUserDetails", method = RequestMethod.POST)
	public ModelAndView getUserDetailsUsingMobileNumber(@RequestParam("mobileNumber") int mobileNumber, Model model8)
	{
		System.out.println("Mobile Number : "+mobileNumber);
		UserDetails userDetails3 = userDetailsDAO.displayOperation(mobileNumber);
		//model8.addAttribute("userDetailsObject", userDetails3);
		//return "EmpLoginModel";
		ModelAndView mv = new ModelAndView();
		//To Transfer Data From Controller to View
		mv.addObject("userDetailsObject2", userDetails3);
		//To Provide JSP File Name or view Name
		mv.setViewName("UserDetaLoginModel");
		return mv;
	}
	
	@RequestMapping(path = "/deleteUserDetails", method = RequestMethod.POST)
	public String displayUserDetailsDeletionFile()
	{
		return "UserDetailsDelete";
	}
	
	@RequestMapping(path = "getUserDeleteDetails", method = RequestMethod.POST)
	public ModelAndView getUserDeleteDetailsUsingMobileNumber(@RequestParam("mobileNumber") int mobileNumber, Model model9)
	{
		System.out.println("Mobile Number : "+mobileNumber);
		UserDetails userDetails4 = userDetailsDAO.displayOperation(mobileNumber);
		UserDetails userDetails5 = userDetails4;
		//model9.addAttribute("userDetailsObject", userDetails4);
		//return "EmpLoginModel";
		ModelAndView mv = new ModelAndView();
		//To Transfer Data From Controller to View
		mv.addObject("userDetailsObject3", userDetails5);
		//To Provide JSP File Name or view Name
		mv.setViewName("UserDetaDeleteModel");
		userDetailsDAO.delete(userDetails4);
		return mv;
	}
	
	
	
	@RequestMapping(path = "/date", method = RequestMethod.POST)
	public String displayDateFile()
	{
		return "Date";
	}
	
	@RequestMapping(path = "/displayDate", method = RequestMethod.POST)
	@ResponseBody
	public String displayDate(@RequestParam("userName") String userName)
	{
		Date date = new Date();
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd/MMM/yyyy");
		SimpleDateFormat simpleTimeFormat = new SimpleDateFormat("hh:mm:ss");
		String currentDate = simpleDateFormat.format(date);
		String currentTime = simpleTimeFormat.format(date);
		System.out.println("Date Method Executed");
		return "<center><h1>Username : "+userName+", Date : "+currentDate+" and Time : "+currentTime+"</h1></center>";
	}
	
	
	
	//To pring the Message On the Browser
	@RequestMapping(path = "/printMessage", method = RequestMethod.POST)
	@ResponseBody
	public String printMessage()
	{
		String message = "<center><h1>PrintMessage Method Executed...</h1></center>";
		return message;
	}
	
	
	
	@RequestMapping(path = "/ourDetails", method = RequestMethod.POST)
	public String displayUserDetailsFile(Model model)
	{
		//To Transfer Data From Controller To View
		model.addAttribute("pageNo", 106);
		Student s3 = new Student();
		s3.setRollno(1001);
		s3.setName("LITISH");
		s3.setPercentage(80);
		s3.setStream("BZCS");
		model.addAttribute("object", s3);
		//Only return JSP file Without Extension
		//If you are using InternalResourceViewResolver Class, then you need to return without Extension - return "UserDetails";
		//If you are not using InternalResourceViewResolver Class, then you need to return with Extension - return "UserDetails.jsp";
		//Executed File without File Extension
		return "OurDetails";
	}
}
