<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Message</title>
<link href="https://select2.github.io/dist/css/select2.min.css" rel="stylesheet">
<link href="https://maxcdn.bootstrapcdn.com/font-awesome/4.3.0/css/font-awesome.min.css" rel="stylesheet">
<spring:url value="/resources/common/vendors/jasny-bootstrap/css/jasny-bootstrap.css"
	var="cs" />
<spring:url value="/resources/common/css/message.css" var="css4" />
<spring:url value="/resources/common/css/bootstrap.css" var="css2" />
<spring:url value="/resources/common/css/jquery-ui.css" var="css3" />
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
<link href="${css4}" rel="stylesheet">
<link href="${css2}" rel="stylesheet">
<link href="${css3}" rel="stylesheet">
<link href="${cs}" rel="stylesheet">

<spring:url value="/resources/common/js/jquery-1.11.1.min.js" var="js1" />
<script src="${js1}"></script>
<spring:url value="/resources/common/js/message.js" var="js2" />
<script src="${js2}"></script>
<spring:url value="/resources/common/js/bootstrap.js" var="js3" />
<script src="${js3}"></script>
<spring:url value="/resources/common/js/simplePagination.js" var="js4" />
<script src="${js4}"></script>
<script src="https://select2.github.io/dist/js/select2.full.js"></script>
<script>
function displayid() {
	
	
	var message_id = document.getElementById("message_id").innerText;
	   
	   $.ajax({
		  url:"delete",
		  contentType : "application/json",
			mtype : "POST",
			data : {
				message_id : message_id
			},
			dataType : 'json',
			async : false,
			success : function(data) {
			
				
			
			$("#tablebody")
			.empty();
			
			$.each(
					data,
					function(
							i,
							value) {
						
						
						var mail='<tr class="unread" id='
						+value.message_id+'><td class="inbox-small-cells"><input type="checkbox" class="mail-checkbox"> </td> <td class="inbox-small-cells"><i class="fa fa-star"></i></td><td id="delete" class="view-message"><span id="dtmsg" style="display:none">'
	                   +value.message_id+'</span><span class ="message_id" id = '+value.message_id+' name="message_id"> <a href="">'
	                   +value.firstname+'</a></span></td><td class="view-message ">'
	                   +value.subject+'</td><td class="view-message  text-right">'+value.date_added+'${record.date_added}</td></tr>'
					
						$("#tablebody").append(mail);
						
						
					});
			
			
			},
	   		});
	   
	
  
   
	}
</script>
 </head>

