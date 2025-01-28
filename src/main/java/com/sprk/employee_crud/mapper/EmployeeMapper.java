package com.sprk.employee_crud.mapper;

import com.sprk.employee_crud.dto.EmployeeDTO;
import com.sprk.employee_crud.entity.Employee;
import org.mapstruct.factory.Mappers;

public interface EmployeeMapper {

    EmployeeMapper EMPLOYEE_MAPPER = Mappers.getMapper(EmployeeMapper.class);

    Employee mapEmployeeDTOToEmployee(EmployeeDTO employeeDTO);

    EmployeeDTO mapEmployeeToEmployeeDTO(Employee employee);
}
