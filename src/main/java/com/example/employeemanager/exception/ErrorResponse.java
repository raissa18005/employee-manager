package com.example.employeemanager.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ErrorResponse {
	private int code;
	private String status;
	private String message;
	
	public ErrorResponse(String message)
    {
        this.message = message;
    }
}
