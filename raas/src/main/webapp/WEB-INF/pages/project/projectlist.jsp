<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/2.2.2/jquery.min.js"></script>
<link
	href="http://code.jquery.com/ui/1.10.4/themes/ui-lightness/jquery-ui.css"
	rel="stylesheet">

<!-- CSS Section Start -->

<spring:url
	value="/resources/common/vendors/wizard/jquery-steps/css/wizard.css"
	var="css2" />
<spring:url
	value="/resources/common/vendors/wizard/jquery-steps/css/jquery.steps.css"
	var="css3" />
<spring:url
	value="/resources/common/vendors/jasny-bootstrap/css/jasny-bootstrap.css"
	var="cs" />
<spring:url value="/resources/common/vendors/select2/select2.min.css"
	var="css4" />
<spring:url value="/resources/common/css/pages/wizard.css" var="css11" />

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
<spring:url value="/resources/common/resource/css/formscrollbar.css"
	var="scroll" />

<!-- JS Section Start -->

<spring:url
	value="/resources/common/vendors/daterangepicker/moment.min.js"
	var="js7" />
<spring:url
	value="/resources/common/vendors/wizard/jquery-steps/js/jquery.steps.js"
	var="js4" />
<spring:url
	value="/resources/common/vendors/wizard/jquery-steps/js/jquery.validate.min.js"
	var="js5" />
<spring:url
	value="/resources/common/vendors/jasny-bootstrap/js/jasny-bootstrap.js"
	var="js3" />
<spring:url value="/resources/common/vendors/select2/select2.min.js"
	var="js6" />
<spring:url value="/resources/common/js/pages/form_wizard.js" var="js2" />
<spring:url
	value="/resources/common/resource/js/bootstrap-tagsinput.min.js"
	var="js1" />
<spring:url value="/resources/common/statesMembernew.js" var="states"></spring:url>
<spring:url value="/resources/common/js/taskdetail.js" var="js8" />
<spring:url value="/resources/common/js/project_list.js" var="js9" />

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
<link href="${scroll}" rel="stylesheet">

<script src="${js7}"></script>
<script src="${js9}"></script>
<script src="${js8}"></script>
<script src="${js4}"></script>
<script src="${js2}"></script>
<script src="${js6}"></script>
<script src="${js3}"></script>
<script src="${js5}"></script>
<script src="${js1}"></script>
<script src="${states}"></script>

</head>
<body>

	<!-- Container Section Start -->
	<div class="container">
		<div>
			<button type="Submit" class="btn btn-success pull-right"
				id="pro_register" data-dismiss="modal">
				<a href="${pageContext.request.contextPath}/crt/projectInfo">
					Create Project </a> <i class="fa fa-plus"></i>
			</button>
		</div>
		<br> <br> <br>
		<!--section ends-->
		<section class="content">
			<div class="row">
				<div class="col-lg-12">
					<div class="panel panel-primary">
						<div class="panel-heading">
							<h3 class="panel-title">
								<i class="livicon" data-name="bell" data-size="16"
									data-loop="true" data-c="#fff" data-hc="white"></i> New Project
							</h3>
							<span class="pull-right clickable"> <i
								class="glyphicon glyphicon-chevron-up"></i>
							</span>
						</div>

						<div class="panel-body">

							<div class="row">
								<form:form id="viewprojects" name="viewprojects" method="GET"
									action="${pageContext.request.contextPath}/crt/tasks">
									<table class="table table-striped table-bordered"
										id="projectdetails">
										<thead class="table table-striped table-bordered">
											<tr>
												<th>Project Id</th>
												<th>Project Name</th>
												<th>Project Description</th>
											</tr>
										</thead>
										<tbody id="projectdetailbody"
											class="table table-striped table-bordered">
											<c:forEach items="${userproject}" var="record">
												<tr id="${record.project_id}" class="taskrow"
													data-href="tasks">
													<td id="project_id"><a href="#"></input>${record.project_id}</a></td>
													<td id="project_name">${record.project_name}</td>
													<td id="project_desc">${record.project_desc}</td>

												</tr>
											</c:forEach>
										</tbody>
									</table>
								</form:form>
							</div>

						</div>
						<!--main content end-->
					</div>
				</div>
			</div>
	</div>
	</section>
	<!-- content -->
	<!-- //Content Section End -->
	</div>
	<!-- //Container end -->


</body>
</html>