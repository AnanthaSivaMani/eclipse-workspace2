package in.vamsoft.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import in.vamsoft.dao.EmployeeDaoImpl;

/**
 * Servlet implementation class DeleteServlet
 */
@WebServlet("/DeleteServlet")
public class DeleteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
   
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		int employeeId=Integer.parseInt(request.getParameter("empId"));
		int departmentId=Integer.parseInt(request.getParameter("deptId"));
		EmployeeDaoImpl  employeeDaoImpl =new EmployeeDaoImpl();
		boolean result=employeeDaoImpl.deleteEmployee(employeeId);
		System.out.println(employeeId);
		if(result)
			
			response.sendRedirect("GetEmployeesServlet?emp="+departmentId+"");
		else
			out.println("Employee not available in our Database");

	}

}
