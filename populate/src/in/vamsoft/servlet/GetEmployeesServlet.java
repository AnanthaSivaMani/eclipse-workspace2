package in.vamsoft.servlet;

import java.io.IOException;
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
 * Servlet implementation class GetEmployeesServlet
 */
@WebServlet("/GetEmployeesServlet")
public class GetEmployeesServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int departmentId=Integer.parseInt(request.getParameter("emp"));
		EmployeeDaoImpl  employeeDaoImpl =new EmployeeDaoImpl();
		List<Employee> employees=  employeeDaoImpl.getEmployeesByDepartment(departmentId);
		HttpSession session = request.getSession();
		session.setAttribute("employees", employees);	
		response.sendRedirect("empdetails.jsp");
		
		
		
	}

}
