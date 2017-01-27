/**
 * 
 */

$(document)
		.ready(
				function() {
					
					
					
					
				$("#create_proposal").unbind().on("click", "#crt_proposal",function(){
						
						var project_id = $(this).attr('value');
						
						var user_id = document
						.getElementById("user_id").value;
						
						if(user_id == null){
							
							window.location.href="/raas/login";
						}else{
							
							$
							.ajax({
								url : "validmember",
								contentType : "application/json",
								mtype : "POST",
								data : {
									user_id : user_id,
									project_id : project_id
								},
								dataType : 'json',
								async : false,
								success : function(
										data) {
									
									
									
									var user_id = data[0].user_id;
							  
									
									if(user_id != 0){
										
										alert("you are already a member");
									}else{
									
									$('#teamModal').modal('show');
									}
								},
							});
							
							
						}
					});
					
					
					$("#save_team").unbind().click(function(e){
						
						var team_name = document
						.getElementById("team_name").value;
						
						var rate = document
						.getElementById("rate").value;
						
						var project_id = document
						.getElementById("project_id").value;
						
						var user_id = document
						.getElementById("user_id").value;
						
						
						$
						.ajax({
							url : "team",
							contentType : "application/json",
							mtype : "POST",
							data : {
								team_name : team_name,
								rate : rate,
								project_id : project_id
							},
							dataType : 'json',
							async : false,
							success : function(
									data) {
								
								
								
								 team_id = data[0].team_id;
								 rate = data[0].rate;
								 
								
								$.ajax({
									url : "addmember",
									contentType : "application/json",
									mtype : "POST",
									data : {
										team_id : team_id,
										user_id : user_id,
										rate : rate,
										
									},
									dataType : 'json',
									async : false,
									success : function(
											data) {
										
										
										
										$.ajax({
											url : "detailproposal",
											contentType : "application/json",
											mtype : "POST",
											data : {
												
											    team_id : team_id,
												project_id : project_id
												
											},
											dataType : 'json',
											async : false,
											success : function(
													data) {
												
												
												$.ajax({
													url : "proposal",
													contentType : "application/json",
													mtype : "POST",
													data : {
														
													    team_id : team_id,
														project_id : project_id
														
													},
													dataType : 'json',
													async : false,
													success : function(
															data) {
														
														
														window.location.href = "/raas/proposal?project_id="+project_id;
														
													},
												
												});
												
												
											},
										});
										
										
									},
									
								});
							
							},
							
						});
						
					});
					
					
					
					
					
				});