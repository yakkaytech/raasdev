$(function () {
    /* wizard2*/
	
	var testvar;
	
    

	
    $("#form-wizard").steps({
        headerTag: "h3",
        bodyTag: "section",
        transitionEffect: "slideLeft",
        autoFocus: true
    });
    /*wizard2 end */
    /****  Inline Form Wizard with Validation  ****/
    $("topskillgroup")
        
    $("#wizard-validation").steps({
        headerTag: "h1",
        bodyTag: "section",
        transitionEffect: "slideLeft",
        onStepChanging: function (event, currentIndex, newIndex) {
        	  var form = $(this);
        	  var BriefSummary = $("textarea").val();
        	  var TagsInputValue = $("input").val();
        	  var Skillarray = $.map($('input[name="checkboxes"]:checked'), function(c){return c.value; });
        	 
        	  
        	  var CountryValue = $("#select2_Country option:selected").val();
        	  var StateZoneValue = $("#select2_StateZone option:selected").val();
        	  var TimeZone = $("#select2_TimeZone option:selected").val();
       
        	  var RateValue = $("#idRate").val();

        	  var HourValue = $("#select2_Hour option:selected").val();
        	  
        	  
        	 testvar = BriefSummary+" "+TagsInputValue+" "+ Skillarray+" "+CountryValue+" "+StateZoneValue+" "+TimeZone+" "+RateValue+" "+HourValue;
        	  
        	
       
        	  
            console.log('inside onstepchanging');
            // Always allow going backward even if the current step contains invalid fields!
            if (currentIndex > newIndex) {
                return true;
            }
            // Forbid suppressing "Warning" step if the user is to young
            if (newIndex === 3 && Number($("#age").val()) < 18) {
                return false;
            }
       
            // Clean up if user went backward before
            if (currentIndex < newIndex) {
                // To remove error styles
                $(".body:eq(" + newIndex + ") label.error", form).remove();
                $(".body:eq(" + newIndex + ") .error", form).removeClass("error");
            }
            // Disable validation on fields that are disabled or hidden.
            form.validate().settings.ignore = ":disabled,:hidden";
            
            // Start validation; Prevent going forward if false
            
            return form.valid();
        },
        onStepChanged: function (event, currentIndex, priorIndex) {
            // Suppress (skip) "Warning" step if the user is old enough.
            if (currentIndex === 2 && Number($("#age").val()) >= 18) {
                $(this).steps("next");
               
                
            }
            // Suppress (skip) "Warning" step if the user is old enough and wants to the previous step.
            if (currentIndex === 2 && priorIndex === 3) {
                $(this).steps("previous");
            }
        },
        onFinishing: function (event, currentIndex) {
            var form = $(this);
            // Disable validation on fields that are disabled.
            // At this point it's recommended to do an overall check (mean ignoring only disabled fields)
            form.validate().settings.ignore = ":disabled";

            // Start validation; Prevent form submission if false
            return form.valid();
        },
        onFinished: function (event, currentIndex) {
            var form = $(this).serializeArray();
           
            
            // Submit form input
          var SkillValue = JSON.stringify(form);
        
            $.ajax({
				url :"memberskill",
				contentType : "application/json",				
				mtype : "POST",
				data: form,			
				dataType : 'json',
				async : false,
				success : function(data) {
					alert("success");
				},
				error : function(jqXHR, textStatus, errorThrown) {
					alert(error);
				}
			});
           
            form.submit();
        }
    }).validate({
        errorPlacement: function (error, element) {
            element.before(error);
        },
        rules: {
            confirm: {
                equalTo: "#password"
            }
        }
    });
    $("select").select2();


});
