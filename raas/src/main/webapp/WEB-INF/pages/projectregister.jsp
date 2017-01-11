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
	<jsp:include page="layout/header.jsp" />
	<!-- Container Section Start -->
	<div class="container">
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
							<!--main content-->
							<div class="row">
								<div class="col-md-12">
									<h3>New Projct Wizard</h3>
									<!-- BEGIN FORM WIZARD WITH VALIDATION -->
									<form id="wizard-valid" action="wizard-valid">
										<h1 class="hidden-xs">Project Details</h1>
										<section>
											<h2 class="hidden">&nbsp;</h2>

											<div class="row">
												<div class="col-lg-6">
													<div class="form-group">
														<label for="projecttype">Project Type *</label> <select
															id="projecttype" class="form-control required"
															name="project_type">
															<c:forEach items="${project_type}" var="record">
																<option value="${record.project_id}">${record.project_type}</option>
															</c:forEach>
														</select>
													</div>
													<div class="form-group">
														<label for="projectname">Project Name *</label> <input
															id="projectname" name="project_name" type="text"
															placeholder="Project Name" class="form-control required">
													</div>
													<div class="form-group">
														<label for="description">Project Description *</label>
														<textarea class="form-control" rows="4" id="description"
															name="project_desc" placeholder="Description"></textarea>
													</div>
													<p>(*) Mandatory</p>
												</div>
												<div class="col-lg-1">&nbsp;</div>
												<div class="col-lg-5">
													<!-- Box Start -->
													<div class="box">
														<div class="box-icon box-icon1">
															<i class="livicon icon1" data-name="user" data-size="55"
																data-loop="true" data-c="#418bca" data-hc="#418bca"></i>
														</div>
														<div class="info">
															<h3 class="primary text-center">Add a Project
																Planner</h3>
															<p>Project planners can help plan, organize and
																control the project. The planners can also help
																decompose project into smaller tasks, assist in
																identifying right project team, verify and sign-off the
																tasks to complete. Depends on your size and compexity,
																you may add a planner to the team. If you are not sure
																at this time, you can always add later.
														</div>

														<div align="center" class="form-group">
															<input type="checkbox" id="checkboxes" name="my-checkbox"
																data-size="small">

														</div>
													</div>
												</div>
										</section>
										<h1 class="hidden-xs">Technology</h1>
										<section>
											<h2 class="hidden">&nbsp;</h2>
											<div class="row">
												<div class="col-lg-6">
													<div class="form-group">
														<label for="skill">Primary technology stack *</label><br>
														<select id="skill" class="form-control required"
															name="skill" style="width: 100%">
															<c:forEach items="${skill}" var="record">
																<option value="${record.skill_id}">${record.skill_name}</option>
															</c:forEach>
														</select>
													</div>
													<div class="form-group">
														<label for="description">Add other technologies</label>
														<textarea class="form-control" rows="4"
															data-role="tagsinput" id="skill_other_name"
															name="skill_other_name" placeholder="technology"
															class="form-control required"></textarea>
													</div>
													<p>(*) Mandatory</p>
												</div>
												<div class="col-lg-1">&nbsp;</div>
												<div class="col-lg-5">
													<!-- Box Start -->
													<div class="box">
														<div class="box-icon box-icon1">
															<i class="livicon icon1" data-name="user" data-size="55"
																data-loop="true" data-c="#418bca" data-hc="#418bca"></i>
														</div>
														<div class="info">
															<h3 class="primary text-center">Add an Cloud
																Architect</h3>
															<p>The cloud architect has demonstrated proficiency
																in the technical architecture that underlies cloud
																platform and cloud based IT resources and solutions, and
																has mastered the hands-on application of design
																patterns, principles, and practices used to engineer and
																evolve environments.
														</div>

														<div align="center" class="form-group">
															<input type="checkbox" id="checkboxes" name="my-checkbox"
																data-size="small">

														</div>
													</div>
												</div>
										</section>
										<h1>Other details</h1>
										<section>
											<div class="row" style="height: 160px;">
												<div class="col-lg-6">
													<h4>Project Location</h4>
													<div class="form-group">
														<label for="country">Country</label>
														<div>
															<select name="country" id="select2_Country"
																class="dropstate">
																<c:forEach items="${country}" var="record">
																	<option value="${record.country_id}">${record.country_name}</option>
																</c:forEach>
															</select>
														</div>
													</div>
													<div class="form-group">
														<label for="state"> State/Zone: </label><br> <select
															name="zone" id="select2_StateZone" class="dropstate">
															<c:forEach items="${statezone}" var="record">
																<option value="${record.state_id}">${record.state_name}</option>
															</c:forEach>

														</select>
													</div>
													<div class="form-group">
														<label for="timezone"> Please select your
															timezone. This would help us to find resources within
															your timezone: </label><br> <select name="timezone"
															id="timezone" class="dropstate">

															<c:forEach items="${timezone}" var="record">
																<option value="${record.timezone_id}">${record.timezone_name}</option>
															</c:forEach>
														</select>
													</div>
													<div class="form-group">
														<label for="budget"> Any budget estimates? </label><br>
														<input id="budget" type="text" value="0" name="budget"
															class="form-control">
													</div>
													<div class="form-group">
														<label for="timelines"> Any timelines? </label> <select
															name="timelines" id="timelines" class="dropstate">
															<option value="">
																<c:forEach items="${timeline}" var="record">
																	<option value="${record.category_code}">${record.category_name}</option>
																</c:forEach>
														</select>
													</div>
												</div>
												<h4>Terms and Conditions</h4>
												<div class="col-lg-6">
													<div class="form-group">
														<textarea class="form-control" rows="10"
															data-role="tagsinput"
															placeholder="scrollable terms and condition goes here"
															class="form-control required" read-only></textarea>
													</div>
													<div class="pos-rel p-l-30">
														<input id="acceptTerms" name="acceptTerms" type="checkbox"
															class="pos-rel p-l-30 required"> <label
															for="acceptTerms">I agree with the Terms and
															Conditions.</label>
													</div>
												</div>
												<!-- end of col 2 -->
											</div>
											<!-- end of row -->
										</section>
									</form>
								</div>
							</div>
						</div>
					</div>
				</div>
				</selection>

			</div>
		</section>

		<!-- //Content Section End -->

		<!-- //Container end -->
		<%@include file="/WEB-INF/pages/layout/footer.jsp"%>
</body>
</html>