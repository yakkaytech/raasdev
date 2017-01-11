<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>

<spring:url
	value="/resources/common/vendors/datatables/js/jquery.dataTables.min.js"
	var="js1" />
<spring:url
	value="/resources/common/vendors/datatables/extensions/TableTools/js/dataTables.tableTools.min.js"
	var="js2" />
<spring:url
	value="/resources/common/vendors/datatables/extensions/ColReorder/js/dataTables.colReorder.min.js"
	var="js3" />
<spring:url
	value="/resources/common/vendors/datatables/extensions/Scroller/js/dataTables.scroller.min.js"
	var="js4" />
<spring:url
	value="/resources/common/vendors/datatables/extensions/RowReorder/js/dataTables.rowReorder.min.js"
	var="js5" />
<spring:url
	value="/resources/common/vendors/datatables/extensions/Responsive/js/dataTables.responsive.min.js"
	var="js6" />
<spring:url
	value="/resources/common/vendors/datatables/extensions/bootstrap/dataTables.bootstrap.min.js"
	var="js7" />
<spring:url value="/resources/common/js/pages/table-advanced.js"
	var="js8" />

<spring:url value="/resources/common/js/jquery-1.11.1.min.js" var="js9" />
<spring:url
	value="/resources/common/vendors/form_builder1/js/jquery.ui.min.js"
	var="js10" />
<spring:url value="/resources/common/js/pages/moment.js" var="js11" />
<spring:url
	value="/resources/common/vendors/datepicker/js/bootstrap-datepicker.js"
	var="js12" />
<spring:url
	value="/resources/common/vendors/fullcalendar/fullcalendar.min.js"
	var="js14" />
<spring:url value="/resources/common/vendors/fullcalendar/moment.min.js"
	var="js15" />
<spring:url value="/resources/common/vendors/charts/jquery.sparkline.js"
	var="js16" />
<spring:url value="/resources/common/js/bootstrap.min.js" var="js17" />
<spring:url value="/resources/common/vendors/Knob/js/jquery.knob.js"
	var="js18" />
<spring:url value="/resources/common/js/pages/knob_page.js" var="js19" />
<spring:url value="/resources/common/js/sortableportlets.js" var="js20" />

<spring:url value="/resources/common/js/jobdetail.js" var="js21" />
<spring:url value="/resources/common/js/toastr.js" var="js22" />
<spring:url value="/resources/common/js/image.js" var="js23" />
<spring:url value="/resources/common/js/proposal.js" var="js24" />


<script src="${js9}"></script>
<script src="${js10}"></script>
<script src="${js11}"></script>
<script src="${js12}"></script>
<script src="${js22}"></script>
<script src="${js14}"></script>
<script src="${js15}"></script>
<script src="${js16}"></script>
<script src="${js17}"></script>
<script src="${js18}"></script>
<script src="${js19}"></script>

<script src="${js20}"></script>
<script src="${js21}"></script>
<script src="${js23}"></script>
<script src="${js24}"></script>


<script src="${js1}"></script>
<script src="${js2}"></script>
<script src="${js3}"></script>
<script src="${js4}"></script>
<script src="${js5}"></script>
<script src="${js6}"></script>
<script src="${js7}"></script>
<script src="${js8}"></script>

<spring:url
	value="resources/common/vendors/wizard/jquery-steps/css/wizard.css"
	var="css2" />
<spring:url
	value="resources/common/vendors/wizard/jquery-steps/css/jquery.steps.css"
	var="css3" />
<spring:url
	value="resources/common/vendors/jasny-bootstrap/css/jasny-bootstrap.css"
	var="cs" />
<spring:url value="resources/common/vendors/select2/select2.min.css"
	var="css4" />
<spring:url value="resources/common/css/pages/wizard.css" var="css11" />
<spring:url
	value="/resources/common/resource/css/bootstrap-tagsinput.css"
	var="css1" />
<spring:url value="/resources/common/resource/css/formelements.css"
	var="css7" />
