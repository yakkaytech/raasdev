<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">

<title>Insert title here</title>
<spring:url value="/resources/common/css/frontend/news.css" var="css1" />
<spring:url value="/resources/common/css/font-awesome.min.css"
	var="css2" />
<spring:url value="/resources/common/css/frontend/blog.css" var="css3" />
<spring:url value="/resources/common/css/pages/portlet.css" var="css4" />
<spring:url
	value="/resources/common/vendors/fullcalendar/css/fullcalendar.css"
	var="css5" />
<spring:url value="/resources/common/css/pages/calendar_custom.css"
	var="css6" />
<spring:url value="/resources/common/css/default.css" var="css7" />
<spring:url
	value="/resources/common/vendors/Buttons-master/css/buttons.css"
	var="css8" />
<spring:url value="/resources/common/css/pages/advbuttons.css"
	var="css9" />
<spring:url
	value="/resources/common/vendors/datatables/extensions/bootstrap/dataTables.bootstrap.css"
	var="css10" />
<spring:url
	value="resources/common/vendors/jasny-bootstrap/css/jasny-bootstrap.css"
	var="css11" />
<spring:url
	value="/resources/common/resource/css/bootstrap-tagsinput.css"
	var="css12" />
<spring:url value="/resources/common/resource/css/formelements.css"
	var="css13" />
<spring:url value="/resources/common/resource/js/wizard.css" var="css14" />
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
	var="css22" />
<spring:url value="/resources/common/css/bootstrap.min.css" var="css23" />
<spring:url value="/resources/common/css/frontend/custom.css"
	var="css24" />
<spring:url value="/resources/common/css/pages/tables.css" var="css25" />
<spring:url value="/resources/common/css/panel.css" var="css26" />
<spring:url value="/resources/common/css/metisMenu.css" var="css27" />
<spring:url value="/resources/common/css/styles/white.css" var="css28" />
<spring:url value="/resources/common/resource/css/head-foot.css"
	var="css29" />



<spring:url value="/resources/common/js/jquery-1.11.1.min.js" var="js1" />
<spring:url
	value="/resources/common/vendors/form_builder1/js/jquery.ui.min.js"
	var="js2" />
<spring:url value="/resources/common/js/todolist.js" var="js3" />
<spring:url
	value="/resources/common/vendors/datepicker/js/bootstrap-datepicker.js"
	var="js4" />
<spring:url value="/resources/common/vendors/fullcalendar/moment.min.js"
	var="js6" />
<spring:url
	value="/resources/common/vendors/fullcalendar/fullcalendar.min.js"
	var="js7" />
<spring:url value="/resources/common/vendors/charts/jquery.sparkline.js"
	var="js8" />
<spring:url value="/resources/common/js/dashboard.js" var="js9" />
<spring:url value="/resources/common/js/bootstrap.min.js" var="js11" />
<spring:url value="/resources/common/vendors/Knob/js/jquery.knob.js"
	var="js12" />
<spring:url value="/resources/common/js/pages/knob_page.js" var="js13" />
<spring:url value="/resources/common/js/taskdetail.js" var="js15" />

<link href="${css1}" rel="stylesheet" />
<link href="${css2}" rel="stylesheet" />
<link href="${css3}" rel="stylesheet" />
<link href="${css4}" rel="stylesheet" />
<link href="${css5}" rel="stylesheet" />
<link href="${css6}" rel="stylesheet" />
<link href="${css7}" rel="stylesheet" />
<link href="${css8}" rel="stylesheet" />
<link href="${css9}" rel="stylesheet" />
<link href="${css10}" rel="stylesheet" />
<link href="${css11}" rel="stylesheet" />
<link href="${css12}" rel="stylesheet" />
<link href="${css13}" rel="stylesheet" />
<link href="${css14}" rel="stylesheet" />
<link href="${css7}" rel="stylesheet" />
<link href="${css8}" rel="stylesheet" />
<link href="${css9}" rel="stylesheet" />
<link href="${css10}" rel="stylesheet" />
<link href="${css11}" rel="stylesheet" />
<link href="${css12}" rel="stylesheet" />
<link href="${css13}" rel="stylesheet" />
<link href="${css14}" rel="stylesheet" />
<link href="${css15}" rel="stylesheet" />
<link href="${css16}" rel="stylesheet" />
<link href="${css17}" rel="stylesheet" />
<link href="${css18}" rel="stylesheet" />
<link href="${css19}" rel="stylesheet" />
<link href="${css20}" rel="stylesheet" />
<link href="${css21}" rel="stylesheet" />
<link href="${css22}" rel="stylesheet" />
<link href="${css18}" rel="stylesheet" />
<link href="${css19}" rel="stylesheet" />
<link href="${css20}" rel="stylesheet" />
<link href="${css21}" rel="stylesheet" />
<link href="${css22}" rel="stylesheet" />
<link href="${css23}" rel="stylesheet" />
<link href="${css24}" rel="stylesheet" />
<link href="${css24}" rel="stylesheet" />
<link href="${css25}" rel="stylesheet" />
<link href="${css26}" rel="stylesheet" />
<link href="${css27}" rel="stylesheet" />
<link href="${css28}" rel="stylesheet" />
<link href="${css29}" rel="stylesheet" />


