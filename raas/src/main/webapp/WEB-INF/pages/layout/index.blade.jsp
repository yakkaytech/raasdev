<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>index.blade</title>

<!-- page level js starts-->


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
	var="js5" />
<spring:url value="/resources/common/vendors/fullcalendar/moment.min.js"
	var="js6" />
<spring:url value="/resources/common/vendors/charts/jquery.sparkline.js"
	var="js7" />
<spring:url value="/resources/common/js/bootstrap.min.js" var="js8" />
<spring:url value="/resources/common/vendors/Knob/js/jquery.knob.js"
	var="js9" />
<spring:url value="/resources/common/js/pages/knob_page.js" var="js10" />
<spring:url value="/resources/common/js/sortableportlets.js" var="js11" />
<spring:url value="/resources/common/js/datepicker.js" var="js12" />
<spring:url value="/resources/common/js/taskdetail.js" var="js13" />
<spring:url value="/resources/common/js/frontend/jquery.circliful.js"
	var="js14" />
<spring:url value="/resources/common/js/frontend/carousel.js" var="js15" />
<spring:url value="/resources/common/js/frontend/index.js" var="js16" />
<spring:url
	value="/resources/common/vendors/owl-carousel/owl.carousel.js"
	var="js17" />



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
<script src="${js14}"></script>
<script src="${js15}"></script>
<script src="${js16}"></script>
<script src="${js17}"></script>

<!--page level js ends-->

<!--page level css starts-->
<spring:url value="/resources/common/css/frontend/tabbular.css"
	var="css" />
<spring:url value="/resources/common/css/frontend/jquery.circliful.css"
	var="css1" />
<spring:url value="/resources/common/resource/css/head-foot.css"
	var="css2" />
<spring:url
	value="resources/common/vendors/jasny-bootstrap/css/jasny-bootstrap.css"
	var="css3" />
<spring:url
	value="/resources/common/resource/css/bootstrap-tagsinput.css"
	var="css4" />
<spring:url value="/resources/common/resource/css/formelements.css"
	var="css5" />
<spring:url value="/resources/common/resource/js/wizard.css" var="css6" />
<spring:url
	value="/resources/common/vendors/gallery/fancy_box/helpers/jquery.fancybox-buttons.css"
	var="css7" />
<spring:url
	value="/resources/common/vendors/gallery/fancy_box/helpers/jquery.fancybox-thumbs.css"
	var="css8" />
<spring:url value="/resources/common/css/frontend/news.css" var="css9" />
<spring:url
	value="/resources/common/vendors/font-awesome/css/font-awesome.min.css"
	var="css10" />
<spring:url value="/resources/common/css/frontend/blog.css" var="css11" />
<spring:url value="/resources/common/resource/css/formscrollbar.css"
	var="css12" />
<spring:url value="/resources/common/resource/dropdown.css" var="css13" />
<spring:url
	value="/resources/common/resource/css/bootstrap-slider.min.css"
	var="css14" />
<spring:url value="/resources/common/css/bootstrap.min.css" var="css15" />
<spring:url value="/resources/common/css/frontend/custom.css"
	var="css16" />
<spring:url
	value="/resources/common/vendors/gallery/fancy_box/jquery.fancybox.css"
	var="css17" />
<spring:url value="/resources/common/resource/css/head-foot.css"
	var="css18" />


<link href="${css}" rel="stylesheet">
<link href="${css1}" rel="stylesheet">
<link href="${css2}" rel="stylesheet">
<link href="${css4}" rel="stylesheet">
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

<!--end of page level css-->




