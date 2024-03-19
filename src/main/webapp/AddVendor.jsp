<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<%
String message = (String) session.getAttribute("message");
%>
</head>
<body>

 <!-- nav bar -->
    <jsp:include page="Navbar.jsp"></jsp:include>
     

<% String rmsg=(String)request.getAttribute("rmsg"); %>
<div align="center">

		<h1>Add Vendor</h1>
		<%if(rmsg!=null){ %>
			<h3 style="color:red;"><%=rmsg%></h3>
		<%} %>
		
	<%if(message!=null){ %>
	<script type="text/javascript">
	alert("InValid Email and Contact")
	<%}%>
	</script>
		<form action="VendorServlet" method="post">
		<input type="hidden" name="action" value="addVendor">
			<table border="1" cellspacing="10" cellpadding="10">
				<tr>
					<th>Name</th>
					<td><input type="text" name="name" required="required"></td>
				</tr>
				<tr>
					<th>Email</th>
					<td><input type="email" name="email" required="required"></td>
				</tr>
				<tr>
					<th>contact</th>
					<td><input type="text" name="contact" required="required"></td>
				</tr>
				<tr>
					<th>Password</th>
					<td><input type="password" name="password" required="required"></td>
				</tr>
				<tr>
					<th><input type="submit" value="Submit"></th>
					<td><input type="reset" value="Reset"></td>
				</tr>
			</table>

		</form>
	</div>
</body>
</html>