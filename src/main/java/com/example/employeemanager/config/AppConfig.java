package com.example.employeemanager.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.example.employeemanager.mapper.EmployeeMapper;

@Configuration
public class AppConfig {

	@Bean
	public EmployeeMapper employeeMapper() {
		return new EmployeeMapper();
	}
}
