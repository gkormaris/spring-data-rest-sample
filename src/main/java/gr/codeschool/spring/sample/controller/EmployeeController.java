package gr.codeschool.spring.sample.controller;

import gr.codeschool.spring.sample.model.Employee;
import gr.codeschool.spring.sample.model.EmployeeDto;
import gr.codeschool.spring.sample.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/employees")
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    @GetMapping
    public List<Employee> list() {
        return employeeService.getEmployees();
    }

    @GetMapping(value="/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public Employee getEmployee(@PathVariable Long id) {
        return employeeService.getEmployee(id);
    }

    @GetMapping(value="/name/{name}", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Employee> getEmployeesByName(@PathVariable String name) {
        return employeeService.getEmployeeByName(name);
    }

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public Employee save(@RequestBody EmployeeDto employeedto) {
        Employee newEmp = employeeService.createEmployee(new Employee(employeedto.getName(), employeedto.getAge(), employeedto.getEmail()));
        return newEmp;
    }

}
