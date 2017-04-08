package gr.codeschool.spring.sample.service;

import gr.codeschool.spring.sample.model.Department;

import java.util.List;

public interface DepartmentService {

    Department getDepartment(Long id);

    List<Department> getDepartments();

}
