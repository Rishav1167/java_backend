package com.springpayroll.services;

import com.springpayroll.dtos.PayrollDTO;
import com.springpayroll.entities.Payroll;
import com.springpayroll.mappings.PayrollMapper;
import com.springpayroll.repositories.PayrollRepository;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class PayrollServices {

    @Autowired
    private PayrollRepository payrollRepository;

    @Autowired
    private PayrollMapper payrollMapper;

    @PersistenceContext
    private EntityManager entityManager;

    public PayrollDTO getPayrollById(int id) {
        Payroll payroll = payrollRepository.findById(id).orElse(null);
        return payroll != null ? payrollMapper.toDTO(payroll) : null;
    }


    // Fetch payroll with employee name (using JPQL join)
    public List<Object[]> getPayrollsWithEmployeeNames() {
        String jpql = "SELECT p.salary, e.name FROM Payroll p JOIN Employee e ON e.payroll.id = p.id";
        Query query = entityManager.createQuery(jpql);
        return query.getResultList(); // Returns List<Object[]>, each with [salary, name]
    }
}
