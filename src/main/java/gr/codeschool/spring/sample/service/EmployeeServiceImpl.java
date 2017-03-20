package gr.codeschool.spring.sample.service;

import gr.codeschool.spring.sample.model.Employee;
import gr.codeschool.spring.sample.repository.EmployeeRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    private static final Logger LOGGER = LoggerFactory.getLogger(EmployeeServiceImpl.class);

    @Autowired
    private EmployeeRepository employeeRepository;

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
    public void createEmployee(Employee employee) {
        LOGGER.info("createEmployee ( " + employee + ") ");

        employeeRepository.save(employee);

        LOGGER.info("createEmployee created employee ( " + employee + " ) !");
    }

}
