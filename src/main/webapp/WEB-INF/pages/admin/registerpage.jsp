<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Register | Welcome to RaaS</title>
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/2.2.2/jquery.min.js"></script>

<spring:url value="resources/common/css/frontend/bootstrap.min.css"
	var="css1" />

<spring:url value="resources/common/vendors/iCheck/skins/all.css"
	var="css2" />

<spring:url value="resources/common/css/frontend/register.css"
	var="css3" />

<spring:url value="resources/common/regis.js" var="js1" />


<link
	href="http://code.jquery.com/ui/1.10.4/themes/ui-lightness/jquery-ui.css"
	rel="stylesheet">


<link href="${css1}" rel="stylesheet">
<link href="${css2}" rel="stylesheet">
<link href="${css3}" rel="stylesheet">

<script src="${js1}"></script>
</head>

<jsp:include page="/WEB-INF/pages/layout/header.jsp" />
<div class="container">
	<!--Content Section Start -->
	<div class="row">
		<div class="box">
			<h3 class="text-primary">Register</h3>

			<form id="f" action="${pageContext.request.contextPath}/register"
				method="post">
				<!-- CSRF Token -->
				<input type="hidden" name="_token" value="" />

				<div class="form-group">
					<label class="sr-only"> First Name</label> <input type="text"
						class="form-control" id="first_name" name="first_name"
						placeholder="First Name" value="" required> <span
						class="help-block"></span>
				</div>
				<div class="form-group">
					<label class="sr-only"> Last Name</label> <input type="text"
						class="form-control" id="last_name" name="last_name"
						placeholder="Last Name" value="" required> <span
						class="help-block"></span>
				</div>
				<div class="form-group">
					<label class="sr-only"> Email</label> <input type="email"
						class="form-control" id="email" name="email" placeholder="Email"
						value="" required> <span class="help-block"></span>
				</div>
				<div class="form-group">
					<label class="sr-only"> Password</label> <input type="password"
						class="form-control" id="password" name="password"
						placeholder="Password" required> <span class="help-block"></span>
				</div>
				<div class="form-group">
					<label class="sr-only"> Confirm Password</label> <input
						type="password" class="form-control" id="cfmPassword"
						name="cfmPassword" placeholder="Confirm Password" required>
					<span class="help-block"></span>
				</div>
				<div class="checkbox">
					<label> <input type="checkbox" name="subscribed"
						id="subscribed">I accept <a href="#"> Terms and
							Conditions</a>
					</label>
				</div>
				<div class="form-group">
					<input type="submit" class="btn btn-primary" value="Create Work"
						id="sub" name="sub"> <input type="submit"
						class="btn btn-primary" id="sub1" name="sub1"
						value="Ready for work">
				</div>
				Already have an account? Please <a href="login"> Sign In</a>
			</form>
		</div>
	</div>
	<!-- //Content Section End -->
</div>
<jsp:include page="/WEB-INF/pages/layout/footer.jsp" />

</html>