<spring:url value="/resources/common/resource/js/wizard.css" var="css5" />
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
<spring:url value="/resources/common/resource/dropdown.css" var="css21" />
<spring:url
	value="/resources/common/resource/css/bootstrap-slider.min.css"
	var="css8" />
<spring:url value="/resources/common/css/bootstrap.min.css" var="css12" />




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

</head>
<body>

	<%@include file="/WEB-INF/pages/layout/header.jsp"%>
	<div class="breadcum">
		<div class="container">
			<ol class="breadcrumb">
				<li><a href="{{ route('home') }}"> <i
						class="livicon icon3 icon4" data-name="home" data-size="18"
						data-loop="true" data-c="#3d3d3d" data-hc="#3d3d3d"></i>Job Search
				</a></li>
				<li class="hidden-xs"><i class="livicon icon3"
					data-name="angle-double-right" data-size="18" data-loop="true"
					data-c="#01bc8c" data-hc="#01bc8c"></i> <a href="#">News Item</a></li>
			</ol>
		</div>
	</div>
	<!-- Container Section Start -->
	<div class="container">
		<br>
		<section class="content">
		<div class="row">
			<div class="col-md-9">
				<div class="panel panel-white border-strong">

					<div class="panel-heading">
						<c:forEach items="${pro_details}" var="record" varStatus="status">
							<c:if test="${status.first}">
								<h3 class="warning">${record.project_name}</h3>
							</c:if>
						</c:forEach>
					</div>
					<div class="panel-body">
						<c:forEach items="${pro_details}" var="record" varStatus="status">
							<c:if test="${status.first}">
								<p>${record.project_desc}</p>
								<span>Primary Skill: ${record.primary_skill}</span>
								<br>
								<br>
								<span>Secondary Skill: ${record.secondary_skill}</span>
								<br>
								<hr>
							</c:if>
						</c:forEach>
					</div>
					<br>
					<div class="row" id=create_proposal>
						<div class="col-md-7" id="proposal">Below are the features
							set. You can submit a proposal by creating plan and estimates.
							Please use the button.</div>
						<div
							class="col-md-2>
                                <c:forEach items="${user_id}" var="record" >
											<input id="user" name="user_id" value ="${record.user_id}" style = "display:none;"></input>
										</c:forEach>	
						</div>
                                 <c:forEach items="${project_id}" var="record" varStatus="status">
                                <div class="col-md-4 pull-right">
                                    <button   id ="crt_proposal" value="${record.project_id}" class="button button-flat-primary button-small">Create a proposal</button>
                                </div> 
                                </c:forEach> 
                               <c:forEach items="${project_id}" var="record" varStatus="status">
                                <div class="col-md-4 pull-right">
                                <a href="${pageContext.request.contextPath}/proposal/project_id/${record.project_id}"> Proposal</a>
                                </div> 
                                </c:forEach> 
                        </div>                      
                             <!-- Feature Set Section -->        
                             <br>       
                            <hr>
                            <br>
                            <section class="featureset">
                            <h4 class="primary">Feature Sets</h4>
                            <br>
                            <div class="row">
                                     <table class="table table-condensed table-responsive">
                                                      <thead>
                                                          <tr>
                                                              <th class="col-md-3 text-center">Feature Name</th>
                                                              <th class="col-md-1 text-center">Priority</th>
                                                              <th class="col-md-4 text-center">Description</th>
                                                              <th class="col-md-4 text-center">Sign-off Creteria</th>
                                                          </tr>
                                                      </thead>
                                                      <tbody>
                                                      <c:forEach items="${feature}" var="record" varStatus="status">
                                                          <tr>
                                                              <td style = "display:none;"></td>
                                                              <td style = "display:none;"></td>
                                                              <td class="col-md-3">${record.feature_name}</td>
                                                              <td class="col-md-1 text-center" id="priority_code"  value= "${record.priority_code}"><i class=""> </i></td>
                                                              <td class="col-md-4 text-center"><span>${record.feature_description}</span></td>
                                                              <td class="col-md-4 text-center"><span>${record.feature_signoff_criteria}</span></td>
                                                         
                                                         </tr>
                                                         </c:forEach> 
                                                      </tbody>
                                                  </table>   
                            </div>
                          </section>
                            <br>
                            <hr>
                            <br>
                             <!-- Available roles section -->        
                            <section>
                             <c:forEach items="${available_roles}" var="record" varStatus="status">
                             <c:if test="${status.first}">
                            <h4 class="primary">Available Roles (${record.role_count})</h4>
                            </c:if>
                            </c:forEach>
                            <br>
                             <c:forEach items="${available_roles}" var="record" varStatus="status">
                            <div class="row">
                            
                                     <div class="col-xs-4">
                                       <h5><b>${record.role_name}</b></h5>
                                       <span>${record.project_desc}</span>
                                    </div>
                                    <div class="col-xs-4">
                                       <ul>
                                        <li><b>Rate/hr:</b>$10</li>
                                        <li>${record.frequency} hrs   ${record.category_code}</li>
                                        <li>Start Date:Nov 31st 2016</li>
                                        <li>End Date:Nov 31st 2016</li>
                                       </ul> 
                                    </div>
                                   
                                    <div class="col-xs-4 pull-center">
                                       <a href="#" class="button button-rounded button-flat-primary button-tiny">Apply</a>
                                    </div>        
                            </div>
                            <hr>
                            </c:forEach>
                           
                          </section>
                            </div> 
                            <!-- panel body end -->
                            
                       
                    <div class="col-md-4">

             </div>
        </div>
