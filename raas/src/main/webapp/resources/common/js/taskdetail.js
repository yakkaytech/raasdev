
function openFileOption() {
	document.getElementById("new-event").click();
}
$(document)
		.ready(
				function() {
					$("#savetasks")
							.unbind()
							.click(
									function() {
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
										var pro_id = document
												.getElementById("project_id").value;
										var fullPath = document
												.getElementById("new-event").value;

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
										if (task_name == null
												|| task_name == "") {

											document.getElementById("gettask").innerHTML = "Please enter Task name";
											return false;
										} else {

											document.getElementById("gettask").innerHTML = "";
										}

										if (task_size == null
												|| task_size == "") {

											document.getElementById("getsize").innerHTML = "Please enter Task Size ";
											return false;
										} else {

											document.getElementById("getsize").innerHTML = " ";
										}

										document.getElementById(
												"savetaskdetails").submit();
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
									function(e) {

										var x = document
												.getElementById("task_group_name").value;
										var y = document
												.getElementById("project_id").value;
										e.preventDefault();

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

					$("#edit-new-event")
							.unbind()
							.click(
									function() {
										var taskgroupvalue = $("#taskgroupId")
												.val();
										var taskgroupname = $(
												"#task_group_namei").val();
										var project_id = document
												.getElementById("project_id").value;
										var taskgp_cnt = document
												.getElementById("taskgp_cnt").value;

										$
										.ajax({
													url : "edittaskgrp",
													contentType : "application/json",
													mtype : "POST",

													data : {
														project_id : project_id,
														task_group_id : taskgroupvalue,
														task_group_name : taskgroupname,
														tasks_cnt_pergp : taskgp_cnt
													},

													dataType : "json",
													async : false,
													success : function(data) {
														$('#task_group_ref')
																.empty();
														var items = [];
														var buffer = " ";
														$
																.each(
																		data,
																		function(
																				index,
																				value) {
																			items
																					.push('<ul id ="taskgroupid"><li value = "'
																							+ value.task_group_id
																							+ '" id = "'
																							+ value.task_group_id
																							+ '" ><a href=""><span>'
																							+ value.task_group_name
																							+ '</span>&nbsp;&nbsp;<span class="badge left" >'
																							+ value.tasks_cnt_pergp
																							+ '</span><span style="display: none;">'
																							+ value.task_group_id
																							+ '</span><span style="display: none;">'
																							+ value.project_id
																							+ '</span></a></li></ul>');

																		});

														$("#task_group_ref")
																.append(
																		items
																				.join(''));

														$("#design").text(
																taskgroupname);
													},
													error : function(jqXHR,
															textStatus,
															errorThrown) {

													}
												});
									});

					$("#editGroupbutton")
							.click(
									function() {
										var taskgroupvalue_name = document
												.getElementById("taskgroupidhidden").innerHTML;
										
										$("#taskgroupId").val(
												taskgroupvalue_name);
										$('#editModal').modal('show');
										return false;

									});
					
					
					$("#DeleteGroupbutton").unbind()
					.click(
							function() {
								var taskgroupvalue_name = document
								.getElementById("taskgroupidhidden").innerHTML;
						
						var task_group_name = document.getElementById("design").innerHTML;
						document.getElementById('taskgroupdelete').innerHTML = task_group_name;
						
						var task_count = document.getElementById("taskgroupcnthidden").innerHTML;
						
						if(task_count > 0){
						//	var elem=document.getElementById('taskgroup_cnt').innerHTML = "<span style='color: red;'>There are '+ task_count + ' tasks. Please delete the tasks first and then delete the group.</span>";
							$(document).ready(function(){
							$( "#delete-new-even" ).button({disabled:true});								
							});
						var elem = document.getElementById('taskgroup_cnt');
						elem.innerHTML = 'There are '+ task_count + ' tasks. Please delete the tasks first and then delete the group.';
						elem.style.color = "Red";
						elem.style.fontSize = "large";
						
						}else {
							document.getElementById('taskgroup_cnt');
							var elem1 = document.getElementById('taskgroup_cnt');
							elem1.innerHTML = 'Are you sure, to delete the group ?';
							elem1.style.color = "black";
							elem1.style.fontSize = "large";
						}
						
						
						$("#task_group_id").val(
								taskgroupvalue_name);
						$("#task_count").val(
								task_count);
						$('#deleteModal').modal('show');
						return false;

							});
					
					$("#delete-new-event").unbind().click(function(){
										alert("Are you sure you want to delete.")		
//						if(tasks_count != null ){
//							
//							documemt.getElementById("taskgp_cnt").innerHTML = "Taskgroup having tasks.Are you sure you want to delete tasks and taskgroup";
//						}else{
//							
//							documemt.getElementById("taskgp_cnt").innerHTML = "Are you sure you want to delete this  taskgroup";
//
//						}
						
						document.getElementById("deletetaskgp")
						.submit();
					});
					$("#taskgroupid li")
							.unbind()
							.click(
									function() {

										var taskgroupvalue = $(this).attr('id');
										var taskgroupvalue_name = $(this)
												.text();
										var task_group_name = $(this).find('.taskgpname').text();										
										
										var task_count = $(this).find('.task_count').text();														
											
										document.getElementById("design").innerHTML = task_group_name;
												
										document.getElementById("taskgroupname").innerHTML = task_group_name;
										
										document.getElementById("taskgroupidhidden").innerHTML = task_group_name;
										document.getElementById("taskgroupId").innerHTML = taskgroupvalue;
										document.getElementById("taskgroupcnthidden").innerHTML = task_count;
										$
												.ajax({
													url : "taskgpbaseddetails",
													contentType : "application/json",
													mtype : "POST",
													data : {
														task_group_id : taskgroupvalue
													},
													dataType : 'json',
													async : false,
													success : function(data) {
														$('#taskdetailbody')
																.empty();
														var taskdetailstable = '';
														$
																.each(
																		data,
																		function(
																				index,
																				value) {
																			taskdetailstable = '<tr id="'
																					+ value.task_id
																					+ '" class="taskrow"><td id="task_id"><a href="#" >'
																					+ value.task_id
																					+ '</a></td><td id="task_type_name">'
																					+ value.task_type_name
																					+ '</td><td id="task_name">'
																					+ value.task_name
																					+ '</td><td id="task_desc">'
																					+ value.task_description
																					+ '</td><td id="size_code">'
																					+ value.task_size_code
																					+ '</td><td>In Progress </td><td >'
																					+ value.task_AssignedTo
																					+ '</td><td style="display: none;">'
																					+ value.task_signoff_criteria
																					+ '</td><td style="display: none;">'
																					+ value.task_group_id
																					+ '</td><td style="display: none;">'
																					+ value.task_type_id
																					+ '</td><td style="display: none;">'
																					+ value.date_begin
																					+ '</td><td style="display: none;">'
																					+ value.date_end
																					+ '</td><td style="display: none;">'
																					+ value.project_id
																					+ '</td><td style="display: none;">'
																					+ value.file_name
																					+ '</td></tr>';

																			$(
																					"tbody")
																					.append(
																							taskdetailstable);
																		});

													},
													error : function(jqXHR,
															textStatus,
															errorThrown) {

													}
												});
									});
					$("#edit_task")
							.click(
									function(e) {

										e.preventDefault();
										var task_id_val = $(this).attr('id');
										$("#taskid").val(task_id_val);

										var task_id = document
												.getElementById("task_Id").innerHTML;
										var tasktype = document
												.getElementById("task_type").innerHTML;
										var taskname = document
												.getElementById("task_type_name").innerHTML;
										var taskdesc = document
												.getElementById("task_type_description").innerHTML;
										var signoffcriteria = document
												.getElementById("sign_off").innerHTML;

										document.getElementById("tasktypeid").innerHTML = tasktype;
										//  document.getElementById("tasksize").innerHTML = size_code;

										var attachment = document
												.getElementById("attach").textContent;
                                       
										document.getElementById("new-event").innerHTML = attachment;
										$('#editTaskModal').modal('show');
										$("#task_id").val(task_id);
										$("#editname").val(taskname);
										$("#editmessage").val(taskdesc);
										$("#editmessage1").val(signoffcriteria);
										$("#task_type").val(tasktype);
									
									});

					$("#savetasks1").unbind().click(
							function() {

								var task_id = document
										.getElementById("task_id").value;
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
								var fullPath = document
								           .getElementById("new-event").value;
								
								
								
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
								
								//document.getElementById("edittaskdetails").submit();
								
							//	document.getElementById("edittaskdetails").submit();
								$("#edittaskdetails").submit();
						        
								
							});
					$("#viewtasks").on('click', '.taskrow', function(e) {
						var task_id_val = $(this).attr('id');
						var $td = $(this).closest('tr').children('td');
						var task_id = $td.eq(0).text();
						var redirecturl = "taskdetail?task_id=" + task_id;
						window.location.replace(redirecturl);
						
					});
					$(function dateselect() {
						$("#datepicker").datepicker();
					});
					
					function change() {
						var project_id = document.getElementById("project_id").value;
						var project_type = document.getElementById("projecttype").value;
						var project_name = document.getElementById("projectname").value;
						var description = document.getElementById("description").value;

						alert(project_id);
						alert(project_type);
						alert(project_name);
						alert(description);
						document.getElementById("savetaskdetail").submit();
					}
					
					
					
				});
