<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>


<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Proposal</title>

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
<spring:url value="/resources/common/js/proposal.js" var="js15" />
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
<script src="${js15}"></script>
<script src="${js16}"></script>

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
<spring:url
	value="/resources/common/vendors/gallery/fancy_box/jquery.fancybox.css"
	var="css14" />
<spring:url value="/resources/common/resource/css/head-foot.css"
	var="css23" />
<spring:url value="/resources/common/vendors/toastr/toastr.css"
	var="css22" />

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
<link href="${css23}" rel="stylesheet">
<link href="${css22}" rel="stylesheet">


</head>
<body>
	<!-- Container Section Start -->
	<%@include file="/WEB-INF/pages/layout/header.jsp"%>
	<%@include file="/WEB-INF/pages/job/layout/header.jsp"%>
	<div class="wrapper">
		<section class="content">
			<aside class="left-side sidebar-offcanvas">
				<section class="sidebar">
					<!--Content Section Start -->
					<!-- Row 1 Col 1 Section Start -->
					<div class="col-lg-15">
						<div id="entiretskgrp">
							<h4>Feature Sets</h4>
							<div class="nav_icons" id="task_projectid">
								<ul class="sidebar_threeicons">
									<c:forEach items="${project_id}" var="record">
										<input id="project_id" name="project_id" type="text"
											style="display: none" placeholder="Project id"
											class="form-control" class="form-control"
											value="${record.project_id}"></input>
									</c:forEach>
								</ul>
							</div>
							<div></div>
							<div id="task_group_ref">
								<div id="feature_click">
									<ul class="nav nav-sidebar" id="taskgroupid">
										<c:forEach items="${feature}" var="record">
											<li value="${record.feature_id}" id="${record.feature_id}"
												class="taskgpclass"><a class="some-trigger" href="#">
													<span id="taskgpname" class="taskgpname">${record.feature_name}</span>
													<span style="display: none;" id="project_id">${record.project_id}</span>
													<span style="display: none;" id="task_group_id">${record.feature_id}</span>
													<span id="task_count" class="badge left task_count">${record.tasks_cnt_pergp}</span>
											</a></li>
										</c:forEach>
									</ul>
								</div>
							</div>
						</div>
					</div>
				</section>
			</aside>
			<!-- Row 1 Col 1 Section End -->

			<!-- Row 1 Col 2 Section Start -->
			<aside class="right-side bdr_left">
				<div class="container-fluid">
					<div class="row">
						<div class="col-lg-7 bdr_right">
							<!-- Add Task Bar Start-->
							<div class="well well-sm">
								<!-- Row 1-->
								<section class="content-header">
									<div class="row">
										<div class="col-lg-5" id="taskgroupheader">
											<h4 id="design">All Tasks</h4>
											<div id="task_gpname">
												<h4 hidden id="taskgroupidhidden">Design</h4>
												<h4 hidden id="taskgroupcnthidden">0</h4>
												<c:forEach items="${taskdetails}" var="record">
													<h4 style="display: none;" id="project_id">
														"${record.project_id}"</h4>
												</c:forEach>
											</div>
										</div>
										<div class="col-lg-3 pull-right">
										
										<c:forEach items="${teamstatus}" var="record">
											<button type="submit" id="create_task" value="${record.statusflag}"
												class="btn btn-primary" data-toggle="modal"
												data-target="#addTaskModal">
												Create Task
												
												</button>
											</c:forEach>
												<c:forEach items="${taskdetails}" var="record">
													<input style="display: none;" value="${record.project_id}"></input>
												</c:forEach>
											
										</div>
									</div>
								</section>
							</div>
							<div class="well well-sm">
								<div class="row">
									<c:forEach items="${count}" var="record">
										<div class="col-lg-3">
											<label id=total_tasks>Total
												Tasks:${record.proposal_task_count} </label>
										</div>
										<div class="col-lg-5">
											<label id=total_hrs>Total Estimated
												Hours:${record.estimated_hrscount} </label>
										</div>
									</c:forEach>
								</div>
							</div>
							<!-- Add Task Bar End -->
							<!-- Task list begin -->
							<section class="content">
								<div class="row" id="pro_tasktable">
									<form id="viewtasks" name="viewtasks" method="POST">
										
										<div class="row" id="mydiv">
											<div class="row" id="taskrow" value="${record.task_id}">
												<c:forEach items="${taskdetails}" var="record"
													varStatus="status">
													<!-- begining of row -->
													<div class="panel panel-custom">
														<div class="panel-heading" id="heading">
															<span class="pro_id" id="${record.task_id}"
																name="task_id"><a style="color: blue" href=""><i
																	class="glyphicon glyphicon-picture" style="color: blue"></i>
																	${record.task_id}-${record.task_name} </a></span>

															<div id="task_group_id" style="display: none;">${record.feature_id}</div>
															<div id="project_id" style="display: none;">${record.project_id}</div>

															<div class="pull-right">

																<span><button type="button"
																		class="btn button-border-primary btn-circle">
																		<b>${record.estimated_hours}</b>
																	</button></span> <span><button type="button"
																		class="btn btn-default btn-circle"></button></span>
															</div>
														</div>
														<!--  <div class="panel-body" id = "task_description">${record.task_description}</div>-->
													</div>
												</c:forEach>
											</div>
									</form>
								</div>
								<!-- modal 2 begin -->
								<div class="modal fade" id="addTaskModal" tabindex="-1"
									role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
									<div class="modal-dialog">
										<div class="modal-content">
											<div class="modal-header">
												<button type="button" class="close" data-dismiss="modal"
													aria-hidden="true">&times;</button>
												<h4 class="modal-title" id="myModalLabel">
													<i class="fa fa-plus"></i> New ProposalTask
												</h4>
											</div>
											<div class="modal-body">
												<!--  <form class="form-horizontal" action="#" method="post"> -->
												<form id="savetaskdetails" name="savetaskdetails"
													enctype="multipart/form-data"
													action="${pageContext.request.contextPath}/proposaltasks"
													method="POST">
													<fieldset>
														<!-- Task Type input-->
														<div class="form-group">
															<label class="col-md-3 control-label" for="name">Task
																Type </label>
															<div class="col-md-9">
																<select class="form-control" name="task_type_id"
																	id="tasktypename">
																	<c:forEach items="${tasktype}" var="record">
																		<option value="${record.task_type_id}">${record.task_type_name}</option>
																	</c:forEach>
																</select>
															</div>
														</div>
														<br>
														<div class="form-group">
															<input id="team_id" name="team_id" style="display: none"
																value="${team_id}"></input>
														</div>
														<div class="form-group">
															<c:forEach items="${project_id}" var="record">
																<input id="project_id" name="project_id"
																	style="display: none" value="${record.project_id}"></input>
															</c:forEach>
														</div>
														<!-- Name input-->
														<div class="form-group">
															<label class="col-md-3 control-label" for="name">Task
																Name *</label>
															<div class="col-md-9">
																<input id="name" name="task_name" type="text"
																	placeholder="Your name" class="form-control"> <span
																	id="gettask" style="color: red"></span><br>
															</div>
														</div>
														<!-- Task Description -->
														<div class="form-group">
															<label class="col-md-3 control-label" for="message">Task
																Description</label>
															<div class="col-md-9">
																<textarea class="form-control" id="message"
																	name="description" placeholder="Description" rows="5"></textarea>
																<span id="getdesc" style="color: red"></span><br>
															</div>
														</div>
														<div class="form-group">
															<label class="col-md-3 control-label" for="message">Sign-off
																Criteria</label>
															<div class="col-md-9">
																<textarea class="form-control" id="message1"
																	name="signoff_criteria" placeholder="Sign-off Criteria"
																	rows="2"></textarea>

															</div>
														</div>
														&nbsp;&nbsp;&nbsp;&nbsp;
														<!-- Task Duration -->
														<div class="form-group">
															<label class="col-md-3 control-label" for="name">Task
																Size *</label>
															<div class="col-md-9">
																<select class="form-control" id="size" name="size_code">
																	<c:forEach items="${tasksize}" var="record">
																		<option value="${record.task_size_code}">${record.task_size_code}-${record.task_size_hrs}</option>
																	</c:forEach>
																</select> <span id="getsize" style="color: red"></span><br>
															</div>
														</div>

														<div class="form-group">
															<label class="col-md-3 control-label" for="name">Estimated
																Hours </label>
															<div class="col-md-9">
																<select class="form-control" id="estimated_hours"
																	name="estimated_hours">
																	<c:forEach items="${estimatedhours}" var="record">
																		<option value="${record.category_value}">${record.category_value}</option>
																	</c:forEach>
																</select>
															</div>
														</div>
														&nbsp;&nbsp;&nbsp;&nbsp;
														<!-- Attachments input-->
														<div class="form-group">
															<label class="col-md-3 control-label" for="name">Attachments</label>
															<div class="col-md-9">
																<div class="input-group">
																	<input type="file" name="file" id="new-event"
																		class="form-control" placeholder="Attachments">
																	<!--  <div class="input-group-btn">
														<button type="button" id="color-chooser-btn"
															onclick="openFileOption();return;"
															class="btn btn-info dropdown-toggle">
															Browse <span class="caret"></span>
														</button>
														<ul class="dropdown-menu pull-right" id="color-chooser">
														</ul>
													</div>-->
																</div>
																<!-- /btn-group -->
															</div>
															<!-- /input-group -->
														</div>
														<div class="col-md-9">
															<textarea style="display: none;" name="feature_id"
																id="cafeId">5</textarea>
														</div>
														<!-- Form actions -->
														<div class="modal-footer">
															<button type="button" class="btn btn-danger pull-right"
																id="closetasks" data-dismiss="modal">
																Close <i class="fa fa-times"></i>
															</button>
															<button type="submit" class="btn btn-success pull-left"
																id="saveproposaltasks" data-dismiss="modal">
																<i class="fa fa-plus"></i> Save
															</button>
														</div>
													</fieldset>
												</form>
											</div>
										</div>
									</div>
								</div>
							</section>
						</div>
						<!-- Task view -->
						<div id="view"><%@include
								file="/WEB-INF/pages/job/layout/proposal_view.jsp"%></div>
					</div>
					<div class="modal fade" id="addmemberModal" tabindex="-1"
						role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
						<div class="modal-dialog">
							<div class="modal-content">
								<div class="modal-header">
									<button type="button" class="close" data-dismiss="modal"
										aria-hidden="true">&times;</button>
									<h4 class="modal-title" id="myModalLabel">
										<i class="fa fa-plus"></i>
									</h4>
								</div>
								<div class="modal-body">
									<!--  <form class="form-horizontal" action="#" method="post"> -->
									<form id="member_request" name="member_request"
										enctype="multipart/form-data"
										action="${pageContext.request.contextPath}/member_request"
										method="POST"
										onsubmit="return validateForm();>
									<fieldset>
                                         <div class="row">
                                           <div class="form-group">
												<input id="team_id" name="team_id"
													style="display: none" value="${team_id}"></input>
										</div>
										<div class="form-group">
											<c:forEach items="${project_id}" var="record">
												<input id="project_id" name="project_id"
													style="display: none" value="${record.project_id}"></input>
											</c:forEach>
										</div>
												<div class="row" id="anothermember"
													style='width: 120%;'>
													<div class="row subrow" id="subrow1"
													style='height: 100px; width: 100%;'>
													<div class="col-lg-3">
														<div class="row">
															<label class="control-label" for="name" name="email"> E-mail
																Address*</label>
														</div>
														<div class="row">
															<div class="col-md-20">
																<input id="email1" name="email" type="email" 
																	placeholder="E-mail Address" class="form-control">
																	<span class="help-block"></span>
															</div>
														</div>
													</div>
													<div class="col-lg-3">
														<div class="row">
															<label class="control-label" for="name" name="firstname">
																First Name </label>
														</div>
														<div class="row">
															<div class="col-md-14">
																<input id="firstname1" name="firstname" type="text"
																	placeholder="Your name" class="form-control">
															</div>
														</div>
													</div>
													<div class="col-lg-3">
														<div class="row">
															<label class="control-label" for="name" name="lastname"> Last Name
															</label>
														</div>
														<div class="row">
															<div class="col-md-14">
																<input id="lastname1" name="lastname" type="text"
																	placeholder="Your name" class="form-control">
															</div>
														</div>
													</div>
													<div class="col-lg-3 pull-right">
														
														&nbsp;&nbsp;&nbsp;&nbsp;
														<div class="row">
															<div class="col-md-1">
																<a href="#" class="removefield"><i class="glyphicon glyphicon-remove" style="display:none;"> </i> </a>
															</div>
														</div>
													</div>
												</div>
                                             </div>
												<div class="row" >
													<div class="col-lg-5" >
														<u><a id="add_new" href="#"><i class="fa fa-plus"> </i>
															Add another invitation</a></u>
													</div>
													<div class="col-lg-3 pull-right">
													<button type="submit" class="btn btn-success pull-left" id="invite"
												 data-dismiss="modal">
												 Invite 1 Person
											</button>
											</div>
												</div>
											</div>
										</fieldset>
								</form>
							</div>
						</div>
					</div>
				</div>	
				</div>
				<!-- modal 2 end -->
				<!-- Modal 1 end -->
				
				
			  <div class="modal fade" id="proposalsubmit" tabindex="-1"
					role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
					<div class="modal-dialog">
						<div class="modal-content">
							<div class="modal-header">
								<button type="button" class="close" data-dismiss="modal"
									aria-hidden="true">&times;</button>
								<h4 class="modal-title" id="myModalLabel">
									<i class="fa fa-plus"></i> 
								</h4>
							</div>
							<div class="modal-body">
								<!--  <form class="form-horizontal" action="#" method="post"> -->
								<form id="create_team" name="create_team"
									enctype="multipart/form-data"
									action="${pageContext.request.contextPath}/proposal"
									method="POST">
									<fieldset>
										<div class="form-group">
											<label class="col-md-12" >Once the proposal is submitted, you cannot make any changes.The proposal will be read-only. Are you sure you want to Submit the proposal? 
												</label>
										</div>
										<div class="form-group">
											<c:forEach items="${project_id}" var="record">
												<input id="project_id" name="project_id"
												style = "display:none"	value="${record.project_id}"></input>
											</c:forEach>
										</div>
										<div class="form-group">
											
												<input id="team_id" name="team_id"
													style = "display:none" value="${team_id}"></input>
											
										</div>
										<!-- Name input-->
										
										&nbsp;&nbsp;&nbsp;&nbsp;
											<!-- /input-group -->
										</div>
										<!-- Form actions -->
										<div class="modal-footer">
											<button type="button" class="btn btn-danger pull-right"
												id="cancel_proposal" data-dismiss="modal">
												Cancel <i class="fa fa-times"></i>
											</button>
											<button type="submit" class="btn btn-success pull-left"
												id="proposal_submit" data-dismiss="modal">
												<i class="fa fa-plus"></i> Submit 
											</button>
										</div>
									</fieldset>
								</form>
							</div>
						</div>
					</div>
				</div>	
			</aside>
		<!-- //Content Section End -->
		</section>
	</div>
	<!-- end of modal -->
	<!-- Modal 2 end -->
</body>
<div><%@include file="/WEB-INF/pages/layout/footer.jsp"%></div>
</html>