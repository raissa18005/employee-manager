package com.example.employeemanager.mapper;

import org.springframework.stereotype.Component;

import com.example.employeemanager.model.Employee;
import com.example.employeemanager.model.EmployeeRequest;
import com.example.employeemanager.model.EmployeeResponse;

public class EmployeeMapper {

	public Employee mapRequestToEmployee(EmployeeRequest input) {

		return Employee.builder()
				.name(input.getName())
				.dateOfBirth(input.getDateOfBirth())
				.age(input.getAge())
				.email(input.getEmail())
				.jobTitle(input.getJobTitle())
				.build();
	}
	
	public EmployeeResponse mapEmployeeToResponse(Employee input) {
		return EmployeeResponse.builder()
				.id(input.getId())
				.name(input.getName())
				.age(input.getAge())
				.email(input.getEmail())
				.jobTitle(input.getJobTitle())
				.dateOfBirth(input.getDateOfBirth())
				.build();
	}
}