</head>
<body>
	<%@include file="/WEB-INF/pages/layout/header.jsp"%>
	<!--Carousel Start -->
	<div id="main-slide">
		<div class="item">
			<img
				src="${pageContext.request.contextPath}/resources/common/images/slide_4.jpg"
				alt="slider-image">
		</div>
	</div>
	<!-- //Carousel End -->


	<!-- Layout Section Start -->
	<section class="feature-main">
	<div class="container">
		<div class="row">
			<div class="col-sm-6 col-md-3">
				<div class="box">
					<div class="box-icon">
						<i class="livicon icon" data-name="users" data-size="55"
							data-loop="true" data-c="#01bc8c" data-hc="#01bc8c"></i>
					</div>
					<div class="info">
						<h3 class="success text-center">People</h3>
						<p>Lorem ipsum dolor sit amet, consectetur adipisicing elit.
							Corrupti atque, tenetur quam aspernatur corporis at explicabo
							nulla dolore necessitatibus doloremque exercitationem sequi
							dolorem architecto perferendis quas aperiam debitis dolor soluta!</p>
						<div class="text-right primary">
							<a href="#">Read more</a>
						</div>
					</div>
				</div>
			</div>
			<!-- //Responsive Section End -->
			<!-- Easy to Use Section Start -->
			<div class="col-sm-6 col-md-3">
				<!-- Box Start -->
				<div class="box">
					<div class="box-icon box-icon1">
						<i class="livicon icon1" data-name="gears" data-size="55"
							data-loop="true" data-c="#418bca" data-hc="#418bca"></i>
					</div>
					<div class="info">
						<h3 class="primary text-center">Process</h3>
						<p>Lorem ipsum dolor sit amet, consectetur adipisicing elit.
							Corrupti atque, tenetur quam aspernatur corporis at explicabo
							nulla dolore necessitatibus doloremque exercitationem sequi
							dolorem architecto perferendis quas aperiam debitis dolor
							soluta!.</p>
						<div class="text-right primary">
							<a href="#">Read more</a>
						</div>
					</div>
				</div>
			</div>
			<!-- //Easy to Use Section End -->
			<!-- Clean Design Section Start -->
			<div class="col-sm-6 col-md-3">
				<div class="box">
					<div class="box-icon box-icon2">
						<i class="livicon icon1" data-name="hammer" data-size="55"
							data-loop="true" data-c="#f89a14" data-hc="#f89a14"></i>
					</div>
					<div class="info">
						<h3 class="warning text-center">Tools</h3>
						<p>Lorem ipsum dolor sit amet, consectetur adipisicing elit.
							Corrupti atque, tenetur quam aspernatur corporis at explicabo
							nulla dolore necessitatibus doloremque exercitationem sequi
							dolorem architecto perferendis quas aperiam debitis dolor soluta!</p>
						<div class="text-right primary">
							<a href="#">Read more</a>
						</div>
					</div>
				</div>
			</div>
			<!-- //Clean Design Section End -->
			<!-- 20+ Page Section Start -->
			<div class="col-sm-6 col-md-3">
				<div class="box">
					<div class="box-icon box-icon3">
						<i class="livicon icon1" data-name="desktop" data-size="55"
							data-loop="true" data-c="#FFD43C" data-hc="#FFD43C"></i>
					</div>
					<div class="info">
						<h3 class="yellow text-center">Infrastructure</h3>
						<p>Lorem ipsum dolor sit amet, consectetur adipisicing elit.
							Corrupti atque, tenetur quam aspernatur corporis at explicabo
							nulla dolore necessitatibus doloremque exercitationem sequi
							dolorem architecto perferendis quas aperiam debitis dolor soluta!</p>
						<div class="text-right primary">
							<a href="#">Read more</a>
						</div>
					</div>
				</div>
			</div>
			<!-- //20+ Page Section End -->

		</div>
	</div>
	</section>
	<!-- //Layout Section Start -->
	<section class="feature-main2">
	<div class="container">
		<div class="row">

			<div class="col-md-9 col-sm-9 col-xs-12">
				<div class="layout-image">
					<img
						src="${pageContext.request.contextPath}/resources/common/images/layout.png"
						alt="layout" class="img-responsive" />
				</div>
			</div>
			<div class="col-md-3 col-sm-3 col-xs-12">
				<ul class="list-unstyled pull-right text-right layout-styl">
					<li><i class="livicon" data-name="checked-on" data-size="20"
						data-loop="true" data-c="#01bc8c" data-hc="#01bc8c"></i> Plan your
						work</li>
					<li><i class="livicon" data-name="checked-on" data-size="20"
						data-loop="true" data-c="#01bc8c" data-hc="#01bc8c"></i> Organize
						the work</li>
					<li><i class="livicon" data-name="checked-on" data-size="20"
						data-loop="true" data-c="#01bc8c" data-hc="#01bc8c"></i> Create
						teams</li>
					<li><i class="livicon" data-name="checked-on" data-size="20"
						data-loop="true" data-c="#01bc8c" data-hc="#01bc8c"></i> Monitor
						the progress</li>
					<li><i class="livicon" data-name="checked-on" data-size="20"
						data-loop="true" data-c="#01bc8c" data-hc="#01bc8c"></i> Control
						the work</li>
				</ul>
			</div>
		</div>
	</div>
	</section>

	<div><%@include file="/WEB-INF/pages/layout/footer.jsp"%></div>
</body>
</html>