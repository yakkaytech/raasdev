/**
 * 
 */

$(document)
		.ready(
				function() {
					
					var status_code = document
					.getElementById("create_task").value;
					  if(status_code == 0){
				        	$(this).find("#create_task").prop('disabled',false);
				        }else if(status_code == 1){
				       		$(this).find("#create_task").prop('disabled',true);
				       		
				       	}
					
					  
					  var member = document
						.getElementById("add_member").value;
						  if(member == 0){
					        	$(this).find("#add_member").prop('disabled',false);
					        }else if(member == 1){
					       		$(this).find("#add_member").prop('disabled',true);
					       	}
					

//					 var edit = document
//							.getElementById("edit_proposaltask").value;
//					if (edit == 0) {
//						$(this).find("#edit_proposaltask").prop('disabled',
//								false);
//					} else if (edit == 1) {
//						$(this).find("#edit_proposaltask").prop('disabled',
//								true);
//					}
					
					
					 var submit = document
						.getElementById("submit_proposal").value;
				if (submit == 0) {
					$(this).find("#submit_proposal").prop('disabled',
							false);
				} else if (submit == 1) {
					$(this).find("#submit_proposal").prop('disabled',
							true);
				}
					
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
										console
												.log(new FormData(
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
																	url : "featureproposaldetails",
																	contentType : "application/json",
																	mtype : "POST",
																	data : {
																		feature_id : feature_id,
																		project_id : project_id
																	},
																	dataType : 'json',
																	async : false,
																	success : function(
																			data) {
																		

																		$(
																				'#taskrow')
																				.empty();

																		$
																				.each(
																						data,
																						function(
																								i,
																								value) {
																							var menu = '<div class="panel panel-custom"><div class="panel-heading"><span class ="pro_id" id="'
																									+ data[i].task_id
																									+ '" name="task_id"><a style="color: blue" href=""><i class="glyphicon glyphicon-picture"style="color: blue"></i>'
																									+ data[i].task_id
																									+ '-'
																									+ data[i].task_name
																									+ ' </a></span><div class="panel-body" id="task_group_id" style="display: none;">'
																									+ data[i].task_group_id
																									+ '</div><div class="panel-body" id="project_id" style="display: none;">'
																									+ data[i].project_id
																									+ '</div><div class="pull-right"><span><button type="button"class="btn button-border-primary btn-circle"><b>'
																									+ data[i].estimated_hours
																									+ '</b></button></span> <span><button type="button"class="btn btn-default btn-circle"></button></span> </div></div></div>'

																									
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

					$('#pro_tasktable')
							.unbind()
							.on(
									'click',
									'.pro_id',
									function(e) {


										e.preventDefault();
										e.stopPropagation();

										var task_id = $(this).attr('id');

										$
												.ajax({
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
																.getElementById('team_task_name').innerHTML = 'Task:'
																+ data[0].task_name;
														document
																.getElementById('teamname').innerHTML = data[0].task_name;

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
																.getElementById('team_task_group_id').innerHTML = data[0].feature_id;

														document
																.getElementById('status_name').innerHTML = data[0].status_name;
														document
														.getElementById('team_estimated_hours').innerHTML = data[0].estimated_hours;
														
														document
														.getElementById('task_owner').innerHTML = data[0].firstname;
														
														document
														.getElementById('task_cost').innerHTML = data[0].cost;

														
														document
																.getElementById('attach').innerHTML = data[0].file_name;
														
													}

												});

									});

					$('#feature_click')
							.unbind()
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
													url : "featureproposaldetails",
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
																.getElementById('total_tasks').innerHTML = 'Total Tasks:'
																+ data[0].proposal_task_count;
														document
																.getElementById('total_hrs').innerHTML = 'Total Estimated Hours:'
																+ data[0].estimated_hrscount;

														$('#taskrow').empty();

														$
																.each(
																		data,
																		function(
																				i,
																				value) {
																			var menu = '<div class="panel panel-custom"><div class="panel-heading"><span class ="pro_id" id="'
																					+ data[i].task_id
																					+ '" name="task_id"><a style="color: blue" href=""><i class="glyphicon glyphicon-picture"style="color: blue"></i>'
																					+ data[i].task_id
																					+ '-'
																					+ data[i].task_name
																					+ ' </a></span><div class="panel-body" id="task_group_id" style="display: none;">'
																					+ data[i].task_group_id
																					+ '</div><div class="panel-body" id="project_id" style="display: none;">'
																					+ data[i].project_id
																					+ '</div><div class="pull-right"><span><button type="button"class="btn button-border-primary btn-circle"><b>'
																					+ data[i].estimated_hours
																					+ '</b></button></span> <span><button type="button"class="btn btn-default btn-circle"></button></span> </div></div></div>'
																	
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
																	success : function(
																			data) {

																		document
																				.getElementById('total_tasks').innerHTML = 'Total Tasks:'
																				+ data[0].proposal_task_count;
																		document
																				.getElementById('total_hrs').innerHTML = 'Total Estimated Hours:'
																				+ data[0].estimated_hrscount;

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
																	success : function(
																			data) {

																		document
																				.getElementById('team_task_name').innerHTML = 'Task:'
																				+ data[0].task_name;
																		document
																				.getElementById('teamname').innerHTML = data[0].task_name;

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
																				.getElementById('team_task_group_id').innerHTML = data[0].feature_id;

																		document
																				.getElementById('status_name').innerHTML = data[0].status_name;
																		document
																				.getElementById('attach').innerHTML = data[0].file_name;

																	},
																});

													},

													error : function(xhRequest,
															ErrorText,
															thrownError) {
														alert("Failed to process promotion correctly, please try again");
														console
																.log('xhRequest: '
																		+ xhRequest
																		+ "\n");
														console
																.log('ErrorText: '
																		+ ErrorText
																		+ "\n");
														console
																.log('thrownError: '
																		+ thrownError
																		+ "\n");
													}

												});

										// $("#teamviewdetails").load(location.href+"
										// #teamviewdetails>*","");

									});

					$("#edit_proposaltask")
							.unbind()
							.click(
									function(e) {

										e.preventDefault();
										var project_id = $('#project_id').val();
										var feature_id = document
												.getElementById("team_task_group_id").innerHTML;
										var task_id_val = document
												.getElementById("team_task_id").innerHTML;
										var team_task_type = document
												.getElementById("team_task_type").innerHTML;
										var team_task_type_name = document
												.getElementById("teamname").innerHTML;
										var team_task_description = document
												.getElementById("team_task_description").innerHTML;
										var team_task_sign = document
												.getElementById("team_task_sign").innerHTML;

										var estimated_hrs = $(
												"#estimated_hours").attr(
												'value');
										var attach = $("#attach").attr('value');

										$("#feature_id").val(feature_id);
										$("#projectid").val(project_id);
										$("#taskid").val(task_id_val);
										$("#editname").val(team_task_type_name);
										$("#editmessage").val(
												team_task_description);
										$("#editmessage1").val(team_task_sign);
										$("#attachment").val(attach);
										$("#estimated_hours").val(
												estimated_hours);

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


										var project_id = document
												.getElementById('project_id').value;
										var task_id = document
												.getElementById("taskid").value;
										var fullPath = document
												.getElementById("new-event").value;

										var file = $('#new-eventattach')[0].files[0];


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
																	success : function(
																			data) {


																		$(
																				'#taskrow')
																				.empty();

																		$
																				.each(
																						data,
																						function(
																								i,
																								value) {
																							var menu = '<div class="panel panel-custom"><div class="panel-heading"><span class ="pro_id" id="'
																									+ data[i].task_id
																									+ '" name="task_id"><a style="color: blue" href=""><i class="glyphicon glyphicon-picture"style="color: blue"></i>'
																									+ data[i].task_id
																									+ '-'
																									+ data[i].task_name
																									+ ' </a></span><div class="panel-body" id="task_group_id" style="display: none;">'
																									+ data[i].task_group_id
																									+ '</div><div class="panel-body" id="project_id" style="display: none;">'
																									+ data[i].project_id
																									+ '</div><div class="pull-right"><span><button type="button"class="btn button-border-primary btn-circle"><b>'
																									+ data[i].estimated_hours
																									+ '</b></button></span> <span><button type="button"class="btn btn-default btn-circle"></button></span> </div></div></div>'


																							$(
																									"#taskrow")
																									.append(
																											menu);

																						});

																	},
																});

														// $("#mydiv").load(location.href
														// + " #mydiv")

														$
																.ajax({
																	url : "proposaltaskview",
																	contentType : "application/json",
																	mtype : "GET",
																	data : {

																		task_id : task_id
																	},
																	dataType : "json",
																	async : false,
																	success : function(
																			data) {
																		

																		document
																				.getElementById('team_task_name').innerHTML = 'Task:'
																				+ data[0].task_name;
																		document
																				.getElementById('teamname').innerHTML = data[0].task_name;

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
																				.getElementById('team_task_group_id').innerHTML = data[0].feature_id;

																		document
																				.getElementById('status_name').innerHTML = data[0].status_name;
																		document
																		.getElementById('team_estimated_hours').innerHTML = data[0].estimated_hours;
																		document
																				.getElementById('attach').innerHTML = data[0].file_name;
																	}
																});

													},

												});
									});

					$("#add_member").unbind().click(function(e) {

						$('#addmemberModal').modal('show');

					});

					var count = 1;
					var counter = 2;
					$("#add_new")
							.unbind()
							.click(
									function(e) {

										if (counter > 5) {

											alert("Only 5 textboxes allow");
											return false;

										}

										else {

											var newTextBoxDiv = $(
													document
															.createElement('div'))
													.attr("id",
															'subrow' + counter);
											newTextBoxDiv
													.after()
													.html(
															'<div class="row" id= "subrow" style="height: 100px; width: 100%;"><div class="col-lg-3"><div class="row"><label class="control-label" for="name"> E-mail Address*</label></div><div class="row"><div class="col-md-20"><input id="email'
																	+ counter
																	+ '" name="email" type="email" placeholder="E-mail Address" class="form-control"><span class="help-block"></span></div></div></div><div class="col-lg-3"><div class="row"><label class="control-label" for="name">firstname </label></div><div class="row"><div class="col-md-14"><input id="First Name'
																	+ counter
																	+ '" name="firstname" type="text" placeholder="Your name" class="form-control"></div></div></div><div class="col-lg-3"><div class="row"><label class="control-label" for="name"> lastname</label></div><div class="row"><div class="col-md-14"><input id="Last Name'
																	+ counter
																	+ '" name="lastname" type="text" placeholder="Your name" class="form-control"></div></div></div><div class="col-lg-3 pull-right"><div class="row"  id="remove"><label class="control-label" for="name"> </label></div>&nbsp;&nbsp;&nbsp;&nbsp;<div class="row" id="symbol"><div class="col-md-1" id="removefield"><a  href="#" ><i class="glyphicon glyphicon-remove" > </i> </a></div></div></div></div>');
											

											$("#anothermember").append(
													newTextBoxDiv);

											counter++;
											count++;
											document.getElementById("invite").innerHTML = "Invite "
													+ count + " Persons.";
										}
									});

					var count = 1;
					$("div")
							.on(
									'click',
									'#removefield',
									function(e) {
										if (counter == 1) {
											alert("No more textbox to remove");
											return false;
										}
										counter--;
										count--;
										$("#subrow" + counter).remove();
										document.getElementById("invite").innerHTML = "Invite "
												+ count + " Persons.";
									});
					
					function validateEmail(sEmail) {
						var filter = /^([\w-\.]+)@((\[[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\.)|(([\w-]+\.)+))([a-zA-Z]{2,4}|[0-9]{1,3})(\]?)$/;
						if (filter.test(sEmail)) {
							return true;
						} else {
							return false;
						}
					}
//					$("#invite").click(function() {
//						var form =  $('form[name="member_request"]').serializeArray();
//						
//						 var SkillValue = JSON.stringify(form);
//						alert(SkillValue);
//						console.log($('form[name="member_request"]').serializeArray());
//						alert($('form[name="member_request"]').serialize());
//						
//						alert("hai");
//						
//						$.ajax({
//							url : "member_req",
//							contentType : "application/json",
//							mtype : "POST",
//							data : form,
//							dataType : "json",
//							async : false,
//							success : function(data) {
//							},
//						});
//						
//						
//					});
					
					
					
					
					

					$("#invite").click(function() {

						var obj= document.getElementsByName('email');
						
						for(var i=1;i<obj.length;i++){
								console.log(obj[i].value);
						  if(obj[i].value=='' || !validateEmail(obj[i].value)){
									
							  alert("Invalid E-mail");
									$(obj[i]).css(
											'border-color', 'red');
									return false;
									
							} 
						  else{
								$(obj[i]).css(
										'border-color', '#E6E6E6');
							}
						}
						
						var email = [];
						 $('input[name=email]').each(function () {
						        email.push($(this).val())
						    });
						
						 console.log("email"+email);
						 
						 var sorted_arr = email.sort();

						    for (var i = 0; i < email.length - 1; i++) {
						        if (sorted_arr[i + 1] == sorted_arr[i]) {
						            alert("Please enter different value in each TextBox.");
						            return false;
						        }
						    }
						    
						    
							var firstname = [];
							 $('input[name=firstname]').each(function () {
								 firstname.push($(this).val())
							    }); 
							 console.log("firstname"+firstname);
								var lastname = [];
								 $('input[name=lastname]').each(function () {
									 lastname.push($(this).val())
								    }); 
								 console.log("lastname"+lastname);
						    
						    
						
						var project_id = $('#project_id').val();
						var team_id = $('#team_id').val();
						
						 
						var email = '';
						var firstname = '';
						var lastname = '';
						var project_id = $('#project_id').val();
						var team_id = $('#team_id').val();

						for (i = 1; i < counter; i++) {

							email = $('#email' + i).val();
							firstname = $('#firstname' + i).val();
							lastname = $('#lastname' + i).val();
							$.ajax({
								url : "member_req",
								contentType : "application/json",
								mtype : "POST",
								data : {
									email : email,
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
					
					$("#submit_proposal")
							.unbind()
							.click(
									function(e) {
										
										
										
										var user_id = document
												.getElementById("user_id").value;

										$("#task_group_ref #task_count")
												.each(
														function(index, elem) {
															var count = $(this)
																	.text();
															if (count == 0) {
																alert(" Feature has no task not able to submit ");
															}
														});
										$
												.ajax({
													url : "checkrateandcode",
													contentType : "application/json",
													mtype : "POST",
													data : {
														user_id : user_id
													},
													dataType : "json",
													async : false,
													success : function(data) {


														var rate = data[0].rate;
														var code = data[0].member_type_code;

														if (rate != 0
																&& code == 'L') {

															$('#proposalsubmit')
																	.modal(
																			'show');

														} else {
															alert("not able to submit");
														}
													},
												});

									});

					$("#proposal_submit").click(
							function(e) {
								var team_id = document.getElementById("team_id").value;
								var project_id = document.getElementById("project_id").value;
								$.ajax({
									url : "submitproposal",
									contentType : "application/json",
									mtype : "POST",
									data : {
										project_id : project_id,
										team_id : team_id
									},
									dataType : "json",
									async : false,
									success : function(data) {
										
										
										
									},

								});

							});

				});
