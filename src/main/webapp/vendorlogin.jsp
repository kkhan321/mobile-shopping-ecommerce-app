<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<%
String message = (String) request.getAttribute("message");
%>
<body>
    <!-- nav bar -->
    <jsp:include page="Navbar.jsp"></jsp:include>
    <jsp:include page="banner.jsp"></jsp:include>
    <br><br><br><br>

	<div align=center>
	
	<h1>Seller Login</h1>
	<%if(message!=null){ %>
	<script type="text/javascript">
	alert("InValid uname and password")
	</script>
	<%} %>
	
		<form action="VendorServlet" method="post">
			<input type="hidden" name=action value=vendorLogin>
			<table>
				<tr>
					<th>UserName</th>
					<td><input type=email name=email
						placeholder="enter Email as UserName"></td>
				</tr>
				<tr>
					<th>Password</th>
					<td><input type=password name=password></td>
				</tr>
				<tr>
					<td><input type=submit value=login></td>
					<td><button>
							<a href="AddVendor.jsp">click here for Registeration</a>
						</button></td>
				</tr>


			</table>
		</form>
	</div>
        <br><br><br><br>
        <!-- Footer-->
        <jsp:include page="footer.jsp"></jsp:include>

</body>
</html>