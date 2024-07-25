package org.springjpa.springjpa.controllers;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springjpa.springjpa.entities.Employee;
import org.springjpa.springjpa.services.EmployeeService;

import java.util.List;

@RestController
public class EmployeeController {
    @Autowired
    EmployeeService employeeService;


    @PostMapping("addemployees")
    public List<Employee> addAllEmployees(@RequestBody List<Employee> employees){
        return employeeService.saveAllEmployees(employees);
    }

    @GetMapping("allemployees")
    public List<Employee> getAllEmployees(){
        return employeeService.findAllEmployees();
    }

    @GetMapping("employeeswithname")
    public List<Employee> getAllEmployeesWithName(@RequestBody String employeename){
        return employeeService.findEmployeesByName(employeename);
    }
    @GetMapping("employeesbyid")
    public Employee getEmployeesById(@RequestBody int id){
        return employeeService.findEmployeeById(id);
    }
}
