<<<<<<< HEAD
=======
/**
 * 
 */

>>>>>>> raasmain

$(document).ready(function() {
		
		$("#select2_Country").change(function() {						
			var dropvalue = $("#select2_Country").val();		
			$.ajax({
				url : "dropcountry",
				contentType : "application/json",
				mtype : "POST",
				data : {
					dropstate : dropvalue
				},
				dataType : 'json',
				async : false,
				success : function(data) {										
					$('#select2_StateZone').empty();
					$.each(data, function(index, value) {

						$("#select2_StateZone").append($("<option>", {
							value : value.state_id,
							text : value.state_name
						}));
					});
				},
				error : function(jqXHR, textStatus, errorThrown) {
					alert(error);
				}
			});

		});
	});
