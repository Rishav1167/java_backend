package com.springpayroll.services;

import com.springpayroll.dtos.EmployeeDTO;
import com.springpayroll.entities.Employee;
import com.springpayroll.mappings.EmployeeMapper;
import com.springpayroll.repositories.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class EmployeeServices {

    private final EmployeeRepository employeeRepository;

    private EmployeeMapper employeeMapper;
    public EmployeeServices(EmployeeRepository employeeRepository, EmployeeMapper employeeMapper) {
        this.employeeRepository = employeeRepository;
        this.employeeMapper = employeeMapper;
    }

    public EmployeeDTO saveEmployee(EmployeeDTO employeeDTO) {
        Employee employee = employeeMapper.toEntity(employeeDTO);
        Employee savedEmployee = employeeRepository.save(employee);
        return employeeMapper.toDTO(savedEmployee);
    }

    // Get employee by ID
    public EmployeeDTO getEmployeeById(int id) {
        Employee employee = employeeRepository.findById(id).orElse(null);
        return employeeMapper.toDTO(employee);

    }

    public List<EmployeeDTO> getAllEmployees() {
        List<Employee> employees = employeeRepository.findAll();
        return employees.stream().map(employeeMapper::toDTO).collect(Collectors.toList());
    }

    // Delete employee by ID
    public boolean deleteEmployee(int id) {
        if (employeeRepository.existsById(id)) {
            employeeRepository.deleteById(id);
            return true;
        }
        return false;
    }

}
