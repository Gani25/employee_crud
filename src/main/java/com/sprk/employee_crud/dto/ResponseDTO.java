package com.sprk.employee_crud.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ResponseDTO<E> {

    private String statusCode;

    private String message;

    private E data;

}
