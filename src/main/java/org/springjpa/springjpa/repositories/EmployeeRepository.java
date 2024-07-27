package org.springjpa.springjpa.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springjpa.springjpa.entities.Employee;

import java.util.List;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Integer> {
    Employee findById(int id);
    List<Employee> findByEmployeename(String employeename);

    List<Employee>findByDepartmentAndAgeLessThanEqual(String department, int age);
    List<Employee>findByDepartmentAndAgeGreaterThanEqual(String department, int age);

    List<Employee>findByEmployeenameStartingWith(String employeename);

}
