package gr.codeschool.spring.sample.controller;

import gr.codeschool.spring.sample.model.Employee;
import gr.codeschool.spring.sample.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@RestController
@RequestMapping("/employee")
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    @GetMapping
    public String hello() {
        return "hello";
    }

    @GetMapping(value="/{name}", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Employee> getEmployee(@PathVariable String name) {
        return employeeService.getEmployeeByName(name);
    }

    @PostMapping(value="/create")
    public ModelAndView save(@RequestParam String name,
                             @RequestParam Integer age,
                             @RequestParam String email) {
        //TODO YK: add validations
        Employee newEmp = new Employee(name, age, email);
        employeeService.createEmployee(newEmp);
        return new ModelAndView("redirect:/employee/"+email);
    }

}
