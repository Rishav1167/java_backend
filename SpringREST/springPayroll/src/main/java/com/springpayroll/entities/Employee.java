package com.springpayroll.entities;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "employee")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String name;

    private String contact;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "payroll_id", referencedColumnName = "id")
    private Payroll payroll;
}
