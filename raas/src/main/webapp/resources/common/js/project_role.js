$(document).ready(function() {
	
	
	
	$("#openNewUserModal").click(function(){
		
		var project_id = document.getElementById("project_id").innerHTML;
		 $("#project_id").val(project_id);
		 $('#addMemberModal').modal('show');
	});
	
	

	$("#addmembers_save").click(function() {
		
		var project_id = document.getElementById("project_id").innerHTML;
		alert(project_id);
		var role_id = document.getElementById("role_id").value;
		alert(role_id);
		var jobname = document.getElementById("addjobname").value;
		alert(jobname);
		var additional_desc = document.getElementById("addadditional_desc").value;
		alert(additional_desc);
		var rate = document.getElementById("addrate").value;
		alert(rate);
		var rate_min = document.getElementById("addrate_min").value;
		alert(rate_min);
		var rate_max = document.getElementById("addrate_max").value;
		alert(rate_max);
		var frequency_code = document.getElementById("category_code").value;
		alert(frequency_code);
		var hrs_per_occurrence = document.getElementById("addhours_per_occurrence").value;
		alert(hrs_per_occurrence);
		var ror_enddate = document.getElementById("datepicker").value;
		alert(ror_enddate);
		$.ajax({
				url :"prjtrole_addmember",
				contentType : "application/json",				
				mtype : "POST",
			
				data:JSON.stringify ({ 'project_id' : project_id,
					'role_id' : role_id,
					'name' : jobname,
					'rate' : rate,
					'rate_min' : rate_min,
					'rate_max' : rate_max,
					'frequency_code' : frequency_code,
					'hours_per_occurrence' : hrs_per_occurrence,
					'ror_end_date' : ror_enddate
				}),			
				dataType : 'json',
				async : false,
				success : function(data) {
					alert(project_id);
					window.location.href = "/raas/projectrole?project_id=" + project_id;
				},
				
			});
		
	});
	
	
	
	$("#editNewUserModal").click(function(){
		
		var project_id = document.getElementById("project_id").innerHTML;
		var jobname = document.getElementById("jobname").innerHTML;
	    var job_desc = document.getElementById("additional_desc").innerHTML;
	    var rate = document.getElementById("rate").innerHTML;
	    var rate_max= document.getElementById("rate_max").innerHTML;
	    var rate_min= document.getElementById("rate_min").innerHTML;
	    var frequency = document.getElementById("frequency").innerHTML;
	    var hrs_per_occurence= document.getElementById("hrs_per_occurrence").value;
	    alert(hrs_per_occurence);
	    var ror_end_date = document.getElementById("ror_end_date").innerHTML;
	    
	    
	    $('#editMemberModal').modal('show');
	   
		
	});
	
	$("#addmembers_edit").click(function(){
		
		var jobtype = document.getElementById("role_id").value;
		var jobname = document.getElementById("editjobname").value;
	    var job_desc = document.getElementById("editadditional_desc").value;
	    var rate = document.getElementById("editrate").value;
	    var rate_max= document.getElementById("editrate_max").value;
	    var rate_min= document.getElementById("editrate_min").value;
	    var frequency = document.getElementById("category_code").value;
	    var hrs_per_occurence= document.getElementById("hours_per_occurrence").value;
	    var project_id = document.getElementById("project_id").innerHTML;
	   
         $.ajax({
				url :"prjtrole_editmember",
				contentType : "application/json",				
				mtype : "POST",
				data: {
					project_id : project_id,
					jobname : jobname,
					role_id : jobtype,
					additional_desc : job_desc,
					rate : rate,
					rate_min : rate_min,
					rate_max : rate_max,
				},			
				dataType : 'json',
				async : false,
				success : function(data) {
					
					window.location.href = "/raas/projectrole?project_id=" + project_id;
					
				},
				
			});
        
	});
	
	
	$(function dateselect() {
		$("#datepicker").datepicker();
	});

});