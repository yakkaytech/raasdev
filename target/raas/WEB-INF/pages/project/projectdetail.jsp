<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>



<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>



<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>

<spring:url value="/resources/common/js/pages/moment.js" var="js1" />
<spring:url
	value="/resources/common/vendors/datepicker/js/bootstrap-datepicker.js"
	var="js2" />

<!--  todolist-->
<spring:url value="/resources/common/js/todolist.js" var="js3" />
<!--for calendar-->
<spring:url value="/resources/common/vendors/fullcalendar/moment.min.js"
	var="js4" />
<spring:url
	value="/resources/common/vendors/fullcalendar/fullcalendar.min.js"
	var="js5" />
<spring:url value="/resources/common/vendors/charts/jquery.sparkline.js"
	var="js6" />
<spring:url value="/resources/common/js/jquery-1.11.1.min.js" var="js7" />
<spring:url value="/resources/common/js/bootstrap.min.js" var="js8" />
<spring:url value="/resources/common/js/pages/knob_page.js" var="js9" />
<spring:url value="/resources/common/vendors/Knob/js/jquery.knob.js"
	var="js10" />
<spring:url value="/resources/common/js/dashboard.js" var="js11" />

<!-- CSS Section Start -->

<spring:url
	value="/resources/common/vendors/wizard/jquery-steps/css/wizard.css"
	var="css15" />
<spring:url
	value="/resources/common/vendors/wizard/jquery-steps/css/jquery.steps.css"
	var="css16" />
<spring:url
	value="/resources/common/vendors/jasny-bootstrap/css/jasny-bootstrap.css"
	var="cs" />
<spring:url value="/resources/common/vendors/select2/select2.min.css"
	var="css17" />
<spring:url value="/resources/common/css/pages/wizard.css" var="css18" />
<spring:url value="/resources/common/css/frontend/news.css" var="css19" />
<spring:url value="/resources/common/css/font-awesome.min.css"
	var="css20" />

<spring:url
	value="/resources/common/resource/css/bootstrap-tagsinput.css"
	var="css1" />
<spring:url value="/resources/common/resource/css/formelements.css"
	var="css2" />
<spring:url value="/resources/common/resource/js/wizard.css" var="css3" />
<spring:url
	value="/resources/common/vendors/gallery/fancy_box/jquery.fancybox.css"
	var="css4" />
<spring:url
	value="/resources/common/vendors/gallery/fancy_box/helpers/jquery.fancybox-buttons.css"
	var="css5" />
<spring:url
	value="/resources/common/vendors/gallery/fancy_box/helpers/jquery.fancybox-thumbs.css"
	var="css6" />
<spring:url value="/resources/common/css/frontend/news.css" var="css7" />
<spring:url
	value="/resources/common/vendors/font-awesome/css/font-awesome.min.css"
	var="css8" />
<spring:url value="/resources/common/css/frontend/blog.css" var="css9" />
<spring:url value="/resources/common/resource/css/formscrollbar.css"
	var="css10" />
<spring:url value="/resources/common/resource/dropdown.css" var="css11" />
<spring:url
	value="/resources/common/resource/css/bootstrap-slider.min.css"
	var="css12" />
<spring:url value="/resources/common/css/bootstrap.min.css" var="css13" />
<spring:url value="/resources/common/css/frontend/custom.css"
	var="css14" />
<spring:url value="/resources/common/resource/css/formscrollbar.css"
	var="scroll" />

<link href="${cs}" rel="stylesheet">
<link href="${css1}" rel="stylesheet">
<link href="${css2}" rel="stylesheet">
<link href="${css3}" rel="stylesheet">
<link href="${css4}" rel="stylesheet">
<link href="${css5}" rel="stylesheet">
<link href="${css6}" rel="stylesheet">
<link href="${css7}" rel="stylesheet">
<link href="${css8}" rel="stylesheet">
<link href="${css9}" rel="stylesheet">
<link href="${css10}" rel="stylesheet">
<link href="${css11}" rel="stylesheet">
<link href="${css12}" rel="stylesheet">
<link href="${css13}" rel="stylesheet">
<link href="${css14}" rel="stylesheet">
<link href="${css15}" rel="stylesheet">
<link href="${css16}" rel="stylesheet">
<link href="${css17}" rel="stylesheet">
<link href="${css18}" rel="stylesheet">
<link href="${css19}" rel="stylesheet">
<link href="${css20}" rel="stylesheet">
<link href="${scroll}" rel="stylesheet">




