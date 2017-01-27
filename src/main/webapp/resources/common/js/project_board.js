/**
 * 
 */

$(document)
		.ready(
				function() {

					$('#add_feature').unbind().on('click', function() {
						$('#myModal').modal('show');
					});

					$('#add-featuregrp')
							.unbind()
							.on(
									'click',
									function() {
										var feature_name = $(
												"input[name=name]")
												.val();
										var project_id = document
												.getElementById("project_id").value;
										var taskgp_description = document
												.getElementById("description").value;
										var taskgp_signoff_criteria = document
												.getElementById("signoff_criteria").value;
										var priority_code = document
												.getElementById("prio_cde").value;


										$
												.ajax({
													url : "addfeature",
													contentType : "application/json",
													mtype : "POST",
													data : {
														feature_name : feature_name,
														feature_description : taskgp_description,
														project_id : project_id,
														feature_signoff_criteria : taskgp_signoff_criteria,
														priority_code : priority_code
													},
													dataType : "json",
													async : false,
													success : function(data) {
														
														$(
																'#task_body')
																.empty();
														$
																.each(
																		data,
																		function(
																				i,
																				value) {
																			
																			var icon = data[i].priority_code;
                                                                            switch(icon) {
                                                                            case '4' :
                                                                           var taskdetailstable = '<tr class="taskrow"><td class="col-md-2 text-center" style = "display:none;">'
																					+value.feature_id
																					+'</td><td class="col-md-2 text-center" style = "display:none;">'
																					+value.tasks_cnt_pergp
																					+'</td><td class="col-md-2" id="task_gp_name"><a href="#" style = "color:blue;">'
																						+ value.feature_name
																						+ '</a></td><td class="col-md-2 text-center" id="priority_code"> <i id="arrow" class="glyphicon glyphicon-arrow-up"> </i></td><td class="col-md-2 text-center" id="est_time"> 40 </td><td id="cost" class="col-md-2 text-center"> $1000 </td><td class="col-md-2 text-center" id="start"> <i class="glyphicon glyphicon-play-circle"></td><td class="col-md-2 text-center" id="status"> <i class="glyphicon glyphicon-equalizer"> </td><td class="col-md-2 text-center" id="delete"><a href="#" > <i class="glyphicon glyphicon-remove"></i></a></td></tr>'
																				
                                                                               break;
                                                                           
                                                                            case '5' :
                                                                           var	taskdetailstable = '<tr class="taskrow"><td class="col-md-2 text-center" style = "display:none;">'
																					+value.feature_id
																					+'</td><td class="col-md-2 text-center" style = "display:none;">'
																					+value.tasks_cnt_pergp
																					+'</td><td class="col-md-2" id="task_gp_name"><a href="#" style = "color:blue;">'
																						+ value.feature_name
																						+ '</a></td><td class="col-md-2 text-center" id="priority_code"> <i id="arrow" class="glyphicon glyphicon-arrow-down"> </i></td><td class="col-md-2 text-center" id="est_time"> 40 </td><td id="cost" class="col-md-2 text-center"> $1000 </td><td class="col-md-2 text-center" id="start"> <i class="glyphicon glyphicon-play-circle"></td><td class="col-md-2 text-center" id="status"> <i class="glyphicon glyphicon-equalizer"> </td><td class="col-md-2 text-center" id="delete"><a href="#" > <i class="glyphicon glyphicon-remove"></i></a></td></tr>'
																				
                                                                               break;
                                                                            case '6' :
                                                                            	var	 taskdetailstable = '<tr class="taskrow"><td class="col-md-2 text-center" style = "display:none;">'
																					+value.feature_id
																					+'</td><td class="col-md-2 text-center" style = "display:none;">'
																					+value.tasks_cnt_pergp
																					+'</td><td class="col-md-2" id="task_gp_name"><a href="#" style = "color:blue;">'
																						+ value.feature_name
																						+ '</a></td><td class="col-md-2 text-center" id="priority_code"> <i id="arrow" class="glyphicon glyphicon-arrow-right"> </i></td><td class="col-md-2 text-center" id="est_time"> 40 </td><td id="cost" class="col-md-2 text-center"> $1000 </td><td class="col-md-2 text-center" id="start"> <i class="glyphicon glyphicon-play-circle"></td><td class="col-md-2 text-center" id="status"> <i class="glyphicon glyphicon-equalizer"> </td><td class="col-md-2 text-center" id="delete"><a href="#" > <i class="glyphicon glyphicon-remove"></i></a></td></tr>'
																				
                                                                            case '7' :
                                                                            	var	 taskdetailstable = '<tr class="taskrow"><td class="col-md-2 text-center" style = "display:none;">'
																					+value.feature_id
																					+'</td><td class="col-md-2 text-center" style = "display:none;">'
																					+value.tasks_cnt_pergp
																					+'</td><td class="col-md-2" id="task_gp_name"><a href="#" style = "color:blue;">'
																						+ value.feature_name
																						+ '</a></td><td class="col-md-2 text-center" id="priority_code"> <i id="arrow" class="glyphicon glyphicon-arrow-left"> </i></td><td class="col-md-2 text-center" id="est_time"> 40 </td><td id="cost" class="col-md-2 text-center"> $1000 </td><td class="col-md-2 text-center" id="start"> <i class="glyphicon glyphicon-play-circle"></td><td class="col-md-2 text-center" id="status"> <i class="glyphicon glyphicon-equalizer"> </td><td class="col-md-2 text-center" id="delete"><a href="#" > <i class="glyphicon glyphicon-remove"></i></a></td></tr>'
																				
                                                                               break;
                                                                           
                                                                         }  
                                                                            
																			$(
																					"#task_body")
																					.append(
																							taskdetailstable);

													
																						});
																	
														$("#savefeature")
																.trigger(
																		"reset");
													},
												})
									});

					
										
					 $("#task_body").on('click','#task_gp_name',function(e) {
										
										e.preventDefault();
										
										var task_name_val=$(this).attr('value');
										var $td= $(this).closest('tr').children('td');
										var taskgroupvalue_name= $td.eq(0).text();
										var project_id = document
												.getElementById("project_id").value;
										$("#taskgroupId").val(
												taskgroupvalue_name);
										//("#taskgroupname").val(taskgroupname);
										$
												.ajax({
													url : "featureeditload",
													contentType : "application/json",
													mtype : "GET",
													data : {

														project_id : project_id,
														feature_id : taskgroupvalue_name,
													},
													dataType : "json",
													async : false,
													success : function(data) {
														

														$('#edit_feature')
																.find(
																		'[name="name"]')
																.val(
																		data[0].feature_name)
																.end()
																.find(
																		'[name="feature_description"]')
																.val(
																		data[0].feature_description)
																.end()
																.find(
																		'[name="feature_signoff_criteria"]')
																.val(
																		data[0].feature_signoff_criteria)
																.end()
																.find(
																		'[name="priority_code_name"]')
																.val(
																		data[0].priority_code_name)
																.end();

														$('#editModal').modal('show');

													}
													
												});

									});
					 
					 
					 $("#edit-event")
						.unbind()
						.click(
								function() {
									var taskgroupvalue = $("#taskgroupId")
											.val();
									
									var taskgroupname = $(
											"#edit_task_group_name").val();
									var taskgp_description = $(
											"#edittaskgp_description")
											.val();
									var taskgp_signoff_criteria = $(
											"#edittaskgp_signoff_criteria")
											.val();
									var priority_cde_name = $(
											"#priority_code_name").val();
									var project_id = document
											.getElementById("project_id").value;
									
									var that = '#priority_code';
									$
											.ajax({
												url : "edittaskgrp",
												contentType : "application/json",
												mtype : "POST",

												data : {
													project_id : project_id,
													feature_id : taskgroupvalue,
													feature_name : taskgroupname,
													feature_description : taskgp_description,
													feature_signoff_criteria : taskgp_signoff_criteria,
													priority_code_name : priority_cde_name,
												},

												dataType : "json",
												async : false,
												success : function(data) {
													
													
															$(
																	'#task_body')
																	.empty();
															$
																	.each(
																			data,
																			function(
																					i,
																					value) {
																				
													
																				
																				var taskdetailstable = " ";
																				var icon = data[i].priority_code;
                                                                                     
                                                                                     
                                                                                     switch(icon) {
                                                                                     case '4' :
                                                                                    	 taskdetailstable = '<tr class="taskrow"><td class="col-md-2 text-center" style = "display:none;">'
         																					+value.feature_id
         																					+'</td><td class="col-md-2 text-center" style = "display:none;">'
        																					+value.tasks_cnt_pergp
        																					+'</td><td class="col-md-2" id="task_gp_name"><a href="#" style = "color:blue;">'
         																						+ value.feature_name
         																						+ '</a></td><td class="col-md-2 text-center" id="priority_code"> <i id="arrow" class="glyphicon glyphicon-arrow-up"> </i></td><td class="col-md-2 text-center" id="est_time"> 40 </td><td id="cost" class="col-md-2 text-center"> $1000 </td><td class="col-md-2 text-center" id="start"> <i class="glyphicon glyphicon-play-circle"></td><td class="col-md-2 text-center" id="status"> <i class="glyphicon glyphicon-equalizer"> </td><td class="col-md-2 text-center" id="delete"><a href="#" > <i class="glyphicon glyphicon-remove"></i></a></td></tr>'
         																				
                                                                                        break;
                                                                                    
                                                                                     case '5' :
                                                                                    	 taskdetailstable = '<tr class="taskrow"><td class="col-md-2 text-center" style = "display:none;">'
         																					+value.feature_id
         																					+'</td><td class="col-md-2 text-center" style = "display:none;">'
        																					+value.tasks_cnt_pergp
        																					+'</td><td class="col-md-2" id="task_gp_name"><a href="#" style = "color:blue;">'
         																						+ value.feature_name
         																						+ '</a></td><td class="col-md-2 text-center" id="priority_code"> <i id="arrow" class="glyphicon glyphicon-arrow-down"> </i></td><td class="col-md-2 text-center" id="est_time"> 40 </td><td id="cost" class="col-md-2 text-center"> $1000 </td><td class="col-md-2 text-center" id="start"> <i class="glyphicon glyphicon-play-circle"></td><td class="col-md-2 text-center" id="status"> <i class="glyphicon glyphicon-equalizer"> </td><td class="col-md-2 text-center" id="delete"><a href="#" > <i class="glyphicon glyphicon-remove"></i></a></td></tr>'
         																				
                                                                                        break;
                                                                                     case '6' :
                                                                                    	 taskdetailstable = '<tr class="taskrow"><td class="col-md-2 text-center" style = "display:none;">'
         																					+value.feature_id
         																					+'</td><td class="col-md-2 text-center" style = "display:none;">'
        																					+value.tasks_cnt_pergp
        																					+'</td><td class="col-md-2" id="task_gp_name"><a href="#" style = "color:blue;">'
         																						+ value.feature_name
         																						+ '</a></td><td class="col-md-2 text-center" id="priority_code"> <i id="arrow" class="glyphicon glyphicon-arrow-right"> </i></td><td class="col-md-2 text-center" id="est_time"> 40 </td><td id="cost" class="col-md-2 text-center"> $1000 </td><td class="col-md-2 text-center" id="start"> <i class="glyphicon glyphicon-play-circle"></td><td class="col-md-2 text-center" id="status"> <i class="glyphicon glyphicon-equalizer"> </td><td class="col-md-2 text-center" id="delete"><a href="#" > <i class="glyphicon glyphicon-remove"></i></a></td></tr>'
         																				
         																			break;			
                                                                                     case '7' :
                                                                                    	 taskdetailstable = '<tr class="taskrow"><td class="col-md-2 text-center" style = "display:none;">'
         																					+value.feature_id
         																					+'</td><td class="col-md-2 text-center" style = "display:none;">'
        																					+value.tasks_cnt_pergp
        																					+'</td><td class="col-md-2" id="task_gp_name"><a href="#" style = "color:blue;">'
         																						+ value.feature_name
         																						+ '</a></td><td class="col-md-2 text-center" id="priority_code"> <i id="arrow" class="glyphicon glyphicon-arrow-left"> </i></td><td class="col-md-2 text-center" id="est_time"> 40 </td><td id="cost" class="col-md-2 text-center"> $1000 </td><td class="col-md-2 text-center" id="start"> <i class="glyphicon glyphicon-play-circle"></td><td class="col-md-2 text-center" id="status"> <i class="glyphicon glyphicon-equalizer"> </td><td class="col-md-2 text-center" id="delete"><a href="#" > <i class="glyphicon glyphicon-remove"></i></a></td></tr>'
         																				
                                                                                        break;
                                                                                    
                                                                                  }  
																				 $(
																						"#task_body")
																						.append(
																								taskdetailstable);
																		
																			});
															
														
														
												},
												});

								});
					 
					 $("#task_body").on('click','#delete',function(e) {
						 var task_name_val=$(this).attr('value');
							var $td= $(this).closest('tr').children('td');
							
							var taskgroupid= $td.eq(0).text();
							var task_count= $td.eq(1).text();
							var taskgroupvalue_name= $td.eq(2).text();
							
							var project_id = document
							.getElementById("project_id").value;
							
						
						$("#task_cnt").val(task_count);
							$("#taskgrpid").val(taskgroupid);
							$("#taskgroupdelete").val(taskgroupvalue_name);
							
							

							if (task_count > 0) {
								toastr
										.warning('There are '
												+ task_count
												+ ' tasks.Not able to delete the group.')
							
							} else {
								$('#deleteModal').modal('show');
								document
										.getElementById('taskgroup_cnt');
								var elem1 = document
										.getElementById('taskgroup_cnt');
								elem1.innerHTML = 'Are you sure, to delete the group ?';
								elem1.style.color = "black";
								elem1.style.fontSize = "large";
							}
							
							
							
							});

					 $("#delete-event")
						.unbind()
						.click(
								function(e) {
									 
									 var taskgp_id = $(
										"#taskgrpid")
										.val();
									 
									 var project_id = $(
										"#project_id")
										.val();
										$
										.ajax({
											url : "deletefeatures",
											contentType : "application/json",
											mtype : "POST",

											data : {
												project_id : project_id,
												feature_id : taskgp_id,
												
											},

											dataType : "json",
											async : false,
											success : function(data) {
												
											
														$(
																'#task_body')
																.empty();
														$
																.each(
																		data,
																		function(
																				i,
																				value) {
																			
																			var taskdetailstable = " ";
																			var icon = data[i].priority_code;
                                                                            
                                                                            switch(icon) {
                                                                            case '4' :
                                                                           	 taskdetailstable = '<tr class="taskrow"><td class="col-md-2 text-center" style = "display:none;">'
																					+value.feature_id
																					+'</td><td class="col-md-2 text-center" style = "display:none;">'
																					+value.tasks_cnt_pergp
																					+'</td><td class="col-md-2" id="task_gp_name"><a href="#" style = "color:blue;">'
																						+ value.feature_name
																						+ '</a></td><td class="col-md-2 text-center" id="priority_code"> <i id="arrow" class="glyphicon glyphicon-arrow-up"> </i></td><td class="col-md-2 text-center" id="est_time"> 40 </td><td id="cost" class="col-md-2 text-center"> $1000 </td><td class="col-md-2 text-center" id="start"> <i class="glyphicon glyphicon-play-circle"></td><td class="col-md-2 text-center" id="status"> <i class="glyphicon glyphicon-equalizer"> </td><td class="col-md-2 text-center" id="delete"><a href="#" > <i class="glyphicon glyphicon-remove"></i></a></td></tr>'
																				
                                                                               break;
                                                                           
                                                                            case '5' :
                                                                           	 taskdetailstable = '<tr class="taskrow"><td class="col-md-2 text-center" style = "display:none;">'
																					+value.feature_id
																					+'</td><td class="col-md-2 text-center" style = "display:none;">'
																					+value.tasks_cnt_pergp
																					+'</td><td class="col-md-2" id="task_gp_name"><a href="#" style = "color:blue;">'
																						+ value.feature_name
																						+ '</a></td><td class="col-md-2 text-center" id="priority_code"> <i id="arrow" class="glyphicon glyphicon-arrow-down"> </i></td><td class="col-md-2 text-center" id="est_time"> 40 </td><td id="cost" class="col-md-2 text-center"> $1000 </td><td class="col-md-2 text-center" id="start"> <i class="glyphicon glyphicon-play-circle"></td><td class="col-md-2 text-center" id="status"> <i class="glyphicon glyphicon-equalizer"> </td><td class="col-md-2 text-center" id="delete"><a href="#" > <i class="glyphicon glyphicon-remove"></i></a></td></tr>'
																				
                                                                               break;
                                                                            case '6' :
                                                                           	 taskdetailstable = '<tr class="taskrow"><td class="col-md-2 text-center" style = "display:none;">'
																					+value.feature_id
																					+'</td><td class="col-md-2 text-center" style = "display:none;">'
																					+value.tasks_cnt_pergp
																					+'</td><td class="col-md-2" id="task_gp_name"><a href="#" style = "color:blue;">'
																						+ value.feature_name
																						+ '</a></td><td class="col-md-2 text-center" id="priority_code"> <i id="arrow" class="glyphicon glyphicon-arrow-right"> </i></td><td class="col-md-2 text-center" id="est_time"> 40 </td><td id="cost" class="col-md-2 text-center"> $1000 </td><td class="col-md-2 text-center" id="start"> <i class="glyphicon glyphicon-play-circle"></td><td class="col-md-2 text-center" id="status"> <i class="glyphicon glyphicon-equalizer"> </td><td class="col-md-2 text-center" id="delete"><a href="#" > <i class="glyphicon glyphicon-remove"></i></a></td></tr>'
																				
                                                                            case '7' :
                                                                           	 taskdetailstable = '<tr class="taskrow"><td class="col-md-2 text-center" style = "display:none;">'
																					+value.feature_id
																					+'</td><td class="col-md-2 text-center" style = "display:none;">'
																					+value.tasks_cnt_pergp
																					+'</td><td class="col-md-2" id="task_gp_name"><a href="#" style = "color:blue;">'
																						+ value.feature_name
																						+ '</a></td><td class="col-md-2 text-center" id="priority_code"> <i id="arrow" class="glyphicon glyphicon-arrow-left"> </i></td><td class="col-md-2 text-center" id="est_time"> 40 </td><td id="cost" class="col-md-2 text-center"> $1000 </td><td class="col-md-2 text-center" id="start"> <i class="glyphicon glyphicon-play-circle"></td><td class="col-md-2 text-center" id="status"> <i class="glyphicon glyphicon-equalizer"> </td><td class="col-md-2 text-center" id="delete"><a href="#" > <i class="glyphicon glyphicon-remove"></i></a></td></tr>'
																				
                                                                               break;
                                                                           
                                                                         }  
                                                                            
																			                                                                               
																					$(
																					"#task_body")
																					.append(
																							taskdetailstable);

																		});
													
											},
											});

									
									
								});

					 

				});