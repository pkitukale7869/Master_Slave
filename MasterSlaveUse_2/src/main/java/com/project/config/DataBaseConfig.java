package com.project.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import org.springframework.jdbc.datasource.DriverManagerDataSource;

import javax.sql.DataSource;

@Configuration
public class DataBaseConfig {

	@Bean(name = "master1")
	public DataSource dataSource1() {
		DriverManagerDataSource dataSource = new DriverManagerDataSource();
		dataSource.setDriverClassName("com.mysql.jdbc.Driver");
		dataSource.setUrl("jdbc:mysql://localhost:3306/employee_details_builder");
		dataSource.setUsername("root");
		dataSource.setPassword("Noida@1999");
		return dataSource;
	}

	@Bean(name = "slave1")
	public DataSource dataSource2() {
		DriverManagerDataSource dataSource = new DriverManagerDataSource();
		dataSource.setDriverClassName("com.mysql.jdbc.Driver");
		dataSource.setUrl("jdbc:mysql://localhost:3306/employee_details_builder");
		dataSource.setUsername("root");
		dataSource.setPassword("Noida@1999");
		return dataSource;
	}

}
