<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/2.2.2/jquery.min.js"></script>
<link href="http://code.jquery.com/ui/1.10.4/themes/ui-lightness/jquery-ui.css" rel="stylesheet">

<!-- CSS Section Start -->

<spring:url value="/resources/common/vendors/wizard/jquery-steps/css/wizard.css" var="css2" />
<spring:url value="/resources/common/vendors/wizard/jquery-steps/css/jquery.steps.css" var="css3" />
<spring:url value="/resources/common/vendors/jasny-bootstrap/css/jasny-bootstrap.css" var="cs" />
<spring:url value="/resources/common/vendors/select2/select2.min.css" var="css4" />
<spring:url value="/resources/common/css/pages/wizard.css" var="css11" />

<spring:url value="/resources/common/resource/css/bootstrap-tagsinput.css" var="css1" />
<spring:url value="/resources/common/resource/css/formelements.css" var="css7" />
<spring:url value="/resources/common/resource/js/wizard.css" var="css5" />
<spring:url value="/resources/common/vendors/gallery/fancy_box/jquery.fancybox.css" var="css14" />
<spring:url value="/resources/common/vendors/gallery/fancy_box/helpers/jquery.fancybox-buttons.css" var="css15" />
<spring:url value="/resources/common/vendors/gallery/fancy_box/helpers/jquery.fancybox-thumbs.css" var="css16" />
<spring:url value="/resources/common/css/frontend/news.css" var="css17" />
<spring:url value="/resources/common/vendors/font-awesome/css/font-awesome.min.css" var="css18" />
<spring:url value="/resources/common/css/frontend/blog.css" var="css19" />
<spring:url value="/resources/common/resource/css/formscrollbar.css" var="css20" />
<spring:url value="/resources/common/resource/dropdown.css" var="css21" />
<spring:url value="/resources/common/resource/css/bootstrap-slider.min.css" var="css8" />
<spring:url value="/resources/common/css/bootstrap.min.css" var="css12" />
<spring:url value="/resources/common/css/frontend/custom.css" var="css13" />
<spring:url value="/resources/common/resource/css/formscrollbar.css" var="scroll" />

<!-- JS Section Start -->

  <spring:url value="/resources/common/vendors/daterangepicker/moment.min.js" var="js7" /> 
  <spring:url value="/resources/common/vendors/wizard/jquery-steps/js/jquery.steps.js" var="js4" />
 <spring:url value="/resources/common/vendors/wizard/jquery-steps/js/jquery.validate.min.js" var="js5" />
 <spring:url value="/resources/common/vendors/jasny-bootstrap/js/jasny-bootstrap.js" var="js3" />
 <spring:url value="/resources/common/vendors/select2/select2.min.js" var="js6" /> 
 <spring:url value="/resources/common/js/pages/form_wizard.js" var="js2" />
 <spring:url value="/resources/common/resource/js/bootstrap-tagsinput.min.js" var="js1" />
 <spring:url value="/resources/common/statesMembernew.js" var="states"></spring:url>



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
											<div class="form-group">
												<label for="projecttype">Project Type *</label> <select
													id="projecttype" class="form-control required"
													name="project_type">
													<c:forEach items="${views5}" var="record">
														<option value="${record.project_id}">${record.project_type}</option>
													</c:forEach>
												</select>
											</div>
											<div class="form-group">
												<label for="projectname">Project Name *</label> <input
													id="projectname" name="project_name" type="text"
													placeholder="Project Name" maxlength="100"
													class="form-control required">
											</div>
											<div class="form-group">
												<label for="description">Project Description *</label>
												<textarea class="form-control" rows="4" id="description"
													name="project_desc" placeholder="Description"
													maxlength="255"></textarea>
											</div>
											<div class="form-group">
												<label for="description">Technology used *</label> <input
													id="skill" name="skill" type="text" value="JAVA,MYSQL"
													data-role="tagsinput" placeholder="technology"
													class="form-control required">
											</div>
											<p>(*) Mandatory</p>
										</section>
										<h1 class="hidden-xs">Resourcing</h1>
										<section>
											<h2 class="hidden">&nbsp;</h2>
											<div class="form-group" id="form-scroll">
												<label for="surname">Type of roles needed?</label>
												<div>
													<table class="table table-striped table-bordered"
														id="table1">
														<thead>
															<tr>
																<th class="col-md-2 text-center">Select</th>
																<th class="col-md-3">Job Title Name</th>
																<th>Title Description</th>
																<th>Quantity</th>
															</tr>
														</thead>
														<tbody>
															<c:forEach items="${views1}" var="record">
																<tr>
																	<td class="col-md-2 text-center"><input
																		type="checkbox" name="checkboxes" id="checkboxes"
																		value="${record.checkbox}"></td>
																	<td class="role"><p id="names" name="names">
																			<c:out value="${record.name}" />
																		</p></td>
																	<td><p>
																			<c:out value="${record.des}" />
																		</p></td>
																	<td><select id="quantity" class="form-control"
																		name="quantity">
																			<option value="1">1</option>
																			<option value="2">2</option>
																			<option value="3">3</option>
																	</select></td>
																</tr>
															</c:forEach>

															<tr>
																<td class="col-md-2 text-center"><input
																	type="checkbox" name="checkboxes" id="checkboxes-0"
																	value="999"></td>

																<td><input type="text" value="" placeholder="Other" /></td>
																<td><textarea class="form-control" rows="2"
																		id="description" name="textarea" placeholder="">
                                                           </textarea></td>
																<td valign="center"><select id="quantity"
																	class="form-control" name="quantity">
																		<option value="1">1</option>
																		<option value="2">2</option>
																		<option value="3">3</option>
																</select></td>
															</tr>


														</tbody>
													</table>
												</div>

											</div>
											<p>(*) Mandatory</p>
										</section>


										<h1>Other details</h1>
										<section>
											<h4>Project Location</h4>
											<div class="form-group">
												<label for="country">Country</label>
												<div>
													<select name="country" id="select2_Country"
														class="dropstate">
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
												<label for="timezone"> Please select your timezone.
													This would help us to find resources within your timezone:
												</label><br> <select name="timezone" id="timezone" class="dropstate">

													<c:forEach items="${views3}" var="record">
														<option value="${record.timezone_id}">${record.timezone_name}</option>
													</c:forEach>


												</select>
											</div>
											<br>
											<h4>Terms and Conditions</h4>

											<div class="pos-rel p-l-30">
												<input id="acceptTerms" name="acceptTerms" type="checkbox"
													class="pos-rel p-l-30 required"> <label
													for="acceptTerms">I agree with the Terms and
													Conditions.</label>
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
	<!-- //Container end -->

	<jsp:include page="layout/footer.jsp" />
</body>
</html>