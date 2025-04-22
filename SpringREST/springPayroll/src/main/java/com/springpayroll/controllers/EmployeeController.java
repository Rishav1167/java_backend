package com.springpayroll.controllers;

import com.springpayroll.dtos.EmployeeDTO;
import com.springpayroll.services.EmployeeServices;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/emp")
public class EmployeeController {


    private EmployeeServices employeeService;
    EmployeeController(EmployeeServices employeeService) {
        this.employeeService = employeeService;
    }

    @PostMapping("/post")
    public ResponseEntity<EmployeeDTO> saveEmployee(@RequestBody EmployeeDTO employeeDTO) {
        EmployeeDTO savedEmployee = employeeService.saveEmployee(employeeDTO);
        return new ResponseEntity<>(savedEmployee, HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<EmployeeDTO> getEmployees(@PathVariable int id) {
        EmployeeDTO employeeDTO = employeeService.getEmployeeById(id);
        if(employeeDTO == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(employeeDTO, HttpStatus.OK);
    }

     @GetMapping("/list")
    public ResponseEntity<List<EmployeeDTO>> getEmployees() {
        return new ResponseEntity<>(employeeService.getAllEmployees(), HttpStatus.OK);
     }

     @DeleteMapping("/{id}")
    public ResponseEntity<Boolean> deleteEmployee(@PathVariable int id) {
        return new ResponseEntity<>(employeeService.deleteEmployee(id) , HttpStatus.OK);
     }
}
