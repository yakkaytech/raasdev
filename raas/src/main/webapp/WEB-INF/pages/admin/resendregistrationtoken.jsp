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

<body>
	<div class="container">
		<!--Content Section Start -->
		<div class="row">
			<div class="alert alert-info">
				<center>Activation Failed. Resend RegistrationToken</center>
			</div>
			<div class="box">
				<form id="f" name="form" method="POST">
					<!-- CSRF Token -->
					<input type="hidden" name="_token" value="" />
					<div class="form-group">
						<label class="sr-only"> Email</label> <input type="email"
							class="form-control" id="email" name="email" placeholder="Email"
							value="" required> <span class="help-block"></span>
					</div>
					<div class="form-group">
						<button type="submit" class="btn btn-primary"
							formaction="${pageContext.request.contextPath}/resendRegistrationToken">Resend
							Token</button>

					</div>

				</form>
			</div>
		</div>
		<!-- //Content Section End -->
	</div>
</body>
</html>