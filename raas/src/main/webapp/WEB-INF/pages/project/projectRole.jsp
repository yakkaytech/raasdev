<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>project Role</title>

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
<spring:url value="/resources/common/js/datepicker.js" var="js14" />
<spring:url value="/resources/common/js/project_role.js" var="js15" />


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
<script src="${js14}"></script>
<script src="${js15}"></script>


<spring:url
	value="resources/common/vendors/jasny-bootstrap/css/jasny-bootstrap.css"
	var="cs" />
<spring:url
	value="/resources/common/resource/css/bootstrap-tagsinput.css"
	var="css1" />
<spring:url value="/resources/common/resource/css/formelements.css"
	var="css7" />
<spring:url value="/resources/common/resource/js/wizard.css" var="css5" />
<spring:url
	value="/resources/common/vendors/gallery/fancy_box/helpers/jquery.fancybox-buttons.css"
	var="css15" />
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
<spring:url
	value="/resources/common/vendors/gallery/fancy_box/jquery.fancybox.css"
	var="css14" />
<spring:url value="/resources/common/resource/css/head-foot.css"
	var="css15" />
<spring:url value="/resources/common/css/bootstrap.css" var="css15" />
<link href="${css1}" rel="stylesheet">
<link href="${css7}" rel="stylesheet">
<link href="${css5}" rel="stylesheet">
<link href="${css12}" rel="stylesheet">
<link href="${css13}" rel="stylesheet">
<link href="${css15}" rel="stylesheet">
<link href="${css16}" rel="stylesheet">
<link href="${css17}" rel="stylesheet">
<link href="${css18}" rel="stylesheet">
<link href="${css19}" rel="stylesheet">
<link href="${css20}" rel="stylesheet">
<link href="${css21}" rel="stylesheet">
<link href="${css8}" rel="stylesheet">
<link href="${scroll}" rel="stylesheet">
<link href="${css14}" rel="stylesheet">
<link href="${css15}" rel="stylesheet">

</head>

