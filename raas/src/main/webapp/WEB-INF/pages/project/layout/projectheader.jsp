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
		<h4>
			<c:forEach items="${projectname}" var="record">
				<option id="${record.project_name}">${record.project_name}</option>
			</c:forEach>
		</h4>
	</div>
	<nav class="navbar navbar-default">
		<div>
			<ul class="nav  nav-justified">

				<c:forEach items="${project_id}" var="record" varStatus="status">
					<c:if test="${status.first}">
						<li><a
							href="${pageContext.request.contextPath}/projectboard?project_id=${record.project_id}""><b><i
									class="glyphicon glyphicon-list-alt primary"> </i> Dashboard </a></b></li>
					</c:if>
				</c:forEach>


				<c:forEach items="${project_id}" var="record" varStatus="status">
					<c:if test="${status.first}">
						<li><a
							href="${pageContext.request.contextPath}/crt/tasks?project_id=${record.project_id}"><b><i
									class="glyphicon glyphicon-list-alt primary"> </i> Planning
									Board</a></b></li>
					</c:if>
				</c:forEach>


				<c:forEach items="${project_id}" var="record" varStatus="status">
					<c:if test="${status.first}">
						<li><a
							href="${pageContext.request.contextPath}/teamboard?project_id=${record.project_id}"><i
								class="glyphicon glyphicon-tasks"> </i> Team board</a></li>
					</c:if>
				</c:forEach>

				<c:forEach items="${project_id}" var="record" varStatus="status">
					<c:if test="${status.first}">
						<li><a
							href="${pageContext.request.contextPath}/projectrole?project_id=${record.project_id}"><i
								class="glyphicon glyphicon-users"> </i> Resources</a></li>
					</c:if>
				</c:forEach>

				<li><a href="${pageContext.request.contextPath}/crt/chat"><i
						class="glyphicon glyphicon-user"></i> Meeting Place</a></li>
				<li><a href="#"><i class="glyphicon glyphicon-usd"> </i>
						Financials</a></li>

				<c:forEach items="${project_id}" var="record" varStatus="status">
					<c:if test="${status.first}">
						<li><a
							href="${pageContext.request.contextPath}/crt/projectdetail?project_id=${record.project_id}"><i
								class="glyphicon glyphicon-cog"> </i> Settings </a></li>
					</c:if>
				</c:forEach>
			</ul>
		</div>
	</nav>
</div>