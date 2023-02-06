package com.example.employeemanager.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.employeemanager.EmployeemanagerApplication;
import com.example.employeemanager.mapper.EmployeeMapper;
import com.example.employeemanager.model.Employee;
import com.example.employeemanager.model.EmployeeRequest;
import com.example.employeemanager.model.EmployeeResponse;
import com.example.employeemanager.repository.EmployeeRepository;

@Service
public class CreateEmployeeService {
	
	@Autowired
	private EmployeeRepository employeeRepository;
	
	@Autowired
	private EmployeeMapper employeeMapper;

	public EmployeeResponse execute(EmployeeRequest input) {
		Employee employee = employeeMapper.mapRequestToEmployee(input);
		return employeeMapper.mapEmployeeToResponse(employeeRepository.save(employee));
	}
}
