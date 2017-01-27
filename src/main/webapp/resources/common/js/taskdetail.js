function openFileOption() {
	document.getElementById("new-event").click();
}

$(document)
		.ready(
				function() {

					$(function() {
						$("#start_datepicker").datepicker();
						$("#end_datepicker").datepicker();
						$("#start_datepicker").datepicker("option",
								"dateFormat", "dd/mm/yy");
						$("#end_datepicker").datepicker("option", "dateFormat",
								"dd/mm/yy");
					});
					
                    $('#viewtasks #playbtn').each(function() {
                        
                        var status = $(this).attr("value");
                        
                        if(status == 0){
                           
                            $(this).addClass('glyphicon glyphicon-pause');
                        }else if(status == 1){
                            $(this).addClass('glyphicon glyphicon-play');
                        }
                        //$(this).attr('class','glyphicon glyphicon-pause');                       
                       });
//					 $( "#taskrow").each(function( i ) {
//				//	$("div #taskrow").each(function() {
//					    var status =$(this).find("#statusflag").text();
//					    if(status == 1){
//				        	$(this).find("#pauseButton").prop('disabled',false);
//				        }else if(status == 0){
//				       		$(this).find("#pauseButton").prop('disabled',true);
//				       	}
//				  });

				
					$('#create_task').unbind().on('click', function() {
						
						$("#savetaskdetails")
						.trigger(
								"reset");
						$('#addTaskModal').modal(
						'show');
					});
					$('#create_group').unbind().on('click', function() {
						$('#myModal').modal(
						'show');
					});
					$('#savetasks')
							.unbind()
							.on(
									'click',
									function(e) {

										e.preventDefault();
										
										var taskgroupvalue_name = document
												.getElementById("taskgroupidhidden").innerHTML;
										$("#cafeId").val(taskgroupvalue_name);

										var task_name = document
												.getElementById("name").value;
										var task_description = document
												.getElementById("message").value;
										var sign_off_criteria = document
												.getElementById("message1").value;
										var task_size = document
												.getElementById("size").value;
										var link_tasks = document
												.getElementById("name1").value;
										var project_id = document
												.getElementById("project_id").value;
										var fullPath = document
												.getElementById("new-event").value;
										var date_begin = document
										.getElementById("start_datepicker").value;
										var date_end = document
										.getElementById("end_datepicker").value;

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

										var sign = {
											task_name : task_name,
											description : task_description,
											signoff_criteria : sign_off_criteria,
											size_code : task_size,
											project_id : project_id,
											
											file : $('#new-event')
													.prop("files")[0]
										};
										var file = $("#new-event")[0].files[0];

										$
												.ajax({
													url : "detailtasks?project_id="
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
														

														$.ajax({
																	url : "taskgpbaseddetails",
																	contentType : "application/json",
																	mtype : "POST",
																	data : {
																		feature_id : taskgroupvalue_name,
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
																		var menu = '<div class="panel panel-custom"><div class="panel-heading"><span class ="task_id" id="'
																	        + data[i].task_id+ '" name="task_id"><a style="color: blue" href=""><i class="glyphicon glyphicon-picture"style="color: blue"></i>'
																	        +data[i].task_id+'-'+data[i].task_name+' </a></span><div class="panel-body" id="task_group_id" style="display: none;">'+data[i].feature_id+'</div><div class="panel-body" id="project_id" style="display: none;">'
																	        +data[i].project_id+'</div><div class="pull-right"><span><button type="button"class="btn button-border-primary btn-circle"><b>'
																	        +data[i].task_size_code+'</b></button></span> <span><button type="button"class="btn btn-default btn-circle"></button></span> <span><buttontype="button" class="btn btn-default btn-circle"></button></span><span  id="carouselButtons" class="tstatus"><button id="pauseButton" type="button"class="btn button-border-primary btn-circle" value='
																	        +data[i].task_id+'><i class="glyphicon glyphicon-play"></i></button></div></div></div>'
																	   
																	        $(
																			"#taskrow").unbind()
																			.append(
																					menu); 
																});

																	},
																	error : function(
																			jqXHR,
																			textStatus,
																			errorThrown) {

																	}
																});

													},
													error : function(xhr,
															ajaxOptions,
															thrownError) {

														console.log(xhr.status);
														console
																.log(thrownError);

													}

												});

									});

					$("#closetasks").click(function() {
						document.getElementById("gettask").innerHTML = "";
						document.getElementById("getdesc").innerHTML = "";
						document.getElementById("getsign").innerHTML = "";
						document.getElementById("getsize").innerHTML = "";
						document.getElementById("getlink").innerHTML = "";
					});
					$("#add-new-event")
							.unbind()
							.click(
									function() {

										var x = document
												.getElementById("task_group_name").value;
										var y = document
												.getElementById("project_id").value;

										if (x == null || x == "") {
											document.getElementById("my_span").innerHTML = "Group Name is required";
											return false;
										}

										// $("#task_group_ref").load(location.href
										// + " #task_group_ref");

										document.getElementById("savetaskgp")
												.submit();
									});

					$("#close-new-event").click(function() {
						document.getElementById("my_span").innerHTML = "";
						$('#myModal').modal('hide');
						return false;
					});


					$("#savetasks1")
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
										var project_id = document
										.getElementById("project_id").value;
										var task_group_id = document
										.getElementById("feature_id").value;
										
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
											url : "editviewtask?project_id="
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
													url : "taskgpbaseddetails",
													contentType : "application/json",
													mtype : "POST",
													data : {
														feature_id : task_group_id,
														project_id : project_id
													},
													dataType : 'json',
													async : false,
													success : function(
															data) {
														$('#taskrow')
														.empty();
												
												$
														.each(
																data,
																function(
																		i,
																	value) {
														var menu = '<div class="panel panel-custom"><div class="panel-heading"><span class ="task_id" id="'
													        + data[i].task_id+ '" name="task_id"><a style="color: blue" href=""><i class="glyphicon glyphicon-picture"style="color: blue"></i>'
													        +data[i].task_id+'-'+data[i].task_name+' </a></span><div class="panel-body" id="task_group_id" style="display: none;">'+data[i].task_group_id+'</div><div class="panel-body" id="project_id" style="display: none;">'
													        +data[i].project_id+'</div><div class="pull-right"><span><button type="button"class="btn button-border-primary btn-circle"><b>'
													        +data[i].task_size_code+'</b></button></span> <span><button type="button"class="btn btn-default btn-circle"></button></span> <span><buttontype="button" class="btn btn-default btn-circle"></button></span><span  id="carouselButtons" class="tstatus"><button id="pauseButton" type="button"class="btn button-border-primary btn-circle" value='
													        +data[i].task_id+'><i class="glyphicon glyphicon-play"></i></button></div></div></div>'
													   
													      
													        
													        
													        $(
															"#taskrow").unbind()
															.append(
																	menu); 
												});
                                               
												
												
												
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
												
												
												
											},
											
										});
										//document.getElementById("edittaskdetails").submit();

									});
					$("#viewtasks").on('click', '#task_id', function(e) {
						var task_id_val = $(this).attr('id');
						var $td = $(this).closest('tr').children('td');
						var task_id = $td.eq(0).text();
						var redirecturl = "taskdetail?task_id=" + task_id;
						window.location.replace(redirecturl);

					});
				
							
				$("body").unbind().on("click", "#pauseButton",function() {
								
							var task_id=$(this).attr('value');
							

							if($(this).attr("id") ==  "pauseButton"){
                                $('#carouselButtons').carousel('pause');
                                $(this).attr("id", "playButton");
                                $("i",this).toggleClass('glyphicon-play glyphicon-pause');
                                 
                                
                           }
								$.ajax({
									url : "taskready",
									contentType : "application/json",
									mtype : "GET",
									data : {
										task_id : task_id

									},
									dataType : "json",
									async : false,
									success : function() {
										
										
									     	//$("tr.taskrow").closest('tr').find("button#pauseButton").prop('disabled',true);
									       	
									},

								});

							});

					function change() {
						var project_id = document.getElementById("project_id").value;
						var project_type = document
								.getElementById("project_type").value;
						var project_name = document
								.getElementById("projectname").value;
						var description = document
								.getElementById("description").value;

						document.getElementById("savetaskdetail").submit();
					}
					
					$(document ).unbind().on('click', '.task_id',function(e) {
										
						
						
										e.preventDefault();
										 e.stopPropagation();
									
										
										var task_id = $(this).attr('id');
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
												        .getElementById('status_name').innerHTML = data[0].status_name;
														
														document
														        .getElementById('team_task_group_id').innerHTML =  data[0].feature_id;
														
														document
														        .getElementById('status_name').innerHTML = data[0].status_name;
														document
														        .getElementById('attach').innerHTML = data[0].file_name;
														

													}

												});

									});
					
					$('#task_group_click').unbind()
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
//								$('#edit_task_group_name').val(
//										task_group_name);
								var task_count = $(this).find(
										'.task_count').text();
								var task_group_id = $(this).find(
										'#task_group_id').text();
								var project_id = $(this).find(
								'#project_id').text();
								
								
								
								document.getElementById("design").innerHTML = task_group_name;
				//			document
					//					.getElementById("taskgroupname").innerHTML = task_group_name;
							document
									.getElementById("taskgroupidhidden").innerHTML = task_group_id;
							//	document.getElementById("taskgroupId").innerHTML = task_group_id;
								document
										.getElementById("taskgroupcnthidden").innerHTML = task_count;
							
								
								$
								.ajax({
											url : "taskgpbaseddetails",
									contentType : "application/json",
									mtype : "POST",
									data : {
										feature_id : taskgroupvalue,
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
										var menu = '<div class="panel panel-custom"><div class="panel-heading"><span class ="task_id" id="'
									        + data[i].task_id+ '" name="task_id"><a style="color: blue" href=""><i class="glyphicon glyphicon-picture"style="color: blue"></i>'
									        +data[i].task_id+'-'+data[i].task_name+' </a></span><div class="panel-body" id="task_group_id" style="display: none;">'+data[i].task_group_id+'</div><div class="panel-body" id="project_id" style="display: none;">'
									        +data[i].project_id+'</div><div class="pull-right"><span><button type="button"class="btn button-border-primary btn-circle"><b>'
									        +data[i].task_size_code+'</b></button></span> <span><button type="button"class="btn btn-default btn-circle"></button></span> <span><buttontype="button" class="btn btn-default btn-circle"></button></span><span  id="carouselButtons" class="tstatus"><button id="pauseButton" type="button"class="btn button-border-primary btn-circle" value='
									        +data[i].task_id+'><i class="glyphicon glyphicon-play"></i></button></div></div></div>'
									    $(
													"#taskrow")
													.append(
															menu);
										
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
					
					$("#edit_task").unbind()
					.click(
							function(e) {

								e.preventDefault();
								var project_id = $('#project_id').val();
								var task_group_id = document.getElementById("team_task_group_id").innerHTML;
								var task_id_val = document.getElementById("team_task_id").innerHTML;
								var team_task_type = document.getElementById("team_task_type").innerHTML;
								var team_task_type_name = document.getElementById("teamname").innerHTML;
								var team_task_description = document.getElementById("team_task_description").innerHTML;
								var team_task_sign= document.getElementById("team_task_sign").innerHTML;
								var attach = $("#attach").attr('value');
								$("#feature_id").val(task_group_id);
								$("#projectid").val(project_id);
								$("#taskid").val(task_id_val);
								$("#editname").val(team_task_type_name);
								$("#editmessage").val(team_task_description);
								$("#editmessage1").val(team_task_sign);
								$("#attachment").val(attach);
								$('#editTaskModal').modal('show');
								
							});

		
					
					
					

				});
