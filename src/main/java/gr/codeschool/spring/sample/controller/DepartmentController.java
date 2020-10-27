package gr.codeschool.spring.sample.controller;

import gr.codeschool.spring.sample.model.Department;
import gr.codeschool.spring.sample.service.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/departments")
public class DepartmentController {

    @Autowired
    private DepartmentService departmentService;

    @GetMapping
    public List<Department> list() {
        return departmentService.getDepartments();
    }

    @GetMapping(value="/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public Department getDepartment(@PathVariable Long id) {
        return departmentService.getDepartment(id);
    }

}
