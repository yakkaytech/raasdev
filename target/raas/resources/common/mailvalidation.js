/**
 * 
 */

$(document).ready(function() {
	
	$("#username").focusout(function() {	
		if (!ValidateEmail($("#username").val())) {
			$("#username").css('border-color', 'red');
			
        }
        else {
           
            $("#username").css('border-color', '#E6E6E6');
        }			
		});
	function ValidateEmail(email) {
		var expr = /^([\w-\.]+)@((\[[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\.)|(([\w-]+\.)+))([a-zA-Z]{2,4}|[0-9]{1,3})(\]?)$/;
        return expr.test(email);
    };
    
	
});