<script src="${js1}"></script>
<script src="${js2}"></script>
<script src="${js3}"></script>
<script src="${js4}"></script>
<script src="${js5}"></script>
<script src="${js6}"></script>
<script src="${js7}"></script>
<script src="${js8}"></script>
<script src="${js9}"></script>
<script src="${js10}"></script>
<script src="${js11}"></script>

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
	<!-- Container Section Start-->
	<div class="wrapper">
		<!-- Begin of left-->
		<aside class="left-side sidebar-offcanvas"> <section
			class="sidebar">
		<div class="page-sidebar  sidebar-nav">
			<div class="clearfix"></div>
			<!-- BEGIN SIDEBAR MENU -->
			<ul id="menu" class="page-sidebar-menu">
				<li><a href=""> <i class="livicon" data-name="home"
						data-size="18" data-c="#418BCA" data-hc="#418BCA" data-loop="true"></i>
						<span class="title">Project</span>
				</a></li>
				<li><a href=""> <i class="livicon" data-name="home"
						data-size="18" data-c="#418BCA" data-hc="#418BCA" data-loop="true"></i>
						<span class="title">Jobs</span>
				</a></li>
				<li><a href=""> <i class="livicon" data-name="home"
						data-size="18" data-c="#418BCA" data-hc="#418BCA" data-loop="true"></i>
						<span class="title">Task</span>
				</a></li>
				<li><a href=""> <i class="livicon" data-name="home"
						data-size="18" data-c="#418BCA" data-hc="#418BCA" data-loop="true"></i>
						<span class="title">Permissions</span>
				</a></li>
			</ul>
		</div>
		</section> </aside>
		<!-- end of left-->
		<!-- Begin of right-->
		<aside class="right-side bdr_left">
		<div class="container-fluid">
               
			<div class="row">
                  
				<div class="col-lg-8">
					<section class="content-header">
					<h1>Project Update</h1>
					<hr>
					</section>
					<section class="content">
					<h2 class="hidden">&nbsp;</h2>
					<c:forEach items="${update}" var="record" >
					<div class="form-group">
						<label for="projecttype">Project Type *</label> <select
							id="projecttype" class="form-control required"
							name="project_type">
							<c:forEach items="${views5}" var="record">
								<option value="${record.project_id}">${record.project_type}</option>
							</c:forEach>
						</select>
						
					</div>
					</c:forEach>
					<div class="form-group">
						<label for="projectname">Project Name *</label> 
						<label
							id="projectname" name="projectName" type="text"
							placeholder="Project Name" class="form-control required">${record.project_name}</label>
					</div>
					<div class="form-group">
						<label for="description">Project Description *</label>
						<textarea class="form-control" rows="4" id="description"
							name="textarea" placeholder="Description">${record.project_desc}</textarea>
					</div>
					<br>
					<h4>
						<b>Technology</b>
					</h4>
					<hr>
					<div class="form-group">
						<label for="projecttype">Primary technology stack *</label> <select
							id="projecttype" class="form-control required" name="select">
							<option value=""></option>
							<option value="6">.NET</option>
							<option value="6">Android</option>
							<option value="1">ASP.NET</option>
							<option value="6">iOS</option>
							<option value="2">Java</option>
							<option value="3">JavaScript</option>
							<option value="4">PHP</option>
							<option value="4">Python</option>
							<option value="5">Ruby</option>
							<option value="5">Office 365</option>
							<option value="5">Other</option>
						</select>
					</div>
					<div class="form-group">
						<label for="description">Add other technologies</label>
						<textarea class="form-control" rows="4" data-role="tagsinput"
							placeholder="technology" class="form-control required"></textarea>
					</div>
					<br>
					<h4>
						<b>Location</b>
					</h4>
					<hr>
					<div class="form-group">
						<label>Country</label>
						<div>
							<select name="country" id="select2_Country" class="dropstate">
								<c:forEach items="${views2}" var="record">
									<option value="${record.country_id}">${record.country_name}</option>
								</c:forEach>
							</select>
						</div>
					</div>
					<div class="form-group">
						<label for="state"> State/Zone: </label><br> <select
							name="zone" id="select2_StateZone" class="dropstate">
							<c:forEach items="${views4}" var="record">
								<option value="${record.state_id}">${record.state_name}</option>
							</c:forEach>

						</select>
					</div>
					<div class="form-group">
						<label for="timezone"> Please select your timezone. This
							would help us to find resources within your timezone: </label><br> <select
							name="timezone" id="timezone">

							<c:forEach items="${views3}" var="record">
								<option value="${record.timezone_id}">${record.timezone_name}</option>
							</c:forEach>


						</select>
					</div>
					<br>
					<h4>
						<b>Budget and Timelines</b>
					</h4>
					<hr>
					<div class="form-group">
						<label for="budget"> Any budget estimates? </label><br> <input
							id="demo2" type="text" value="0" name="demo2"
							class="form-control">
					</div>
					<div class="form-group">
						<label for="country"> Any timelines? </label><br> <select>
							<option value=""></option>
							<option value="1">Less than a month</option>
							<option value="2">1 to 3 months</option>
							<option value="3">3 to 6 months</option>
							<option value="4">6 to 12 months</option>
						</select>
					</div>

					</section>

				</div>
				<div class="col-lg-4"></div>
				
			</div>
			
		</div>
		<div>

			<button type="Submit" class="btn btn-success pull-left"
				id="savetasks">

				<i class="fa fa-plus"></i> Save
			</button>

		</div>

		<!-- Begin of right-->
	</div>
	<!-- End of Wrapper-->




</body>
</html>