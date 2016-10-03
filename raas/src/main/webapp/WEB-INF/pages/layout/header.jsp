<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<!DOCTYPE html>
<html>

<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <!-- HTML5 Shim and Respond.js IE8 support of HTML5 elements and media queries -->
    <!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
    <!--[if lt IE 9]>
    <script src="https://oss.maxcdn.com/libs/html5shiv/3.7.0/html5shiv.js"></script>
    <script src="https://oss.maxcdn.com/libs/respond.js/1.3.0/respond.min.js"></script>
    <![endif]-->
    <title>
    	
    </title>
    <!--global css starts-->

<spring:url value="resources/common/css/bootstrap.min.css" var="cs" />
<spring:url value="resources/common/css/frontend/custom.css" var="css1" />
<spring:url value="resources/common/css/default.css" var="css2" />

<link href="${cs}" rel="stylesheet">
<link href="${css1}" rel="stylesheet">
<link href="${css2}" rel="stylesheet">

<!--end of global css-->
   
</head>

<body>
    <!-- Header Start -->
    <header class="header">
        <!-- Icon Section Start  -->
        <div class="icon-section">
        <!-- //Icon Section End -->
        <!-- Nav bar Start -->
        <nav class="navbar navbar-default container">
            <div class="navbar-header">
                <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#collapse">
                    <span><a href="#">_<i class="livicon" data-name="responsive-menu" data-size="25" data-loop="true" data-c="#757b87" data-hc="#ccc"></i>
                    </a></span>
                </button>
            </div>
            <div class="collapse navbar-collapse" id="collapse">
                <ul class="nav navbar-nav navbar-left"> 
                     <li><a href="{{ route('home') }}"> Raaspool</a> </li>
                </ul>        
                <ul class="nav navbar-nav navbar-center">
                   
                   <!-- by raj -->

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
                    <li class="dropdown-toggle"><a href="{{ URL::to('infrastructure') }}">Jobs</a>
                    </li>
                    
                   <!-- end of raj -->

                    <li {!! (Request::is('blog') || Request::is('blogitem/*') ? 'class="active"' : '') !!}><a href="{{ URL::to('blog') }}"> How it works</a>
                    </li>
                   
                </ul>
                <ul class="nav navbar-nav navbar-right">    
                   
                        <li class="dropdown-toggle"> <a href="{{ URL::to('login') }}">LOGIN</a>
                        </li>
                        <li class="dropdown-toggle"> <a href="{{ URL::to('login') }}">CREATE PROJECT</a>
                        </li>
                        <li class="dropdown-toggle"><a href="{{ URL::to('register') }}">JOIN THE TEAM</a>
                        </li>
                    
                        <li {{ (Request::is('my-account') ? 'class=active' : '') }} class="dropdown-toggle"><a href="{{ URL::to('my-account') }}">My Account</a>
                        </li>
                        <li class="dropdown-toggle"><a href="{{ URL::to('logout') }}">Logout</a>
                        </li>
                    
                </ul>
            </div>
        </nav>
        <!-- Nav bar End -->
    </div>

    </header>
    <!-- //Header End -->