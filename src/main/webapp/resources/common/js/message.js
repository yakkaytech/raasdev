$(document).ready(function(){
     
    $("#compose")
	.click(
			function() {
				
				alert("hai");
				$('#myModal').modal('show');
			});   
      
     });
	
	

$(document).ready(function() {
    $(document).unbind().on("click",".message_id",function(e) {
	
    	var message_id = $(this).attr('id');		
    
					e.preventDefault();
					e.stopPropagation();
					$.ajax({
								url : "messageview",
								contentType : "application/json",
								mtype : "GET",
								data : {
									message_id : message_id
									},
								dataType : "json",
								async : false,
								success : function(data) {										
									
									document
									.getElementById('message_id').innerHTML =  data[0].message_id;
									document
										.getElementById('created_by').innerHTML =  data[0].created_by;
									document
									    .getElementById('to_email_id').innerHTML =  data[0].to_email_id;
									document
										.getElementById('subject').innerHTML = data[0].subject;
									document
										.getElementById('date_added').innerHTML = data[0].date_added;
									document
										.getElementById('message_text').innerHTML = data[0].message_text;
									}
									
								});

			     		    });
                      });
					
					$(function() {
						$("#tableid").simplePagination({
							previousButtonClass: "btn btn-primary",
							nextButtonClass: "btn btn-primary"
						});
					});
			
		