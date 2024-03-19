<%@page import="ecom.pojo.Vendor"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
</head>
<body>

	<%Vendor vendor=(Vendor)session.getAttribute("vendor"); %>
	<div align="center">
		<form action="VendorServlet" method="post">
			<input type="hidden" name="action" value="updateVendor">
			<table border="1" cellspacing="10" cellpadding="10">
				<tr>
					<th>Id</th>
					<td><input type="text" name="id" value=<%=vendor.getId()%> required="required"></td>
				</tr>

				<tr>
					<th>Name</th>
					<td><input type="text" name="name" value=<%=vendor.getName()%> required="required"></td>
				</tr>
				<tr>
					<th>Email</th>
					<td><input type="email" name="email" value=<%=vendor.getEmail()%> required="required"></td>
				</tr>
				<tr>
					<th>contact</th>
					<td><input type="text" name="contact"value=<%=vendor.getContact()%> required="required"></td>
				</tr>
				<tr>
					<th>Password</th>
					<td><input type="password" name="password" value=<%=vendor.getPassword()%> required="required"></td>
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