/**
 * 
 */

$(document).ready(function() {
		$("#subscribed").attr("disabled", true);
		$("#sub").attr("disabled", true);
		$("#sub1").attr("disabled", true);
		$("#cfmPassword").keyup(function() {
			var password = $("#password").val();
			var confirmPassword = $("#cfmPassword").val();
			if (password != confirmPassword) {
				$("#cfmPassword").css("background-color", "red");
			} else if (password == confirmPassword) {

				$("#cfmPassword").css("background-color", "white");
				$("#subscribed").removeAttr("disabled");

			}
		});

		$('#subscribed').change(function() {
			$("#sub").removeAttr("disabled");
			$("#sub1").removeAttr("disabled");
			
		});

		
		$("#email").focusout(function() {	
			if (!validateEmail($("#email").val())) {
				$("#email").css('border-color', 'red');				
	        }
	        else {	           
	            $("#email").css('border-color', '#E6E6E6');
	        }			
			});
	});
	
	function validateEmail(sEmail) {
	    var filter = /^([\w-\.]+)@((\[[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\.)|(([\w-]+\.)+))([a-zA-Z]{2,4}|[0-9]{1,3})(\]?)$/;
	    if (filter.test(sEmail)) {
	        return true;
	    }
	    else {
	        return false;
	    }
	}