package com.springpayroll.mappings;

import com.springpayroll.dtos.PayrollDTO;
import com.springpayroll.entities.Payroll;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface PayrollMapper {
    PayrollDTO toDTO(Payroll payroll);
    Payroll toEntity(PayrollDTO payrollDTO);
}
