package com.sprk.employee_crud.mapper;

import com.sprk.employee_crud.dto.EmployeeDTO;
import com.sprk.employee_crud.entity.Employee;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface EmployeeMapper {

//    EmployeeMapper EMPLOYEE_MAPPER = Mappers.getMapper(EmployeeMapper.class);

    @Mappings({
            @Mapping(source = "empId", target = "empId"),
            @Mapping(source = "empName", target = "empName"),
            @Mapping(source = "phone", target = "phone"),
            @Mapping(source = "email", target = "email"),
            @Mapping(source = "gender", target = "gender")
    })
    Employee mapEmployeeDTOToEmployee(EmployeeDTO employeeDTO);

    @Mappings({
            @Mapping(source = "empId", target = "empId"),
            @Mapping(source = "empName", target = "empName"),
            @Mapping(source = "phone", target = "phone"),
            @Mapping(source = "email", target = "email"),
            @Mapping(source = "gender", target = "gender")
    })
    EmployeeDTO mapEmployeeToEmployeeDTO(Employee employee);
}
