package com.restdemo.REst.rest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.restdemo.REst.errors.EmployeeErrorResponse;
import com.restdemo.REst.errors.EmployeeNotFoundException;


@ControllerAdvice
public class GlobalExceptionHandlerClass {
	
	@ExceptionHandler
    public ResponseEntity<EmployeeErrorResponse> handler(EmployeeNotFoundException exc){
    	 EmployeeErrorResponse error = new EmployeeErrorResponse();
    	 error.setMessage(exc.getMessage());
    	 error.setStatus(HttpStatus.NOT_FOUND.value());
    	 error.setTimeStamp(System.currentTimeMillis());
    	 
    	 return new ResponseEntity<>(error, HttpStatus.NOT_FOUND);   
    }

}
