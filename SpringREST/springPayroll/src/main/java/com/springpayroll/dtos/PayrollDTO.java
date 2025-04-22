package com.springpayroll.dtos;

import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class PayrollDTO {
    private int id;
    private int salary;
}
