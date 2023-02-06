package com.example.employeemanager.service;

import java.time.LocalDate;
import java.util.ArrayList;
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
public class GetEmployeeByDobBetweenService {
	
	@Autowired
	private EmployeeRepository employeeRepository;
	
	public List<EmployeeResponse> execute(LocalDate startDate, LocalDate endDate) {
		List<Employee> employees = employeeRepository.getByDobBetween(startDate, endDate);
		
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