<script src="${js1}"></script>
<script src="${js2}"></script>
<script src="${js3}"></script>
<script src="${js4}"></script>
<script src="${js6}"></script>
<script src="${js7}"></script>
<script src="${js8}"></script>
<script src="${js9}"></script>
<script src="${js11}"></script>
<script src="${js12}"></script>
<script src="${js13}"></script>
<script src="${js15}"></script>
<%@ page import="java.util.*,java.io.*"%>
<script>
	jQuery(document).ready(function() {
		$("#sortable_portlets").sortable({
			connectWith : ".portlet",
			items : ".portlet",
			opacity : 0.8,
			coneHelperSize : true,
			placeholder : 'sortable-box-placeholder round-all',
			forcePlaceholderSize : true,
			tolerance : "pointer"
		});

		$(".column").disableSelection();

	});
</script>
<script>
	$(function() {
		$(".datepicker").datepicker();
	});
</script>
</head>
<body>

	<%@include file="/WEB-INF/pages/layout/header.jsp"%>
	<div><jsp:include page="layout/projectheader.jsp">
			<jsp:param name="project_id" value="${project_id}" />
		</jsp:include>
	</div>
	<div class="container">
		<!-- Container Section Start -->
		<section class="content">
		<div>

			<nav class="navbar navbar-default"></nav>
			<div class="wrapper row-offcanvas row-offcanvas-left">
				<!-- Begin of wrapper -->
				<!-- Left side column. contains the logo and sidebar -->
				<aside class="left-side sidebar-offcanvas"> <section
					class="sidebar ">
				<div class="page-sidebar  sidebar-nav">

					<!-- BEGIN SIDEBAR MENU -->
					<ul id="menu" class="page-sidebar-menu">
						<li><a href=""> <i class="livicon" data-name="home"
								data-size="18" data-c="#418BCA" data-hc="#418BCA"
								data-loop="true"></i> <span class="title">Task Details</span>
						</a></li>
						<li><a href=""> <i class="livicon" data-name="home"
								data-size="18" data-c="#418BCA" data-hc="#418BCA"
								data-loop="true"></i> <span class="title">History</span>
						</a></li>
						<li><a href=""> <i class="livicon" data-name="home"
								data-size="18" data-c="#418BCA" data-hc="#418BCA"
								data-loop="true"></i> <span class="title">Timeline</span>
						</a></li>
					</ul>
				</div>
				</section> </aside>
				<!-- End of right side column. -->
				<aside class="right-side"> <!-- Left side column. contains the logo and sidebar -->
				<!--Content Section Start --> <section class="content-header">


				<ol class="breadcrumb">
					<li>
						<button type="button" class="btn button-border-primary btn-circle">
							<b>S</b>
						</button>
					</li>
					<li>
						<button type="button" class="btn button-border-primary btn-circle">
							<i class="glyphicon glyphicon-user"></i>
						</button>
					</li>
					<li>
						<button type="button" class="btn btn-default btn-circle"></button>
					</li>
				</ol>
				<hr>
				</section> <section class="content">
				<div class="row">
					<!-- Row 1 Col 1 Section Start -->
					<div class="col-lg-8">
						<!-- Row 1-->
						<div class="well well-sm">
							<div class="btn-group">
								<button type="button" class="btn btn-default" id="edit_task"
									style="margin-bottom: 7px;">Edit</button>
							</div>
							<div class="btn-group">
								<button type="button" class="btn btn-default"
									style="margin-bottom: 7px;">Check-out</button>
								<button type="button" class="btn btn-default"
									style="margin-bottom: 7px;">Check-in</button>
							</div>

							<div class="btn-group">
								<button type="button" class="btn btn-default"
									style="margin-bottom: 7px;">Complete</button>
								<button type="button" class="btn btn-default"
									style="margin-bottom: 7px;">Sign-off</button>
							</div>
						</div>
						<div class="clearfix"></div>


						<c:forEach items="${taskview}" var="record">
							<div class="news_item_image thumbnail">
								<div class="panel ">
									<!-- Panel body main content begin-->
									<div class="panel-body">

										<div class="form-group">
											<label class="col-md-3 control-label" for="name"
												style="display: none;">Task Id: </label> <label type="text"
												id="task_Id" name="task_Id" style="display: none;"
												class="col-md-9 control-label" for="name"
												value="${record.task_id}">${record.task_id}</label>
										</div>
										<!-- Task Type input-->
										<div class="form-group">
											<label class="col-md-3 control-label" for="name">Task
												Type: </label> <label type="text" id="task_type"
												name="task_type_name" class="col-md-9 control-label"
												for="name" value="${record.task_type_name}">${record.task_type_name}</label>

										</div>
										<div class="form-group">
											<label class="col-md-3 control-label" for="name">Task
												Name: </label> <label type="text" id="task_type_name"
												name="task_type_name" class="col-md-9 control-label"
												for="name" value="${record.task_name}">${record.task_name}</label>
										</div>
										<div class="form-group">
											<label class="col-md-3 control-label" for="name">Task
												Description:</label><label type="text" id="task_type_description"
												class="col-md-9 control-label" for="name"
												value="${record.task_description}">${record.task_description}
											</label> <br />
										</div>
									</div>
									<div class="form-group">
										<label class="col-md-3 control-label" for="name">Sign-off
											Criteria:</label><label type="text" id="sign_off"
											class="col-md-9 control-label" for="name"
											value="${record.task_signoff_criteria}">${record.task_signoff_criteria}</label>
										<br />
									</div>
									<!--
                                     <div class="form-group">
                                            <label class="col-md-3 control-label" for="name">Task Size</label>
                                            <label class="col-md-9 control-label" for="name">${record.task_size_code}</label>
                                    </div> -->
									<div class="form-group">
										<div class="form-group">
											<label class="col-md-3 control-label" for="name">Est.
												Start Date</label> <label type="text" id="start_date"
												class="col-md-3 control-label" for="name"
												value="${record.date_begin}"><p>${record.date_begin}</p>
											</label> <label class="col-md-3 control-label" for="name">End
												Date</label> <label type="text" id="end_date"
												class="col-md-3 control-label" for="name"
												value="${record.date_end}"><p>
													${record.date_end}</p> </label>
										</div>
									</div>
									<div class="form-group">
										<label class="col-md-3 control-label" for="name">Attachments</label>
										<label class="col-md-9 control-label" for="name" id="attach"
											onclick="attachment()"> <a
											href='${pageContext.request.contextPath}/crt/download/${record.file_name}'><p>${record.file_name}</p></a></label>
									</div>


								</div>
								<!-- Panel body main content end-->
								<div>
									<hr>
								</div>
								<ul class="nav nav-tabs">
									<li class="active"><a href="#">Conversation</a></li>
									<li><a href="#">Timeline</a></li>
								</ul>

							</div>
						</c:forEach>

					</div>
				</div>
				<!-- end of col 1 --> <!-- Row 1 Col 2 Section End -->
				<div class="col-lg-4 col-full-width-left">
					<!-- Featured Author Section Start -->
					<div class="the-box  no-margin more-padding martop3">
						<h3>Team</h3>
						<br>
						<div class="row">
							<div class="col-xs-3">
								<p>
									<a href="#"> <img
										src="${pageContext.request.contextPath}/resources/common/images/13.jpg"
										class="img-responsive img-circle" alt="riot">
									</a>
								</p>
							</div>
							<!-- /.col-xs-3 -->
							<div class="col-xs-3">
								<p>
									<a href="#"> <img
										src="${pageContext.request.contextPath}/resources/common/images/14.jpg"
										class="img-responsive img-circle" alt="riot">
									</a>
								</p>
							</div>
							<!-- /.col-xs-3 -->
							<div class="col-xs-3">
								<p>
									<a href="#"> <img
										src="${pageContext.request.contextPath}/resources/common/images/15.jpg"
										class="img-responsive img-circle" alt="riot">
									</a>
								</p>
							</div>
							<!-- /.col-xs-3 -->
							<div class="col-xs-3"></div>
							<!-- /.col-xs-3 -->
						</div>
					</div>
					<!-- Recent Post Section End -->
					<div class="the-box">
						<h3>Conversation</h3>
						<div class="tab-pane active" id="tab_default_1">
							<div class="media">
								<div class="media-left">
									<a href="#"> <img class="media-object"
										src="${pageContext.request.contextPath}/resources/common/images/13.jpg"
										alt="image">
									</a>
								</div>
								<div class="media-body">
									<a href="#"><h5 class="media-heading text-primary">The
											customer registration must include the email validation.</h5></a>
									<h6 class="text-danger">May 13, 2016</h6>
									<i class="fa fa-star text-primary"></i> <i
										class="fa fa-star text-primary"></i> <i
										class="fa fa-star text-primary"></i> <i
										class="fa fa-star text-primary"></i> <i
										class="fa fa-star text-primary"></i>
								</div>
							</div>
							<div class="media">
								<div class="media-left">
									<a href="#"> <img class="media-object"
										src="${pageContext.request.contextPath}/resources/common/images/14.jpg"
										alt="image">
									</a>
								</div>
								<div class="media-body">
									<a href="#"><h5 class="media-heading text-primary">Do
											we need to display the address?.</h5> </a>
									<h6 class="text-danger">May 12, 2016</h6>
									<i class="fa fa-star text-primary"></i> <i
										class="fa fa-star text-primary"></i> <i
										class="fa fa-star text-primary"></i> <i
										class="fa fa-star text-primary"></i> <i
										class="fa fa-star-o text-primary"></i>
								</div>
							</div>
							<div class="media">
								<div class="media-left">
									<a href="#"> <img class="media-object"
										src="${pageContext.request.contextPath}/resources/common/images/15.jpg"
										alt="image">
									</a>
								</div>
								<div class="media-body">
									<a href="#"><h5 class="media-heading text-primary">Add
											address and zip code.</h5></a>
									<h6 class="text-danger">May 11, 2016</h6>
									<i class="fa fa-star text-primary"></i> <i
										class="fa fa-star text-primary"></i> <i
										class="fa fa-star text-primary"></i> <i
										class="fa fa-star-o text-primary"></i> <i
										class="fa fa-star-o text-primary"></i>
								</div>
							</div>
						</div>
					</div>
					<!-- /.the-box .no-border -->
					<div class="panel panel-danger">
						<div class="panel-heading border-light">
							<h4 class="panel-title">
								<i class="livicon" data-name="mail" data-size="18"
									data-color="white" data-hc="white" data-l="true"></i>
								Conversation
							</h4>
						</div>
						<div class="panel-body no-padding">
							<div class="compose row">
								<div class="form-group">
									<label class="col-md-3 hidden-xs">To:</label>
									<div class="col-md-9">
										<select class="form-control">
											<option></option>
											<option>Robert Jr.</option>
											<option>John</option>
											<option>Raj K</option>
										</select>
									</div>
								</div>
							</div>
							<div class="compose row">
								<div class="form-group">
									<label class="col-md-3 hidden-xs ">Message:</label>
									<div class="col-md-9">
										<textarea rows="4" cols="28" class="textarea"
											placeholder="Write mail content here"></textarea>
									</div>
								</div>
							</div>
							<div class="compose row">
								<div class="pull-right">
									<a href="#" class="btn btn-danger">Send</a>
								</div>
							</div>
						</div>
					</div>
					<!-- end of col 2 -->
				</div>
				</section> </aside>
				<!-- end of wrapper -->
			</div>
		</div>
		</section>
	</div>

	<!--  Modal for edit a table -->
	<div class="modal fade" id="editTaskModal" tabindex="-1" role="dialog"
		aria-labelledby="myModalLabel" aria-hidden="true">
		<div class="modal-dialog">
			<div class="modal-content">
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal"
						aria-hidden="true">&times;</button>
					<h4 class="modal-title" id="myModalLabel">
						<i class="fa fa-plus"></i> Edit Task
					</h4>
				</div>
				<div class="modal-body">
					<form id="edittaskdetails" name="edittaskdetails" method="POST"
						action="${pageContext.request.contextPath}/crt/edittask"
						enctype="multipart/form-data">
						<fieldset>

							<!-- Task Type input-->
							<div class="form-group">
								<label class="col-md-3 control-label" for="name">Task
									Type *</label>
								<div class="col-md-9">
									<select class="form-control" name="task_type_id" id="selId">
										<c:forEach items="${tasktype}" var="record">
											<option id="tasktypeid" value="${record.task_type_id}">${record.task_type_id}-${record.task_type_name}</option>
										</c:forEach>
									</select>
								</div>
							</div>
							&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
							<!-- Name input-->
							<div class="form-group">
								<label class="col-md-3 control-label" for="name">Task
									Name *</label>
								<div class="col-md-9">
									<input id="editname" name="task_name" type="text"
										placeholder="Your name" class="form-control"> <span
										id="gettaskid" style="color: red"></span><br>
								</div>
							</div>
							<!-- Task Description -->
							<div class="form-group">
								<label class="col-md-3 control-label" for="message">Task
									Description</label>
								<div class="col-md-9">
									<textarea class="form-control" id="editmessage"
										name="description" placeholder="Description"></textarea>
									<span id="getdescid" style="color: red"></span><br>
								</div>
							</div>
							<!-- Task Sign-off criteria -->
							<div class="form-group">
								<label class="col-md-3 control-label" for="message">Sign-off
									Criteria</label>
								<div class="col-md-9">
									<textarea class="form-control" id="editmessage1"
										name="signoff_criteria" placeholder="Sign-off Criteria"
										rows="3"></textarea>
									<span id="getsignid" style="color: red"></span><br>
								</div>
							</div>
							<!-- Task Duration -->
							<div class="form-group">
								<label class="col-md-3 control-label" for="name">Task
									Size *</label>
								<div class="col-md-9">
									<select class="form-control" id="sizecode"
										name="task_size_code">
										<c:forEach items="${tasksize}" var="record">
											<option id="tasksize" value="${record.task_size_code}">${record.task_size_code}-${record.task_size_hrs}</option>
										</c:forEach>
									</select> <br>
								</div>
								&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
								<!-- Link Tasks-->
								<div class="form-group">
									<label class="col-md-3 control-label" for="name">Link
										Tasks</label>
									<div class="col-md-9">
										<input id="editname1" name="name" type="text"
											placeholder="Enter Task ID" class="form-control"> <span
											id="getlinkid" style="color: red"></span><br>
									</div>
								</div>
								<!-- Attachments input-->
								<div class="form-group">
									<label class="col-md-3 control-label" for="name">Attachments</label>
									<div class="col-md-9">
										<div class="input-group">
											<input type="file" name="file" id="new-event"
												class="form-control" placeholder="Attachments">
											<div class="input-group-btn">
												<button type="button" id="color-chooser-btn"
													onclick="openFileOption();return;"
													class="btn btn-info dropdown-toggle">
													Browse <span class="caret"></span>
												</button>
												<ul class="dropdown-menu pull-right" id="color-chooser">
												</ul>
											</div>
										</div>
										<!-- /btn-group -->
									</div>
								</div>

								<div class="form-group">

									<div class="col-md-9">
										<input id="task_id" name="task_id" type="text"
											style="display: none;" placeholder="Enter Task ID"
											class="form-control"> <br>
									</div>
								</div>



								<!-- /input-group -->


								<!-- Form actions -->
								<div class="modal-footer">
									<button type="button" class="btn btn-danger pull-right"
										data-dismiss="modal">
										Close <i class="fa fa-times"></i>
									</button>
									<button type="Submit" class="btn btn-success pull-left"
										id="savetasks1" data-dismiss="modal">
										<i class="fa fa-plus"></i> Save
									</button>
								</div>
						</fieldset>
					</form>
				</div>
			</div>
		</div>
	</div>
	<div><%@include file="/WEB-INF/pages/layout/footer.jsp"%></div>
</body>
</html>