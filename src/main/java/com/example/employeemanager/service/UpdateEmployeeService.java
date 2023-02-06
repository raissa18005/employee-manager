package com.example.employeemanager.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import com.example.employeemanager.model.Employee;
import com.example.employeemanager.model.EmployeeRequest;
import com.example.employeemanager.model.EmployeeResponse;
import com.example.employeemanager.repository.EmployeeRepository;

@Service
public class UpdateEmployeeService {
	
	@Autowired
	private EmployeeRepository employeeRepository;
	
	public EmployeeResponse execute(EmployeeRequest input) {
		Employee employee = employeeRepository.findById(input.getId())
				.orElseThrow(() -> new IllegalArgumentException("No employee found by id = " + input.getId()));
		mapRequestToEmployee(input, employee);
		return mapEmployeeToResponse(employeeRepository.save(employee));
	}

	private void mapRequestToEmployee(EmployeeRequest input, Employee employee) {
		if(!StringUtils.isEmpty(input.getName())) employee.setName(input.getName());
		if(!StringUtils.isEmpty(input.getAge())) employee.setAge(input.getAge());
		if(!StringUtils.isEmpty(input.getEmail())) employee.setEmail(input.getEmail());
		if(!StringUtils.isEmpty(input.getJobTitle())) employee.setJobTitle(input.getJobTitle());
		if(!StringUtils.isEmpty(input.getDateOfBirth())) employee.setDateOfBirth(input.getDateOfBirth());
		
	}
	
	private EmployeeResponse mapEmployeeToResponse(Employee input) {
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
