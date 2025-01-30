package com.sprk.employee_crud.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Entity
@Getter
@Setter
@Table(name = "employee")
@ToString
public class Employee {

    // primary key column
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY) // auto increment
    private int empId;

    @Column(nullable = false, name = "emp_name")
    private String empName;

    @Column(unique = true, nullable = false)
    private String phone;

    @Column(unique = true, nullable = false)
    private String email;

    private String gender;

}
