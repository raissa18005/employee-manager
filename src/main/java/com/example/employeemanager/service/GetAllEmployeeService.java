package com.example.employeemanager.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.employeemanager.exception.IcaException;
import com.example.employeemanager.model.Employee;
import com.example.employeemanager.model.EmployeeResponse;
import com.example.employeemanager.repository.EmployeeRepository;

@Service
public class GetAllEmployeeService {
	
	@Autowired
	private EmployeeRepository employeeRepository;
	
	public List<EmployeeResponse> execute() {
		List<Employee> employees = employeeRepository.findAll();
		return employees.stream()
				.map(emp -> {
					return EmployeeResponse.builder()
								.id(emp.getId())
								.name(emp.getName())
								.age(emp.getAge())
								.jobTitle(emp.getJobTitle())
								.email(emp.getEmail())
								.dateOfBirth(emp.getDateOfBirth())
								.build();
				}).collect(Collectors.toList());	
	}

}
