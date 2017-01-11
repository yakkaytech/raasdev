<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="en">

<head>

<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<script type="text/javascript" src="http://code.jquery.com/jquery-1.7.1.min.js"></script>
<title>Chat WebSocket</title>
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<spring:url value="/resources/common/js/sockjs-0.3.4.js" var="js1" />
<spring:url value="/resources/common/js/stomp.js" var="js2" />
<spring:url value="/resources/common/js/chat.js" var="js5" />
<spring:url value="/resources/common/css/pages/bootstrap.min.css" var="css1" />
<spring:url value="/resources/common/css/flat-ui.css" var="css2" />
<spring:url value="/resources/common/css/toaster.css" var="css3" />
<spring:url value="/resources/common/css/bootstrap.min.css" var="cs" /> 
<spring:url value="/resources/common/css/chat.css" var="css4" />
<script src="${js1}"></script> 
<script src="${js2}"></script> 
<script src="${js3}"></script>	     
<script src="${js4}"></script>
<script src="${js5}"></script>
<script src="${js6}"></script>
<script src="${js7}"></script> 
<script src="${js8}"></script> 
<script src="${js9}"></script>	     
<script src="${js10}"></script>
<script src="${js11}"></script>
<script src="${js12}"></script>

<link href="${cs}" rel="stylesheet">
<link href="${css1}" rel="stylesheet">
<link href="${css2}" rel="stylesheet">
<link href="${css3}" rel="stylesheet">
<link href="${css4}" rel="stylesheet">
     
<script type="text/javascript" language="javascript">
	 $(document).ready(function() {
	    var typing = false;
	    var timeout = undefined;
	    var typingDelayMillis = 500;
	    var user = document.getElementById('from').textContent;
	    
	    function timeoutFunction() {
	        typing = false;
	        $.ajax({
	            type: "GET",
	            url: "typing",
	            data : {
	            	user_name: user 
					},
					datatype: 'json',
					
					success : function(user_name) {
						$('#typing').html("");
					}
				});
	        }
	    
	    var delay = (function() {
	        var timer = 0;
	        return function(callback, ms) {
	            clearTimeout(timer);
	            timer = setTimeout(callback, ms);
	        };
	    });
	
	    $('#text').keyup(function(e) {
	        if (typing === false && $("#text").is(":focus")) {
	            delay(function() {
	                timeoutFunction();
	            }, typingDelayMillis);
	            typing = true;
	            $.ajax({
	              type: "GET",
	              url: "typing",
	              data : {
	            	  user_name:user 
					},
					datatype: 'json',
					success : function(user_name) {
						$('#typing').html(user_name);
					}
				});
	         }
	    });
	
	    $('#text').on("blur", function() {
	        clearTimeout(timeout);
	        timeout = setTimeout(timeoutFunction, typingDelayMillis);
	    })
	});
 
	/* var typingTimer;
	var doneTypingInterval = 10;
	var finaldoneTypingInterval = 500;
	
	var oldData = $("#typing").html();
	$(document).ready(function() {
		var typingTimer;
		var doneTypingInterval = 10;
		var finaldoneTypingInterval = 500;
		var oldData = $("#typing").html();
		
	$('#text').keydown(function () {
	    clearTimeout(typingTimer);
	    if ($('#text').val()) {
	        typingTimer = setTimeout(function () {
	            $("#typing").html('Typing...');
	        }, doneTypingInterval);
	    }
	});
	});
	$(document).ready(function() {
		var typingTimer;
		var doneTypingInterval = 10;
		var finaldoneTypingInterval = 500;
		var oldData = $("#typing").html();
		$('#text').keyup(function () {
	    clearTimeout(typingTimer);
	    typingTimer = setTimeout(function () {
	        $("#typing").html(oldData);
	    }, finaldoneTypingInterval);
	});
	});*/
	
	/* var timer = 0;
	function reduceTimer(){
	timer = timer - 1;
	isTyping(true);
	}
	function isTyping(val){
	if(val == 'true'){
	var user= document.getElementById('from').textContent;
	document.getElementById('typing').innerHTML = (user + " is typing...");
	}else{
	
	if(timer <= 0){
	document.getElementById('typing').innerHTML = "";
	}else{
	setTimeout("reduceTimer();",500);
	}
	}
	}*/
  
	</script>
</head>

<body onload="connect()">
    <div class="container">
			<div class="row">
				<nav class="navbar navbar-inverse navbar-embossed" role="navigation">
		            <div class="collapse navbar-collapse" id="navbar-collapse-01">		            
		           <h3>Welcome <i id="from" class="username" value="${user}">
		           <c:forEach items="${user}" var="record">${record.firstname}</c:forEach>${record.firstname}</i>
		           <ul class="nav navbar-nav navbar-right">		                              
		              <li class="dropdown-toggle"><a id="connect" onclick="connect();">CONNECT</a></li>   
		              <li class="dropdown-toggle"><a id="disconnect" style="visibility: hidden" onclick="disconnect();">DISCONNECT</a></li>
		             </ul></h3>
		            </div><!-- /.navbar-collapse -->
		        </nav><!-- /navbar -->
			</div>
	        
       <div class="row">
        <div class="col-xs-4" id="participants" style="visibility: hidden">
          <h4>Participants</h4>
        	<div id="list" class="share">        			                   			
	          <ul><p id="participant"><c:forEach items="${user}" var="record">
				 <option value="${record.firstname}">${record.firstname}</option> 
		      </c:forEach></p></ul>
	   		</div>
        </div>   
      <div class="col-xs-8 chat-box">
      <h4>Messages</h4>
      <div id="scroll" style="height:400px;width:975px;border:solid 2px white;overflow:scroll;overflow-x:hidden;overflow-y:scroll;">
       	<c:forEach items="${messages}" var="record">
       	<div class="row" id = "msgrow">
       	<div class="panel panel-custom">
       	<span>
       	${record.firstname}   (${record.time})
       	</span>
       	<div >${record.messages}</div>
       	</div></div>		  
		</c:forEach><p id="response"></p>
	      <div id="chatArea" style="width: 600px; height: 300px; overflow: auto"></div>
        </div> 
      </div> 
    </div>    
       	
    <div id="conversationDiv">
	  <p class="content"></p>
		<div id="typing"></div>		
		  <input type="text" class="form-control" id="text" name="messages" placeholder="Type Message ..." value="" required>
		    <span class="help-block"></span>
		  <div><button type="submit" id="sendMessage" class="btn btn-success btn-flat" onclick="sendMessage();">Send</button></div>
        </div>
       </div>
      </body>
     </html>