package com.sprk.employee_crud.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class EmployeeDetailDTO {

    private int empDetailId;

    @NotBlank(message = "Hobby cannot be null")
    private String hobby;

    @NotBlank(message = "Qualification cannot be null")
    private String qualification;
}
