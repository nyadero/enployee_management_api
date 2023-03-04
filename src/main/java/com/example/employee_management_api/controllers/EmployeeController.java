package com.example.employee_management_api.controllers;


import com.example.employee_management_api.entities.Employee;
import com.example.employee_management_api.model.EmployeeModel;
import com.example.employee_management_api.services.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/v1")
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

//    post method
    @PostMapping("/save-employee")
    public EmployeeModel saveEmployee(@RequestBody EmployeeModel employee){
      return employeeService.saveEmployee(employee);
    }

//    fetch all employees
    @GetMapping("/all-employees")
    public List<EmployeeModel> getAllEmployees(){
      return employeeService.getAllEmployees();
    }

//    delete employee
    @DeleteMapping("/delete-employee/{id}")
    public ResponseEntity<Map<String, Boolean>> deleteEmployee(@PathVariable Long id){
        boolean deleted = false;
        deleted = employeeService.deleteEmployee(id);
        Map<String, Boolean> response = new HashMap<>();
        response.put("Employee deleted", deleted);
        return ResponseEntity.ok(response);
    }

//    get employee by id
    @GetMapping("/get-employee/{id}")
    public ResponseEntity<EmployeeModel> getEmployeeById(@PathVariable Long id){
       EmployeeModel employee = null;
       employee = employeeService.getEmployeeById(id);
      return ResponseEntity.ok(employee);
    }

//    update employee
    @PutMapping("/update-employee/{id}")
    public ResponseEntity<EmployeeModel> updateEmployee(@PathVariable Long id, @RequestBody EmployeeModel employeeModel){
       employeeModel = employeeService.updateEmployee(id, employeeModel);
       return ResponseEntity.ok(employeeModel);
    }
}
