package com.example.employeemanager.exception;

public class IcaException extends RuntimeException {
	private String message;
	
	public IcaException() {
		
	}
	 
    public IcaException(String msg)
    {
        super(msg);
        this.message = msg;
    }	    
}
