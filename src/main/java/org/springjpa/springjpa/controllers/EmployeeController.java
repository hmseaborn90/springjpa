package org.springjpa.springjpa.controllers;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springjpa.springjpa.entities.Employee;
import org.springjpa.springjpa.repositories.EmployeeRepository;
import org.springjpa.springjpa.services.EmployeeService;

import java.util.List;

@RestController
public class EmployeeController {
    @Autowired
    EmployeeService employeeService;

    @Autowired
    EmployeeRepository employeeRepository;


    @PostMapping("addemployees")
    public List<Employee> addAllEmployees(@RequestBody List<Employee> employees){
        return employeeService.saveAllEmployees(employees);
    }

    @GetMapping("allemployees")
    public List<Employee> getAllEmployees(){
        return employeeService.findAllEmployees();
    }

    @GetMapping("employeeswithname")
    public List<Employee> getAllEmployeesWithName(@RequestParam String employeename){
        return employeeService.findEmployeesByName(employeename);
    }
    @GetMapping("employeebyid")
    public Employee getEmployeeById(@RequestParam int id){
        System.out.println(id);
        return employeeService.findEmployeeById(id);
    }
    @GetMapping("employeesbyids")
    public List<Employee> getAllEmployeesById(@RequestBody List<Integer> ids){
        return employeeService.findAllEmployeesByIds(ids);
    }
    @GetMapping("empbydeptandage")
    public List<Employee> getEmpByDeptAndAge(@RequestParam String department, @RequestParam int age){
        return employeeRepository.findByDepartmentAndAgeLessThanEqual(department, age);
    }
    @GetMapping("empbydeptandagegreater")
    public List<Employee> getEmpByDeptAndAgeGreater(@RequestParam String department, @RequestParam int age){
        return employeeRepository.findByDepartmentAndAgeGreaterThanEqual(department, age);
    }

    @GetMapping("employeesbyname")
    public List<Employee> getEmployeesByName(@RequestParam String employeename){
        return employeeRepository.findByEmployeenameStartingWith(employeename);
    }

}
