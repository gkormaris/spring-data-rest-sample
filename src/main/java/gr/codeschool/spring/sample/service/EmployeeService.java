package gr.codeschool.spring.sample.service;

import gr.codeschool.spring.sample.model.Employee;

import java.util.List;

public interface EmployeeService {

    Employee getEmployeeByEmail(String email);

    List<Employee> getEmployeeByName(String name);

    void createEmployee(Employee employee);

}
