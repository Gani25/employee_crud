package com.sprk.employee_crud.service.impl;

import com.sprk.employee_crud.dto.EmployeeDTO;
import com.sprk.employee_crud.entity.Employee;
import com.sprk.employee_crud.mapper.EmployeeMapper;
import com.sprk.employee_crud.repository.EmployeeRepository;
import com.sprk.employee_crud.service.EmployeeService;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@AllArgsConstructor
public class EmployeeServiceImpl implements EmployeeService {

    // Field Injection
    // @Autowired
    private final EmployeeRepository employeeRepository;

    private final EmployeeMapper employeeMapper;

    /*
    // constructor injection
    @Autowired
    public EmployeeServiceImpl(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }*/

    @Override
    public EmployeeDTO saveEmployee(EmployeeDTO employeeDTO) {
        Employee employee = employeeMapper.mapEmployeeDTOToEmployee(employeeDTO);


        Optional<Employee> dbOptionalEmployee = employeeRepository.findByEmailOrPhone(employee.getEmail(), employee.getPhone());
        if(dbOptionalEmployee.isPresent()){
            return null;
        }

        // check if employee not exists by same email or phone then only save
//        System.out.println(employee);
        Employee savedEmployee =  employeeRepository.save(employee);

        return employeeMapper.mapEmployeeToEmployeeDTO(savedEmployee);
    }
}
