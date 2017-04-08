package gr.codeschool.spring.sample.service;

import gr.codeschool.spring.sample.model.Department;
import gr.codeschool.spring.sample.repository.DepartmentRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DepartmentServiceImpl implements DepartmentService {

    private static final Logger LOGGER = LoggerFactory.getLogger(DepartmentServiceImpl.class);

    @Autowired
    private DepartmentRepository departmentRepository;

    @Override
    public Department getDepartment(Long id) {
        LOGGER.info("getDepartment ( {} ) ", id);

        Department dep = departmentRepository.findOne(id);

        LOGGER.info("getDepartment: {} ", dep);
        return dep;
    }

    @Override
    public List<Department> getDepartments() {
        LOGGER.info("getDepartments () ");
        List<Department> all = departmentRepository.findAll();
        LOGGER.info("getDepartments: {} ", all);
        return all;
    }
}
