<%@page import="ecom.pojo.Category"%>
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

	<%List<Category> clist=(List<Category>)session.getAttribute("Category"); %>
	<div align=center>
	<table border=1 cellspacing=10px cellpadding=10px>
	<tr>
	    <th>Id</th>
		<th>Name</th>
		<td>Description</td>
		<th colspan=2>Action</th>
		
	
	</tr>
	<%for(Category c:clist){ %>
	<tr>
	<td><%=c.getId() %></td>
		<td><%=c.getName() %></td>
		<td><textarea rows="3" cols="20"><%=c.getDescription() %></textarea></td>
		<td><a href="CategoryServlet?action=delete&&id=<%=c.getId()%>">delete</a></td>
		<td><a href="CategoryServlet?action=edit&&id=<%=c.getId()%>">Edit</a></td>
			
		
	
	</tr>
	<%}; %>
	</table>
	</div>
        <!-- Footer-->
        <jsp:include page="footer.jsp"></jsp:include>
        
	
</body>
</html>