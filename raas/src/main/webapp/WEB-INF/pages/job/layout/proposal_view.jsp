<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>

</head>
<body>
	<div class="col-lg-5" id="proposal_details">
		<div class="row" align="center">
			<h4>Team</h4>

			<div>
				<div id="team">
					<ul class="nav nav-sidebar" id="teamid">
						<c:forEach items="${team}" var="record">
							<li value="${record.team_id}" id="${record.team_id}"
								class="taskgpclass"><a class="some-trigger" href="#"> <span
									id="taskgpname" class="taskgpname">${record.firstname}</span> <span
									id="project_id">${record.lastname}</span>
							</a></li>
						</c:forEach>
					</ul>
				</div>
				<div>
					<button id="add_member">+Add Apeople</button>
				</div>
			</div>
		</div>
		<hr>
	</div>
	<c:forEach items="${teamdetail}" var="record" varStatus="stat">
		<c:if test="${stat.first}">
			<div class="col-lg-5" id="teamviewdetails">
				<section class="content-header">
				<div class="row" align="center">
					<h4 id="team_task_name">Task : ${record.task_name}</h4>
					<h4 id="teamname" style="display: none;">${record.task_name}</h4>
					<div class="col-xs-3"></div>
					<div class="col-xs-1">
						<span><button type="button" title="task"
								class="btn button-border-primary btn-circle">
								<i class="glyphicon glyphicon-list-alt"></i>
							</button></span>
					</div>
					<div class="col-xs-1">
						<span><button type="button"
								class="btn button-border-primary btn-circle">
								<i class="glyphicon glyphicon-paperclip"></i>
							</button></span>
					</div>
					<div class="col-xs-1">
						<span><button type="button"
								class="btn button-border-primary btn-circle">
								<i class="glyphicon glyphicon-tags"></i>
							</button></span>
					</div>
					<div class="col-xs-1">
						<span><button type="button"
								class="btn button-border-primary btn-circle">
								<i class="glyphicon glyphicon-equalizer"></i>
							</button></span>
					</div>
					<div class="col-xs-1">
						<span><button type="button"
								class="btn button-border-primary btn-circle"
								id="edit_proposaltask">
								<i class="glyphicon glyphicon-pencil"></i>
							</button></span>
					</div>
					<div class="col-xs-1">
						<span><button type="button"
								class="btn button-border-primary btn-circle">
								<i class="glyphicon glyphicon-bullhorn"></i>
							</button></span>
					</div>
					<div class="col-xs-3"></div>
				</div>
				<hr>
				</section>
				<section>
				<div class="row">
					<div class="form-group">
						<label class="col-xs-3 control-label" for="name"
							style="display: none">Task id:</label> <label
							class="col-xs-9 control-label" for="name" style="display: none"
							id="team_task_id">${record.task_id}</label>
					</div>
					<div class="form-group">
						<label class="col-xs-3 control-label" for="name"
							style="display: none">Status_name :</label> <label
							class="col-xs-9 control-label" for="name" style="display: none"
							id="status_name">${record.status_name}</label>
					</div>
					<div class="form-group">
						<label class="col-xs-3 control-label" for="name"
							style="display: none">project id:</label> <label
							class="col-xs-9 control-label" for="name" id="project_id"
							style="display: none">${record.project_id}</label>
					</div>
					<div class="form-group">
						<label class="col-xs-3 control-label" for="name"
							style="display: none;">Feature_id:</label> <label
							class="col-xs-9 control-label" for="name" id="team_task_group_id"
							style="display: none;">${record.feature_id}</label>
					</div>
					<div class="form-group">
						<label class="col-xs-3 control-label" for="name">Task
							Type:</label> <label class="col-xs-9 control-label" for="name"
							id="team_task_type">${record.task_type_name}</label>
					</div>
					<div class="form-group">
						<label class="col-xs-3 control-label" for="name">Task
							Description:</label> <label class="col-xs-9 control-label" for="name"
							id="team_task_description">${record.task_description} </label>
					</div>
				</div>
				<div class="form-group">
					<label class="col-xs-3 control-label" for="name">Sign-off
						Criteria:</label> <label class="col-xs-9 control-label" for="name"
						id="team_task_sign">${record.task_signoff_criteria} </label>
				</div>
				<br>
				<br>
				<br>
				<div class="form-group">
					<label class="col-xs-3 control-label" for="name">Estimated
						hours:</label> <label class="col-xs-9 control-label" for="name"
						id="estimated_hours">${record.estimated_hours} </label>
				</div>
				<br>
				<br>
				<br>
				<div class="form-group">
					<label class="col-xs-3 control-label" for="name">Attachments
					</label> <label class="col-md-9 control-label" for="name" id="attach"
						value="${record.file_name}" onclick="attachment()"> <a
						style="color: blue"
						href='${pageContext.request.contextPath}/crt/download/${record.file_name}'>${record.file_name}</a></label>
				</div>
				</section>
		</c:if>
	</c:forEach>
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
						enctype="multipart/form-data">
						<fieldset>
							<!-- Task Type input-->
							<div class="form-group">
								<label class="col-md-3 control-label" for="name">Task
									Type *</label>
								<div class="col-md-9">
									<select class="form-control" name="task_type_id" id="selId">
										<c:forEach items="${tasktype}" var="record">
											<option id="tasktypeid" value="${record.task_type_id}">${record.task_type_name}</option>
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
									<label class="col-md-3 control-label" for="name">Estimated_hours
									</label>
									<div class="col-md-9">
										<input id="estimated_hours" name="estimated_hours" type="text"
											placeholder="Estimated_hours" class="form-control">
									</div>
								</div>
								<!-- Attachments input-->
								&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; <br> <br>
								<div class="form-group">
									<label class="col-md-3 control-label" for="message">Attachments
									</label>
									<div class="col-md-9">
										<input class="form-control" id="attachment" name="Attachments"
											placeholder="Attachments" rows="1"></input>
									</div>
								</div>
								&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
								<div class="form-group">
									<label class="col-md-3 control-label" for="name">Attachments</label>
									<div class="col-md-9">
										<div class="input-group">
											<input type="file" name="file" id="new-eventattach"
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
									<input id="team_id" name="team_id" style="display: none"
										value="${team_id}"></input>
								</div>
								<div class="form-group">
									<div class="col-md-9">
										<input id="taskid" name="task_id" type="text"
											class="form-control" style="display: none;" /> <input
											id="feature_id" name="feature_id" type="text"
											class="form-control" style="display: none;" /> <input
											id="projectid" name="project_id" type="text"
											class="form-control" style="display: none;" /> <br>
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
										id="edittasks" data-dismiss="modal">
										<i class="fa fa-plus"></i> Save
									</button>
								</div>
						</fieldset>
					</form>
				</div>
			</div>
		</div>
</body>
</html>