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
   <!-- banner -->
    <jsp:include page="banner.jsp"></jsp:include>
    <div align= center>
    
    </div>

	        <!-- Footer-->
        <jsp:include page="footer.jsp"></jsp:include>
        

</body>
</html>