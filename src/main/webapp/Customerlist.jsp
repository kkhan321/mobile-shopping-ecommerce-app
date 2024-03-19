<%@page import="ecom.pojo.Customer"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

 <!-- nav bar -->
    <jsp:include page="Navbar.jsp"></jsp:include>
     
	<%List<Customer> clist=(List<Customer>)session.getAttribute("Customer"); %>
	<div align=center>
	<table border=1 cellspacing=10px cellpadding=10px>
	<tr>
	    <th>Id</th>
		<th>Name</th>
		<td>Email</td>
		<th>Contact</th>
		<th>PAssword</th>
		<th colspan=2>Action</th>
		
	
	</tr>
	<%for(Customer c:clist){ %>
	<tr>
	<td><%=c.getId() %></td>
		<td><%=c.getName() %></td>
		<td><%=c.getEmail() %></td>
		<td><%=c.getContact()%></td>
		<td><%=c.getPassword() %></td>
				<td><a href="CustomerServlet?action=delete&&id=<%=c.getId()%>">Delete</a></td>
               
               <td><a href="CustomerServlet?action=edit&&id=<%=c.getId()%>">Edit</a></td>		
	
	</tr>
	<%}; %>
	</table>
	<h2><a href=index.jsp>Home</a></h2>
	</div>
	
</body>
</html>