package com.sprk.employee_crud.service;

import com.sprk.employee_crud.dto.EmployeeDTO;
import com.sprk.employee_crud.entity.Employee;
import com.sprk.employee_crud.repository.EmployeeRepository;

import java.util.List;

public interface EmployeeService {

    // only abstract methods
    public EmployeeDTO saveEmployee(EmployeeDTO employeeDTO);

    List<EmployeeDTO> getAllEmployees();

    EmployeeDTO getEmployeeByEmpId(String empId);

    EmployeeDTO deleteById(String empId);

    EmployeeDTO updateEmployeeById(String empId, EmployeeDTO employeeDTO);
}
