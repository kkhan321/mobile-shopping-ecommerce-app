<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<%
String message = (String) request.getAttribute("c");
%>
<body>
    <!-- nav bar -->
    <jsp:include page="Navbar.jsp"></jsp:include>

	<div align=center>
	
	<h1>User Login</h1>
	<%if(message!=null){ %>
	<script type="text/javascript">
	alert("InValid uname and password")
	</script>
	<%} %>
	
		<form action="LoginServlet" method="post">
			<input type="hidden" name=action value=customerlogin>
			<table>
				<tr>
					<th>UserType</th>
					<td><select>
							<option>Admin</option>
							<option>Customer</option>
					</select></td>
				</tr>
				<tr>
					<th>UserName</th>
					<td><input type=email name=uname
						placeholder="enter Email as UserName"></td>
				</tr>
				<tr>
					<th>Password</th>
					<td><input type=password name=password></td>
				</tr>
				<tr>
					<td><input type=submit value=login></td>
					<td><button>
							<a href="addUser.jsp">click here for Registeration</a>
						</button></td>
				</tr>


			</table>
		</form>
	</div>
        <!-- Footer-->
        <jsp:include page="footer.jsp"></jsp:include>
        

</body>
</html>