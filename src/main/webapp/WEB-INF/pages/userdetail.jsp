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
<spring:url value="/resources/common/js/bootstrap-taglabel.min.js"
	var="js20" />
<spring:url value="/resources/common/js/userdetails.js" var="js21" />
<spring:url value="/resources/common/js/toastr.js" var="js22" />
<spring:url value="/resources/common/js/typeahead.js" var="js23" />
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
<script src="${js20}"></script>
<script src="${js21}"></script>
<script src="${js22}"></script>
<script src="${js23}"></script>

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
<spring:url value="/resources/common/resource/css/select2.min.css"
	var="css23" />
<spring:url
	value="/resources/common/css/jQueryUI/jquery-ui-1.10.3.custom.css"
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
<link href="${css23}" rel="stylesheet">
<link href="${css24}" rel="stylesheet">


</head>
<body>
	<!-- Container Section Start-->
	<%@include file="/WEB-INF/pages/member/layout/memberheader.jsp"%>
	<form id="userdetails" name="userdetails"   method="POST" enctype="multipart/form-data">
	<div class="container">
	    <br><br><br><br>
         <div class="row" align="left">
                  <div class="col-lg-8 col-md-8">
                         <!--Project Panel start -->
                        <div class="panel panel-default" style="border:1">
                            <div class="panel-body">
                              <div class="row">
                                    <!-- image -->
                                  <div class="col-md-4">
                                             <div class="form-group">
                                                <div class="text-center">
                                                   <div class="fileinput fileinput-new" data-provides="fileinput">
                                                      <div class="fileinput-new thumbnail">
                                                      <c:choose>
														    <c:when test="${not empty image}">
                                                               <img src="${pageContext.request.contextPath}/resources/common/images/${image}" class="profile-pic" id="profile-pic" alt="profile pic"/>
														    </c:when>
														    <c:otherwise>
                                                           <img src="http://placehold.it/200x200" class="profile-pic" id="profile-pic" alt="profile pic"/>
														    </c:otherwise>
														</c:choose>
                                                     </div>
                                                     <div>
                                                          <div class="glyphicon glyphicon-camera hide" id="upload-button" style="cursor:pointer;"></div>
                                                          <input class="file-upload" type="file" id="new-event" name="file" accept="image/*" style="display:none;"/>
                                                          
                                                        </div>
                                                 </div>
                                               </div>

                                            </div>   
                                  </div>  
                                  <!-- Name & address -->
                                   
                                  
                                  <div class="col-md-4 col-md-4">
                                  <div class="form-group">
                                       
                                        <ul id="editul"> <c:forEach items="${userdetail}" var="rec">
                                        <h5 style="display:none;"><li>${rec.user_id}</li></h5>
                                        <h3> <li>${rec.firstname} ${rec.lastname}</li></h3></c:forEach>
                                          <c:forEach items="${userrole}" var="rec">
                                         <h4> <li>${rec.role_name}</li></h4></c:forEach>
                                         <c:forEach items="${userdetail}" var="rec">
                                          <h5><li>${rec.country_name}</li></h5>
                                          <h5><li>${rec.zone_name}</li> </h5> 
                                          </c:forEach>
                                          <a href="#" class="button button-rounded button-flat-primary button-tiny" id="edit">Edit</a>&nbsp;&nbsp;&nbsp;                          
                                         </ul>
                                         <div id="showul" class="hide"> <c:forEach items="${userdetail}" var="rec">
                                            <input style="display:none;"class="form-control" id="user_id" name="user_id" value="${rec.user_id}">
                                             <br>
                                             <input id="firstname" class="form-control" name="first_name" value="${rec.firstname}"/>
                                             <br>
                                             <input id="lastname" class="form-control" name="last_name" value="${rec.lastname}"/></c:forEach>
                                             <br>
                                           
											    <select id="role_id" class="form-control required" name="roleid"  multiple>
											                                              
											        
											        <c:forEach var="ordTyp" items="${role}">   
											            <c:set var="mySelectVar" value=""></c:set>
											            <c:forEach var="item" items="${userrole}">
											                <c:if test="${ordTyp.checkbox==item.role_id}"> 
											                <c:set var="mySelectVar" value="selected"></c:set>
											                </c:if>
											            </c:forEach>                      
											            <option value="${ordTyp.checkbox}" ${(mySelectVar eq 'selected')?'selected' : ''}>${ordTyp.name}</option>
											             
											       </c:forEach>
											    </select>
											
                                             <br> 
                                              <select id="countryid" class="form-control required" name="country_id">
                                              <c:forEach items="${userdetail}" var="rec"><option value="${rec.country_id}">${rec.country_name}</option></c:forEach>
                                              <c:forEach items="${country}" var="record"><option value="${record.country_id}">${record.country_name}</option></c:forEach>
                                              </select>
                                              <br>
                                              <select  id="szoneid" class="form-control required" name="szone_id">
                                              <c:forEach items="${userdetail}" var="rec"><option value="${rec.zone_id}">${rec.zone_name}</option></c:forEach>
                                              <c:forEach items="${zone}" var="record"><option value="${record.state_id}">${record.state_name}</option></c:forEach>
                                              </select>
                                              <br>
                                             <button class="btn btn-info pull-left" id="save">Save</button>
                                             <button class="btn btn-info pull-right" id="cancel">cancel</button>
                                         </div> </div>
                                        
                                </div>  
                              </div>  
                              </div> 
                              <!-- Panel footer -->
                       </div></div></div>  
                       <div class="panel panel-default" style="border:2">
                          <div class="panel-heading" >
                                <h4  class="panel-title">
                                
                                    Skills  <div class="pull-right" ><input type="text" name="inskill" id="inskill" class="inskill" placeholder="Enter one skill" style=" border-radius:4px;border: 1px solid #ccc;padding: 0 6px;">&nbsp;&nbsp;
                                    <a class="btn btn-info" style="padding: 1px 10px;color:white;" id="add">Add skill</a>&nbsp;&nbsp;<a class="btn btn-info" style="padding: 1px 10px;color:white;" id="skilledit">Edit Skill</a>
                                    </div></h4>
                                   
                                
                                </div>
                             <div class="panel-body" id="panel-body">   
							
                               <section class="skillset">
                           
                            <div class="row">
                                     <table class="table table-condensed table-responsive">
                                                      <thead>
                                                          <tr>
                                                              <th class="col-md-3 text-center" for="inputskill" >Skill</th>
                                                              <th class="col-md-1 text-center" for="inputyear">Years of Experience</th>
                                                              <th class="col-md-4 text-center" for="inputexp">Expertise Level</th>
                                                              <!--<th class="col-md-4 text-center">Edit</th>-->
                                                              <th class="col-md-4 text-center">Remove</th>
                                                          </tr>
                                                      </thead>
                                                      <tbody id="skill_body">
                                                     <c:forEach items="${userskill}" var="record" varStatus="status">
                                                          <tr class="item">
                                                              
                                                              <td class="col-md-3 text-center"><span>${record.skill_name}</span>
                                                              <input type="text"  name="inputskill" id="inputskill" class="inputskill hide" value="${record.skill_name}"/>
                                                              </td>
                                                              <td class="col-md-1 text-center"><span id="yecodespan">${record.yearexp}</span><input type="text" name="inputyear" list="option" id="inputyear" class="inputyear hide" value="${record.yearexp}"/>
                                                               <datalist id="option"><select> <c:forEach items="${yearexp}" var="recr">
                                                                 <option>${recr.yearexp}</option></c:forEach>
                                                                </select></datalist>
                                                              </td>
                                                              <td class="col-md-4 text-center"><span id="elcodespan">${record.explevel}</span><input type="text" name="inputexp" list="options" id="inputexp"   class="inputexp hide" value="${record.explevel}"/>
                                                                <datalist id="options"><select> <c:forEach items="${level}" var="rec">
                                                                 <option>${rec.explevel}</option></c:forEach>
                                                                </select></datalist>
                                                              </td>
                                                              <!--<td class="col-md-4 text-center"><a><i class="glyphicon glyphicon-edit"></i></a></td>-->
                                                              <td class="col-md-4 text-center" id="delete"><a><i class="glyphicon glyphicon-remove"></i></a></td>
                                                         
                                                         </tr>
                                                         </c:forEach>
                                                      </tbody>
                                                </table> 
                                      <div style="text-align:center;"><a class="btn btn-info"style="padding: 2px 10px;" id="skillsave">Save</a> </div>  
                                   </div>
                            </section>			
						    </div> 	

						 </div>
                             </div>
                        
                       
                       
                       
               
                 
         
	</form>
	<!-- End of Wrapper-->
<%@include file="/WEB-INF/pages/layout/footer.jsp"%>

</body>

</html>

