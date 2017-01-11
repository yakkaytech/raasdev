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
							$('#teamModal').modal('show');
						}
					});
					
					
					$("#save_team").unbind().click(function(e){
						
					alert("team");
						
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
								 
								 alert(team_id);
								
								
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
										alert("detailproposal");
										
										alert("hai");
										window.location.href="/raas/proposal/project_id"
										
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
												
												
											},
										});
										
										
									},
									
								});
							
							},
							
						});
						
					});
					
					
					
					
					
				});