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
<title>Tasks</title>

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

<spring:url value="/resources/common/js/taskdetail.js" var="js15" />
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
	<%@include file="/WEB-INF/pages/project/layout/projectheader.jsp"%>

	<!--  <div><jsp:include page="layout/projectheader.jsp">
			<jsp:param name="project_id" value="${project_id}" />
		</jsp:include>
	</div>-->

	<div class="wrapper">
	<section class="content">
	<aside class="left-side sidebar-offcanvas">
					<section class="sidebar">
		<!--Content Section Start -->
				<!-- Row 1 Col 1 Section Start -->
				<div class="col-lg-15">
						<div id="entiretskgrp">
							<div align="center">
								<span class="title">Group</span>
							</div>
							<div class="nav_icons" id="task_projectid">
								<ul class="sidebar_threeicons">
									<c:forEach items="${project_id}" var="record">
										<input id="project_id" name="project_id" type="text"
											style="display: none" placeholder="Project id"
											class="form-control" class="form-control"
											value="${record.project_id}"></input>
									</c:forEach>

									<li><a href="#" data-toggle="modal" data-target="#myModal">
											<i class="glyphicon glyphicon-plus" id = "create_group"></i>
									</a></li>

									<li><a href="#" data-toggle="modal"
										data-target="#editModal"> <i
											class="glyphicon glyphicon-pencil"></i>
									</a></li>
									<li><a href="#" data-toggle="modal"
										data-target="#deletemodal"> <i
											class="glyphicon glyphicon-remove"></i>
									</a></li>
								</ul>
							</div>
							<div>
								<hr>
							</div>
							<div id="task_group_ref">
								<div id="task_group_click">
									<ul class="nav nav-sidebar" id="taskgroupid">
										<c:forEach items="${taskgroup}" var="record">
											<li value="${record.feature_id}"
												id="${record.feature_id}" class="taskgpclass"><a
												class="some-trigger" href="#"> <span id="taskgpname"
													class="taskgpname">${record.feature_name}</span> <span
													style="display: none;" id="project_id">${record.project_id}</span>
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
							<!--  <div class="col-lg-3"></div>
							<div class="col-lg-3 pull-right">
								<button type="submit" class="btn btn-primary"
									id="DeleteGroupbutton" data-toggle="modal">Delete
									Group</button>
							</div>
							<div class="col-lg-3 pull-right">
								<button type="submit" class="btn btn-primary"
									data-toggle="modal" id="editGroupbutton">Edit Group</button>
								<c:forEach items="${taskdetails}" var="record">
									<input style="display: none;" id="project_id"
										value="${record.project_id}"></input>
								</c:forEach>
							</div>-->


							<div class="col-lg-3 pull-right">
								<button type="submit" id="create_task" class="btn btn-primary"
									data-toggle="modal" data-target="#addTaskModal">
									Create Task
									<c:forEach items="${taskdetails}" var="record">
										<input style="display: none;" value="${record.project_id}"></input>
									</c:forEach>
								</button>
							</div>
						</div>
						</section>
						<!-- Row 2 
                        <div class="row">
                            <div class="col-lg-3">
                                <button type="button" class="knob btn-lg" data-fgColor="#418bca" data-thickness=".2" data-width="80%" readonly value="0"><i class="glyphicon glyphicon-dashboard"></i>  
                                </button>                   
                                  Dashboard  
                            </div>
                             <div class="col-lg-3">
                            </div>
                            <div class="col-lg-3 pull-right">
                            </div>   
                        </div>-->

					</div>
					<!-- Add Task Bar End -->
					<!-- Task list begin -->
					
					<section class="content">
					<div class="row" id="tasktable">
						<form id="viewtasks" name="viewtasks" method="POST"
							action="${pageContext.request.contextPath}/crt/taskdetail">
								<div class="row" id="mydiv">
						<div class = "row" id = "taskrow" value ="${record.task_id}" >
								<c:forEach items="${taskdetails}" var="record" varStatus="status">
									<!-- begining of row -->
									<div class="panel panel-custom">
										<div class="panel-heading" id = "heading">
											<span  class = "task_id" id="${record.task_id}" name="task_id"  ><a style="color: blue"
												href=""><i class="glyphicon glyphicon-picture"
													style="color: blue"></i>
													${record.task_id}-${record.task_name} </a></span>
													
										<div  id="task_group_id" style="display: none;">${record.feature_id}</div>
										<div  id="project_id" style="display: none;">${record.project_id}</div>

											<div class="pull-right">
											
												<span><button type="button"
														class="btn button-border-primary btn-circle">
														<b>${record.task_size_code}</b>
													</button></span> <span><button type="button"
														class="btn btn-default btn-circle"></button></span> <span><button
														type="button" class="btn btn-default btn-circle"></button></span>
												<span class="tstatus"><button id="pauseButton" type="button"
													class="btn button-border-primary btn-circle" value="${record.task_id}">
													<i id="playbtn" class="" value="${record.statusflag}"></i>
												</button><label id="statusflag" style = "display:none;">${record.statusflag}</label></span>
												
											</div>
										</div>
										
										<!--  <div class="panel-body" id = "task_description">${record.task_description}</div>-->
										
									</div>
								</c:forEach>
							</div>
						</form>
					</div>
				
				
				<!-- Task list end -->
				<!-- Row 1 Col 2 Section End -->
				<!-- Modal 1 begin -->
				<!-- Modal -->
				<div class="modal fade" id="myModal" tabindex="-1" role="dialog"
					aria-labelledby="myModalLabel" aria-hidden="true">
					<div class="modal-dialog">
						<div class="modal-content">
							<div class="modal-header">
								<button type="button" class="close" data-dismiss="modal"
									aria-hidden="true">&times;</button>
								<h4 class="modal-title" id="myModalLabel">
									<i class="fa fa-plus"></i> Feature
								</h4>
							</div>
							<div class="modal-body">
								<form class="form-horizontal" id="savetaskgp"
									action="${pageContext.request.contextPath}/crt/tasks"
									method="post">
									<fieldset>
										<!-- Name input-->
										<div class="form-group">
											<label class="col-md-3 control-label" for="name">Feature
												Name *</label>
											<div class="col-md-9">
												<input id="task_group_name" name="task_group_name"
													type="text" placeholder="Feature Name" class="form-control">
											</div>
										</div>
										<!-- Task Description -->
										<div class="form-group">
											<label class="col-md-3 control-label" for="message">Description</label>
											<div class="col-md-9">
												<textarea class="form-control" id="taskgp_description"
													name="taskgp_description" placeholder="Description"
													rows="5"></textarea>
											</div>
										</div>
										<!-- Task Sign-off criteria -->
										<div class="form-group">
											<label class="col-md-3 control-label" for="message">Sign-off
												Criteria</label>
											<div class="col-md-9">
												<textarea class="form-control" id="taskgp_signoff_criteria"
													name="taskgp_signoff_criteria"
													placeholder="Sign-off Criteria" rows="3"></textarea>
											</div>
										</div>
										<!-- /input-group -->
										<!-- Task Type input-->
										<div class="form-group">
											<label class="col-md-3 control-label" for="name">Priority
												*</label>
											<div class="col-md-9">
												<select class="form-control" id="priority_code"
													name="priority_code">
													<option value=" "></option>
													<c:forEach items="${priority_code}" var="record">
														<option value="${record.priority_code}">${record.priority_cde_name}</option>
													</c:forEach>
												</select>
											</div>
										</div>
										<!-- Project_id -->
										<div class="modal-body">
											<div class="input-group">
												<c:forEach items="${project_id}" var="record">
													<input id="project_id" name="project_id" type="text"
														style="display: none" placeholder="Project id"
														class="form-control" class="form-control"
														value="${record.project_id}"></input>
												</c:forEach>
											</div>
										</div>

									</fieldset>
								</form>
							</div>
							<div class="modal-footer">
								<button type="button" class="btn btn-danger pull-right"
									id="close-new-event" data-dismiss="modal">
									Close <i class="fa fa-times"></i>
								</button>
								<button type="submit" class="btn btn-success pull-left"
									id="add-new-event" data-dismiss="modal">
									<i class="fa fa-plus"></i> Save
								</button>
							</div>
						</div>
					</div>
				</div>
							<!-- end of modal -->
			
				<!-- modal 2 begin -->
				<div class="modal fade" id="addTaskModal" tabindex="-1"
					role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
					<div class="modal-dialog">
						<div class="modal-content">
							<div class="modal-header">
								<button type="button" class="close" data-dismiss="modal"
									aria-hidden="true">&times;</button>
								<h4 class="modal-title" id="myModalLabel">
									<i class="fa fa-plus"></i> New Task
								</h4>
							</div>
							<div class="modal-body">
								<!--  <form class="form-horizontal" action="#" method="post"> -->
								<form id="savetaskdetails" name="savetaskdetails"
									enctype="multipart/form-data"
									action="${pageContext.request.contextPath}/crt/detailtasks"
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
										<br> <br>
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
										<!-- Task Sign-off criteria -->
										<div class="form-group">
											<label class="col-md-3 control-label" for="message">Sign-off
												Criteria</label>
											<div class="col-md-9">
												<textarea class="form-control" id="message1"
													name="signoff_criteria" placeholder="Sign-off Criteria"
													rows="3"></textarea>
												<span id="getsign" style="color: red"></span><br>
											</div>
										</div>
										<!-- Task Duration -->
										<div class="form-group">
											<label class="col-md-3 control-label" for="name">Task
												Size *</label>
											<div class="col-md-9">
												<select class="form-control" id="size" name="task_size_code">
													<c:forEach items="${tasksize}" var="record">
														<option value="${record.task_size_code}">${record.task_size_code}-${record.task_size_hrs}</option>
													</c:forEach>
												</select> <span id="getsize" style="color: red"></span><br>
											</div>
										</div>
										<!-- Task Duration -->
										<!-- Budgeted Amount 
                                        <div class="form-group">
                                            <label class="col-md-3 control-label" for="name">Budget ($)</label>
                                                <div class="col-md-3">
                                                    <input id="name" name="name" type="text" placeholder="$" class="form-control">
                                                </div>                                      
                                            <label class="col-md-3 control-label" for="name"></label>
                                                <div class="col-md-3">
                                            </div>
                                        </div>  -->
										<!-- Link Tasks-->
										<div class="form-group">
											<label class="col-md-3 control-label" for="name">Link
												Tasks</label>
											<div class="col-md-9">
												<input id="name1" name="name" type="text"
													placeholder="Enter Task ID" class="form-control"> <span
													id="getlink" style="color: red"></span><br>
											</div>
										</div>
										<!--  Est.StartDate -->
										<div class="form-group">
											<label class="col-md-3 control-label" for="name">
												Est.StartDate</label>
											<div class='col-sm-9'>
												<input type='text' class="form-control"
													placeholder="dd/mm/yyyy" id='start_datepicker' />
											</div>
										</div>
										&nbsp;&nbsp;&nbsp;&nbsp;
										<!--  Est.EndDate -->
										<div class="form-group">
											<label class="col-md-3 control-label" for="name"
												class="form-group"> Est.EndDate</label>
											<div class='col-sm-9'>
												<input type='text' class=" form-control"
													placeholder="dd/mm/yyyy" id='end_datepicker' />

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
												id="savetasks" data-dismiss="modal">
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
                    <div id="view"><%@include file="/WEB-INF/pages/project/layout/taskview.jsp"%></div>
				</div>
				</div>
				<!-- modal 2 end -->
				<!-- Modal 1 end -->
			</aside>
		<!-- //Content Section End -->
		</section>
	</div>
	<!-- end of modal -->
	<!-- Modal 2 end -->
</body>
<div><%@include file="/WEB-INF/pages/layout/footer.jsp"%></div>
</html>