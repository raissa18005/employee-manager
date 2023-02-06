package com.example.employeemanager.model;

import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name = "tbl_employee")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Employee {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	
	@Column(name = "name",nullable=false,length=100)
	private String name;
	
	@Column(name = "age",nullable=false,length=3)
	private Integer age;
	
	@Column(name = "email",nullable=true)
	private String email;
	
	@Column(name = "job_title",nullable=true,length=100)
	private String jobTitle;
	
	@Column(name = "date_of_birth",nullable=true)
	private LocalDate dateOfBirth;
}
