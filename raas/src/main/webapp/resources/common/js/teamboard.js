/**
 * 
 */
$(document)
		.ready(
				function() {

//					jQuery('span')
//							.click(
//									function(e) {
										
						$(document ).unbind().on('click', '.task_id',function(e) {
									
							e.preventDefault();
										
										var task_id = $(this).attr('id');
										$
												.ajax({
													url : "teamview",
													contentType : "application/json",
													mtype : "GET",
													data : {

														task_id : task_id

													},
													dataType : "json",
													async : false,
													success : function(data) {

														document
																.getElementById('team_task_name').innerHTML = 'Task:'
																+ data[0].task_name;
														document
														.getElementById('teamname').innerHTML =  data[0].task_name;
														
														document
																.getElementById('team_task_type').innerHTML = data[0].task_type_name;
														document
																.getElementById('team_task_description').innerHTML = data[0].task_description;
														document
																.getElementById('team_task_sign').innerHTML = data[0].task_signoff_criteria;
														document
																.getElementById('team_task_id').innerHTML = data[0].task_id;
														document
																.getElementById('project_id').innerHTML = data[0].project_id;
														
														document
														.getElementById('status_name').innerHTML = data[0].status_name;

														document
														.getElementById('attach').innerHTML = data[0].file_name;
													}

												});

									});

					$("#check-in")
							.unbind()
							.click(
									function() {
										
										

										var task_id = document
												.getElementById('team_task_id').innerHTML;
										var project_id = document
												.getElementById('project_id').innerHTML;
										var Status_name = document
									                   	.getElementById('status_name').innerHTML;
										
										
                                   if(Status_name == "Ready for work"){
										$.ajax({
											url : "taskInprogress",
											contentType : "application/json",
											mtype : "POST",
											data : {
												task_id : task_id,
												project_id : project_id
											},
											dataType : "json",
											async : false,
											success : function() {
												
												$("#mydiv").load(
														location.href
																+ " #mydiv");
												 


											},

										});
                                   }else{
                                	   
                                	   if(Status_name == "In progress"){
                                		   
                                		   toastr
   										.warning('Current Status is already in   '  +  Status_name  + '  You are not able to Check-In');
                                		   
                                	   }else{
                                		   
                                	   
                                		toastr
										.warning('Current Status is  '  +  Status_name  + '  You are not able to Check-In');
                                	   }
                                	   
                                   }

									});

					$("#check-out")
							.unbind()
							.click(
									function() {

										var task_id = document
												.getElementById('team_task_id').innerHTML;
										var project_id = document
												.getElementById('project_id').innerHTML;
									var Status_name = document
										.getElementById('status_name').innerHTML;
										
										
                                   if(Status_name == "In progress"){

										$.ajax({
											url : "taskcompleted",
											contentType : "application/json",
											mtype : "POST",
											data : {
												task_id : task_id,
												project_id : project_id
											},
											dataType : "json",
											async : false,
											success : function() {
												
												$("#mydiv").load(
														location.href
																+ " #mydiv");

											},

										});
                                   }else{
                                	   
                                	   if(Status_name == "Completed"){
                                		   toastr
   										.warning('Current Status is already in '  +  Status_name  + '  You are not able to Check-Out');
                                		   
                                	   }else{
                                		   
                                	   toastr
										.warning('Current Status is  '  +  Status_name  + '  You are not able to Check-Out');
                            	   
                                	   }
                               }

									});

					$("#completed")
							.unbind()
							.click(
									function() {

										var task_id = document
												.getElementById('team_task_id').innerHTML;
										var project_id = document
												.getElementById('project_id').innerHTML;
										
										var Status_name = document
										.getElementById('status_name').innerHTML;
										
										
                                   if(Status_name == "In progress"){

										$.ajax({
											
											url : "taskcompleted",
											contentType : "application/json",
											mtype : "POST",
											data : {
												task_id : task_id,
												project_id : project_id
											},
											dataType : "json",
											async : false,
											success : function() {
											$("#mydiv").load(
														location.href
																+ " #mydiv");

											},

										});
                                   }else{
                                	   
                                	   if(Status_name == "Completed"){
                                		   toastr
   										.warning('Current Status is  already in  '  +  Status_name  + '  You are not able to Completed');
                                		   
                                	   }else{
                                	   toastr
										.warning('Current Status is  '  +  Status_name  + '  You are not able to Completed');
                            	   
                                	   }
                               }

									});

					$("#sign-off")
							.unbind()
							.click(
									function() {

										var task_id = document
												.getElementById('team_task_id').innerHTML;
										var project_id = document
												.getElementById('project_id').innerHTML;
										
										var Status_name = document
										.getElementById('status_name').innerHTML;
										
										
                                   if(Status_name == "Completed"){

										$.ajax({
											
											
											url : "tasksignedoff",
											contentType : "application/json",
											mtype : "POST",
											data : {
												task_id : task_id,
												project_id : project_id
											},
											dataType : "json",
											async : false,
											success : function(data) {
												
												$("#mydiv").load(
														location.href
																+ " #mydiv");

											},

										});
                                   }else{
                                	   
                                	   if(Status_name == 'Signed-off'){
                                		   toastr
   										.warning('Current Status is  already in   '  +  Status_name  + '  You are not able to Signed-off');       
                                		   
                                	   }else{
                                	   toastr
										.warning('Current Status is  '  +  Status_name  + '  You are not able to Signed-off');                            	   
                                	   }
                               }

									});

					$("#ready").unbind().click(function() {

						$('#readyforwork').show();
						$('#sign').hide();
						$('#cmp').hide();
						$('#inp').hide();

					});
					$("#inprogress").unbind().click(function() {

						$('#inp').show();
						$('#sign').hide();
						$('#cmp').hide();
						$('#readyforwork').hide();
					});
					$("#cpml").unbind().click(function() {

						$('#readyforwork').hide();
						$('#sign').hide();
						$('#cmp').show();
						$('#inp').hide();
					});
					$("#all").unbind().click(function() {

						$('#readyforwork').show();
						$('#sign').show();
						$('#cmp').show();
						$('#inp').show();
					});
					
					
					$("#edit_view").unbind()
					.click(
							function(e) {

								e.preventDefault();
								
								var project_id=  document.getElementById("project_id").innerHTML;
								
								var task_id_val = document.getElementById("team_task_id").innerHTML;
								var team_task_type = document.getElementById("team_task_type").innerHTML;
								var team_task_type_name = document.getElementById("teamname").innerHTML;
								var team_task_description = document.getElementById("team_task_description").innerHTML;
								var team_task_sign= document.getElementById("team_task_sign").innerHTML;
								var attach = $("#attach").attr('value');
																//document.getElementById("team_task_type").innerHTML = team_task_type;
							//	$("#tasktype_id").val(tasktype_id);
								$("#projectid").val(project_id);
								$("#taskid").val(task_id_val);
								$("#editname").val(team_task_type_name);
								$("#editmessage").val(team_task_description);
								$("#editmessage1").val(team_task_sign);
								$("#attachment").val(attach);
								
								
								$('#editTaskModal').modal('show');
								
							});
					$("#edittask")
					.unbind()
					.click(
							function() {
								var task_name = document
								.getElementById("editname").value;
						var task_type = document
								.getElementById("selId").value;
						var task_description = document
								.getElementById("editmessage").value;
						var sign_off_criteria = document
								.getElementById("editmessage1").value;
						var task_size = document
								.getElementById("sizecode").value;
					
						var project_id =document.getElementById('project_id').value;
					
						var task_id = document
						.getElementById("taskid").value;
					
						
						var fullPath = document
								.getElementById("new-event").value;
						var file = $("#new-event")[0].files[0];

						if (fullPath) {
							var startIndex = (fullPath
									.indexOf('\\') >= 0 ? fullPath
									.lastIndexOf('\\')
									: fullPath.lastIndexOf('/'));
							var filename = fullPath
									.substring(startIndex);
							if (filename.indexOf('\\') === 0
									|| filename.indexOf('/') === 0) {
								filename = filename
										.substring(1);
							}
						}	
								$
								.ajax({
									url : "editviewteam?project_id="
											+ project_id
											+ "&file=" + file,
									type : "POST",
									enctype : 'multipart/form-data',
									contentType : "application/json; charset=utf-8",
									data : new FormData(
											document
													.getElementById("edittaskdetails")),
									datatype : 'json',
									processData : false,
									contentType : false,
									async : false,
									success : function(data) {
										
										$("#mydiv").load(location.href + " #mydiv")
										
										$.ajax({
											url : "teamview",
											contentType : "application/json",
											mtype : "GET",
											data : {

												task_id : task_id
											},
											dataType : "json",
											async : false,
											success : function(data) {
												
												document
														.getElementById('team_task_name').innerHTML = 'Task:'+ data[0].task_name;
												document
												.getElementById('teamname').innerHTML =  data[0].task_name;
												
												document
														.getElementById('team_task_type').innerHTML = data[0].task_type_name;
												document
														.getElementById('team_task_description').innerHTML = data[0].task_description;
												document
														.getElementById('team_task_sign').innerHTML = data[0].task_signoff_criteria;
												document
														.getElementById('team_task_id').innerHTML = data[0].task_id;
												document
														.getElementById('project_id').innerHTML = data[0].project_id;
												
												document
												.getElementById('team_task_group_id').innerHTML =  data[0].task_group_id;
												
												document
												.getElementById('status_name').innerHTML = data[0].status_name;
												document
												.getElementById('attach').innerHTML = data[0].file_name;
											}
										});
									},
									
								});
								document.getElementById("edittaskdetails").submit();
							});
				});