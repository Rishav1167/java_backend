package com.springpayroll.dtos;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.*;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Pattern;
import java.io.Serializable;
import java.sql.Date;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PastOrPresent;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class EmployeeDTO implements Serializable {
    private int id;

    @NotEmpty(message = "Name must not be empty")
    @Pattern(regexp = "^[A-Za-z ]{2,50}$", message = "Name must be 2-50 characters and contain only letters and spaces")

    private String name;

    @NotEmpty(message = "Gender must not be empty")
    @Pattern(regexp = "M | F", message = "Gender needs to be M or F")
    private Character gender;

    @NotNull(message = "startDate must not be null")
    @JsonFormat(pattern = "dd MM yyyy")
    @PastOrPresent(message = "startDate should be past or present")
    private Date startDate;
    private String contact;
    private PayrollDTO payroll;
}
