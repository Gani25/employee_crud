package com.sprk.employee_crud.service.impl;

import com.sprk.employee_crud.constant.EmployeeConstants;
import com.sprk.employee_crud.dto.EmployeeDTO;
import com.sprk.employee_crud.entity.Employee;
import com.sprk.employee_crud.exception.EmployeeAlreadyExists;
import com.sprk.employee_crud.exception.EmployeeIdException;
import com.sprk.employee_crud.exception.EmployeeNotFoundException;
import com.sprk.employee_crud.mapper.EmployeeMapper;
import com.sprk.employee_crud.repository.EmployeeRepository;
import com.sprk.employee_crud.service.EmployeeService;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
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


        List<Employee> employeesWithEmailOrPhone = employeeRepository.findByEmailOrPhone(employee.getEmail(), employee.getPhone());
        // If at least one employee exists, throw an error
        if (!employeesWithEmailOrPhone.isEmpty()) {
            throw new EmployeeAlreadyExists(EmployeeConstants.MESSAGE_400,
                    HttpStatus.valueOf(Integer.parseInt(EmployeeConstants.STATUS_400)));
        }

        // check if employee not exists by same email or phone then only save
//        System.out.println(employee);
        Employee savedEmployee = employeeRepository.save(employee);

        return employeeMapper.mapEmployeeToEmployeeDTO(savedEmployee);
    }

    @Override
    public List<EmployeeDTO> getAllEmployees() {
        List<Employee> employees = employeeRepository.findAll();

        List<EmployeeDTO> employeeDTOS = employees
                .stream()
                .map(employeeMapper::mapEmployeeToEmployeeDTO)
                .toList();

        return employeeDTOS;
    }

    @Override
    public EmployeeDTO getEmployeeByEmpId(String empId) {
        if (!empId.matches("\\d+")) {
            throw new EmployeeIdException(EmployeeConstants.MESSAGE_400_INVALID, HttpStatus.valueOf(Integer.parseInt(EmployeeConstants.STATUS_400)));
        }

        int eId = Integer.parseInt(empId);
        Employee employee = employeeRepository
                .findById(eId)
                .orElseThrow(() -> new EmployeeNotFoundException(
                        String.format(EmployeeConstants.MESSAGE_400_NOT_FOUND, eId),
                        HttpStatus.valueOf(Integer.parseInt(EmployeeConstants.STATUS_400))));
        return employeeMapper.mapEmployeeToEmployeeDTO(employee);
    }

    @Override
    public EmployeeDTO deleteById(String empId) {
        // Find Employee By Id
        EmployeeDTO employeeDTO = getEmployeeByEmpId(empId);

//        If Exists then Only Delete
        employeeRepository.delete(employeeMapper.mapEmployeeDTOToEmployee(employeeDTO));

        return employeeDTO;
    }

    @Override
    public EmployeeDTO updateEmployeeById(String empId, EmployeeDTO employeeDTO) {
        EmployeeDTO existingEmployeeDto = getEmployeeByEmpId(empId);

        List<Employee> employeesWithEmailOrPhone = employeeRepository.findByEmailOrPhone(employeeDTO.getEmail(), employeeDTO.getPhone());

        // Check if any of these employees are not the one being updated
        boolean isConflict = employeesWithEmailOrPhone.stream()
                .anyMatch(emp -> !String.valueOf(emp.getEmpId()).equals(empId));

        if (isConflict) {
            throw new EmployeeAlreadyExists(EmployeeConstants.MESSAGE_400,
                    HttpStatus.valueOf(Integer.parseInt(EmployeeConstants.STATUS_400)));
        }

        if(employeeDTO.getPhone() != null){
            existingEmployeeDto.setPhone(employeeDTO.getPhone());
        }
        if(employeeDTO.getEmail() != null){
            existingEmployeeDto.setEmail(employeeDTO.getEmail());
        }
        if(employeeDTO.getEmpName() != null){
            existingEmployeeDto.setEmpName(employeeDTO.getEmpName());
        }
        if(employeeDTO.getGender()!= null){
            existingEmployeeDto.setGender(employeeDTO.getGender());
        }

        Employee updatedEmployee = employeeRepository.save(employeeMapper.mapEmployeeDTOToEmployee(existingEmployeeDto));


        return employeeMapper.mapEmployeeToEmployeeDTO(updatedEmployee);
    }
}
