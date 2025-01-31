package com.sprk.employee_crud.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.http.HttpStatus;

import java.time.LocalDateTime;
import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ErrorResponseDTO<E> {

    private String apiPath;

    private HttpStatus errorCode;

    private E errorMessage;

    private LocalDateTime timestamp;
}
