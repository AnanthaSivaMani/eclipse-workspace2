package in.vamsoft.servlet;

import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import in.vamsoft.dao.EmployeeDaoImpl;
import in.vamsoft.model.Employee;

/**
 * Servlet implementation class UpdateServlet
 */
@WebServlet("/UpdateServlet")
public class UpdateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		int employeeId = Integer.parseInt(request.getParameter("empId"));
		EmployeeDaoImpl employeeDaoImpl = new EmployeeDaoImpl();
		Employee employee = employeeDaoImpl.getEmployeeById(employeeId);
		HttpSession session = request.getSession();
		session.setAttribute("employee", employee);
		response.sendRedirect("update.jsp");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int employeeId=Integer.parseInt(request.getParameter("empId"));
		String employeeName=request.getParameter("empName");
		double salary=Double.parseDouble(request.getParameter("salary"));
		String date=request.getParameter("hireDate");
		DateTimeFormatter formatter_1=DateTimeFormatter.ofPattern("yyyy-MM-dd");
		LocalDate doj= LocalDate.parse(date,formatter_1);
		int deptId=Integer.parseInt(request.getParameter("departmentId"));
		Employee employee=new Employee(employeeId, employeeName, salary, doj, deptId);
		EmployeeDaoImpl  employeeDaoImpl =new EmployeeDaoImpl();
		employeeDaoImpl.updateEmployee(employee);
		List<Employee> employees=  employeeDaoImpl.getEmployeesByDepartment(deptId);
		HttpSession session = request.getSession();
		session.setAttribute("employees", employees);
		response.sendRedirect("empdetails.jsp");
		
		
	}

}