<body>

	<div><%@include file="/WEB-INF/pages/layout/header.jsp"%></div>
	<!-- Container Section Start-->
	<div class="wrapper">
		<!-- Begin of left-->
		<aside class="left-side sidebar-offcanvas">
			<section class="sidebar">
				<div class="page-sidebar  sidebar-nav">
					<div class="clearfix"></div>
					<!-- BEGIN SIDEBAR MENU -->
				</div>
			</section>
		</aside>
		<!-- end of left-->
		<!-- Begin of right-->
		<aside class="right-side bdr_left">
			<div class="container-fluid">
				<div class="row">
					<div class="col-lg-8">
						<section class="content-header">
							<div class="row">
								<div class="col-md-9">
									<h1>Resources</h1>
								</div>
								<br>
								<c:forEach items="${jobdetail}" var="record">
									<label id="project_id" style="display: none;">${record.project_id}
									</label>
								</c:forEach>
								<br>
								<div class="col-md-3 pull-right" data-toggle="buttons">
									<button type="button" class="btn btn-default"
										data-toggle="modal" id="openNewUserModal">Add new
										User</button>
								</div>
								<br> <br> <br>

							</div>
							<hr>
						</section>
						<section class="content">
							<c:forEach items="${jobdetail}" var="record">
								<div class="row" id="${record.project_role_id}">
									<div class="panel panel-white">
										<div class="panel-heading border-light">
											<h3 class="panel-title">

												<label id="jobname" name="jobname">${record.jobname}</label>


												<label id="jobtype" name="jobtype">(
													${record.jobtype} )</label>



												<div class="col-md-3 pull-right" data-toggle="buttons">
													<button type="button" class="btn btn-default"
														data-toggle="modal" id="editNewUserModal">Edit</button>
												</div>
											</h3>
										</div>
										<div class="panel-body">
											<!-- panel body -->
											<div class="row">
												<div class="col-xs-4">
													<label id="additional_desc"> ${record.job_desc} </label>

													<div>
														<br> <br> <br> <br> <br> <br>
														<br> <br> <br> <label>Project_role_id</label>
														<input id="project_role_id" name="project_role_id"
															value="${record.project_role_id}"> </input>
													</div>
												</div>

												<div class="col-xs-4">
													<div class="form-group">
														<p>
															<b>Rate/hr:</b> <label id="rate" value="${record.rate}">${record.rate}</label>
														</p>
														Min: <label id="rate_min">${record.rate_min}</label> Max:
														<label id="rate_max">${record.rate_max}</label>
													</div>
													<br>
													<div class="form-group">
														<p>
															<b>Frequency:</b> <label id="frequency">
																${record.frequency}</label>
														</p>
														<label id="hrs_per_occurrence">
															${record.no_of_occurrence} hrs per occurence</label>
													</div>
													<br>
													<div class="form-group">
														<p>
															<b>Range of Recurrence:</b>
														</p>
														End date: <label id="ror_end_date">${record.ror_enddate}
														</label>

													</div>
												</div>



												<div class="col-xs-4">
													<div class="form-group">
														<b>+ Invite People</b>
													</div>
													<div class="form-group">
														<b>Shown Interest:</b> 10
													</div>
													<div class="form-group">
														<b>Search Candidates</b>
													</div>
												</div>
											</div>
											<!-- panel body end -->
										</div>

									</div>

								</div>
							</c:forEach>
						</section>
					</div>
					<div class="col-lg-4"></div>
				</div>
			</div>
		</aside>
		<!-- Begin of right-->

		<!--- responsive model -->
		<div class="modal fade" id="addMemberModal" tabindex="-1"
			role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
			<form id="save_addmembers"
				action="${pageContext.request.contextPath}/prjtrole_addmember"
				method="POST">
				<div class="modal-dialog modal-lg full-width">

					<div class="modal-content">
						<div class="modal-header">

							<button type="button" class="close" data-dismiss="modal"
								aria-hidden="true">×</button>
							<h4 class="modal-title">Job specifications</h4>
						</div>
						<div class="modal-body">
							<div class="row">
								<div class="col-md-6">
									<div class="form-group">
										<label for="jobtype">Job Type *</label> <select id="role_id"
											name="role_id" class="form-control required" name="select">
											<c:forEach items="${jobtype}" var="record">
												<option value="${record.role_id}">${record.role_name}</option>
											</c:forEach>
										</select>
									</div>
									<div class="form-group">
										<label for="projectname">Job Title *</label> <input
											id="addjobname" name="jobname" type="text"
											placeholder="Job Name" class="form-control required">
									</div>
									<div class="form-group">
										<label for="description">Job Description *</label>
										<textarea class="form-control" rows="4"
											id="addadditional_desc" name="additional_desc"
											placeholder="Description"></textarea>
									</div>

									<div class="form-group">
										<c:forEach items="${jobdetail}" var="record">
											<input id="project_id" name="project_id"
												style="display: none;" value="${record.project_id}">
											</input>
										</c:forEach>
									</div>

								</div>
								<div class="col-md-6">
									<h4>Rate & Durations</h4>
									<div class="form-group">
										<div class="row">
											<div class="col-xs-2">Rate/hr:</div>
											<div class="col-xs-2">
												<input id="addrate" name="rate" type="text" placeholder="0"
													class="form-control required">
											</div>
											<div class="col-xs-2">Min:</div>
											<div class="col-xs-2">
												<input id="addrate_min" name="rate_min" type="text"
													placeholder="0" class="form-control">
											</div>

											<div class="col-xs-2">Max:</div>
											<div class="col-xs-2">
												<input id="addrate_max" name="rate_max" type="text"
													placeholder="0" class="form-control">
											</div>
										</div>
									</div>
									<hr>
									<h4>Recurrence</h4>
									<div class="form-group">
										<div class="row">
											<div class="col-xs-4">Frequency:</div>
											<div class="col-xs-6">
												<select id="category_code" class="form-control required"
													name="category_code">
													<c:forEach items="${frequency}" var="record">
														<option value="${record.category_code}">${record.category_name}</option>
													</c:forEach>
												</select>
											</div>
										</div>
									</div>
									<div class="form-group">
										<div class="row">
											<div class="col-xs-4">
												<label for="description"> Target Hours: </label>
											</div>
											<div class="col-xs-4">
												<input id="addhours_per_occurrence"
													name="hours_per_occurrence" type="text" placeholder="000"
													class="form-control required">
											</div>
											<div class="col-xs-4 pull-left">
												<label for="description"> per occurrence</label>
											</div>
										</div>
									</div>
									<hr>
									<h4>Range of Recurrence</h4>
									<div class="form-group">
										<div class="row">
											<div class="col-xs-4">
												<div class="radio">
													<label> <input type="radio" name="optionsRadios"
														id="optionsRadios1" value="option1" checked>No End
														Date
													</label>
												</div>
											</div>
										</div>
										<div class="row">
											<div class="col-xs-4">
												<div class="radio">
													<label> <input type="radio" name="optionsRadios"
														id="optionsRadios1" value="option1" checked>No. of
														occurrences
													</label>
												</div>
											</div>
											<div class="col-xs-4 pull-left">
												<input id="occurrence" name="occurrence" type="text"
													placeholder="0" class="form-control required">
											</div>

										</div>
									</div>
									<div class="row">
										<div class="col-xs-4">
											<div class="radio">
												<label> <input type="radio" name="optionsRadios"
													id="optionsRadios1" value="option1" checked>End
													After:
												</label>
											</div>
										</div>
										<div class="col-xs-8 pull-left">
											<input type="date" id="datepicker" data-role="date"
												data-inline="true" onclick="dateselect()">
										</div>
									</div>
								</div>
							</div>
						</div>
					</div>
					<div class="modal-footer">
						<button type="button" data-dismiss="modal" class="btn">Close</button>
						<button type="button" id="addmembers_save" class="btn btn-primary">Save
							changes</button>
					</div>
				</div>
			</form>
		</div>
		<!--Edit Modal -->
		<div class="modal fade" id="editMemberModal" tabindex="-1"
			data-toggle="modal" role="dialog" aria-labelledby="myModalLabel"
			aria-hidden="false">
			<form:form id="edit_addmembers"
				action="${pageContext.request.contextPath}/prjtrole_editmember"
				method="POST">
				<div class="modal-dialog modal-lg full-width">
					<div class="modal-content">
						<div class="modal-header">
							<button type="button" class="close" data-dismiss="modal"
								aria-hidden="true">×</button>
							<h4 class="modal-title">Job specifications</h4>
						</div>
						<div class="modal-body">
							<div class="row">
								<div class="col-md-6">
									<div class="form-group">
										<label for="jobtype">Job Type *</label> <select id="role_id"
											name="role_id" class="form-control required" name="select">
											<c:forEach items="${jobtype}" var="record">
												<option value="${record.role_id}">${record.role_name}</option>
											</c:forEach>
										</select>
									</div>
									<div class="form-group">
										<label for="projectname">Job Title *</label> <input
											id="editjobname" name="jobname" type="text"
											placeholder="Job Name" class="form-control required"
											value="${record.jobname}">
									</div>
									<div class="form-group">
										<label for="description">Job Description *</label>
										<textarea class="form-control" rows="4"
											id="editadditional_desc" name="additional_desc"
											placeholder="Description" value="${record.additional_desc}"></textarea>
									</div>
									<div class="form-group">
										<c:forEach items="${jobdetail}" var="record">
											<input id="project_id" style="display: none;"
												name="project_id" value="${record.project_id}">${record.project_id}
                                        </c:forEach>
									</div>
									<div class="form-group">
										<c:forEach items="${jobdetail}" var="record">
											<input id="project_role_id" name="project_role_id"
												value="${record.project_role_id}">
											</input>
										</c:forEach>
									</div>
								</div>
								<div class="col-md-6">
									<h4>Rate & Durations</h4>
									<div class="form-group">
										<div class="row">
											<div class="col-xs-2">Rate/hr:</div>
											<div class="col-xs-2">
												<input id="editrate" name="rate" type="text" placeholder="0"
													class="form-control required" value="${record.rate}">
											</div>
											<div class="col-xs-2">Min:</div>
											<div class="col-xs-2">
												<input id="editrate_min" name="rate_min" type="text"
													placeholder="0" class="form-control"
													value="${record.rate_min}">
											</div>

											<div class="col-xs-2">Max:</div>
											<div class="col-xs-2">
												<input id="editrate_max" name="rate_max" type="text"
													placeholder="0" class="form-control"
													value="${record.rate_max}">
											</div>
										</div>
									</div>
									<hr>
									<h4>Recurrence</h4>
									<div class="form-group">
										<div class="row">
											<div class="col-xs-4">Frequency:</div>
											<div class="col-xs-6">
												<select id="category_code" class="form-control required"
													name="category_code">
													<c:forEach items="${frequency}" var="record">
														<option value="${record.category_code}">${record.category_name}</option>
													</c:forEach>
												</select>
											</div>
										</div>
									</div>
									<div class="form-group">
										<div class="row">
											<div class="col-xs-4">
												<label for="description"> Target Hours: </label>
											</div>
											<div class="col-xs-4">
												<input id="hours_per_occurrence" name="hours_per_occurrence"
													type="text" placeholder="000" class="form-control required"
													value="${record.no_of_occurrence}">
											</div>
											<div class="col-xs-4 pull-left">
												<label for="description"> per occurrence</label>
											</div>
										</div>
									</div>
									<hr>
									<h4>Range of Recurrence</h4>
									<div class="form-group">
										<div class="row">
											<div class="col-xs-4">
												<div class="radio">
													<label> <input type="radio" name="optionsRadios"
														id="optionsRadios1" value="option1" checked>No End
														Date
													</label>
												</div>
											</div>
										</div>
										<div class="row">
											<div class="col-xs-4">
												<div class="radio">
													<label> <input type="radio" name="optionsRadios"
														id="optionsRadios1" value="option1" checked>No. of
														occurrences
													</label>
												</div>
											</div>
											<div class="col-xs-4 pull-left">
												<input id="occurrence" name="occurrence" type="text"
													placeholder="0" class="form-control required">
											</div>

										</div>
									</div>
									<div class="row">
										<div class="col-xs-4">
											<div class="radio">
												<label> <input type="radio" name="optionsRadios"
													id="optionsRadios1" value="option1" checked>End
													After:
												</label>
											</div>
										</div>
										<div class="col-xs-8 pull-left">
											<input type="date" id="datepicker" data-role="date"
												data-inline="true" onclick="dateselect()"
												value="${record.ror_enddate}">
										</div>
									</div>
								</div>
							</div>
						</div>
					</div>
					<div class="modal-footer">
						<button type="button" data-dismiss="modal" class="btn">Close</button>
						<button type="button" id="addmembers_edit" class="btn btn-primary">Save
							changes</button>
					</div>
				</div>
			</form:form>
		</div>
	</div>
	<!-- END modal-->
	<div><%@include file="/WEB-INF/pages/layout/footer.jsp"%></div>
</body>
</html>