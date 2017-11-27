package in.vamsoft.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import in.vamsoft.model.Department;
import in.vamsoft.model.Employee;

public class EmployeeDaoImpl {
	
	Connection connection=null;
	public EmployeeDaoImpl() {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			connection=DriverManager.getConnection("jdbc:oracle:thin:@192.168.10.77:1521:xe","hr","password");  
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		} 
		
	}
	
	
	public List<Employee> getEmployeesByDepartment(int departmentId){
		 List<Employee>  employees=new ArrayList<>();
		 ResultSet resultSet=null;
		 try(PreparedStatement preparedStatement=connection.prepareStatement("select * from emp_siva2  where department_id=?")){
			 preparedStatement.setInt(1, departmentId);
			 resultSet = preparedStatement.executeQuery();
			 while(resultSet.next()) {
				 Employee employee= new Employee();
				 employee.setEmpId(resultSet.getInt(1));
				 employee.setEmpName(resultSet.getString(2));
				 employee.setSalary(resultSet.getDouble(3));
				 employee.setDoj(resultSet.getDate(4).toLocalDate());
				 employee.setDeptId(resultSet.getInt(5));
				 employees.add(employee);
			 }

		 } catch (SQLException e) {
			e.printStackTrace();
		}
		return employees;
	}
	
	public Employee getEmployeeById(int empId) {
		Employee employee=null;
		 ResultSet resultSet=null;
		 try(PreparedStatement preparedStatement=connection.prepareStatement("select * from emp_siva2  where employee_id=?")){
			 preparedStatement.setInt(1, empId);
			 resultSet = preparedStatement.executeQuery();
			 while(resultSet.next()) {
				 employee= new Employee();
				 employee.setEmpId(resultSet.getInt(1));
				 employee.setEmpName(resultSet.getString(2));
				 employee.setSalary(resultSet.getDouble(3));
				 employee.setDoj(resultSet.getDate(4).toLocalDate());
				 employee.setDeptId(resultSet.getInt(5));
			 }
		 } catch (SQLException e) {
			e.printStackTrace();
		}
		return employee;
	}
	
	
	public boolean updateEmployee(Employee employee) {
		int result=0;
		 try(PreparedStatement preparedStatement=connection.prepareStatement("update emp_siva2 set first_name=?,salary=?,department_id=? where employee_id=?")){
			 preparedStatement.setString(1, employee.getEmpName());
			 preparedStatement.setDouble(2, employee.getSalary());
			 preparedStatement.setInt(3, employee.getDeptId());
			 preparedStatement.setInt(4, employee.getEmpId());
			 result=preparedStatement.executeUpdate();
		 } catch (SQLException e) {
			e.printStackTrace();
		}
		return result>0?true:false;
	}
	
	
	
	
	public List<Department> getAllDepartments(){
		List<Department> departments=new ArrayList<>();		
		 ResultSet resultSet=null;
		 try(PreparedStatement preparedStatement=connection.prepareStatement("select * from departments")){
			 resultSet = preparedStatement.executeQuery();
			 while(resultSet.next()) {
				 Department department= new Department();
				department.setDepartmentId(resultSet.getInt(1));
				department.setDepartmentName(resultSet.getString(2));
				departments.add(department);
			 }
		 } catch (SQLException e) {
			e.printStackTrace();
		}
		return departments;
	}
	
	public boolean deleteEmployee(int empId) {
		int result=0;
		try(PreparedStatement preparedStatement=connection.prepareStatement("delete  from emp_siva2  where employee_id=?")){
			preparedStatement.setInt(1, empId);
			result=preparedStatement.executeUpdate();
			
		 } catch (SQLException e) {
			e.printStackTrace();
		}

		return result>0?true:false;
		
	}

}
