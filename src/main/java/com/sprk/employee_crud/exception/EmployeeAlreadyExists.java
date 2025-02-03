package com.sprk.employee_crud.exception;

import org.springframework.http.HttpStatus;

public class EmployeeAlreadyExists extends EmployeeException{

    public EmployeeAlreadyExists(String message, HttpStatus status) {

        super(message, status);
    }
}
