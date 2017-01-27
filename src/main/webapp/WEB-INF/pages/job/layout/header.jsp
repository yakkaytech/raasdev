<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="sec"
	uri="http://www.springframework.org/security/tags"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<spring:url value="/resources/common/js/taskdetail.js" var="js1" />

<spring:url value="/resources/common/vendors/modal/css/component.css"
	var="css1" />
<spring:url value="/resources/common/css/frontend/tabbular.css"
	var="css2" />
<spring:url value="/resources/common/css/default.css" var="css3" />
<spring:url value="/resources/common/css/frontend/jquery.circliful.css"
	var="css4" />
<spring:url
	value="/resources/common/vendors/font-awesome-4.2.0/css/font-awesome.min.css"
	var="css5" />
<spring:url
	value="/resources/common/vendors/datatables/extensions/bootstrap/dataTables.bootstrap.css"
	var="css6" />
<spring:url
	value="/resources/common/vendors/Buttons-master/css/buttons.css"
	var="css7" />
<spring:url value="/resources/common/css/pages/advbuttons.css"
	var="css8" />
<spring:url value="/resources/common/css/frontend/news.css" var="css9" />
<spring:url value="/resources/common/css/pages/tab.css" var="css10" />
<spring:url value="/resources/common/css/metisMenu.css" var="css11" />
<spring:url value="/resources/common/css/frontend/blog.css" var="css12" />
<spring:url value="/resources/common/css/frontend/project.css"
	var="css13" />
<spring:url value="/resources/common/css/pages/tables.css" var="css14" />
<spring:url value="/resources/common/css/panel.css" var="css15" />

<script src="${js1}"></script>
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

<div class="projectbar">
	<div class="header">
	<div class="row">
		<h4>
			<c:forEach items="${projectname}" var="record">
				<div class="col-lg-3 pull-left" id="${record.project_name}">${record.project_name}</div>
				</c:forEach>
				
				
				<div class="col-lg-3">
				<c:forEach items="${user_id}" var="record" >
					<input    id="user_id" style="display:none;"
						data-dismiss="modal" value = "${record.user_id}"></input>
						</c:forEach>
				</div>
				

				<div class="col-lg-3 pull-right">
				<c:forEach items="${teamstatus}" var="record" >
					<button type="submit" class="btn btn-success pull-left"  id="submit_proposal"
						data-dismiss="modal" value = "${record.statusflag}">Submit a Proposal</button>
						</c:forEach>
				</div>
		</h4>
		</div>
	</div>
	<nav class="navbar navbar-default">
		<div>
		</div>
	</nav>
</div>