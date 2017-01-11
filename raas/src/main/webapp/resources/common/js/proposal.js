/**
 * 
 */

$(document)
		.ready(
				function() {
					
					
					$('#saveproposaltasks')
					.unbind()
					.on(
							'click',
							function(e) {

								e.preventDefault();
								
								var taskgroupvalue_name = document
										.getElementById("taskgroupidhidden").innerHTML;
                                 
								$("#cafeId").val(taskgroupvalue_name);
								
								var feature_id = document
								.getElementById("cafeId").value;
								var task_name = document
										.getElementById("name").value;
								var task_description = document
										.getElementById("message").value;
								var task_size = document
										.getElementById("size").value;
								var project_id = document
										.getElementById("project_id").value;
								var fullPath = document
										.getElementById("new-event").value;
								
								var team_id = document
								.getElementById("team_id").value;

								var signoff = document
								.getElementById("message1").value;
								alert(signoff);

								var estimated_hours = document
								.getElementById("estimated_hours").value;
								
								alert(estimated_hours);
								
								alert(new FormData(
													document
															.getElementById("savetaskdetails")));
                                   console.log(new FormData(
													document
															.getElementById("savetaskdetails")));
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

							
								var file = $("#new-event")[0].files[0];

								$
										.ajax({
											url : "proposaltasks?project_id="
													+ project_id
													+ "&file=" + file,
											type : "POST",
											enctype : 'multipart/form-data',
											contentType : "application/json; charset=utf-8",
											data : new FormData(
													document
															.getElementById("savetaskdetails")),
											datatype : 'json',
											processData : false,
											contentType : false,
											async : false,
											success : function(data) {
												
												$("#taskgroupid")
												.unbind()
												.load(
														location.href
																+ " #taskgroupid>*",
														"");
												$
												.ajax({
															url : "featurebaseddetails",
													contentType : "application/json",
													mtype : "POST",
													data : {
														feature_id : feature_id,
														project_id : project_id
													},
													dataType : 'json',
													async : false,
													success : function(data) {
														
														
														
														
														$('#taskrow')
														.empty();
												
												$
														.each(
																data,
																function(
																		i,
																	value) {
														var menu = '<div class="panel panel-custom"><div class="panel-heading"><span class ="pro_id" id="'
													        + data[i].task_id+ '" name="task_id"><a style="color: blue" href=""><i class="glyphicon glyphicon-picture"style="color: blue"></i>'
													        +data[i].task_id+'-'+data[i].task_name+' </a></span><div class="panel-body" id="task_group_id" style="display: none;">'+data[i].task_group_id+'</div><div class="panel-body" id="project_id" style="display: none;">'
													        +data[i].project_id+'</div><div class="pull-right"><span><button type="button"class="btn button-border-primary btn-circle"><b>'
													        +data[i].estimated_hours+'</b></button></span> <span><button type="button"class="btn btn-default btn-circle"></button></span> </div></div></div>'
													        
													        $(
																	"#taskrow")
																	.append(
																			menu);
														
																});
												
													},
												});
												
											},
										});
							});
					
					
					
					$('#pro_tasktable').unbind().on('click', '.pro_id',function(e) {
						
											e.preventDefault();
											 e.stopPropagation();
											 
											var task_id = $(this).attr('id');
											
											$.ajax({
														url : "proposaltaskview",
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
															.getElementById('team_task_group_id').innerHTML =  data[0].feature_id;
															
															document
															.getElementById('status_name').innerHTML = data[0].status_name;
															document
															.getElementById('attach').innerHTML = data[0].file_name;
															document
															.getElementById('estimated_hours').innerHTML = data[0].estimated_hours;
															

														}

													});

										});
					
					
					$('#feature_click').unbind()
					.on(
							'click',
							'#taskgroupid li',
							function(e) {
								
								e.preventDefault();
								
								var taskgroupvalue = $(this).attr('id');
								
								var taskgroupvalue_name = $(this)
										.text();
								var task_group_name = $(this).find(
										'.taskgpname').text();

								var task_count = $(this).find(
										'.task_count').text();
								var task_group_id = $(this).find(
										'#task_group_id').text();
								var project_id = $(this).find(
								'#project_id').text();
								
								
								document.getElementById("design").innerHTML = task_group_name;
							document
									.getElementById("taskgroupidhidden").innerHTML = task_group_id;
								document
										.getElementById("taskgroupcnthidden").innerHTML = task_count;
								
								
								$
								.ajax({
											url : "featurebaseddetails",
									contentType : "application/json",
									mtype : "POST",
									data : {
										feature_id : taskgroupvalue,
										project_id : project_id
									},
									dataType : 'json',
									async : false,
									success : function(data) {
										
										document
										.getElementById('total_tasks').innerHTML = 'Total Tasks:'+ data[0].proposal_task_count;
								document
								.getElementById('total_hrs').innerHTML =  'Total Estimated Hours:'+ data[0].estimated_hrscount;
										
										
										
										$('#taskrow')
										.empty();
								
								$
										.each(
												data,
												function(
														i,
													value) {
										var menu = '<div class="panel panel-custom"><div class="panel-heading"><span class ="pro_id" id="'
									        + data[i].task_id+ '" name="task_id"><a style="color: blue" href=""><i class="glyphicon glyphicon-picture"style="color: blue"></i>'
									        +data[i].task_id+'-'+data[i].task_name+' </a></span><div class="panel-body" id="task_group_id" style="display: none;">'+data[i].task_group_id+'</div><div class="panel-body" id="project_id" style="display: none;">'
									        +data[i].project_id+'</div><div class="pull-right"><span><button type="button"class="btn button-border-primary btn-circle"><b>'
									        +data[i].estimated_hours+'</b></button></span> <span><button type="button"class="btn btn-default btn-circle"></button></span> </div></div></div>'
									    $(
													"#taskrow")
													.append(
															menu);
										
												});
								
								
								$
								.ajax({
											url : "featurebasedcount",
									contentType : "application/json",
									mtype : "POST",
									data : {
										feature_id : taskgroupvalue,
										project_id : project_id
									},
									dataType : 'json',
									async : false,
									success : function(data) {
										
										document
										.getElementById('total_tasks').innerHTML = 'Total Tasks:'+ data[0].proposal_task_count;
								document
								.getElementById('total_hrs').innerHTML =  'Total Estimated Hours:'+ data[0].estimated_hrscount;
										
										
									},
									
								});
								
								
								
								
								$
								.ajax({
											url : "taskgpview",
									contentType : "application/json",
									mtype : "POST",
									data : {
										feature_id : taskgroupvalue,
										project_id : project_id
									},
									dataType : 'json',
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
								.getElementById('team_task_group_id').innerHTML =  data[0].feature_id;
								
								document
								.getElementById('status_name').innerHTML = data[0].status_name;
								document
								.getElementById('attach').innerHTML = data[0].file_name;
								

										
									},
								});
								
								
							},
				});
								
							//	$("#teamviewdetails").load(location.href+" #teamviewdetails>*","");		
								
							});
					
					
					$("#edit_proposaltask").unbind()
					.click(
							function(e) {
								

								e.preventDefault();
								var project_id = $('#project_id').val();
								var feature_id = document.getElementById("team_task_group_id").innerHTML;
								var task_id_val = document.getElementById("team_task_id").innerHTML;
								var team_task_type = document.getElementById("team_task_type").innerHTML;
								var team_task_type_name = document.getElementById("teamname").innerHTML;
								var team_task_description = document.getElementById("team_task_description").innerHTML;
								var team_task_sign= document.getElementById("team_task_sign").innerHTML;
								
								var estimated_hrs= $("#estimated_hours").attr('value');
								var attach = $("#attach").attr('value');
								
								
								$("#feature_id").val(feature_id);
								$("#projectid").val(project_id);
								$("#taskid").val(task_id_val);
								$("#editname").val(team_task_type_name);
								$("#editmessage").val(team_task_description);
								$("#editmessage1").val(team_task_sign);
								$("#attachment").val(attach);
								$("#estimated_hours").val(estimated_hours);
								
								
								
								$('#editTaskModal').modal('show');
								
							});
					
					
					
					$("#edittasks")
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
						var feature_id = document
						.getElementById("feature_id").value;
						
						alert(feature_id);
					
						var project_id =document.getElementById('project_id').value;
					alert(project_id);
						var task_id = document
						.getElementById("taskid").value;
						var fullPath = document
								.getElementById("new-event").value;
						
						var file = $('#new-eventattach')[0].files[0];
						
						alert(file);

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
						
					
								$.ajax({
									url : "proposaledit?project_id="
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
										
										
										
										$("#taskgroupid")
										.unbind()
										.load(
												location.href
														+ " #taskgroupid>*",
												"");
										$
										.ajax({
													url : "featurebaseddetails",
											contentType : "application/json",
											mtype : "POST",
											data : {
												feature_id : feature_id,
												project_id : project_id
											},
											dataType : 'json',
											async : false,
											success : function(data) {
												
												alert("featurebaseddetails");
												
												
												$('#taskrow')
												.empty();
										
										$
												.each(
														data,
														function(
																i,
															value) {
												var menu = '<div class="panel panel-custom"><div class="panel-heading"><span class ="pro_id" id="'
											        + data[i].task_id+ '" name="task_id"><a style="color: blue" href=""><i class="glyphicon glyphicon-picture"style="color: blue"></i>'
											        +data[i].task_id+'-'+data[i].task_name+' </a></span><div class="panel-body" id="task_group_id" style="display: none;">'+data[i].task_group_id+'</div><div class="panel-body" id="project_id" style="display: none;">'
											        +data[i].project_id+'</div><div class="pull-right"><span><button type="button"class="btn button-border-primary btn-circle"><b>'
											        +data[i].estimated_hours+'</b></button></span> <span><button type="button"class="btn btn-default btn-circle"></button></span> </div></div></div>'
											        
											        alert(menu);
											        
											        $(
															"#taskrow")
															.append(
																	menu);
												
														});
										
											},
										});
										
										
										
										
								//	$("#mydiv").load(location.href + " #mydiv")
										
										$.ajax({
											url : "proposaltaskview",
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
												.getElementById('team_task_group_id').innerHTML =  data[0].feature_id;
												
												document
												.getElementById('status_name').innerHTML = data[0].status_name;
												document
												.getElementById('attach').innerHTML = data[0].file_name;
											}
										});
										
										
										
										
									},
									
								});
							});
					
					$("#add_member").unbind()
					.click(
							function(e) {
								
								$('#addmemberModal').modal('show');
								
							});
					
					
				
				   
					var ctr = 1;
					$("#email" + ctr).focusout(function() {	
					
						if (!validateEmail($("div input[name='email']").val())) {
							$("div input[name='email']").css('border-color', 'red');				
				        }
				        else {	           
				            $("div input[name ='email']").css('border-color', '#E6E6E6');
				        }			
						});
					
					function validateEmail(sEmail) {
					    var filter = /^([\w-\.]+)@((\[[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\.)|(([\w-]+\.)+))([a-zA-Z]{2,4}|[0-9]{1,3})(\]?)$/;
					    if (filter.test(sEmail)) {
					        return true;
					    }
					    else {
					        return false;
					    }
					}
					
					
					
					var count = 1;
					var counter = 2;
					$("#add_new").unbind()
					.click(
							function(e) {
								
								
								if(counter > 5 ){
									
									 alert("Only 5 textboxes allow");
							            return false;
									
								}
								
								else{	
									
								var newTextBoxDiv = $(document.createElement('div'))
							     .attr("id", 'subrow' + counter);

								
						
								alert("tasks");
								newTextBoxDiv.after().html('<div class="row" id= "subrow" style="height: 100px; width: 100%;"><div class="col-lg-3"><div class="row"><label class="control-label" for="name"> E-mail Address*</label></div><div class="row"><div class="col-md-20"><input id="email' 
										+ counter +'" name="email" type="email" placeholder="E-mail Address" class="form-control"><span class="help-block"></span></div></div></div><div class="col-lg-3"><div class="row"><label class="control-label" for="name">firstname </label></div><div class="row"><div class="col-md-14"><input id="First Name'
										+ counter +'" name="firstname" type="text" placeholder="Your name" class="form-control"></div></div></div><div class="col-lg-3"><div class="row"><label class="control-label" for="name"> lastname</label></div><div class="row"><div class="col-md-14"><input id="Last Name'
										+ counter +'" name="lastname" type="text" placeholder="Your name" class="form-control"></div></div></div><div class="col-lg-3 pull-right"><div class="row"  id="remove"><label class="control-label" for="name"> </label></div>&nbsp;&nbsp;&nbsp;&nbsp;<div class="row" id="symbol"><div class="col-md-1" id="removefield"><a  href="#" ><i class="glyphicon glyphicon-remove" > </i> </a></div></div></div></div>');
							console.log(newTextBoxDiv);
							alert(newTextBoxDiv);
								
								$("#anothermember").append(newTextBoxDiv);
								
								counter++;
								 count++;
							 document.getElementById("invite").innerHTML = "Invite " + count + " Persons.";
								
						} 
							 
							});
					
					
					 $("div").on('click','#removefield',function(e) {
				    		if(counter==1){
				    	          alert("No more textbox to remove");
				    	          return false;
				    	       }

				    		counter--;

				    	        $("#subrow" + counter).remove();

				    	     });
				  
				     
				     $("#invite").click(function () {
				    	 
//							var dt = JSON.stringify('#member_request');
//							alert(dt);
				    	 
				    		var email = '';
				    		var firstname = '';
				    		var lastname = '';
				    		var  project_id =  $('#project_id').val();
				    		alert(project_id);
				    		var  team_id =  $('#team_id').val();
				    		alert(team_id);
				    		
				    		for(i=1; i<counter; i++){
				    			
				    	   	 email =  $('#email' + i).val();
				    	   	firstname =  $('#firstname' + i).val();
				    	   	lastname =  $('#lastname' + i).val();
				    		
				    	    	  
				    	    	
				    	    	  $.ajax({
										url : "member_req",
										contentType : "application/json",
										mtype : "POST",
										data :   {  email : email,
											firstname : firstname,
											lastname : lastname,
											project_id : project_id,
											team_id : team_id
										},
										dataType : "json",
										async : false,
										success : function(data) {
											
											
										},
										
								    });
				    		}
				    		
				    		 
				    	     });
				    	  
				    
					
					
					

					
				});
					