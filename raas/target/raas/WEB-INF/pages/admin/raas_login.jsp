<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>login</title>
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/2.2.2/jquery.min.js"></script>

<spring:url value="resources/common/css/frontend/bootstrap.min.css"
	var="css1" />

<spring:url value="resources/common/vendors/iCheck/skins/all.css"
	var="css2" />

<spring:url value="resources/common/css/frontend/register.css"
	var="css3" />
<spring:url value="/resources/common/mailvalidation.js"
 var="manjs1"/>

<link
	href="http://code.jquery.com/ui/1.10.4/themes/ui-lightness/jquery-ui.css"
	rel="stylesheet">
<link href="${css1}" rel="stylesheet">
<link href="${css2}" rel="stylesheet">
<link href="${css3}" rel="stylesheet">
<script src="${manjs1}"></script>

</head>
<body>
	<div class="container">
		<!--Content Section Start -->
		<div class="row">
			<div class="box">
				<h3 class="text-primary">Login</h3>
				<c:if test="${param.error == 'true'}">
					<div style="color: red; margin: 10px 0px;">

						Login Failed!!!<br /> Reason :
						${sessionScope["SPRING_SECURITY_LAST_EXCEPTION"].message}

					</div>
				</c:if>
				<div style="color: green; margin: 10px 0px;">${message}</div>
				<c:url value="j_spring_security_check" var="loginUrl" />
				<form name='f'
					action="${loginUrl}"
					method='POST'>
					<!-- CSRF Token -->
					

					<div class="form-group">
						<input type="text" class="form-control" id="username"
							name="username" placeholder="Email"> <span
							class="help-block"></span>


					</div>
					<div class="form-group">
						<input type="password" class="form-control" id="password"
							name="password" placeholder="Password" value="" required>
						<span class="help-block"></span>
					</div>


					<div class="checkbox">
						<label> <input type="checkbox" name="subscribed"
							id="subscribed">Remember Password <a href="#"> </a>
						</label>
					</div>
					<div class="form-group">
						<input type="submit" class="btn btn-primary" value="Login"
							id="submit" name="submit">


					</div>
					Don't have an account?<a href="welcome"> Sign up</a>
					<div class="form-group">
						<hr>
						</hr>

						<a href="forgot" style="background-color: lightgrey:">Forgot
							Password?</a>
					</div>
				</form>
			</div>
		</div>
		<!-- //Content Section End -->
	</div>
</body>
</html>