<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
 
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>userproposals</title>
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
<spring:url value="/resources/common/js/proposal.js" var="js15" />
<spring:url value="/resources/common/js/toastr.js" var="js16" />

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
<spring:url value="/resources/common/css/styles/white.css"
	var="css24" />

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
<link href="${css24}" rel="stylesheet">
</head>
<body>
<%@include file="/WEB-INF/pages/layout/header.jsp"%>
<div class="wrapper row-offcanvas row-offcanvas-left active relative" style="min-height:753px">
     <!-- Left side column. contains the logo and sidebar -->
     <aside class="left-side sidebar-offcanvas" style="min-height:200px">
            <section class="sidebar">
                <div class="page-sidebar sidebar-nav">
                    <!-- Begin Sidebar -->
                        <ul id="menu" class="page-sidebar-menu">
                            <li>
                              <a href="{{ URL::to('dashboard')}}">
                                <span class="Title">Dashboard</span>
                                </a>      
                            </li>
                            <li>
                                <a href="{{ URL::to('projects')}}">
                                </i>
                                <span class="Title">Projects</span>
                                </a>  
                            </li>
                            <li>
                                <a href="{{ URL::to('proposals')}}">
                                <span class="Title">Proposals</span>
                                </a>  
                            </li>
                            <li>
                                <a href="{{ URL::to('messages')}}">
                                <span class="Title">Messages</span>
                                </a>  
                            </li>  
                        </ul>    
                    <!-- End Sidebar -->
                </div>    
          </section>    
 </aside>   

    <!---- Begin of right-side put this in detail page-->
    <aside class="right-side">
          <section class="content-header">
                <h1>My Proposal List</h1>
                 <div class="content">
        <!--Content Section Start -->
        <!-- //Content Section End -->
         <!--Content Section Start -->
         <!--Content Section End -->
         <br><br><br><br>
         <div class="row">
            <div class="col-lg-8">
                         <!--Project Panel start -->
                        <div class="panel panel-default" style="border:1">
                            <div class="panel-heading border-light">
                                <h4 class="panel-title">
                                    Proposal for web development
                                </h4>
                            </div>
                            <div class="panel-body">
                                <div class="row">
                                   <div class="col-lg-6">
                                    <p>This is the test project for software development for the client unknown</p>
                                    <br>
                                    <br>
                                    <span class="glyphicon glyphicon-th-list">Todo list:</span>
                                    <br><br>
                                    <table style="border:1;colspacing:10px;">
                                          <tr>
                                                <td>
                                                    Task 1        
                                                </td>  
                                                 <td>
                                                    Task 2        
                                                </td>  
                                                 <td>
                                                    Task 3        
                                                </td>    
                                          </tr>  
                                    </table>    
                                    <br/>  

                                   </div>
                                   <div class="col-lg-2 pull-right">
                                    <a href="#" class="btn btn-info pull-right" role="button">
                                            <span class="glyphicon glyphicon-th-list"></span>
                                            <br/>
                                           Team board
                                        </a>

                                        <a href="#" class="btn btn-info pull-right" role="button">
                                            <span class="glyphicon glyphicon-envelope"></span>
                                            <br/>
                                            Messages
                                        </a>
                                   </div>
                                </div>
                            </div>
                        </div>
                       <!--Project Panel end -->
                       <br><br>
                       <!--Project Panel 2 start -->
                        <div class="panel panel-default" style="border:1">
                            <div class="panel-heading border-light">
                                <h4 class="panel-title">
                                    Proposal for Y development
                                </h4>
                            </div>
                            <div class="panel-body">
                                <div class="row">
                                   <div class="col-lg-6">
                                    <p>This is the test project for software development for the client unknown</p>
                                    <br>
                                    <br>
                                    <span class="glyphicon glyphicon-th-list">Todo list:</span>
                                    <br><br>
                                    <table style="border:1;colspacing:10px;">
                                          <tr>
                                                <td>
                                                    Task 1        
                                                </td>  
                                                 <td>
                                                    Task 2        
                                                </td>  
                                                 <td>
                                                    Task 3        
                                                </td>    
                                          </tr>  
                                    </table>    
                                    <br/>  

                                   </div>
                                   <div class="col-lg-2 pull-right">
                                    <a href="#" class="btn btn-info pull-right" role="button">
                                            <span class="glyphicon glyphicon-th-list"></span>
                                            <br/>
                                           Team board
                                        </a>

                                        <a href="#" class="btn btn-info pull-right" role="button">
                                            <span class="glyphicon glyphicon-envelope"></span>
                                            <br/>
                                            Messages
                                        </a>
                                   </div>
                                </div>
                            </div>
                        </div>
                       <!--Project Panel end --> 
            </div>
            <div class="col-lg-4">
                        <!--dashboard summary start -->
                        <!--dashboard summary end -->
                        
            </div>
          </div>  
    </div>








          </section>  
    </aside>  
    <!-- Begin of right-side -->

 <!-- Begin of wrapper - outer -->
</div>
</body>
<div><%@include file="/WEB-INF/pages/layout/footer.jsp"%></div>
</html>