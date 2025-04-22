package com.springpayroll.repositories;

import com.springpayroll.entities.Payroll;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PayrollRepository extends JpaRepository<Payroll, Integer> {
}
