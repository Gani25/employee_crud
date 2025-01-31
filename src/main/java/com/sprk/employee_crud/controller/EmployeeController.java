package com.sprk.employee_crud.controller;

import com.sprk.employee_crud.dto.EmployeeDTO;
import com.sprk.employee_crud.entity.Employee;
import com.sprk.employee_crud.service.EmployeeService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/sprk")
@RequiredArgsConstructor
public class EmployeeController {

    private final EmployeeService employeeService;



    // create -> save -> post mapping
    @PostMapping("/employee")
    public Employee addEmployee(@Valid @RequestBody EmployeeDTO employeeDTO) {

        System.out.println(employeeDTO.toString());

        Employee savedEmployee =  employeeService.saveEmployee(employeeDTO);
        return savedEmployee;

    }
    
}
