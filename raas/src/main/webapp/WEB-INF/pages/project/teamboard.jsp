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
<title>Insert title here</title>

<spring:url value="/resources/common/js/jquery-1.11.1.min.js" var="js" />
<spring:url
	value="/resources/common/vendors/form_builder1/js/jquery.ui.min.js"
	var="js1" />
<spring:url value="/resources/common/js/pages/moment.js" var="js2" />
<spring:url
	value="/resources/common/vendors/datepicker/js/bootstrap-datepicker.js"
	var="js3" />
<spring:url value="/resources/common/js/todolist.js" var="js4" />
<spring:url value="/resources/common/vendors/fullcalendar/moment.min.js"
	var="js5" />
<spring:url
	value="/resources/common/vendors/fullcalendar/fullcalendar.min.js"
	var="js6" />
<spring:url
	value="/resources/common/vendors/charts/jquery.sparkline.min.js"
	var="js7" />
<spring:url value="/resources/common/js/dashboard.js" var="js8" />
<spring:url value="/resources/common/js/bootstrap.min.js" var="js9" />
<spring:url value="/resources/common/vendors/Knob/js/jquery.knob.js"
	var="js10" />
<spring:url value="/resources/common/js/pages/knob_page.js" var="js11" />
<spring:url value="/resources/common/js/teamboard.js" var="js12" />
<spring:url value="/resources/common/js/toastr.js" var="js13" />


<script src="${js}"></script>
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
<script src="${js12}"></script>
<script src="${js13}"></script>


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
<spring:url value="/resources/common/vendors/toastr/toastr.css"
	var="css30" />


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
<link href="${css30}" rel="stylesheet" />


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
<!--for calendar-->
	$(function() {
		$(".datepicker").datepicker();
	});
</script>

