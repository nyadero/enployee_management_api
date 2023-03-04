package com.example.employee_management_api.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeController {

    @GetMapping("/")
    public String homeController(){
        return "Welcome to the employee management system api";
    }
}
