package com.bncode.springbootdemo.service;

import com.bncode.springbootdemo.errors.EmployeeNotFoundException;
import com.bncode.springbootdemo.model.Employee;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    List<Employee> employees = new ArrayList<>();

    @Override
    public Employee saveEmployee(Employee employee) {
        if (employee.getEmployeeId() == null ||
                employee.getEmailId().isEmpty()) {
            employee.setEmployeeId(UUID.randomUUID().toString());
        }
        employees.add(employee);
        return employee;
    }

    @Override
    public List<Employee> getAllEmployees() {
        return employees;
    }

    @Override
    public Employee getEmployeeById(String id) {
        return employees
                .stream()
                .filter(employee -> employee.getEmployeeId().equals(id))
                .findFirst()
                .orElseThrow(() -> new EmployeeNotFoundException("" + "Employee Not Found with Id: " + id)); //RuntimeException("Employee Not Found with Id: " + id)
//              .orElseThrow(() -> new RuntimeException("" + "Employee Not Found with Id: " + id)); // to show genericException
//              had .get() after this but it is going away
//              .get()

    }

    @Override
    public String deleteEmployeeById(String id) {
        Employee employee
                = employees
                .stream()
                .filter(e -> e.getEmployeeId().equalsIgnoreCase(id))
                .findFirst()
                .get();

        employees.remove(employee);
        return "Employee deleted with the id: " + id;
    }
}