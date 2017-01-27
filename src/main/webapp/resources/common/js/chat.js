var socket = new SockJS('/raas/chat');
stompClient = Stomp.over(socket);  
var stompClient = null;
	        	        	        	        
	        function setConnected(connected) {
	        	
	            document.getElementById('connect').style.visibility = !connected ? 'visible' : 'hidden'
	            document.getElementById('disconnect').style.visibility = connected ? 'visible' : 'hidden'
	            document.getElementById('conversationDiv').style.visibility = connected ? 'visible' : 'hidden';
	            document.getElementById('response').innerHTML = '';
	            document.getElementById('participant').innerHTML = '';	            
	        }
	        
	        $(document).ready(function() {
	            $("#text").keypress(function(e) {
	                if(e.keyCode == 13) {
	                    sendMessage();
	                }
	            });
	        });
	        	             	        
	         function connect() {
	            var socket = new SockJS('/raas/chat');
	            stompClient = Stomp.over(socket);  	            
	            var from = document.getElementById('from').textContent;
	            stompClient.connect({}, function(frame) {
	                
	            	setConnected(true);
	                console.log('Connected: ' + frame);
	                
	                stompClient.subscribe('/topic/messages', function(messageOutput) {
	                	showMessageOutput(JSON.parse(messageOutput.body));
	                    });
	                 stompClient.subscribe('/topic/participants', function(participants) {
	                	showParticipants(JSON.parse(participants.body));
                        });		                                  
	                 stompClient.send("/app/user", {}, JSON.stringify({'from':from}));
	               });
	            }
	         
	      function disconnect() {
	        	
	            if(stompClient != null) {
	                stompClient.disconnect();
	                document.getElementById('participants').style.visibility = 'hidden';
	            }
	            setConnected(false);
	            console.log("Disconnected");
	        }
	        	          
	        function sendMessage(message) { 
	        	
	        	
	        	
	        	
	          if($('#text').val() == ''){
	           return false;
	        
	          }
	        	else
	          {	        	        		        	  		
	        	var from = document.getElementById('from').textContent;
	            var text = document.getElementById('text').value;
	            
	            	            
	          stompClient.send("/app/chat", {}, JSON.stringify({'from':from, 'text':text}));
	            if (message !== "") {
	                socket.send(message);
	                id("text").value = "";
	            }
	            
	            var objDiv = document.getElementById("scroll");
	            objDiv.scrollTop = objDiv.scrollHeight;
	            
	            $.ajax({	                  
		        	  url: "messages",
		        	  type: "GET",
			          contentType : "application/json",
			          data : {
			           	messages : text 
						     },
							datatype: 'json',
						success : function(data) {
														
							$('#msgrow').empty();
							
							$.each(data,function(i,value){
															
                            var menu = '<div class="panel panel-custom"><span>'
								+data[i].firstname
								+'+'-'+'+data[i].time
								+'</span><div>'+data[i].messages+'</div></div>'							
							
								$('#msgrow').append(menu);
								
							});
						}
						
	               });    
	            	 
	           }     
	    
	       }
	        
	        function showMessageOutput(messageOutput) {
	        	
	            var response = document.getElementById('response');
	            var p = document.createElement('p');
	            p.style.wordWrap = 'break-word';
	            p.appendChild(document.createTextNode(messageOutput.from + "\xa0\xa0\xa0\xa0" + "( " + messageOutput.time + " )" + ":" + "\xa0\xa0\xa0\xa0" + messageOutput.text));
	            response.appendChild(p);
	        }
	        
	        function showParticipants(participants){
	        	var participant =document.getElementById('participant');
	        	var p = document.createElement('p');
	            p.style.wordWrap = 'break-word';
	            p.appendChild(document.createTextNode(participants.from));
	            participant.appendChild(p);   	
	        }     
	                  
	        function id(id) {
	        
	        return document.getElementById(id);
	         
	        }	 
	    