</div>
       <!-- row-->
		</section>
        <!-- //Content Section End -->
      <div class="modal fade" id="teamModal" tabindex="-1"
					role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
					<div class="modal-dialog">
						<div class="modal-content">
							<div class="modal-header">
								<button type="button" class="close" data-dismiss="modal"
									aria-hidden="true">&times;</button>
								<h4 class="modal-title" id="myModalLabel">
									<i class="fa fa-plus"></i> New Team
								</h4>
							</div>
							<div class="modal-body">
								<!--  <form class="form-horizontal" action="#" method="post"> -->
								<form id="create_team" name="create_team"
									enctype="multipart/form-data"
									action="${pageContext.request.contextPath}/proposal"
									method="POST">
									<fieldset>
										<!-- Task Type input-->
										<div class="form-group">
											<label class="col-md-3 control-label" for="name">Team Name
												 </label>
											<div class="col-md-9">
												<input id="team_name" name="team_name" type="text"
													placeholder="Your name" class="form-control">
											</div>
										</div>
										<br> <br>
										<div class="form-group">
											<c:forEach items="${project_id}" var="record">
												<input id="project_id" name="project_id"
													style="display: none" value="${record.project_id}"></input>
											</c:forEach>
										</div>
										<div class="form-group">
											<c:forEach items="${user_id}" var="record">
												<input id="user_id" name="user_id"
													style="display: none" value="${record.user_id}"></input>
											</c:forEach>
										</div>
										<!-- Name input-->
										<div class="form-group">
											<label class="col-md-3 control-label" for="name">Member Rate
												</label>
											<div class="col-md-9">
												<input id="rate" name="rate" type="text"
													placeholder="What is your rate for this project?" class="form-control"> 
											</div>
										</div>
										&nbsp;&nbsp;&nbsp;&nbsp;
											<!-- /input-group -->
										</div>
										<!-- Form actions -->
										<div class="modal-footer">
											<button type="button" class="btn btn-danger pull-right"
												id="cancel_team" data-dismiss="modal">
												Cancel <i class="fa fa-times"></i>
											</button>
											<button type="submit" class="btn btn-success pull-left"
												id="save_team" data-dismiss="modal">
												<i class="fa fa-plus"></i> Continue
											</button>
										</div>
									</fieldset>
								</form>
							</div>
						</div>
					</div>
				</div>
</div>
    </div>
    <!-- //Container end -->
</body>
<%@include file="/WEB-INF/pages/layout/footer.jsp"%>
</html>