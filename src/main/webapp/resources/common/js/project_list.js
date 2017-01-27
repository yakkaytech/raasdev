$(document).ready(function() {

		$("#viewprojects").unbind().on('click', '.taskrow', function(e) {

			var project_id = $(this).attr('id');

			var $td = $(this).closest('tr').children('td');
			var project_id = $td.eq(0).text();
			$.post("projectlist", {
				"project_id" : $("#proid").val()
			})
			var redirecturl = "projectboard?project_id=" + project_id;
			window.location.replace(redirecturl);


		});
	});