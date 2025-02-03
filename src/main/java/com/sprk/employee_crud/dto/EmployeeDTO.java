package com.sprk.employee_crud.dto;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import lombok.*;


@ToString
@AllArgsConstructor
@NoArgsConstructor
@Data
public class EmployeeDTO {

    private int empId;

    @NotBlank(message = "Name cannot be empty")
    private String empName;

    @Pattern(
            regexp = "^(\\+\\d{1,3}\\s?)?(\\d{5}\\s?\\d{5}|\\d{10})$",
            message = "Invalid phone number format. Correct format is: [+1 12345 67890]")
    @NotBlank(message = "Phone cannot be empty")
    private String phone;

    @Email(message = "Invalid email format, Correct format is: [sample@gmail.com]")
    @NotBlank(message = "Email cannot be empty")
    private String email;

    private String gender;

}

