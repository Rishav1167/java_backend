package com.springpayroll.controllers;

import com.springpayroll.dtos.PayrollDTO;
import com.springpayroll.services.PayrollServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/payroll")
public class PayrollController {

    @Autowired
    private PayrollServices payrollService;

    @GetMapping("/{id}")
    public ResponseEntity<PayrollDTO> getPayrollById(@PathVariable int id) {
        PayrollDTO payrollDTO = payrollService.getPayrollById(id);
        if (payrollDTO == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(payrollDTO);
    }

    @GetMapping("/list")
    public ResponseEntity<List<Object[]>> getPayrollsWithEmployeeNames() {
        return ResponseEntity.ok(payrollService.getPayrollsWithEmployeeNames());
    }
}
