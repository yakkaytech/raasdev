<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
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


<link href="http://code.jquery.com/ui/1.10.4/themes/ui-lightness/jquery-ui.css"
	rel="stylesheet">
<link href="${css1}" rel="stylesheet">
<link href="${css2}" rel="stylesheet">
<link href="${css3}" rel="stylesheet">
<script>
$(document).ready(function(){
    $("button").button();
});

</script>

<script>
		$(document).ready(function() {
			$("#submit").click(function(e) {
				e.preventDefault();
				var formid = $("#validateform").serializeArray()
									
				$.ajax({
					url :"forgot",
					contentType : "application/json",				
					mtype : "POST",
					data:formid,			
					dataType : 'json',
					async : false,
					success : function(data) {
						alert(data);
					},
					error : function(jqXHR, textStatus, errorThrown) {
						alert(error);
					}
				});

			});
		});
	</script>
</head>
<body>

<jsp:include page="header.jsp" />
	<div class="container">
		<!--Content Section Start -->
		<div class="row">
			<div class="box">
				<h3 class="text-primary">Forgot Password</h3>
				<p>Enter your email to send password</p>

				<form id="validateform" >
					<!-- CSRF Token -->
					<input type="hidden" name="_token" value="" />

					<div class="form-group">
						 <input type="text"
							class="form-control" id="email" name="email"
							placeholder="Email" value="" required> <span
							class="help-block"></span>
							<div class="form-group">
							
							<input type="submit" class="btn btn-primary" value="Reset Your Password"
							id="submit" name="submit">
						
							
							
					</div>
							
				</form>
			</div>
		</div>
		<!-- //Content Section End -->
	</div>
	<jsp:include page="footer.jsp" />
</body>
</html>