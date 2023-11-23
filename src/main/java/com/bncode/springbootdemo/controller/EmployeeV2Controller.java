package com.bncode.springbootdemo.controller;

import com.bncode.springbootdemo.model.Employee;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/v2/employees")
public class EmployeeV2Controller {

    @PostMapping
    public Employee saveEmployee(@RequestBody Employee employee) {
        return employee;//employeeService.saveEmployee(employee);
    }
}