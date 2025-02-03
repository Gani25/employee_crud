package com.sprk.employee_crud.exception;

import lombok.Data;
import org.springframework.http.HttpStatus;

@Data
public class EmployeeException extends RuntimeException{

    private HttpStatus status;

    public EmployeeException(String message, HttpStatus status){
        super(message);
        this.status = status;
    }
}
