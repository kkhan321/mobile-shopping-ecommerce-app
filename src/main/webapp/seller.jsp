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

	<section class="py-5">
		<div class="container px-4 px-lg-5 mt-5">
				<div class="row gx-4 gx-lg-5 row-cols-2 row-cols-md-3 row-cols-xl-4 justify-content-center">
				                    <div class="col mb-5">
                        <div class="card h-100">                            
                            <div class="card-body p-4">
                                <div class="text-center">                                    
                                    <h5 class="fw-bolder"></h5>                                    
                                   	<h2><a href="vendorlogin.jsp">Login</a></h2>
                                </div>
                            </div>
                            
                        </div>
                    </div>    
                    
						<!-- Product actions-->

						<div class="col mb-5">
							<div class="card h-100">
								<div class="card-body p-4">
									<div class="text-center">
										<h5 class="fw-bolder"></h5>
										<h2>
											<a href="AddVendor.jsp">Register</a>
										</h2>
									</div>
								</div>
							</div>
						</div>

					</div>
				</div>
				
				
	</section>
	<!-- Footer-->
	<jsp:include page="footer.jsp"></jsp:include>


</body>
</html>