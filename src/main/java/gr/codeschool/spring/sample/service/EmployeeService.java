package gr.codeschool.spring.sample.service;

import gr.codeschool.spring.sample.model.Employee;

import java.util.List;

public interface EmployeeService {

    Employee getEmployee(Long id);

    Employee getEmployeeByEmail(String email);

    List<Employee> getEmployeeByName(String name);

    Employee createEmployee(Employee employee);

    List<Employee> getEmployees();

}
