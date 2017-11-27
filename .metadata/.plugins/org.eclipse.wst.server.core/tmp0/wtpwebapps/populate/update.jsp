<%@page import="in.vamsoft.model.Employee"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<%Employee employee=(Employee)session.getAttribute("employee"); %>


<form action="UpdateServlet" method="post">
<input name="empId" type="text"  value="<%= employee.getEmpId() %>" readonly="readonly" >
<input name="empName" type="text" value="<%= employee.getEmpName() %>">
<input name="salary" type="text"value="<%= employee.getSalary() %>" >
<input name="hireDate" type="text" value="<%= employee.getDoj() %>" >
<input name="departmentId" value="<%= employee.getDeptId() %>" type="text" >
<input type="submit" value="Update">
</form>



</body>
</html>