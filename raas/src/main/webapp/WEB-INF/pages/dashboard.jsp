<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
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
<spring:url value="/resources/common/resource/js/knockout-3.4.0.js" var="js17" />

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
<script src="${js17}"></script>
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
 <%@include file="/WEB-INF/pages/member/layout/memberheader.jsp"%>


 <div class="container">
        <!--Content Section Start -->
        <br><br>
         <!-- //Content Section End -->
         <!--Content Section Start -->
         <!--Content Section End -->
         <br><br><br><br>
         <div class="row">
            <div class="col-lg-8">
                         <!--Project Panel start -->
                        <div class="panel panel-primary" style="border:1">
                            <div class="panel-heading border-light">
                                <h4 class="panel-title">
                                    Project X development
                                </h4>
                            </div>
                            <div class="panel-body">
                                <div class="row">
                                   <div class="col-lg-6">
                                    <p>This is the test project for software development for the client unknown</p>
                                    <br>
                                    <br>
                                    <span class="glyphicon glyphicon-th-list">Task list:</span>
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
                                        <a href="#" class="btn btn-info pull-right" role="button">
                                            <span class="glyphicon glyphicon-cloud"></span>
                                            <br/>
                                            Infrastructure
                                        </a>
                                   </div>
                                </div>
                            </div>
                        </div>
                       <!--Project Panel end -->
                       <br><br>
                       <!--Project Panel 2 start -->
                        <div class="panel panel-primary" style="border:1">
                            <div class="panel-heading border-light">
                                <h4 class="panel-title">
                                    Project X development
                                </h4>
                            </div>
                            <div class="panel-body">
                                <div class="row">
                                   <div class="col-lg-6">
                                    <p>This is the test project for software development for the client unknown</p>
                                    <br>
                                    <br>
                                    <span class="glyphicon glyphicon-th-list">Task list:</span>
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
                                        <a href="#" class="btn btn-info pull-right" role="button">
                                            <span class="glyphicon glyphicon-cloud"></span>
                                            <br/>
                                            Infrastructure
                                        </a>
                                   </div>
                                </div>
                            </div>
                        </div>
                       <!--Project Panel end --> 
            </div>
            <div class="col-lg-4">
                        <!--dashboard summary start -->
                        <div class="panel panel-success">
                            <div class="panel-heading panel-success">
                                <h4 class="panel-title">
                                    <i class="livicon" data-name="clock" data-size="16" data-loop="true" data-c="#fff" data-hc="white"></i>
                                    Jobs matching your skillsets
                                </h4>
                            </div> 
                              <div class="panel-body">
                                <div class="row">
                                        <ul>
                                        <li>
                                             <h5><b><a href="">Rich WPF Application</a></b></h5>
                                        </li>
                                        <li>
                                           Need to develop a graphically rich WPF desktop application based on an 
                                            existing architecture, that uses Entity Framework, MVVM, WCF and WS. 
                                        </li>
                                        <li>
                                          <b>Skills</b>:ASP.NET, WPF, MVC, JavaScript 
                                        </li>
                                        <li>
                                        <a href="#" class="button button-rounded button-flat-grey button-tiny">Apply</a>
                                        </li>
                                        </ul>
                                </div>  
                                 <div class="row">
                                        <ul>
                                        <li>
                                             <h5><b><a href="">Application development</a></b></h5>
                                        </li>
                                        <li>
                                           Need to develop a product development using Java platform. 
                                        </li>
                                        <li>
                                          <b>Skills</b>:JavaScript, MVC, MySQL  
                                        </li>
                                        <li>
                                        <a href="#" class="button button-rounded button-flat-grey button-tiny">Apply</a>
                                        </li>
                                        </ul>
                                </div>                     
                            </div>
                        </div>
                        <!--dashboard summary end -->
                        <!--dashboard summary start -->
                        <div class="panel panel-success">
                            <div class="panel-heading ">
                                <h4 class="panel-title">
                                    <i class="livicon" data-name="clock" data-size="16" data-loop="true" data-c="#fff" data-hc="white"></i>
                                    Messages
                                </h4>
                            </div> 
                              <div class="panel-body">
                                <div class="row">
                                    
                                </div>
                            </div>
                        </div>
                          <!--dashboard summary end -->
                        <!--dashboard summary start -->
                         <div class="panel panel-success">
                            <div class="panel-heading">
                                <h4 class="panel-title">
                                    <i class="livicon" data-name="clock" data-size="16" data-loop="true" data-c="#fff" data-hc="white"></i>
                                    Transactions
                                </h4>
                            </div> 
                              <div class="panel-body">
                                <div class="row">
                                   
                                </div>
                            </div>
                        </div>
                          <!--dashboard summary end -->
                        <!--dashboard summary start -->
                         <div class="panel panel-success">
                            <div class="panel-heading">
                                <h4 class="panel-title">
                                    <i class="livicon" data-name="clock" data-size="16" data-loop="true" data-c="#fff" data-hc="white"></i>
                                    Profile
                                </h4>
                            </div> 
                              <div class="panel-body">
                                <div class="row">
                                   
                                </div>
                            </div>
                        </div>
                          <!--dashboard summary end -->
                        
            </div>
          </div>  
    </div>
</body><div><%@include file="/WEB-INF/pages/layout/footer.jsp"%></div>
</html>