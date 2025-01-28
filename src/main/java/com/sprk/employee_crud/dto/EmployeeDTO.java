package com.sprk.employee_crud.dto;

import jakarta.persistence.*;
import lombok.Data;


@Data
public class EmployeeDTO {

    private int empId;

    private String empName;

    private String phone;

    private String gender;

}

