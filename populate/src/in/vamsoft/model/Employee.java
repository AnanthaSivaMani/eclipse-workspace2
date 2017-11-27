package in.vamsoft.model;

import java.time.LocalDate;

import javax.persistence.*;

@Entity
@Table(name = "emp_siva2")
public class Employee {
	@Id
	@Column(name = "EMPLOYEE_ID")
	private int empId;
	@Column(name = "FIRST_NAME")
	private String empName;
	@Column(name = "SALARY")
	private double salary;
	@Column(name = "HIRE_DATE")
	private LocalDate doj;
	@Column(name = "DEPARTMENT_ID")
	private Integer deptId;

	public Employee() {
	}

	public Employee(int empId, String empName, double salary, LocalDate doj, int deptId) {
		super();
		this.empId = empId;
		this.empName = empName;
		this.salary = salary;
		this.doj = doj;
		this.deptId = deptId;
	}

	public int getEmpId() {
		return empId;
	}

	public void setEmpId(int empId) {
		this.empId = empId;
	}

	public String getEmpName() {
		return empName;
	}

	public void setEmpName(String empName) {
		this.empName = empName;
	}

	public double getSalary() {
		return salary;
	}

	public void setSalary(double salary) {
		this.salary = salary;
	}

	public LocalDate getDoj() {
		return doj;
	}

	public void setDoj(LocalDate doj) {
		this.doj = doj;
	}

	public int getDeptId() {
		return deptId;
	}

	public void setDeptId(int deptId) {
		this.deptId = deptId;
	}

}
