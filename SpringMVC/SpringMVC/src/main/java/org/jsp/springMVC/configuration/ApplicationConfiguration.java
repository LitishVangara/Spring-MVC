/*package org.jsp.springMVC.configuration;

import org.springframework.beans.factory.annotation.Configurable;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;

import org.springframework.jdbc.core.JdbcTemplate;

import org.springframework.jdbc.datasource.DriverManagerDataSource;

import org.springframework.web.servlet.view.InternalResourceViewResolver;

//Using Annotations
@Configurable
@ComponentScan(basePackages = "org.jsp.springMVC")
public class ApplicationConfiguration 
{
	@Bean
	public DriverManagerDataSource getDataSource()
	{
		DriverManagerDataSource ds = new DriverManagerDataSource();
		ds.setDriverClassName("com.mysql.cj.jdbc.Driver");
		ds.setUrl("jdbc:mysql://localhost:3306/litishdatabase");
		ds.setUsername("root");
		ds.setPassword("Litish17@");
		return ds;
	}
	@Bean
	public JdbcTemplate getConnection()
	{
		JdbcTemplate jdbcTemplate = new JdbcTemplate(getDataSource());
		return jdbcTemplate;
	}
	@Bean
	public InternalResourceViewResolver getViewResolver()
	{
		InternalResourceViewResolver vr = new InternalResourceViewResolver();
		//vr.setPrefix("/views/");    //By Creating Folder Called views in WebApp and including all the JSP Files in that Folder
		vr.setPrefix("/");
		vr.setSuffix(".jsp");
		return vr;
	}
}*/
