package com.sprk.employee_crud.mapper;

import com.sprk.employee_crud.dto.EmployeeDetailDTO;
import com.sprk.employee_crud.entity.EmployeeDetail;
import org.mapstruct.Mapper;
import org.springframework.stereotype.Component;

@Component
@Mapper(componentModel = "spring")
public interface EmployeeDetailMapper {

    EmployeeDetail employeeDetailDTOToEmployeeDetail(EmployeeDetailDTO employeeDetailDTO);

    EmployeeDetailDTO employeeDetailToEmployeeDetailDTO(EmployeeDetail employeeDetail);
}
