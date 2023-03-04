package com.example.employee_management_api.service_impl;


import com.example.employee_management_api.entities.Employee;
import com.example.employee_management_api.model.EmployeeModel;
import com.example.employee_management_api.repository.EmployeeRepository;
import com.example.employee_management_api.services.EmployeeService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;

    public EmployeeServiceImpl(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    @Override
    public EmployeeModel saveEmployee(EmployeeModel employee) {
        Employee employeeEntity = new Employee();
        BeanUtils.copyProperties(employee, employeeEntity);
        employeeRepository.save(employeeEntity);
        return employee;
    }

    @Override
    public List<EmployeeModel> getAllEmployees() {
        List<Employee> employeeList = employeeRepository.findAll();
        List<EmployeeModel> employees = employeeList.stream().map(employee -> new EmployeeModel(employee.getId(), employee.getFirstName(), employee.getLastName(), employee.getEmailId()))
                .collect(Collectors.toList());
        return employees;
    }

    @Override
    public boolean deleteEmployee(Long id) {
        Employee employee = employeeRepository.findById(id).get();
        employeeRepository.delete(employee);
        return true;
    }

    @Override
    public EmployeeModel getEmployeeById(Long id) {
        Employee employee = employeeRepository.findById(id).get();
        EmployeeModel employeeModel = new EmployeeModel();
        BeanUtils.copyProperties(employee, employeeModel);
        return employeeModel;
    }

    @Override
    public EmployeeModel updateEmployee(Long id, EmployeeModel employeeModel) {
        Employee employee = employeeRepository.findById(id).get();
        employee.setEmailId(employeeModel.getEmailId());
        employee.setFirstName(employeeModel.getFirstName());
        employee.setLastName(employeeModel.getLastName());

        employeeRepository.save(employee);
        return employeeModel;
    }


}
