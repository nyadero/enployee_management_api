package com.example.employee_management_api.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class EmployeeModel {
    private Long id;
    private String firstName;
    private String lastName;
    private String emailId;
}
