<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>

<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<spring:url value="resources/common/css/styles/white.css" var="css1" />
<link href="${css1}" rel="stylesheet">
</head>
<body>
 <div class="container">
                <div id="header">
                
               <h4 id="newTabButton" class="tabButtonHidden"> ${pageContext.request.userPrincipal.name} -  </h4> 
                   
                </div>
                <nav class="navbar navbar-default">*
                <div class="well well-sm center ">
                        <ul class="nav  nav-justified">
                            <li class="active"><a href="#"><i class="glyphicon glyphicon-dashboard"> </i> Dashboard</a></li>
                                <li><a href="#"><b><i class="glyphicon glyphicon-list-alt primary"> </i> Planning board</a></b></li>
                                <li><a href="#"><i class="glyphicon glyphicon-tasks"> </i> Team board</a></li>
                                <li><a href="#"><i class="glyphicon glyphicon-user"></i> Resourcing</a></li>
                                <li><a href="#"><i class="glyphicon glyphicon-usd"> </i> Financials</a></li>
                                <li><a href="${pageContext.request.contextPath}/crt/projectdetail"><i class="glyphicon glyphicon-cog"> </i> Settings</a></li>
                         </ul>
                </div>
                </nav>   
    </div>
</body>
</html>