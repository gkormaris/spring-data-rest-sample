package gr.codeschool.spring.sample.model;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name="employee")
public class Employee implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
	private Long id;

    @Column(name = "name")
	private String name;

    @Column(name = "age")
	private Integer age;

    @Column(name = "email", unique = true)
    private String email;

	@OneToOne(fetch = FetchType.EAGER)
	@JoinColumn(name="dep_id", nullable=true)
	private Department department;

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

	public Employee(){}
	
	public Employee(String name, int age, String email) {
		this.name = name;
		this.age = age;
        this.email = email;
	}
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}

	public String toString() {
		return "Employee (" + getId() + ", " + getName() + ", " + age + ")";
	}

	public Department getDepartment() {
		return department;
	}

	public void setDepartment(Department department) {
		this.department = department;
	}
	
	@Override
	public boolean equals(Object obj) {

		if (this == obj) {
			return true;
		}

		if (this.id == null || obj == null || !(this.getClass().equals(obj.getClass()))) {
			return false;
		}

		Employee o = (Employee) obj;

		return this.id.equals(o.getId());
	}

	@Override
	public int hashCode() {
		return id == null ? 0 : id.hashCode();
	}

}
