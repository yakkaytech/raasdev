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
<spring:url value="/resources/common/css/pages/tables.css" var="css11" />
<spring:url value="/resources/common/css/panel.css" var="css12" />
<spring:url value="/resources/common/css/metisMenu.css" var="css13" />
<spring:url value="/resources/common/css/styles/white.css" var="css14" />
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
	<!-- Container Section Start -->
	<div>

	<div id="header">
		<h4>PROJECT X DEVELOPMENT</h4>
	</div>
	<nav class="navbar navbar-default"></nav>
	<div class="well well-sm center">
		<ul class="nav nav-justified">
			<li class="active"><a href="#"><i
					class="glyphicon glyphicon-dashboard"> </i> Dashboard</a></li>
			<li><a href="#"><b><i
						class="glyphicon glyphicon-list-alt primary"> </i> Planning board</a></b></li>
			<li><a href="#"><i class="glyphicon glyphicon-tasks"> </i>
					Team board</a></li>
			<li><a href="#"><i class="glyphicon glyphicon-user"></i>
					Resourcing</a></li>
			<li><a href="#"><i class="glyphicon glyphicon-usd"> </i>
					Financials</a></li>
			<li><a href="#"><i class="glyphicon glyphicon-cog"> </i>
					Settings</a></li>
		</ul>
	</div>

	<div class="wrapper row-offcanvas row-offcanvas-left">
		<!-- Begin of wrapper -->
		<!-- Left side column. contains the logo and sidebar -->
		<aside class="left-side sidebar-offcanvas"> <section
			class="sidebar ">
		<div class="page-sidebar  sidebar-nav">
			<div class="clearfix"></div>
			<!-- BEGIN SIDEBAR MENU -->
			<ul id="menu" class="page-sidebar-menu">
				<li><a href=""> <i class="livicon" data-name="home"
						data-size="18" data-c="#418BCA" data-hc="#418BCA" data-loop="true"></i>
						<span class="title">Task Details</span>
				</a></li>
				<li><a href=""> <i class="livicon" data-name="home"
						data-size="18" data-c="#418BCA" data-hc="#418BCA" data-loop="true"></i>
						<span class="title">History</span>
				</a></li>
				<li><a href=""> <i class="livicon" data-name="home"
						data-size="18" data-c="#418BCA" data-hc="#418BCA" data-loop="true"></i>
						<span class="title">Timeline</span>
				</a></li>
			</ul>
		</div>
		</section> </aside>
		<!-- End of right side column. -->
		<aside class="right-side"> <!-- Left side column. contains the logo and sidebar -->
		<!--Content Section Start --> <section class="content-header">
		<c:forEach items="${taskview}" var="record" >
		<!--<h1>PRJ1234 - User Registration</h1>-->
		<h1>${record.task_id} - ${record.task_name}</h1>
		</c:forEach>
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
						<button type="button" class="btn btn-default"
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
				<c:forEach items="${taskview}" var="record" >
				<div class="news_item_image thumbnail">
					<div class="panel ">
						<!-- Panel body main content begin-->
						<div class="panel-body">
							<!-- Task Type input-->
		                 					
							<div class="form-group">
								 
								<label class="col-md-3 control-label" for="name">Task
									Type: </label>
									
							    <label id="task_type_name" name="task_type_name" class="col-md-9 control-label" for="name">${record.task_type_name}</label>
							
							</div>
							
							
										<div class="form-group">
												<label class="col-md-3 control-label" for="name">Task
													Description:</label><label class="col-md-9 control-label" for="name"><p>${record.task_description}</p> </label>
												</div>
											</div>
								<div class="form-group">
												<label class="col-md-3 control-label" for="name">Sign-off
													Criteria:</label><label class="col-md-9 control-label" for="name"><p>${record.task_signoff_criteria}</p> </label>
												
											</div>
								<!--
                                     <div class="form-group">
                                            <label class="col-md-3 control-label" for="name">Task Size</label>
                                            <label class="col-md-9 control-label" for="name">${record.task_size_code}</label>
                                    </div> -->
							<div class="form-group">
								<div class="form-group">
									<label class="col-md-3 control-label" for="name">Est.
										Start Date</label> <label class="col-md-3 control-label" for="name"> <p>${record.date_begin}</p>
										</label> <label class="col-md-3 control-label" for="name">End
										Date</label> <label class="col-md-3 control-label" for="name"><p>${record.date_end}</p>
										</label>
								</div>
							</div>
							<div class="form-group">
								<label class="col-md-3 control-label" for="name" >Attachments</label>
								<label class="col-md-9 control-label" for="name" id="attach" onclick = "attachment()">
								<a href='${pageContext.request.contextPath}/crt/download/${record.file_name}'><p>${record.file_name}</p></a></label>
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
			<!-- end of col 1 -->
			<!-- Row 1 Col 2 Section End -->
			<div class="col-lg-4 col-full-width-left">
				<!-- Featured Author Section Start -->
				<div class="the-box  no-margin more-padding martop3">
					<h3>Team</h3>
					<br>
					<div class="row">
						<div class="col-xs-3">
							<p>
								<a href="#"> <img src="${pageContext.request.contextPath}/resources/common/images/13.jpg"
									class="img-responsive img-circle" alt="riot">
								</a>
							</p>
						</div>
						<!-- /.col-xs-3 -->
						<div class="col-xs-3">
							<p>
								<a href="#"> <img src="${pageContext.request.contextPath}/resources/common/images/14.jpg"
									class="img-responsive img-circle" alt="riot">
								</a>
							</p>
						</div>
						<!-- /.col-xs-3 -->
						<div class="col-xs-3">
							<p>
								<a href="#"> <img src="${pageContext.request.contextPath}/resources/common/images/15.jpg"
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
									src="${pageContext.request.contextPath}/resources/common/images/13.jpg" alt="image">
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
									src="${pageContext.request.contextPath}/resources/common/images/14.jpg" alt="image">
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
									src="${pageContext.request.contextPath}/resources/common/images/15.jpg" alt="image">
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
</body>
</html>