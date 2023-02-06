package com.example.employeemanager.controller;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.employeemanager.model.Employee;
import com.example.employeemanager.model.EmployeeRequest;
import com.example.employeemanager.model.EmployeeResponse;
import com.example.employeemanager.service.CreateEmployeeService;
import com.example.employeemanager.service.DeleteEmployeeService;
import com.example.employeemanager.service.GetAllEmployeeService;
import com.example.employeemanager.service.GetEmployeeByDobBetweenService;
import com.example.employeemanager.service.GetEmployeeByIdService;
import com.example.employeemanager.service.UpdateEmployeeService;

@RestController
@RequestMapping("/api/employees")
public class EmployeeController {
	
	@Autowired
	private GetAllEmployeeService getAllEmployeeService;
	
	@Autowired
	private GetEmployeeByIdService getEmployeeByIdService;
	
	@Autowired
	private CreateEmployeeService createEmployeeService;
	
	@Autowired
	private UpdateEmployeeService updateEmployeeService;
	
	@Autowired
	private DeleteEmployeeService deleteEmployeeService;
	
	@Autowired
	private GetEmployeeByDobBetweenService getEmployeeByDobBetweenEmployeeService;
	
	@GetMapping
	public ResponseEntity<List<EmployeeResponse>> getAllEmployee(){
		List<EmployeeResponse> employees = getAllEmployeeService.execute();
		return ResponseEntity.ok(employees);
	}
	
	@GetMapping(path = "/{id}")
	public ResponseEntity<EmployeeResponse> getEmployeeById(@PathVariable(name = "id") Long id){
		return ResponseEntity.ok(getEmployeeByIdService.getEmployeeById(id));
	}

	@PostMapping
	public ResponseEntity<EmployeeResponse> insertEmployee(@RequestBody EmployeeRequest input){
		return ResponseEntity.ok(createEmployeeService.execute(input));
	}
	
	@PutMapping(path = "/{id}")
	public ResponseEntity<EmployeeResponse> updateEmployee(@PathVariable(name="id") Long id, @RequestBody EmployeeRequest input){
		input.setId(id);
		return ResponseEntity.ok(updateEmployeeService.execute(input));
	}
	
	@DeleteMapping(path = "/{id}")
	public ResponseEntity<String> deleteEmployee(@PathVariable(name="id") Long id){
		deleteEmployeeService.execute(id);
		return ResponseEntity.ok("Data deleted, id = " + id);
	}
	
	@GetMapping("/dob")
	public ResponseEntity<List<EmployeeResponse>> getDobBetween(@RequestParam LocalDate startDate, @RequestParam LocalDate endDate){
		List<EmployeeResponse> employees = getEmployeeByDobBetweenEmployeeService.execute(startDate, endDate);
		return ResponseEntity.ok(employees);
	}
}
