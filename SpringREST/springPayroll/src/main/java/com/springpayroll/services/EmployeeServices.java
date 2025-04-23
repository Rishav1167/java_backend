package com.springpayroll.services;

import com.springpayroll.dtos.EmployeeDTO;
import com.springpayroll.entities.Employee;
import com.springpayroll.exceptions.EmployeeException;
import com.springpayroll.mappings.EmployeeMapper;
import com.springpayroll.repositories.EmployeeRepository;
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
        return employeeRepository.findById(id)
                .map(employeeMapper::toDTO)
                .orElseThrow(() -> new EmployeeException("Employee with ID " + id + " not found"));

    }

    public List<EmployeeDTO> getAllEmployees() {
        List<Employee> employees = employeeRepository.findAll();
        return employees.stream().map(employeeMapper::toDTO).collect(Collectors.toList());
    }

    // Delete employee by ID
    public boolean deleteEmployee(int id) {
        if (!employeeRepository.existsById(id)) {
            throw new EmployeeException("Cannot delete. Employee with ID " + id + " does not exist.");
        }
        employeeRepository.deleteById(id);
        return true;
    }

    public EmployeeDTO updateEmployeeSalary(int employeeId, int newSalary)  {
        Employee employee = employeeRepository.findById(employeeId)
                .orElseThrow(() -> new EmployeeException("Cannot update salary. Employee with ID " + employeeId + " not found."));

        employee.getPayroll().setSalary(newSalary);
        Employee updatedEmployee = employeeRepository.save(employee);
        return employeeMapper.toDTO(updatedEmployee);
    }

}
