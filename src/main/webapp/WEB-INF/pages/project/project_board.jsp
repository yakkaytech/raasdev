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
<spring:url value="/resources/common/js/project_board.js" var="js17" />
<spring:url value="/resources/common/js/image.js" var="js18" />





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
<script src="${js17}"></script>
<script src="${js18}"></script>


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
	

	<div class="container">
            <section class="content">
                
                <section class="content-header">
                    <h1>Dashboard</h1>
                    <section class="featureset">
                       <div class="row">
                       <div class="col-lg-12">   
                        <div class="panel panel-border">
                            <div class="panel-body">
                              <!-- panel body -->
                                   <div class="row">
                                        <nav class="navbar navbar-default">
                                            <div class="col-md-4">
                                                    <ul class="nav">
                                                            <li><a href="{{ URL::to('tasks') }}"><b><i class="glyphicon glyphicon-pencil "> </i>  Project Details</a></b></li>
                                                            <li><a href="{{ URL::to('team') }}"><i class="glyphicon glyphicon-plus"> </i> Add Feature Sets</a></li>
                                                            <li><a href="{{ URL::to('addpeople') }}"><i class="glyphicon glyphicon-th-list"></i> Plan & Estimates</a></li>
                                                            <li><button type="button" class="btn btn-primary button-tiny" style="margin-top:7px;">Create Plan</button>&nbsp;&nbsp;&nbsp;<button type="button" class="btn btn-primary button-tiny" style="margin-top:7px;">Request Plan</button></li>
                                                       </ul>
                                            </div>
                                            <!--
                                             <div class="col-md-3">
                                                    <ul class="nav">
                                                            <li><a href="{{ URL::to('tasks') }}"><i class="glyphicon glyphicon-pencil primary"> </i> Post jobs</a></li>
                                                            <li><a href="{{ URL::to('team') }}"><i class="glyphicon glyphicon-tasks"> </i> Review candidates</a></li>
                                                            <li><a href="{{ URL::to('addpeople') }}"><i class="glyphicon glyphicon-user"></i> Recruit Team</a></li>
                                                     </ul>
                                            </div>
                                          -->
                                            <div class="col-md-4">
                                                    <ul class="nav">
                                                            <li><a href="{{ URL::to('tasks') }}"><i class="glyphicon glyphicon-play-circle"> </i>Start the work</a></li>
                                                            <li><a href="{{ URL::to('team') }}"><i class="glyphicon glyphicon-equalizer"> </i> Review Progress</a></li>
                                                            <li><a href="{{ URL::to('addpeople') }}"><i class="glyphicon glyphicon-user"></i> Meeting Place</a></li>
                                                            </ul>
                                            </div>
                                            <div class="col-md-4">
                                                    <ul class="nav">
                                                            <li><a href="{{ URL::to('tasks') }}"><i class="glyphicon glyphicon-list-alt primary"> </i> Update project details</a></li>
                                                            <li><a href="{{ URL::to('team') }}"><i class="glyphicon glyphicon-tasks"> </i> Set permissions</a></li>
                                                            <li><a href="#"><i class="glyphicon glyphicon-usd"> </i> Invoice & Payments</a></li>
                                                            <li><a href="{{ URL::to('projectupdate') }}"><i class="glyphicon glyphicon-cog"> </i> Settings</a></li>
                                                     </ul>
                                            </div> 
                                        </nav>       
                                   </div> 
                            </div>    
                        </div> 
                        <!-- end of pannel -->
                      </div>
                    </div>
                  </section>
                 </section>

                 <div class="clearfix"></div>

                 <!-- section feature sets -->
                  <section class="featureset">
                                  <div class="row">
                                   <div class="col-lg-12">
                                          <div class="panel panel-border">
                                              <div class="panel-heading border-light">
                                                      <h4 class="panel-title">
                                                          <i class="livicon" data-name="grid" data-size="16" data-loop="true" data-c="#333"
                                                             data-hc="#333"></i>
                                                          Feature Sets
                                                      </h4>
                                                      <span class="pull-right">
                                                      <i>
                                                        <button type="button" class="button button-default button-tiny" id = "add_feature" >+ Add Feature</button>
                                                      </i>
                                                  </span>
                                              </div>
                                              <div class="panel-body table-responsive">
                                                  <table class="table table-condensed" id="table1">
                                                      <thead>
                                                          <tr>
                                                              <th class="col-md-2 text-center">Feature</th>
                                                              <th class="col-md-2 text-center">Priority</th>
                                                              <th class="col-md-2 text-center">Est. Time (hrs)</th>
                                                              <th class="col-md-2 text-center">Cost($)</th>
                                                              <th class="col-md-2 text-center">Start</th>
                                                              <th class="col-md-2 text-center">Status</th>
                                                          </tr>
                                                      </thead>
                                                      <tbody id = "task_body">
                                                      <c:forEach items="${feature}" var="record">
                                                          <tr class="taskrow">
                                                          
                                                          <td class="col-md-2 text-center" style = "display:none;">${record.feature_id}</td>
                                                           <td class="col-md-2 text-center" style = "display:none;" id ="task_count">${record.tasks_cnt_pergp}</td>
                                                              <td class="col-md-2" id="task_gp_name" value ="${record.feature_id}" ><a href="#" style = "color:blue;">${record.feature_name}</a></td>
                                                              <td class="col-md-2 text-center" id="priority_code" value= "${record.priority_code}" ><i id= "arrow" class=" "> </i></td>
                                                              <td class="col-md-2 text-center" id="est_time">40</td>
                                                              <td class="col-md-2 text-center" id="cost">$1000</td>
                                                              <td class="col-md-2 text-center" id="start"><i class="glyphicon glyphicon-play-circle"> </i></td>
                                                              <td class="col-md-2 text-center" id="status"><i class="glyphicon glyphicon-equalizer"> </i></td>
                                                            <td class="col-md-2 text-center" id="delete"><a href="#" > <i class="glyphicon glyphicon-remove"></i></a></td>
                                                         
                                                         </tr>
                                                        </c:forEach>
                                                      </tbody>
                                                  </table>
                                              </div>
                                          </div>
                                      </div>
                                  </div>
                                  <!-- row-->
                        </section>
         <!-- end of feature sets -->
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
								<form class="form-horizontal" id="savefeature"
									action="${pageContext.request.contextPath}/addfeature"
									method="post">
									<fieldset>
										<!-- Name input-->
										<div class="form-group">
											<label class="col-md-3 control-label" for="name">Feature
												Name *</label>
											<div class="col-md-9">
												<input id="name" name="name" 
													type="text" placeholder="Feature Name" class="form-control" ></input>
											</div>
										</div>
										<!-- Task Description -->
										<div class="form-group">
											<label class="col-md-3 control-label" for="message">Description</label>
											<div class="col-md-9">
												<textarea class="form-control" id="description"
													name="description" placeholder="Description"
													rows="5"></textarea>
											</div>
										</div>
										<!-- Task Sign-off criteria -->
										<div class="form-group">
											<label class="col-md-3 control-label" for="message">Sign-off
												Criteria</label>
											<div class="col-md-9">
												<textarea class="form-control" id="signoff_criteria"
													name="signoff_criteria"
													placeholder="Sign-off Criteria" rows="3"></textarea>
											</div>
										</div>
										<!-- /input-group -->
										<!-- Task Type input-->
										<div class="form-group">
											<label class="col-md-3 control-label" for="name">Priority
												*</label>
											<div class="col-md-9">
												<select class="form-control" id="prio_cde"
													name="priority_code">
													<option value=" "> </option>
													<c:forEach items="${prioritycode}" var="record">
														<option  value = "${record.priority_code}" >${record.priority_code}-${record.priority_cde_name}</option>
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
									id="close-featuregrp" data-adismiss="modal">
									Close <i class="fa fa-times"></i>
								</button>
								<button type="submit" class="btn btn-success pull-left"
									id="add-featuregrp" data-dismiss="modal">
									<i class="fa fa-plus"></i> Save
								</button>
							</div>
						</div>
					</div>
				</div>
				
		  <!-- end of Modal 1  -->
         <!-- Modal 2 begin -->
	     <!-- Modal -->

				<div class="modal fade" id="editModal" tabindex="-1" role="dialog"
					aria-labelledby="myModalLabel" aria-hidden="true">
					<div class="modal-dialog">
						<div class="modal-content">
							<div class="modal-header">
								<button type="button" class="close" data-dismiss="modal"
									aria-hidden="true">&times;</button>
								<h4 class="modal-title" id="myModalLabel">
									<i class="fa fa-plus"></i> Edit Group - <label
										id="taskgroupname"></label>
								</h4>
								<div class="col-md-9">
									<input type="hidden" name="taskgroupid" id="taskgroupId"></input>
								</div>
							</div>
							<div class="modal-body">
								<form:form modelAttribute="editdetails" class="form-horizontal"
									id="edit_feature"
									action="${pageContext.request.contextPath}/crt/edittaskgrp"
									method="post">
									<fieldset>

										<!-- Name input-->
										<div class="form-group">
											<label class="col-md-3 control-label" for="name">Feature
												Name *</label>
											<div class="col-md-9">

												<input type="text" id="edit_task_group_name"
													name="name" placeholder="Feature Name"
													class="form-control">${editdetails.feature_name}

											</div>
										</div>
										<!-- Task Description -->
										<div class="form-group">
											<label class="col-md-3 control-label" for="message">Description</label>
											<div class="col-md-9">

												<textarea class="form-control" id="edittaskgp_description"
													name="feature_description" placeholder="Description"
													rows="5">${editdetails.feature_description }</textarea>

											</div>
										</div>
										<!-- Task Sign-off criteria -->
										<div class="form-group">
											<label class="col-md-3 control-label" for="message">Sign-off
												Criteria</label>
											<div class="col-md-9">

												<textarea class="form-control"
													id="edittaskgp_signoff_criteria"
													value="${record.feature_signoff_criteria}"
													name="feature_signoff_criteria"
													placeholder="Sign-off Criteria" rows="3"></textarea>

											</div>
										</div>
										<!-- /input-group -->
										<!-- Task Type input-->
										<div class="form-group">
											<label class="col-md-3 control-label" for="name">Priority
												*</label>
											<div class="col-md-9">
												<select class="form-control" name="priority_code_name"
													id="priority_code_name">
													<option></option>
													<c:forEach items="${prioritycode}" var="record">
														<option value="${record.priority_code}">${record.priority_code}-${record.priority_cde_name}</option>
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
														class="form-control" value="${record.project_id}"></input>
												</c:forEach>
											</div>
										</div>

									</fieldset>
								</form:form>
							</div>
							<div class="modal-footer">
								<button type="button" class="btn btn-danger pull-right"
									id="close-new-event" data-dismiss="modal">
									Close <i class="fa fa-times"></i>
								</button>
								<button type="Submit" class="btn btn-success pull-left"
									id="edit-event" data-dismiss="modal">
									<i class="fa fa-plus"></i> Update
								</button>
							</div>
						</div>
					</div>
				</div>
				<!-- end of modal -->
				<!-- Modal 2 end -->
				<!-- Modal 3 begin -->
				<!-- Model for Delete -->
				<div class="modal fade" id="deleteModal" tabindex="-1" role="dialog"
					aria-labelledby="myModalLabel" aria-hidden="true">
					<form:form id="deletetaskgp"
						action="${pageContext.request.contextPath}/deletefeatures"
						method="POST">
						<div class="modal-dialog">
							<div class="modal-content">
								<div class="modal-header">
									<button type="button" class="close" data-dismiss="modal"
										aria-hidden="true">&times;</button>
									<h4 class="modal-title" id="myModalLabel">
										<i class="fa fa-plus"></i> Delete Group - <label
											id="taskgroupdelete"></label>
									</h4>
									<div class="col-md-9">
										<input type="hidden" name="taskgrpid" id="taskgrpid"
											class="taskgrpid"></input>
									</div>
								</div>
								<div class="modal-body">
								<div class="col-md-9">
										<input type="hidden" name="task_cnt" id="task_cnt"
											class="task_cnt"></input>
									</div>
							<div class="modal-body" style = "height:50%">
									<div class="input-group"></div>
								</div>
								<div>
									<label id="taskgroup_cnt"></label>
								</div>
									<div class="input-group">
										<c:forEach items="${project_id}" var="record">
											<input id="project_id" name="project_id" type="text"
												style="display: none" placeholder="Project id"
												class="form-control" class="form-control"
												value="${record.project_id}"></input>
										</c:forEach>
									</div>
								</div>
								<div class="modal-footer">
									<button type="button" class="btn btn-danger pull-right"
										id="close-new-event" data-dismiss="modal">
										Close <i class="fa fa-times"></i>
									</button>
									<button type="Submit" class="btn btn-success pull-left"
										id="delete-event" data-dismiss="modal">
										<i class="fa fa-plus"></i> OK
									</button>
								</div>
							</div>
						</div>
					</form:form>
				</div>
                  <div class="clearfix"></div>
              </section>
    </div>
	<!-- end of modal -->
	<!-- Modal 2 end -->
</body>
<div><%@include file="/WEB-INF/pages/layout/footer.jsp"%></div>
</html>