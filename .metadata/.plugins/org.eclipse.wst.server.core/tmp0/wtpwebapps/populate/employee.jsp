<%@page import="in.vamsoft.dao.EmployeeDaoImpl,java.util.List,in.vamsoft.model.Department"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>

<%

EmployeeDaoImpl  employeeDaoImpl =new EmployeeDaoImpl();
List<Department> departments=  employeeDaoImpl.getAllDepartments();

%>
<form action="GetEmployeesServlet">
<select name="emp">

<% for(Department d: departments){%>

<option value="<%= d.getDepartmentId() %>" ><%= d. getDepartmentName() %></option>
<% }%>
</select>
<input type="submit" value="Get Employees">
</form>
</body>
</html>