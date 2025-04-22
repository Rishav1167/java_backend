package com.springpayroll.mappings;

import com.springpayroll.dtos.EmployeeDTO;
import com.springpayroll.entities.Employee;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring", uses = {PayrollMapper.class})
public interface EmployeeMapper {
    EmployeeDTO toDTO(Employee employee);
    Employee toEntity(EmployeeDTO employeeDTO);
}
