package com.sprk.employee_crud.exception;

import org.springframework.http.HttpStatus;

public class EmployeeNotFoundException extends EmployeeException {

    public EmployeeNotFoundException(String message, HttpStatus status) {
        super(message, status);
    }
}
