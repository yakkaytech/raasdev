<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>

<html>
<head>

<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Welcome to New Member</title>

<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/2.2.2/jquery.min.js"></script>


<link
	href="http://code.jquery.com/ui/1.10.4/themes/ui-lightness/jquery-ui.css"
	rel="stylesheet">


<spring:url
	value="/resources/common/vendors/wizard/jquery-steps/css/wizard.css"
	var="css2" />
<spring:url value="/resources/common/resource/css/bootstrap-tagsinput.css"
	var="css1" />
<spring:url value="/resources/common/resource/css/formelements.css"
	var="css7" />
<spring:url value="/resources/common/resource/css/jquery.steps.css"
	var="css3" />
<spring:url value="/resources/common/resource/js/wizard.css" var="css5" />
<spring:url value="/resources/common/css/pages/wizard.css" var="css11" />

<spring:url value="/resources/common/resource/css/select2.min.css"
	var="css4" />
<spring:url
	value="/resources/common/resource/js/bootstrap-tagsinput.min.js" var="js1" />
<spring:url value="/resources/common/resource/css/bootstrap-slider.min.css"
	var="css8" />
<spring:url value="/resources/common/resource/js/form_wizard.js" var="js2" />
<spring:url value="/resources/common/resource/js/select2.min.js" var="js6" />
<spring:url value="/resources/common/resource/js/jquery.steps.js" var="js4" />
<spring:url value="/resources/common/resource/js/jasny-bootstrap.js"
	var="js3" />
<spring:url value="/resources/common/resource/js/moment.min.js" var="js7" />
<spring:url value="/resources/common/css/bootstrap.min.css" var="css12" />
<spring:url value="/resources/common/css/frontend/custom.css"
	var="css13" />
<spring:url value="/resources/common/resource/js/jquery.validate.min.js"
	var="js5" />
<spring:url value="/resources/common/statesMembernew.js" var="states"></spring:url>


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
	<spring:url value="/resources/common/resource/dropdown.css"
	var="css21" />

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

<script src="${js2}"></script>
<script src="${js6}"></script>
<script src="${js4}"></script>
<script src="${js3}"></script>
<script src="${js7}"></script>
<script src="${js5}"></script>
<script src="${states}"></script>
<script src="${js1}"></script>

</head>





<jsp:include page="/WEB-INF/pages/layout/header.jsp"/>
<div class="container">


	<!--section ends-->
	<section class="content">
	<div class="row">
		<div class="col-lg-12">
			<div class="panel panel-primary">
				<div class="panel-heading">
					<h3 class="panel-title">
						<i class="livicon" data-name="bell" data-size="16"
							data-loop="true" data-c="#fff" data-hc="white"></i> New Member
					</h3>
					<span class="pull-right clickable"> <i
						class="glyphicon glyphicon-chevron-up"></i>
					</span>
				</div>


				<div class="panel-body">
					<!--main content-->
					<div class="row">

						<div class="col-md-12">
							<!-- BEGIN FORM WIZARD WITH VALIDATION -->
							<form id="wizard-validation" name="wizard-validation">

								<h1 class="form-group">What do you do? - Experience &
									Skillset</h1>
								<section>
								<h2 class="hidden">&nbsp;</h2>

								<div class="form-scroll" id="form-scroll">
									<div class="form-group">
										<label for="description">Breif summary of your
											education & experience </label>
										<textarea class="form-control" rows="4" id="Breif_education"
											name="Breif_education"
											placeholder="Breif summary of your education & experience"></textarea>
									</div>
									<label for="Skillset">Enter Top 10 Skills</label>
									<div class="form-group" id="topskillgroup">
										<input type="text" class="form-control" name="topskill"
											id="topskill" value="JSP,PHP,JAVA,MYSQL"
											data-role="tagsinput" placeholder="Enter one skill" />

									</div>

									<div class="form-group">
										<label for="surname">Please select the role(s) that
											best fits your experience</label>
										<div>
											<table class="table table-striped table-bordered" id="root"
												name="root">
												<thead>
													<tr>
														<th class="col-md-2 text-center">Select</th>
														<th class="col-md-3">Role Name</th>
														<th>Role Description</th>
													</tr>
												</thead>
												<tbody>
													<c:forEach items="${view}" var="record">
														<tr>
															<td class="col-md-2 text-center"><input
																type="checkbox" name="checkboxes" id="checkboxes"
																value="${record.checkbox}"></td>
															<td class="role"><p>
																	<c:out value="${record.name}" />
																</p></td>
															<td><p>
																	<c:out value="${record.des}" />
																</p></td>
														</tr>
													</c:forEach>
													<tr>
														<td class="col-md-2 text-center"><input
															type="checkbox" name="checkboxes" id="checkboxes"
															value="999"></td>
														<td><label>Other</label> <input type="text"
															name="role_name" id="role_name" /></td>
														<td><textarea class="form-control" rows="2"
																name="role_des" id="role_des" placeholder="">
                                                           </textarea></td>
													</tr>
												</tbody>
											</table>
										</div>
									</div>
									<p>(*) Mandatory</p>

								</div>
								</section>



								<h1 class="form-group">Where do you work from?</h1>
								<section>

								<div class="form-group">
									<label for="country"> Please select the country where
										do you work: </label><br> <select name="select2_Country"
										id="select2_Country" class="dropstate">																				
										
										<c:forEach items="${view1}" var="record">
											<option value="${record.country_id}">${record.country_name}</option>
										</c:forEach>
									</select>
								</div>
								<div class="form-group">
									<label for="state"> State/Zone: </label><br> <select
										name="select2_StateZone" id="select2_StateZone" class="dropstate">
									<c:forEach items="${view3}" var="record">
											<option value="${record.state_id}">${record.state_name}</option>
										</c:forEach>

									</select>
								</div>



								<div class="form-group">
									<label for="country"> Please select your timezone. This
										would help us to find work within your timezone: </label><br> <select
										name="select2_TimeZone" id="select2_TimeZone">
										<c:forEach items="${view2}" var="record">
											<option value="${record.timezone_id}">${record.timezone_name}</option>
										</c:forEach>


									</select>
								</div>

								</section>



								<h1 class="form-group">Rate & Availability</h1>
								<section>

								<div class="form-group">
									<label class="col-md-2 control-label">Rate per hour
										($):</label><br>
									<div>
										<input id="idRate" name="idRate" type="text" />
									</div>
								</div>
								<div class="form-group">
									<label class="col-md-2 control-label">Weekly
										Availability - expected work per week</label><br> <select
										name="select2_Hour" id="select2_Hour" class="drophour">
																				
										<%
											for (int i = 1; i <= 40; i++) {
										%>
										<option value='<%=i%>'><%=i%>hr
										</option>
										<%
											}
										%>
									</select>
								</div>




								<div class="form-group">
									<label></label> <br>
									<div class="pos-rel p-l-30">
										<input id="acceptTerms" name="acceptTerms" type="checkbox"
											class="pos-rel p-l-30" required> <label
											for="acceptTerms">I agree with the Terms and
											Conditions.</label>
									</div>
								</div>


								</section>
							</form>
							<!-- END FORM WIZARD WITH VALIDATION -->
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


<jsp:include page="/WEB-INF/pages/layout/footer.jsp" />

</html>