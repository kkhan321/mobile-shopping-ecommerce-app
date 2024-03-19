<%@page import="ecom.pojo.Customer"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<%Customer customer=(Customer)session.getAttribute("Customer1"); %>
<%//System.out.println(customer); %>
</head>
<body>
<div align=center>
	<form action="CustomerServlet" method ="post">
	<input type=hidden name=action value=updatecustomer>
		<table border=1 cellspacing=10px cellpadding=10px>
		<tr>
		<td>Id</td>
		<td><input type=text Name=id value="<%=customer.getId()%>" required=required></td>
		</tr>
		
		<tr>
		<td>Name</td>
		<td><input type=text Name=name value="<%=customer.getName() %>"required=required></td>
		</tr>
		<tr>
		<td>Email</td>
		<td><input type=email Name=email value="<%=customer.getEmail() %>" required=required></td>
		</tr>
		<tr>
		<td>Contact</td>
		<td><input type=text Name=contact value="<%=customer.getContact() %> " required=required></td>
		</tr>
		<tr>
		<td>Password</td>
		<td><input type=password Name=password value="<%=customer.getPassword() %>" required=required></td>
		</tr>
		<tr>
        <tr>
		<td><input type=submit value=submit></td>
		<td><input type=reset value=reset></td>
		</tr>
		

		</table>
	</form>
</div>
</body>
</html>