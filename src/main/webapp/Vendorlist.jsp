<%@page import="ecom.pojo.Vendor"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<body>

   <!-- nav bar -->
    <jsp:include page="Navbar.jsp"></jsp:include>
     
<%List<Vendor> vlist=(List<Vendor>)session.getAttribute("vlist"); %>
	<div align=center>
		<table border=1 cellspacing=10px cellpadding=10px>
			<tr>
				<th>Id</th>
				<th>Name</th>
		    	<th>email</th>
		    	<th>contact</th>
		    	<th>password</th>
		    	<th colespan=3>Action</th>
				
			</tr>
			<%for(Vendor v:vlist) {%>
	<tr>
	<td><%=v.getId() %></td>
		<td><%=v.getName() %></td>
		<td><%=v.getEmail() %></td>
		<td><%=v.getContact()%></td>
		<td><%=v.getPassword() %></td>
		<td><a href="VendorServlet?action=delete&&id=<%=v.getId()%>">Delete</a></td>
               
          <td><a href="VendorServlet?action=edit&&id=<%=v.getId()%>">Edit</a></td>		
	
	</tr>
	<%}; %>
	
		</table>
	<h2><a href=index.jsp>Home</a></h2>
	</div>
</body>
</head>
</html>