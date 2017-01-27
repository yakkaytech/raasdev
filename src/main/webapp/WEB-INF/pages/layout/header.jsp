<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html>
<html>
<head>
<title>Welcome to RaaS</title>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">

<spring:url value="/resources/common/css/styles/raas.css" var="whitecs" />
<spring:url value="/resources/common/css/bootstrap.min.css" var="cs" />
<spring:url value="/resources/common/css/frontend/font-awesome.min.css" var="fontawesome" />
<spring:url value="/resources/common/css/metisMenu.css" var="mmcs" />
<spring:url value="/resources/common/css/frontend/custom.css" var="css1" />



<link href="${whitecs}" rel="stylesheet">
<link href="${cs}" rel="stylesheet">
<link href="${css1}" rel="stylesheet">
<link href="${fontawesome}" rel="stylesheet">
<link href="${mmcs}" rel="stylesheet">



<!--end of global css-->
</head>
<body>
    <!-- Header Start -->
   
    <header class="header">
        <!-- Icon Section Start  -->
        <div class="icon-section">
        <!-- //Icon Section End -->
        <!-- Nav bar Start -->
        <nav class="navbar navbar-static-top" role="navigation">
            <div class="navbar-header">
                <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#collapse">
                    <span><a href="#">_<i class="livicon" data-name="responsive-menu" data-size="25" data-loop="true" data-c="#757b87" data-hc="#ccc"></i>
                    </a></span>
                </button>
            </div>
            <div class="collapse navbar-collapse" id="collapse"  >
             <!--    <ul class="nav navbar-nav navbar-left"  > 
                     <li><a href="{{ route('home') }}"> Raaspool</a> </li>
                </ul>        
                <ul class="nav navbar-nav navbar-center">-->
                   
                   <!-- by raj -->
                   <ul class="nav navbar-nav"> 
                     <li class="dropdown-toggle"><a href="{{ route('home') }}">Raaspool</a> </li>
                

                    <li class="dropdown"><a href="#" class="dropdown-toggle" data-toggle="dropdown"> Projects</a>
                        <ul class="dropdown-menu" role="menu">
                            <li><a href="{{ URL::to('newproject') }}">New Project</a></li>
                            <li><a href="{{ URL::to('taskdetail') }}">task detail</a>
                            <li><a href="{{ URL::to('Roles') }}">Roles</a>
                            <li><a href="{{ URL::to('team') }}">Team Board</a></li>
                        </ul>
                    </li>

                     <li class="dropdown {!! (Request::is('aboutus') || Request::is('timeline') || Request::is('faq') || Request::is('blank_page')  ? 'active' : '') !!}"><a href="#" class="dropdown-toggle" data-toggle="dropdown"> Teams</a>
                        <ul class="dropdown-menu" role="menu">
                            <li><a href="{{ URL::to('dashboard') }}">Dashboard</a></li>
                            <li><a href="{{ URL::to('newmember') }}">New Member</a></li>
                            <li><a href="{{ URL::to('paymentlist') }}">Payment List</a></li>
                            <li><a href="{{ URL::to('payment') }}">Payment</a></li>
                            <li><a href="{{ URL::to('ratecard') }}">ratecard</a></li>
                        </ul>
                    </li>
                      
                    <li class="dropdown-toggle"><a href="${pageContext.request.contextPath}/jobs">Jobs</a>
                    </li>
                     <li> <a href="">How it works</a></li>  
                   </ul>
                   <!-- end of raj -->
                   <div class="navbar-right">
					<ul class="nav navbar-nav">
                        <li class="dropdown-toggle"><a href="{{ URL::to('register') }}">SignUp</a>
                        </li>                                       
                       
                       <%
                         String username=(String) session.getAttribute("user");
                         if(username==null){
                        	 %> <li class="dropdown-toggle" id="login"> <a href="${pageContext.request.contextPath}/login">LOGIN</a>
                             </li>
                             <% }else{
                            	 %>
                          <li {{ (Request::is('my-account') ? 'class=active' : '') }} class="dropdown-toggle"><a href="{{ URL::to('my-account') }}">My Account</a>
                       		 </li>
                             <li class="dropdown-toggle" id="logout"><a href="${pageContext.request.contextPath}/logout">Logout</a>
                             </li>                              
                         <%  }
                        %>                         
                     </ul>  
                     </div>
            </div>
        </nav>
        <!-- Nav bar End -->
    </div>
    </header>
     <div class="wrapper">
    <!-- //Header End -- -->