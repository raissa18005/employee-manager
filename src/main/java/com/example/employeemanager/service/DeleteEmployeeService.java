package com.example.employeemanager.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.employeemanager.model.Employee;
import com.example.employeemanager.model.EmployeeRequest;
import com.example.employeemanager.model.EmployeeResponse;
import com.example.employeemanager.repository.EmployeeRepository;

@Service
public class DeleteEmployeeService {
	
	@Autowired
	private EmployeeRepository employeeRepository;
	
	public boolean execute(Long id) {
		Employee employee = employeeRepository.findById(id)
				.orElseThrow(() -> new IllegalArgumentException("No employee found by id = " + id));
		employeeRepository.delete(employee);
		return true;
	}
}
