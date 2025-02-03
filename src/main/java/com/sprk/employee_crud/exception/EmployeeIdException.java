package com.sprk.employee_crud.exception;

import org.springframework.http.HttpStatus;

public class EmployeeIdException extends EmployeeException{

    public EmployeeIdException(String message, HttpStatus status) {
        super(message, status);
    }
}
