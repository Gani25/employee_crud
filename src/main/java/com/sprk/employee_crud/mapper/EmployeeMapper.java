package com.sprk.employee_crud.mapper;

import com.sprk.employee_crud.dto.EmployeeDTO;
import com.sprk.employee_crud.entity.Employee;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;
import org.springframework.stereotype.Component;

@Component
@Mapper(componentModel = "spring")
public interface EmployeeMapper {

    Employee mapEmployeeDTOToEmployee(EmployeeDTO employeeDTO);

    EmployeeDTO mapEmployeeToEmployeeDTO(Employee employee);
}
