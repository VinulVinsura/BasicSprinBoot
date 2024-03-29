package com.example.basicsprinboot.dto;

import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString

public class EmployeeDto {

    private int empId;
    private String empName;
    private String empAddress;
    private String empMNumber;
}
