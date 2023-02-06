package com.example.employeemanager.repository;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import com.example.employeemanager.model.Employee;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long> {
	
	@Query(value = " SELECT e.* FROM tbl_employee e WHERE e.date_of_birth between ?1 and ?2 ",nativeQuery = true)
	public List<Employee> getByDobBetween(LocalDate startDate, LocalDate endDate);
	
	@Query(value = " SELECT e.* FROM tbl_employee e WHERE e.age between ?1 and ?2 ",nativeQuery = true)
	public List<Employee> getByAgeBetween(Integer startAge, Integer endAge);
}
