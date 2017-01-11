<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Tasks</title>

<spring:url value="/resources/common/js/jquery-1.11.1.min.js" var="js1" />
<spring:url value="/resources/common/vendors/form_builder1/js/jquery.ui.min.js" var="js2" />
<spring:url value="/resources/common/js/pages/moment.js" var="js3" />
<spring:url value="/resources/common/vendors/datepicker/js/bootstrap-datepicker.js" var="js4" />
<spring:url value="/resources/common/vendors/fullcalendar/fullcalendar.min.js" var="js6" />
<spring:url value="/resources/common/vendors/fullcalendar/moment.min.js" var="js7" />
<spring:url value="/resources/common/vendors/charts/jquery.sparkline.js" var="js8" />
<spring:url value="/resources/common/js/bootstrap.min.js" var="js10" />
<spring:url value="/resources/common/vendors/Knob/js/jquery.knob.js" var="js11" />
<spring:url value="/resources/common/js/pages/knob_page.js" var="js12" />
<spring:url value="/resources/common/js/sortableportlets.js" var="js13" />
<spring:url value="/resources/common/js/datepicker.js" var="js14" />

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
<script src="${js14}"></script>

<spring:url value="resources/common/vendors/wizard/jquery-steps/css/wizard.css" var="css2" />
<spring:url value="resources/common/vendors/wizard/jquery-steps/css/jquery.steps.css" var="css3" />
<spring:url value="resources/common/vendors/jasny-bootstrap/css/jasny-bootstrap.css" var="cs" />
<spring:url value="resources/common/vendors/select2/select2.min.css" var="css4" />
<spring:url value="resources/common/css/pages/wizard.css" var="css11" />
<spring:url value="/resources/common/resource/css/bootstrap-tagsinput.css" var="css1" />
<spring:url value="/resources/common/resource/css/formelements.css" var="css7" />
<spring:url value="/resources/common/resource/js/wizard.css" var="css5" />
<spring:url value="/resources/common/vendors/gallery/fancy_box/jquery.fancybox.css" var="css14" />
<spring:url value="/resources/common/vendors/gallery/fancy_box/helpers/jquery.fancybox-buttons.css" var="css15" />
<spring:url value="/resources/common/vendors/gallery/fancy_box/helpers/jquery.fancybox-thumbs.css" 	var="css16" />
<spring:url value="/resources/common/css/frontend/news.css" var="css17" />
<spring:url value="/resources/common/vendors/font-awesome/css/font-awesome.min.css" var="css18" />
<spring:url value="/resources/common/css/frontend/blog.css" var="css19" />
<spring:url value="/resources/common/resource/css/formscrollbar.css" var="css20" />
<spring:url value="/resources/common/resource/dropdown.css" var="css21" />
<spring:url value="/resources/common/resource/css/bootstrap-slider.min.css" var="css8" />
<spring:url value="/resources/common/css/bootstrap.min.css" var="css12" />
<spring:url value="/resources/common/css/frontend/custom.css" var="css13" />



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

     <form id="ck" action="${pageContext.request.contextPath}/crt/detailtasks" method="POST"> 
                            <div class="modal-dialog">
                                <div class="modal-content">
                                    <div class="modal-header">
                                        <button type="button" class="close" data-dismiss="modal"
                                                aria-hidden="true">&times;</button>
                                        <h4 class="modal-title" id="myModalLabel">
                                            <i class="fa fa-plus"></i>
                                            Create Group
                                        </h4>
                                    </div>
                                    
                                    <div class="modal-body">
                                        <div class="input-group">
                                        <c:forEach items="${taskdetails}" var="record" >
                                        <label>${record.task_id}</label>
                                            <input type="text" id="task_group_name" class="form-control"  placeholder="New Group" name="task_name" value="task_name">
                                        </c:forEach>         
                                                 <div class="input-group-btn">
                                                 </div>
                                            <!-- /btn-group -->
                                        </div>
                                        <!-- /input-group -->
                                    </div>
                                    <div class="modal-footer">
                                        <button type="button" class="btn btn-danger pull-right" data-dismiss="modal">
                                            Close
                                            <i class="fa fa-times"></i>
                                        </button>
                                        
                                        <button type="Submit" class="btn btn-success pull-left" id="add-new-event"
                                                data-dismiss="modal" >
                                            <i class="fa fa-plus"></i> Save
                                        </button>
                                       
                                    </div>
                                </div>
                            </div>
                             </form>                       

</body>
</html>