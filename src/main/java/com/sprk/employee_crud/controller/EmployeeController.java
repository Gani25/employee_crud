package com.sprk.employee_crud.controller;

import com.sprk.employee_crud.constant.EmployeeConstants;
import com.sprk.employee_crud.dto.EmployeeDTO;
import com.sprk.employee_crud.dto.ResponseDTO;
import com.sprk.employee_crud.entity.Employee;
import com.sprk.employee_crud.service.EmployeeService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/sprk")
@RequiredArgsConstructor
public class EmployeeController {

    private final EmployeeService employeeService;


    // create -> save -> post mapping
    @PostMapping("/employees")
    public ResponseEntity<?> addEmployee(@Valid @RequestBody EmployeeDTO employeeDTO) {

//        System.out.println(employeeDTO.toString());

        EmployeeDTO savedEmployee = employeeService.saveEmployee(employeeDTO);
        ResponseDTO<EmployeeDTO> responseDTO = new ResponseDTO();

        responseDTO.setMessage(EmployeeConstants.MESSAGE_201);
        responseDTO.setStatusCode(EmployeeConstants.STATUS_201);
        responseDTO.setData(savedEmployee);
        return new ResponseEntity<>(responseDTO, HttpStatus.CREATED);


    }

    @GetMapping("/employees")
    public ResponseEntity<?> getAllEmployees() {
        List<EmployeeDTO> employeeDTOList =  employeeService.getAllEmployees();

        ResponseDTO<List<EmployeeDTO>> responseDTO = new ResponseDTO<>();
        responseDTO.setMessage(EmployeeConstants.MESSAGE_200);
        responseDTO.setStatusCode(EmployeeConstants.STATUS_200);
        responseDTO.setData(employeeDTOList);

        return new ResponseEntity<>(responseDTO, HttpStatus.OK);
    }

    @GetMapping("/employees/{empId}")
    public ResponseEntity<?> getEmployeeById(@PathVariable String empId) {

        EmployeeDTO employeeDTO = employeeService.getEmployeeByEmpId(empId);
        ResponseDTO<EmployeeDTO> responseDTO = new ResponseDTO<>();
        responseDTO.setMessage(EmployeeConstants.MESSAGE_200);
        responseDTO.setStatusCode(EmployeeConstants.STATUS_200);
        responseDTO.setData(employeeDTO);
        return new ResponseEntity<>(responseDTO, HttpStatus.OK);

    }

    @DeleteMapping("/employees/{empId}")
    public ResponseEntity<?> deleteEmployeeById(@PathVariable String empId) {

        EmployeeDTO deletedEmployeeDto = employeeService.deleteById(empId);
        ResponseDTO<EmployeeDTO> responseDTO = new ResponseDTO<>();

        responseDTO.setMessage(String.format(EmployeeConstants.MESSAGE_202, deletedEmployeeDto.getEmpId()));
        responseDTO.setStatusCode(EmployeeConstants.STATUS_202);
        responseDTO.setData(deletedEmployeeDto);
        return new ResponseEntity<>(responseDTO, HttpStatus.valueOf(Integer.parseInt(EmployeeConstants.STATUS_202)));

    }

    // Update
//    path variable, request body

}