</head>
<body>
	<!-- Container Section Start-->

	<%@include file="/WEB-INF/pages/layout/header.jsp"%>
	<div><jsp:include page="layout/projectheader.jsp">
			<jsp:param name="project_id" value="${project_id}" />
		</jsp:include>
	</div>
	<div class="wrapper">
		<!-- Begin of left-->
		<aside class="left-side sidebar-offcanvas">
			<section class="sidebar">
				<div class="page-sidebar  sidebar-nav">
					<div class="clearfix"></div>
					<!-- BEGIN SIDEBAR MENU -->
					<section class="content-header">
						<div align="center">
							<h4>Team</h4>
						</div>
					</section>
					<div class="row">
						<div class="panel panel-white">
							<div class="panel-body no-padding">
								<div class="padding-15">
									<h5>
										Robert Devlin
										<h5>
											<h5>
												Vishal K.
												<h5>
													<h5>
														Edward James
														<h5>
								</div>
							</div>
						</div>
					</div>

				</div>
			</section>
		</aside>
		<!-- end of left-->
		<!-- Begin of right-->
		<aside class="right-side bdr_left">
			<div class="container-fluid">
				<div class="row">
					<div class="col-lg-7 bdr_right">
						<section class="content-header">
							<div class="row">
								<div class="col-md-4">
									<h1>Team board</h1>
								</div>
								<div class="col-md-8 pull-right">
									<br>
									<div class="btn-group">
										<button type="button" id="all" class="btn btn-default"
											style="margin-bottom: 7px;">All</button>
										<button type="button" id="ready" class="btn btn-default"
											style="margin-bottom: 7px;">Ready to work</button>
										<button type="button" id="inprogress" class="btn btn-default"
											style="margin-bottom: 7px;">In progress</button>
										<button type="button" id="cpml" class="btn btn-default"
											style="margin-bottom: 7px;">Completed</button>
									</div>
								</div>
							</div>
							<hr>
						</section>
						<section class="content">
							<div class="row" id="mydiv">
								<div class="row" id="readyforwork">
									<c:forEach items="${teamboard}" var="record" varStatus="status">
										<!-- begining of row -->

										<c:choose>
											<c:when test="${status.first}">
												<b><h4>${record.task_status}</h4></b>
											</c:when>
											<c:otherwise>
												<c:choose>
													<c:when
														test="${teamboard[status.index-1].task_status == record.task_status}">
														<b><h4 style="display: none">${record.task_status}</h4></b>
													</c:when>
													<c:otherwise>
														<b><h4>${record.task_status}</h4></b>
													</c:otherwise>
												</c:choose>
											</c:otherwise>
										</c:choose>
										<div class="panel panel-custom">
											<div class="panel-heading">

												<span class="task_id" id="${record.task_id}"><a
													style="color: blue" href=""><i
														class="glyphicon glyphicon-picture" style="color: blue"></i>
														${record.task_id}-${record.task_name} </a></span>

												<div class="pull-right">
													<span><button type="button"
															class="btn button-border-primary btn-circle">
															<b>${record.task_size_code}</b>
														</button></span> <span><button type="button"
															class="btn btn-default btn-circle"></button></span> <span><button
															type="button" class="btn btn-default btn-circle"></button></span>
													<span><button type="button"
															class="btn button-border-primary btn-circle">
															<i class="glyphicon glyphicon-pause"></i>
														</button></span>
												</div>
											</div>
											<div class="panel-body">${record.task_description}</div>
										</div>
									</c:forEach>
								</div>

								<div class='row' id="inp">
									<c:forEach items="${Inprogress}" var="record"
										varStatus="status">
										<!-- begining of row -->

										<c:choose>
											<c:when test="${status.first}">
												<b><h4>${record.task_status}</h4></b>
											</c:when>
											<c:otherwise>
												<c:choose>
													<c:when
														test="${Inprogress[status.index-1].task_status == record.task_status}">
														<b><h4 style="display: none">${record.task_status}</h4></b>
													</c:when>
													<c:otherwise>
														<b><h4>${record.task_status}</h4></b>
													</c:otherwise>
												</c:choose>
											</c:otherwise>
										</c:choose>
										<div class="panel panel-custom">
											<div class="panel-heading">

												<span class="task_id" id="${record.task_id}"><a
													style="color: blue" href=""><i
														class="glyphicon glyphicon-picture" style="color: blue"></i>
														${record.task_id}-${record.task_name} </a></span>

												<div class="pull-right">
													<span><button type="button"
															class="btn button-border-primary btn-circle">
															<b>${record.task_size_code}</b>
														</button></span> <span><button type="button"
															class="btn btn-default btn-circle"></button></span> <span><button
															type="button" class="btn btn-default btn-circle"></button></span>
													<span><button type="button"
															class="btn button-border-primary btn-circle">
															<i class="glyphicon glyphicon-pause"></i>
														</button></span>
												</div>
											</div>
											<div class="panel-body">${record.task_description}</div>
										</div>

									</c:forEach>
								</div>
								<div class='row' id="cmp">
									<c:forEach items="${completed}" var="record" varStatus="status">
										<!-- begining of row -->
										<c:choose>
											<c:when test="${status.first}">
												<b><h4>${record.task_status}</h4></b>
											</c:when>
											<c:otherwise>
												<c:choose>
													<c:when
														test="${completed[status.index-1].task_status == record.task_status}">
														<b><h4 style="display: none">${record.task_status}</h4></b>
													</c:when>
													<c:otherwise>
														<b><h4>${record.task_status}</h4></b>
													</c:otherwise>
												</c:choose>
											</c:otherwise>
										</c:choose>
										<div class="panel panel-custom">
											<div class="panel-heading">

												<span class="task_id" id="${record.task_id}"><a
													style="color: blue" href=""><i
														class="glyphicon glyphicon-picture" style="color: blue"></i>
														${record.task_id}-${record.task_name} </a></span>

												<div class="pull-right">
													<span><button type="button"
															class="btn button-border-primary btn-circle">
															<b>${record.task_size_code}</b>
														</button></span> <span><button type="button"
															class="btn btn-default btn-circle"></button></span> <span><button
															type="button" class="btn btn-default btn-circle"></button></span>
													<span><button type="button"
															class="btn button-border-primary btn-circle">
															<i class="glyphicon glyphicon-pause"></i>
														</button></span>
												</div>
											</div>
											<div class="panel-body">${record.task_description}</div>
										</div>

									</c:forEach>
								</div>
								<div class='row' id="sign">
									<c:forEach items="${signoff}" var="record" varStatus="status">
										<!-- begining of row -->
										<c:choose>
											<c:when test="${status.first}">
												<b><h4>${record.task_status}</h4></b>
											</c:when>
											<c:otherwise>
												<c:choose>
													<c:when
														test="${signoff[status.index-1].task_status == record.task_status}">
														<b><h4 style="display: none">${record.task_status}</h4></b>
													</c:when>
													<c:otherwise>
														<b><h4>${record.task_status}</h4></b>
													</c:otherwise>
												</c:choose>
											</c:otherwise>
										</c:choose>
										<div class="panel panel-custom">
											<div class="panel-heading">

												<span class="task_id" id="${record.task_id}"><a
													style="color: blue" href=""><i
														class="glyphicon glyphicon-picture" style="color: blue"></i>
														${record.task_id}-${record.task_name} </a></span>

												<div class="pull-right">
													<span><button type="button"
															class="btn button-border-primary btn-circle">
															<b>${record.task_size_code}</b>
														</button></span> <span><button type="button"
															class="btn btn-default btn-circle"></button></span> <span><button
															type="button" class="btn btn-default btn-circle"></button></span>
													<span><button type="button"
															class="btn button-border-primary btn-circle">
															<i class="glyphicon glyphicon-pause"></i>
														</button></span>
												</div>
											</div>
											<div class="panel-body">${record.task_description}</div>
										</div>

									</c:forEach>
								</div>
							</div>
						</section>
					</div>
					<!-- Task view -->
					<div><%@include file="/WEB-INF/pages/project/teamview.jsp"%></div>
				</div>
			</div>
		</aside>
	</div>
	<div><%@include file="/WEB-INF/pages/layout/footer.jsp"%></div>
	<!-- End of Wrapper-->
</body>
</html>