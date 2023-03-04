package com.example.employee_management_api.services;

import com.example.employee_management_api.model.EmployeeModel;

import java.util.List;

public interface EmployeeService {
    EmployeeModel saveEmployee(EmployeeModel employee);

    List<EmployeeModel> getAllEmployees();

    boolean deleteEmployee(Long id);


    EmployeeModel getEmployeeById(Long id);

    EmployeeModel updateEmployee(Long id, EmployeeModel employeeModel);
}
