package com.springpayroll.dtos;

import lombok.*;
import java.io.Serializable;
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class PayrollDTO implements Serializable {
    private int id;
    private int salary;
}
