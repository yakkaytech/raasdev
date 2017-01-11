$(document).ready(function() {
	
	
	
	$("#openNewUserModal").click(function(){
		 $('#addMemberModal').modal('show');
	});

	$("#addmembers_save").click(function() {
		var project_id = document.getElementById("project_id").innerHTML;
		var role_id = document.getElementById("role_id").value;
		var jobname = document.getElementById("addjobname").value;
		var additional_desc = document.getElementById("addadditional_desc").value;
		var rate = document.getElementById("addrate").value;
		var rate_min = document.getElementById("addrate_min").value;
		var rate_max = document.getElementById("addrate_max").value;
		var frequency_code = document.getElementById("category_code").value;
		
		var hrs_per_occurrence = document.getElementById("addhours_per_occurrence").value;
		var ror_enddate = document.getElementById("datepicker").value;
		
		document.getElementById("save_addmembers").submit(); 
	});
	
	
	$("#save_and_publish").click(function() {
		
		var project_id = document.getElementById("project_id").innerHTML;
		var role_id = document.getElementById("role_id").value;
		var jobname = document.getElementById("addjobname").value;
		var additional_desc = document.getElementById("addadditional_desc").value;
		var rate = document.getElementById("addrate").value;
		var rate_min = document.getElementById("addrate_min").value;
		var rate_max = document.getElementById("addrate_max").value;
		var frequency_code = document.getElementById("category_code").value;
		var hrs_per_occurrence = document.getElementById("addhours_per_occurrence").value;
		var ror_enddate = document.getElementById("datepicker").value;
		
		$.ajax({
			url : "savepublish",
			contentType : "application/json",
			mtype : "GET",
			data : {
				project_id : project_id, 
				role_id : role_id,
				jobname : jobname,
				additional_desc : additional_desc,
				rate : rate,
				rate_min : rate_min,
				category_code : frequency_code,
				hours_per_occurrence : hrs_per_occurrence,
				ror_enddate : ror_enddate
			},
			dataType : "json",
			async : false,
			success : function(data) {
				
				
								window.location.href = "/raas/projectrole?project_id=" + project_id;
			},
		
	});
		
		
	});
	
	
	$("#role_member button").unbind().click(function(){
		
		var project_role_id = $(this).attr('id');
		var project_id = document.getElementById("project_id").innerHTML;    
	    var jobtype = document.getElementById('jobtype.".$row[' + this.id + ']."').innerHTML;    
		var jobname =  document.getElementById('jobname.".$row[' + this.id + ']."').innerHTML;
        var job_desc = document.getElementById('additional_desc.".$row[' + this.id + ']."').innerHTML;
	    var rate = document.getElementById('rate.".$row[' + this.id + ']."').innerHTML;
	    var rate_max= document.getElementById('rate_max.".$row[' + this.id + ']."').innerHTML;
	    var rate_min= document.getElementById('rate_min.".$row[' + this.id + ']."').innerHTML;
	    var frequency = document.getElementById('frequency.".$row[' + this.id + ']."').innerHTML;
	    var hrs_per_occurence= document.getElementById('hrs_per_occurrence.".$row[' + this.id + ']."').innerHTML;
	    var ror_end_date = document.getElementById('ror_end_date.".$row[' + this.id + ']."').innerHTML;
	   
	    
	    $("#editproject_role_id").val(project_role_id);
	    $("#editproject_id").val(project_id);
	    $("#editjobname").val(jobname);
	    $("#editadditional_desc").val(job_desc);
	    $("#editrate").val(rate);
	    $("#editrate_max").val(rate_max);
	    $("#editrate_min").val(rate_min);
	    $("#hours_per_occurrence").val(hrs_per_occurence);
	    $("#datepicker").val(ror_end_date);
				
		$('#editMemberModal').modal('show');
			
		
		});
	$("#addmembers_edit").click(function(){
		
		var jobtype = document.getElementById("role_id").value;
		var jobname = document.getElementById("editjobname").value;
	    var job_desc = document.getElementById("editadditional_desc").value;
	    var rate = document.getElementById("editrate").value;
	    var rate_max= document.getElementById("editrate_max").value;
	    var rate_min= document.getElementById("editrate_min").value;
	    var frequency_code = document.getElementById("category_code").value;
	    var hrs_per_occurence= document.getElementById("hours_per_occurrence").value;
	    var project_id = document.getElementById("project_id").innerHTML;
	    var project_role_id = document.getElementById("editproject_role_id").value;
	    
         $.ajax({
				url :"prjtrole_editmember",
				contentType : "application/json",				
				mtype : "POST",
				data: {
					project_id : project_id,
					project_role_id : project_role_id,
					jobname : jobname,
					role_id : jobtype,
					additional_desc : job_desc,
					rate : rate,
					rate_min : rate_min,
					rate_max : rate_max,
					category_code : frequency_code,
				//	hours_per_occurrence : hrs_per_occurence
				},			
				dataType : 'json',
				async : false,
				success : function(data) {
					window.location.href = "/raas/projectrole?project_id=" + project_id;
					
				},
				
			});
        
	});
	
	$("#addmembers_edit_and_publish").click(function(){
		
		var jobtype = document.getElementById("role_id").value;
		var jobname = document.getElementById("editjobname").value;
	    var job_desc = document.getElementById("editadditional_desc").value;
	    var rate = document.getElementById("editrate").value;
	    var rate_max= document.getElementById("editrate_max").value;
	    var rate_min= document.getElementById("editrate_min").value;
	    var frequency_code = document.getElementById("category_code").value;
	    var hrs_per_occurence= document.getElementById("hours_per_occurrence").value;
	    var project_id = document.getElementById("project_id").innerHTML;
	    var project_role_id = document.getElementById("editproject_role_id").value;
	    
         $.ajax({
				url :"prjtrole_edit_publishmember",
				contentType : "application/json",				
				mtype : "POST",
				data: {
					project_id : project_id,
					project_role_id : project_role_id,
					jobname : jobname,
					role_id : jobtype,
					additional_desc : job_desc,
					rate : rate,
					rate_min : rate_min,
					rate_max : rate_max,
					category_code : frequency_code,
			//		hours_per_occurrence : hrs_per_occurence
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