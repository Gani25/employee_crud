package com.sprk.employee_crud.mapper;

import com.sprk.employee_crud.dto.EmployeeDTO;
import com.sprk.employee_crud.entity.Employee;

//UTILITY CLASS / SUPPORTING CLASS
public class EmployeeMapperOld {

    public static Employee mapEmployeeDTOToEmployee(EmployeeDTO employeeDTO) {
        Employee employee = new Employee();
        employee.setEmpId(employeeDTO.getEmpId());
        employee.setEmpName(employeeDTO.getEmpName());
        employee.setGender(employeeDTO.getGender());
        employee.setPhone(employeeDTO.getPhone());

        return employee;
    }

    public static EmployeeDTO mapEmployeeToEmployeeDTO(Employee employee) {
        EmployeeDTO employeeDTO = new EmployeeDTO();
        employeeDTO.setEmpId(employee.getEmpId());
        employeeDTO.setEmpName(employee.getEmpName());
        employeeDTO.setGender(employee.getGender());
        employeeDTO.setPhone(employee.getPhone());
        return employeeDTO;
    }
}
