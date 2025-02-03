package com.sprk.employee_crud.exception;

import com.sprk.employee_crud.dto.ErrorResponseDTO;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestControllerAdvice
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler {


    @Override
    protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex, HttpHeaders headers, HttpStatusCode status, WebRequest request) {
        Map<String, String> validationErrors = new HashMap<>();

        List<ObjectError> validationErrorList = ex.getBindingResult().getAllErrors();

        validationErrorList.forEach(error -> {
            String fieldName = ((FieldError) error).getField();
            String validationErrorMsg = error.getDefaultMessage();

            validationErrors.put(fieldName, validationErrorMsg);
        });

        ErrorResponseDTO<Map> errorResponseDTO = new ErrorResponseDTO();
        errorResponseDTO.setErrorCode(HttpStatus.valueOf(status.value()));
        errorResponseDTO.setApiPath(request.getDescription(false));
        errorResponseDTO.setTimestamp(LocalDateTime.now());
        errorResponseDTO.setErrorMessage(validationErrors);

        return new ResponseEntity<>(errorResponseDTO, headers, status);
    }

    @ExceptionHandler(EmployeeException.class)
    public ResponseEntity<ErrorResponseDTO<String>> handleEmployeeException(EmployeeException ex, WebRequest request) {
        ErrorResponseDTO<String> errorResponseDTO = new ErrorResponseDTO<>();
        errorResponseDTO.setApiPath(request.getDescription(false));
        errorResponseDTO.setTimestamp(LocalDateTime.now());
        errorResponseDTO.setErrorMessage(ex.getMessage());
        errorResponseDTO.setErrorCode(ex.getStatus());

        return new ResponseEntity<>(errorResponseDTO, ex.getStatus());
    }
}
