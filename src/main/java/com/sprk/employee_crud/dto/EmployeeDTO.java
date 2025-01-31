package com.sprk.employee_crud.dto;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import lombok.*;


@ToString
@AllArgsConstructor
@NoArgsConstructor
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

    public int getEmpId() {
        return empId;
    }

    public void setEmpId(int empId) {
        this.empId = empId;
    }

    public @NotBlank(message = "Name cannot be empty") String getEmpName() {
        return empName;
    }

    public void setEmpName(@NotBlank(message = "Name cannot be empty") String empName) {
        this.empName = empName;
    }

    public @Pattern(
            regexp = "^(\\+\\d{1,3}\\s?)?(\\d{5}\\s?\\d{5}|\\d{10})$",
            message = "Invalid phone number format. Correct format is: [+1 12345 67890]") @NotBlank(message = "Phone cannot be empty") String getPhone() {
        return phone;
    }

    public void setPhone(@Pattern(
            regexp = "^(\\+\\d{1,3}\\s?)?(\\d{5}\\s?\\d{5}|\\d{10})$",
            message = "Invalid phone number format. Correct format is: [+1 12345 67890]") @NotBlank(message = "Phone cannot be empty") String phone) {
        this.phone = phone;
    }

    public @Email(message = "Invalid email format, Correct format is: [sample@gmail.com]") @NotBlank(message = "Email cannot be empty") String getEmail() {
        return email;
    }

    public void setEmail(@Email(message = "Invalid email format, Correct format is: [sample@gmail.com]") @NotBlank(message = "Email cannot be empty") String email) {
        this.email = email;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }
}

