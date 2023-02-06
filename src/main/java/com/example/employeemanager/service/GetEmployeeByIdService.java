package com.example.employeemanager.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.employeemanager.exception.IcaException;
import com.example.employeemanager.mapper.EmployeeMapper;
import com.example.employeemanager.model.Employee;
import com.example.employeemanager.model.EmployeeResponse;
import com.example.employeemanager.repository.EmployeeRepository;

@Service
public class GetEmployeeByIdService {
	
	@Autowired
	private EmployeeRepository employeeRepository;
	
	@Autowired
	private EmployeeMapper employeeMapper;
	
	public EmployeeResponse getEmployeeById(Long id) {
		Employee employee = employeeRepository.findById(id)
				.orElseThrow(() -> new IcaException("data not found, id = " + id));
		return employeeMapper.mapEmployeeToResponse(employee);
	}

}
