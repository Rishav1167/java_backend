package com.springpayroll.dtos;

import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class EmployeeDTO {
    private int id;
    private String name;
    private String contact;
    private PayrollDTO payroll;
}
