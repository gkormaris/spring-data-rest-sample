package gr.codeschool.spring.sample.service;

import gr.codeschool.spring.sample.model.Employee;
import gr.codeschool.spring.sample.repository.EmployeeRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    private static final Logger LOGGER = LoggerFactory.getLogger(EmployeeServiceImpl.class);

    private Map<String, Integer> cache = new HashMap<>();

    @Autowired
    private EmployeeRepository employeeRepository;

    @Override
    public Employee getEmployee(String id) {
        return employeeRepository.findOne(id);
    }

    @Override
    public Employee getEmployeeByEmail(String email) {
        LOGGER.info("getEmployeeByEmail ( " + email + ") ");

        Employee emp = employeeRepository.findEmployeeByEMail(email);

        LOGGER.info("getEmployeeByEmail return employee ( " + emp + " ) !");
        return emp;
    }

    @Override
    public List<Employee> getEmployeeByName(String name) {
        LOGGER.info("getEmployeeByName ( " + name + ") ");

        List<Employee> emps = employeeRepository.findEmployeesByName(name);

        LOGGER.info("getEmployeeByName return employee ( " + emps + " ) !");
        return emps;
    }

    @Override
    public Employee createEmployee(Employee employee) {
        LOGGER.info("createEmployee ( " + employee + ") ");

        if (cache.containsKey(employee.getEmail())) {
            throw new RuntimeException("You are not allowed to do this");
        }

        Employee employee1 = employeeRepository.save(employee);
        cache.putIfAbsent(employee1.getEmail(), 1);

        LOGGER.info("createEmployee created employee ( " + employee1 + " ) !");
        return employee1;
    }

    @Override
    public List<Employee> getEmployees() {
        return employeeRepository.findAll();
    }

}
