<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<spring:url value="/resources/common/js/jquery-1.11.1.min.js" var="js1" />
<spring:url
	value="/resources/common/vendors/form_builder1/js/jquery.ui.min.js"
	var="js2" />
<spring:url value="/resources/common/js/pages/moment.js" var="js3" />
<spring:url
	value="/resources/common/vendors/datepicker/js/bootstrap-datepicker.js"
	var="js4" />
<spring:url
	value="/resources/common/vendors/fullcalendar/fullcalendar.min.js"
	var="js6" />
<spring:url value="/resources/common/vendors/fullcalendar/moment.min.js"
	var="js7" />
<spring:url value="/resources/common/vendors/charts/jquery.sparkline.js"
	var="js8" />
<spring:url value="/resources/common/js/bootstrap.min.js" var="js10" />
<spring:url value="/resources/common/vendors/Knob/js/jquery.knob.js"
	var="js11" />
<spring:url value="/resources/common/js/pages/knob_page.js" var="js12" />
<spring:url value="/resources/common/js/sortableportlets.js" var="js13" />


<spring:url value="/resources/common/js/toastr.js" var="js16" />

<script src="${js1}"></script>
<script src="${js2}"></script>
<script src="${js3}"></script>
<script src="${js4}"></script>
<script src="${js6}"></script>
<script src="${js7}"></script>
<script src="${js8}"></script>
<script src="${js10}"></script>
<script src="${js11}"></script>
<script src="${js12}"></script>
<script src="${js13}"></script>
<script src="${js16}"></script>


<spring:url
	value="resources/common/vendors/wizard/jquery-steps/css/wizard.css"
	var="css2" />
<spring:url
	value="resources/common/vendors/wizard/jquery-steps/css/jquery.steps.css"
	var="css3" />
<spring:url
	value="resources/common/vendors/jasny-bootstrap/css/jasny-bootstrap.css"
	var="cs" />
<spring:url value="resources/common/vendors/select2/select2.min.css"
	var="css4" />
<spring:url value="resources/common/css/pages/wizard.css" var="css11" />
<spring:url
	value="/resources/common/resource/css/bootstrap-tagsinput.css"
	var="css1" />
<spring:url value="/resources/common/resource/css/formelements.css"
	var="css7" />
<spring:url value="/resources/common/resource/js/wizard.css" var="css5" />
<spring:url
	value="/resources/common/vendors/gallery/fancy_box/jquery.fancybox.css"
	var="css14" />
<spring:url
	value="/resources/common/vendors/gallery/fancy_box/helpers/jquery.fancybox-buttons.css"
	var="css15" />
<spring:url
	value="/resources/common/vendors/gallery/fancy_box/helpers/jquery.fancybox-thumbs.css"
	var="css16" />
<spring:url value="/resources/common/css/frontend/news.css" var="css17" />
<spring:url
	value="/resources/common/vendors/font-awesome/css/font-awesome.min.css"
	var="css18" />
<spring:url value="/resources/common/css/frontend/blog.css" var="css19" />
<spring:url value="/resources/common/resource/css/formscrollbar.css"
	var="css20" />
<spring:url value="/resources/common/resource/dropdown.css" var="css21" />
<spring:url
	value="/resources/common/resource/css/bootstrap-slider.min.css"
	var="css8" />
<spring:url value="/resources/common/css/bootstrap.min.css" var="css12" />
<spring:url value="/resources/common/css/frontend/custom.css"
	var="css13" />



<link href="${css2}" rel="stylesheet">
<link href="${css1}" rel="stylesheet">
<link href="${css7}" rel="stylesheet">
<link href="${css3}" rel="stylesheet">
<link href="${css5}" rel="stylesheet">
<link href="${css11}" rel="stylesheet">
<link href="${css4}" rel="stylesheet">
<link href="${css12}" rel="stylesheet">
<link href="${css13}" rel="stylesheet">
<link href="${css14}" rel="stylesheet">
<link href="${css15}" rel="stylesheet">
<link href="${css16}" rel="stylesheet">
<link href="${css17}" rel="stylesheet">
<link href="${css18}" rel="stylesheet">
<link href="${css19}" rel="stylesheet">
<link href="${css20}" rel="stylesheet">
<link href="${css21}" rel="stylesheet">
<link href="${css8}" rel="stylesheet">
</head>
<body>
	<%@include file="/WEB-INF/pages/layout/header.jsp"%>
	<div class="container">
		<br> <br>
		<h2>Job Search</h2>
		<br> <br>
		<section class="content">
		<div class="row">
			<div class="col-md-2 border-light">
				<!-- <section class="sidebar"> -->
				<div class="center">
					<h4>Categories</h4>
				</div>
				<div class="page-sidebar sidebar-nav align-left">
					<!-- BEGIN SIDEBAR MENU -->
					<ul id="menu" class="page-sidebar-menu">
						<li><a href=""> <span class="title">Java</span>
						</a></li>
						<li><a href=""> <span class="title">.NET</span>
						</a></li>
						<li><a href=""> <span class="title">PHP</span>
						</a></li>
					</ul>
				</div>
				<!--   </section> -->
			</div>
			<div class="col-md-8" id="prodetail">
				<div class="panel panel-white border-strong">

					<div class="panel-heading">

						<c:forEach items="${alljobs}" var="record" varStatus="status">
							<h3 class="warning">${record.project_name}</h3>
							<div class="col-md-3 pull-right" data-toggle="buttons">
								<button
									onclick="location.href = '${pageContext.request.contextPath}/jobdetail?project_id=${record.project_id}';"
									id="myButton" class="float-left submit-button">View
									details</button>
							</div>
					</div>
					<div class="panel-body">
						<p>${record.project_desc}</p>
						<span>Primary Skill: ${record.primary_skill}</span><br> <br>
						<span>Secondary Skill: ${record.secondary_skill}</span>
						<hr>
						</c:forEach>

					</div>
					<!-- panel body end -->

				</div>
			</div>
			<div class="col-md-2"></div>
		</div>
		<!-- row--> </section>
		<!-- //Content Section End -->
	</div>
	<!-- //Container end -->
	<div><%@include file="/WEB-INF/pages/layout/footer.jsp"%></div>
</body>
</html>