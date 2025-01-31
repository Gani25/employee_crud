package com.sprk.employee_crud.service;

import com.sprk.employee_crud.dto.EmployeeDTO;
import com.sprk.employee_crud.entity.Employee;
import com.sprk.employee_crud.repository.EmployeeRepository;

public interface EmployeeService {

    // only abstract methods
    public EmployeeDTO saveEmployee(EmployeeDTO employeeDTO);
}
