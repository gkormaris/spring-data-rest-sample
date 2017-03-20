package gr.codeschool.spring.sample;

import java.net.URISyntaxException;
import java.util.List;

import javax.sql.DataSource;

import gr.codeschool.spring.sample.model.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import gr.codeschool.spring.sample.repository.EmployeeRepository;

@Transactional(propagation = Propagation.REQUIRED)
public class SpringDataJpaExampleUsingAnnotation {

	@Autowired
	private EmployeeRepository employeeRepository;
	
	@Autowired
	private DataSource dataSource;

	public static void main(String[] args) throws URISyntaxException, Exception {
		AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext();
		try {
			ctx.register(SpringDataJpaExampleUsingAnnotation.class);
			ctx.refresh();
			System.out.println("Load context");
			SpringDataJpaExampleUsingAnnotation s = (SpringDataJpaExampleUsingAnnotation) ctx.getBean("mainBean");

			System.out.println("Add employees");
			s.addEmployees();
			System.out.println("Find all employees");
			s.findAllEmployees();
			System.out.println("Find employee by name 'Joe'");
			s.findEmployee("Joe");
			System.out.println("Find employee by name 'John'");
			s.findEmployee("John");
			System.out.println("Find employees by age");
			s.findEmployeesByAge(32);
			System.out.println("Find employees between 30 and 45");
			s.findEmployeesBetweenAge(30, 45);
			System.out.println("Find employees greater than 20");
			s.findEmployeesGreaterThanAgePageWise(20, 1, 0);
			s.findEmployeesGreaterThanAgePageWise(20, 1, 1);
			s.findEmployeesGreaterThanAgePageWise(20, 2, 0);
			s.findEmployeesGreaterThanAgePageWise(20, 2, 1);
		} finally {
			ctx.close();
		}
	}

	public void addEmployees() {
		Employee emp1 = new Employee("Richard", 32, "richard@mail.com");
		Employee emp2 = new Employee("Satish", 30, "satish@mail.com");
		Employee emp3 = new Employee("Priya", 16, "priya@mail.com");
		Employee emp4 = new Employee("Rimi", 30, "rimi@mail.com");
		
		employeeRepository.save(emp1);
		employeeRepository.save(emp2);
		employeeRepository.save(emp3);
		employeeRepository.save(emp4);
	}

	public void findAllEmployees() {
		employeeRepository.findAll().forEach(System.out::println);
	}

	public void findEmployee(String name) {
		List<Employee> empList = employeeRepository.findEmployeesByName(name);
		System.out.println("Employee list: " + empList);
	}

	public void findEmployeesByAge(int age) {
		List<Employee> empList = employeeRepository.findEmployeesByAge(age);
		System.out.println("Employee list: " + empList);
	}
	
	public void findEmployeesBetweenAge(int from, int to) {
		List<Employee> empList = employeeRepository.findEmployeesBetweenAge(from, to);
		System.out.println("Employee list: " + empList);
	}	
	
	public void findEmployeesGreaterThanAgePageWise(int age, int pageSize, int pageNbr) {
		System.out.println("Page size: " + pageSize + ", page " + pageNbr);
		Pageable pageable = new PageRequest(pageNbr, pageSize, Direction.DESC, "name", "age");
		Page<Employee> page = employeeRepository.findEmployeesByAgeGreaterThan(age, pageable);
		System.out.println(page.getContent());
	}
}