<body>
    <div class="container">
        <div class="mail-box">
            <aside class="sm-side">
                  <div class="inbox-body">
                      <a id="compose"  data-toggle="modal" title="Compose" data-model="#myModal" class="btn btn-compose" >Compose</a>
                          <!-- Modal -->
                          <div aria-hidden="true" aria-labelledby="myModalLabel" role="dialog" tabindex="-1" id="myModal" class="modal fade">
                              <div class="modal-dialog">
                                  <div class="modal-content">
                                      <div class="modal-header">
                                          <button aria-hidden="true" data-dismiss="modal"  class="close" type="button">×</button>
                                          <h4 class="modal-title">Compose</h4>
                                      </div>
                                      <div class="modal-body">
                                      					
                                          <form role="form" class="form-horizontal" id="send" action="${pageContext.request.contextPath}/send" method="post">
                                              <div class="form-group">
                                                  <label class="col-lg-2 control-label" >To</label>
                                                  <div class="col-lg-10">
                                                      <input type="text" placeholder="" id="inputEmail1" class="form-control" name="to_email_id">
                                                  </div>
                                              </div>
                                         <!--     <div class="form-group">
                                                  <label class="col-lg-2 control-label">Cc / Bcc</label>
                                                  <div class="col-lg-10">
                                                  <input type="text" placeholder="" id="inputPassword1" class="form-control">
                                                  </div>
                                              </div>    -->
                                              <div class="form-group">
                                                  <label class="col-lg-2 control-label" >Subject</label>
                                                  <div class="col-lg-10">
                                                      <input type="text" name="subject" id="inputPassword1" class="form-control">
                                                  </div>
                                              </div>                                   
					
						<div class="btn-group">
						  	<button class="btn btn-default"><span class="fa fa-bold"></span></button>
						  	<button class="btn btn-default"><span class="fa fa-italic"></span></button>
							<button class="btn btn-default"><span class="fa fa-underline"></span></button>
						</div>

						<div class="btn-group">
						  	<button class="btn btn-default"><span class="fa fa-align-left"></span></button>
						  	<button class="btn btn-default"><span class="fa fa-align-right"></span></button>
						  	<button class="btn btn-default"><span class="fa fa-align-center"></span></button>
							<button class="btn btn-default"><span class="fa fa-align-justify"></span></button>
						</div>
						
						<div class="btn-group">
						  	<button class="btn btn-default"><span class="fa fa-indent"></span></button>
						  	<button class="btn btn-default"><span class="fa fa-outdent"></span></button>
						</div>
						
						<div class="btn-group">
						  	<button class="btn btn-default"><span class="fa fa-list-ul"></span></button>
						  	<button class="btn btn-default"><span class="fa fa-list-ol"></span></button>
						</div>
						<button class="btn btn-default"><span class="fa fa-trash-o"></span></button>	
						<button class="btn btn-default"><span class="fa fa-paperclip"></span></button>
						<div class="btn-group">
							<button class="btn btn-default dropdown-toggle" data-toggle="dropdown"><span class="fa fa-tags"></span> <span class="caret"></span></button>
							<ul class="dropdown-menu">
								<li><a href="#">add label <span class="label label-danger"> Home</span></a></li>
								<li><a href="#">add label <span class="label label-info">Job</span></a></li>
								<li><a href="#">add label <span class="label label-success">Clients</span></a></li>
								<li><a href="#">add label <span class="label label-warning">News</span></a></li>
							</ul>
						</div>
					     <div class="form-group">
                                                  <label class="col-lg-2 control-label" >Message</label>
                                                  <div class="col-lg-10">
                                                      <textarea rows="10" cols="30" class="form-control" id="text" name="text"></textarea>
                                                  </div>
                                              </div>

                                              <div class="form-group">
                                                  <div class="col-lg-offset-2 col-lg-10">
                                                      <span class="btn green fileinput-button">
                                                        <i class="fa fa-plus fa fa-white"></i>
                                                        <span>Attachment</span>
                                                        <input type="file" name="files[]" multiple="">
                                                      </span>
                                                      <button class="btn btn-send" type="submit" id="savemsg" >Send</button>
                                                  </div>
                                              </div>
                                          </form>
                                      </div>
                                  </div><!-- /.modal-content -->
                              </div><!-- /.modal-dialog -->
                          </div><!-- /.modal -->
                      </div>
                      <ul class="inbox-nav inbox-divider">
                          <li><a href="${pageContext.request.contextPath}/messages" ><i class="fa fa-inbox"></i> Inbox </a></li>
                          <li><a href="${pageContext.request.contextPath}/sendmsg"><i class="fa fa-envelope-o"></i> Sent Mail</a></li>
                      </ul>
                  </aside>
                  <aside class="lg-side">
                       <div class="inbox-body">
                         <div class="mail-option">
                             <div class="chk-all">
                                 <input type="checkbox" class="mail-checkbox mail-group-checkbox">
                                 <div class="btn-group">
                                     <a data-toggle="dropdown" href="#" class="btn mini all" aria-expanded="false">
                                         All
                                         <i class="fa fa-angle-down "></i>
                                     </a>
                                     <ul class="dropdown-menu">
                                         <li><a href="#"> None</a></li>
                                         <li><a href="#"> Read</a></li>
                                         <li><a href="#"> Unread</a></li>
                                     </ul>
                                 </div>
                             </div>

                             <div class="btn-group">
                                 <a href="javascript:location.reload(true)" data-original-title="Refresh" data-placement="top" data-toggle="dropdown" href="#" class="btn mini tooltips">
                                     <i class=" fa fa-refresh"></i>
                                 </a>
                             </div>
                             <button class="btn btn-default" onclick="displayid('tableid')"  ><span id="deletemsg" class="fa fa-trash-o">
                             </span>
                             </button></a>
                             <div class="btn-group">
                                 <a data-toggle="dropdown" href="#" class="btn mini blue">
                                     Move to
                                     <i class="fa fa-angle-down "></i>
                                 </a>
                                 <ul class="dropdown-menu">
                                     <li><a href="#"><i class="fa fa-pencil"></i> Mark as Read</a></li>
                                     <li><a href="#"><i class="fa fa-ban"></i> Spam</a></li>
                                     <li class="divider"></li>
                                     <li><a href="#"><i class="fa fa-trash-o"></i> Delete</a></li>
                                 </ul>
                             </div>
                       
                             <ul class="unstyled inbox-pagination">
                                 <li><span>1-50 of 234</span></li>
                                 <li>
                                     <a class="np-btn" href="javascript:prevPage()" id="btn_prev"><i class="fa fa-angle-left  pagination-left"></i></a>
                                 </li>
                                 <li>
                                     <a class="np-btn" href="javascript:nextPage()" id="btn_next"><i class="fa fa-angle-right pagination-right"></i></a>
                                 </li>
                             </ul>
                            
                         </div>
                          <table class="table table-inbox table-hover" id ="tableid">
                            <tbody id="tablebody">
                            <c:forEach items="${usermessage}" var="record">
                              <tr class="unread" id="${record.message_id}">
                                  <td class="inbox-small-cells">
                                      <input type="checkbox" class="mail-checkbox">
                                  </td>                                  
                                  <td class="inbox-small-cells"><i class="fa fa-star"></i></td>                                  
                                  <td id="delete" class="view-message"><span id="dtmsg" style="display:none">${record.message_id}</span><span class ="message_id" id = "${record.message_id}" name="message_id">
                                  <a href="">${record.firstname}</a></span></td>
                                  <td class="view-message ">${record.subject}</td>
                                  <td class="view-message  text-right">${record.date_added}</td>                                  
                                   </tr>
                                </c:forEach>
                            </tbody>
                          </table>
                      </div>
                  </aside>
              
              <aside class="md-side">
              <div><section>
              <div class="row" align="center">
					<h4 id="team_task_name">MESSAGES</h4>
					<h4 id="teamname" style="display: none;"></h4>
					<div class="col-xs-3"></div></div></section></div>    
              	<c:forEach items="${usermessage}" var="record" varStatus="stat">
		           <c:if test="${stat.first}">				
				     <div class="col-lg-12" id="msgviewdetails">
				      <div class="row">
			            <div class="col-lg-12" id="msgviewdetails">
				
					<div class="form-group" style="display: none;">
						<label class="col-xs-3 control-label" for="name">message_id:</label> <label
							class="col-xs-9 control-label" for="name" 
							id="message_id">${record.message_id}</label>
					</div>				
					<div class="form-group">
						<label class="col-xs-3 control-label" for="name">From:</label> <label
							class="col-xs-9 control-label" for="name" 
							id="created_by">${record.created_by}</label>
					</div>
					<div class="form-group">
						<label class="col-xs-3 control-label" for="name">To:</label> <label
							class="col-xs-9 control-label" for="name" 
							id="to_email_id">${record.to_email_id}</label>
					</div>					
					<div class="form-group">
						<label class="col-xs-3 control-label" for="name">Subject:</label> 
						<label class="col-xs-9 control-label" for="name" id="subject">${record.subject}</label>
					</div>
                    <div class="form-group">
						<label class="col-xs-3 control-label" for="name"
							>Date:</label> <label
							class="col-xs-9 control-label" for="name" id="date_added"
							>${record.date_added}</label>
					</div>					
					<div class="form-group">
						<label class="col-xs-3 control-label" for="name">Message:</label> 
						<label class="col-xs-9 control-label" for="name" id="message_text">${record.message_text}</label>
					</div>
				  </div>
			    </div>
			  </div>
			</c:if>
	      </c:forEach>
		</aside>
      </div>
    </div>
  </body>
</html>