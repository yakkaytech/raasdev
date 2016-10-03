

function openFileOption()
{
	
  document.getElementById("new-event").click();

 }

	$(document).ready(function() {
		
		
		$("#savetasks").click(function(){
			var taskgroupvalue_name = document.getElementById("taskgroupidhidden").innerHTML;
			$("#cafeId").val(taskgroupvalue_name);
		//var task_type=document.getElementById("name").value;
		var task_name = document.getElementById("name").value;
		var task_description = document.getElementById("message").value;
		var sign_off_criteria = document.getElementById("message1").value;
		var task_size = document.getElementById("size").value;
		var link_tasks = document.getElementById("name1").value;
		
		
		  var fullPath = document.getElementById("new-event").value;
		 
		  if (fullPath) {
			    var startIndex = (fullPath.indexOf('\\') >= 0 ? fullPath.lastIndexOf('\\') : fullPath.lastIndexOf('/'));
			    var filename = fullPath.substring(startIndex);
			    if (filename.indexOf('\\') === 0 || filename.indexOf('/') === 0) {
			        filename = filename.substring(1);
			    }
			   
			}
		if (task_name == null || task_name == "") {
			
			document.getElementById("gettask").innerHTML = "Please enter Task name";
			return false;
		} else{
			
			document.getElementById("gettask").innerHTML = "";
		}
	    
		
		if(task_size == null || task_size == "") {
						
		document.getElementById("getsize").innerHTML = "Please enter Task Size ";
		return false;			
		}else{
			
			document.getElementById("getsize").innerHTML = " ";
		}
	   
	    document.getElementById("savetaskdetails").submit();
	});
		
		$("#closetasks").click(function(){
			document.getElementById("gettask").innerHTML = "";
			document.getElementById("getdesc").innerHTML = "";
			document.getElementById("getsign").innerHTML = "";
			document.getElementById("getsize").innerHTML = "";
			document.getElementById("getlink").innerHTML = "";
		});
		$("#add-new-event").click(function() {
			
			var x = document.getElementById("task_group_name").value;
			if (x == null || x == "") {
					document.getElementById("my_span").innerHTML = "Group Name is required";
				return false;
			}			
			
		document.getElementById("savetaskgp").submit();
					
		});

				$("#close-new-event").click(function() {
					document.getElementById("my_span").innerHTML = "";
					$('#myModal').modal('hide');
					return false;

				});
				
			$("#edit-new-event").click(function() {
				var taskgroupvalue = $("#taskgroupId").val();
				var taskgroupname = $("#task_group_namei").val();
				
				
				alert("Saved Successfully");
				
	          $.ajax({
	        	 
	        	  url : "savetaskgrp",
	        	  contentType : "application/json",
	        	  mtype : "POST",
					data : {
						task_group_id : taskgroupvalue,
						task_group_name : taskgroupname
					},
			         dataType : 'json',
					 async : false,
				   	 success : function() {
				   		 window.location.reload(true);
				   		//window.location = window.location.'${pageContext.request.contextPath}/crt/project/tasks'
//				   		$('#taskgroupid').empty;
//			   	 for (row in data) {
//			      	  $('#taskgroupid').append($('<option></option>').attr('id', data[row].task_group_id).text(data[row].task_group_name));
//				   	 }
					}
					
	          });
	          
			});
			
		$("#editGroupbutton").click(function() {
					var taskgroupvalue_name = document.getElementById("taskgroupidhidden").innerHTML;
					$("#taskgroupId").val(taskgroupvalue_name);
					$('#editModal').modal('show');
					return false;

			});

	$("#taskgroupid li").click(function() {
		var taskgroupvalue = $(this).attr('id');
		var taskgroupvalue_name = $(this).text();
	    var current = $(this).find('span:first');
	    document.getElementById("design").innerHTML = current.text();
	    document.getElementById("taskgroupname").innerHTML = current.text();
		document.getElementById("taskgroupidhidden").innerHTML = taskgroupvalue;
		document.getElementById("taskgroupId").innerHTML = taskgroupvalue;
		
		$.ajax({
				url : "taskgpbaseddetails",
				contentType : "application/json",
			    mtype : "POST",
				data : {
				task_group_id : taskgroupvalue
		},
		         dataType : 'json',
				 async : false,
			   	success : function(data) {
							$('#taskdetailbody').empty();
								 var taskdetailstable = '';
						$.each(data,function(index,value) {
							taskdetailstable = '<tr id="'+value.task_id+'" class="taskrow"><td id="task_id"><a href="#" >'
									+ value.task_id+ '</a></td><td id="task_type_name">'
									+ value.task_type_name+ '</td><td id="task_name">'
									+ value.task_name+ '</td><td id="task_desc">'
									+ value.task_description+ '</td><td id="size_code">'
									+ value.task_size_code+ '</td><td>In Progress </td><td >'
									+ value.task_AssignedTo+ '</td><td style="display: none;">'
									+ value.task_signoff_criteria+ '</td><td style="display: none;">'
									+ value.task_group_id+'</td><td style="display: none;">'
									+ value.task_type_id+'</td><td style="display: none;">'
									+ value.date_begin+'</td><td style="display: none;">'
									+ value.date_end+'</td><td style="display: none;">'
									+ value.file_name+'</td></tr>';
									
							$("tbody").append(taskdetailstable);
				});
						//alert(taskdetailstable);
			},
						error : function(jqXHR,textStatus,errorThrown) {
							alert(error);
	}
	});
});           $("#savetasks1").click(function(){
	
	                var task_name = document.getElementById("editname").value;
	        		var task_description = document.getElementById("editmessage").value;
	        		var sign_off_criteria = document.getElementById("editmessage1").value;
	        		var task_size = document.getElementById("sizecode").value;
	        		
	                if (task_name == "") {
		       			
		       			document.getElementById("gettaskid").innerHTML = "Please enter Task name";
		       			return false;
		       		} else{
		       			
		       			document.getElementById("gettaskid").innerHTML = "";
		       		}
		       	    if(task_description == "") {
		       			
		       	    	document.getElementById("getdescid").innerHTML = "Please enter Task Description ";
		       	    	return false;
		       	    }else{
		       	    	
		       	    	document.getElementById("getdescid").innerHTML = " ";
		       	    }
		       		if(sign_off_criteria == "") {
		       					
		             	  document.getElementById("getsignid").innerHTML = "Please enter  Sign_off_Criteria ";
		             	return false;
		       		}else{
		       			 document.getElementById("getsignid").innerHTML = " ";
		       			
		       		}
		       		if(task_size == "") {
		       						
		       		document.getElementById("getsizeid").innerHTML = "Please enter Task Size ";
		       		return false;			
		       		}else{
		       			
		       			document.getElementById("getsizeid").innerHTML = " ";
		       		}
	                  document.getElementById("edittaskdetails").submit();
	            
	});         
           
           /* $("#taskdetailbody").on('click','.taskrow',function(e) {
				 e.preventDefault();
				 //var taskgroupid = document.getElementById("taskgroupidhidden").innerHTML;
					
					var task_id_val=$(this).attr('id');
					$("#taskid").val(task_id_val);
					var $td= $(this).closest('tr').children('td');
					var task_id= $td.eq(0).text();
					var tasktypename= $td.eq(1).text();
					var taskname= $td.eq(2).text();
					var taskdesc= $td.eq(3).text();
					var signoffcriteria= $td.eq(7).text();
					var size_code= $td.eq(4).text();
					var taskgpid= $td.eq(8).text();
					var tasktypeid= $td.eq(9).text();
					
					$("#taskgroupIde").val(taskgpid);
					$("#task_id").val(task_id);
					
					$("#tasktypename").val(3).change();
				
				   document.getElementById("tasktypeid").innerHTML=tasktypename;
				   document.getElementById("tasksize").innerHTML = size_code;
				
					$("#editname").val(taskname);
					$("#editmessage").val(taskdesc);
					$("#editmessage1").val(signoffcriteria);
					$("#editsize").val(size_code);
					$("#task_type").val(tasktypename);
					
					$('#editTaskModal').modal('show');
				   
		});*/
		
		 $("#viewtasks").on('click','.taskrow',function(e){
			var task_id_val=$(this).attr('id');
			var $td= $(this).closest('tr').children('td');
			var task_id= $td.eq(0).text();
			var redirecturl = "taskdetail?task_id="+task_id;
			 window.location.replace(redirecturl);
				//document.getElementById("viewtasks").submit(); 
		    });
		 
		 $( function dateselect() {
			    $( "#datepicker" ).datepicker();
			  } );

});
