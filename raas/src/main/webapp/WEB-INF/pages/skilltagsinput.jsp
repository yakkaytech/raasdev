<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>

<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title> Welcome to New Member</title>

<script src="https://ajax.googleapis.com/ajax/libs/jquery/2.2.2/jquery.min.js"></script>

 
<link href="http://code.jquery.com/ui/1.10.4/themes/ui-lightness/jquery-ui.css"
	rel="stylesheet">
 
 
<spring:url value="/resources/common/vendors/wizard/jquery-steps/css/wizard.css" var="css2" />
<spring:url value="/resources/common/dummy/css/bootstrap-tagsinput.css" var="css1" />
<spring:url value="/resources/common/dummy/css/formelements.css" var="css7" />
<spring:url value="/resources/common/dummy/css/jquery.steps.css" var="css3" />
<spring:url value="/resources/common/dummy/js/wizard.css" var="css5" />
<spring:url value="/resources/common/css/pages/wizard.css" var="css11" />

<spring:url value="/resources/common/dummy/css/select2.min.css" var="css4" />	
<spring:url value="/resources/common/dummy/js/bootstrap-tagsinput.min.js" var="js1" />		
<spring:url value="/resources/common/dummy/css/bootstrap-slider.min.css" var="css8" />				
<spring:url value="/resources/common/dummy/js/form_wizard.js" var="js2" />	
<spring:url value="/resources/common/dummy/js/select2.min.js" var="js6" />	
<spring:url value="/resources/common/dummy/js/jquery.steps.js" var="js4" />
<spring:url value="/resources/common/dummy/js/jasny-bootstrap.js" var="js3" />	
<spring:url value="/resources/common/dummy/js/moment.min.js" var="js7" />
<spring:url value="/resources/common/css/bootstrap.min.css" var="css12" />	
<spring:url value="/resources/common/css/frontend/custom.css" var="css13" />
<spring:url value="/resources/common/dummy/js/jquery.validate.min.js" var="js5" />	

 

<spring:url value="/resources/common/vendors/gallery/fancy_box/jquery.fancybox.css" var="css14" />	
 <spring:url value="/resources/common/vendors/gallery/fancy_box/helpers/jquery.fancybox-buttons.css" var="css15" />
<spring:url value="/resources/common/vendors/gallery/fancy_box/helpers/jquery.fancybox-thumbs.css" var="css16" />	 		
<spring:url value="/resources/common/css/frontend/news.css" var="css17" />	 			
<spring:url value="/resources/common/vendors/font-awesome/css/font-awesome.min.css" var="css18" />	 		
<spring:url value="/resources/common/css/frontend/blog.css" var="css19" />	 		
<spring:url value="/resources/common/dummy/css/formscrollbar.css" var="css20" />

<spring:url value="/resources/common/vendors/selector/index.js" var="js8" />	
<spring:url value="/resources/common/vendors/selector/jquery.js" var="js9" />	
<spring:url value="/resources/common/vendors/selector/selectize.js" var="js10" />	
<spring:url value="/resources/common/vendors/selector/es5.js" var="js11" />
<spring:url value="/resources/common/vendors/selector/normalize.css" var="css21" />
<spring:url value="/resources/common/vendors/selector/stylesheet.css" var="css22" />

<link href="${css2}" rel="stylesheet">
<link href="${css1}" rel="stylesheet">
<link href="${css7}" rel="stylesheet">
<link href="${css3}" rel="stylesheet">
<link href="${css5}" rel="stylesheet">
<link href="${css11}" rel="stylesheet">
<link href="${css4}" rel="stylesheet">
<link href="${css12}" rel="stylesheet">
<link href="${css13}" rel="stylesheet">
<link href="${css14}" rel="stylesheet">
<link href="${css15}" rel="stylesheet">
<link href="${css16}" rel="stylesheet">
<link href="${css17}" rel="stylesheet">
<link href="${css18}" rel="stylesheet">
<link href="${css19}" rel="stylesheet">
<link href="${css20}" rel="stylesheet">
<link href="${css21}" rel="stylesheet">
<link href="${css22}" rel="stylesheet">
<script src="${js1}"></script>
<link href="${css8}" rel="stylesheet">

<script src="${js2}"></script>
<script src="${js6}"></script>
<script src="${js4}"></script>
<script src="${js3}"></script>
<script src="${js7}"></script>
<script src="${js5}"></script>
<script src="${js8}"></script>
<script src="${js9}"></script>
<script src="${js10}"></script>
<Script>
$(document).ready(function () {
    $('#defaultForm')
        .find('[name="cities"]')
    // Revalidate the color when it is changed
    .change(function (e) {
        console.warn($('[name="cities"]').val());
        console.info($('#aa').val());
        console.info($("#aa").tagsinput('items'));
        var a = $("#aa").tagsinput('items');
        console.log(typeof (a));
        console.log(a.length);
        $('#defaultForm').bootstrapValidator('revalidateField', 'cities');
    })
        .end()
        .find('[name="cities1"]')
    // Revalidate the color when it is changed
    .change(function (e) {
        console.warn($('[name="cities1"]').val());
        console.info($('#aa1').val());
        console.info($("#aa1").tagsinput('items'));
        var a = $("#aa1").tagsinput('items');
        console.log(typeof (a));
        console.log(a.length);
        $('#defaultForm').bootstrapValidator('revalidateField', 'cities1');
    })
        .end()
        .bootstrapValidator({
        excluded: ':disabled',
        feedbackIcons: {
            valid: 'glyphicon glyphicon-ok',
            invalid: 'glyphicon glyphicon-remove',
            validating: 'glyphicon glyphicon-refresh'
        },
        fields: {
            cities: {
                validators: {
                    notEmpty: {
                        message: 'Please enter at least one city you like the most'
                    }
                }
            },
            cities1: {
                validators: {
                    callback: {
                        message: 'Please choose 2-4 color you like most',
                        callback: function (value, validator) {
                            // Get the selected options
                            var options = validator.getFieldElements('cities1').tagsinput('items');
                            // console.info(options);
                            return (options !== null && options.length >= 2 && options.length <= 4);
                        }
                    }
                }
            }
        }
    })
        .on('success.form.bv', function (e) {
        // Prevent form submission
        e.preventDefault();
    });
});
</Script>

<script>


</script>
<body>
<form id="wizard-validation1">
							
                                <h1 class="hidden-xs">What do you do? - Experience & Skillset</h1>
                               <section>
                                    <h2 class="hidden">&nbsp;</h2>
                                 
									<div class="form-group">
                                        <label for="description">Breif summary of your education & experience </label> 
                                        <textarea class="form-control" rows="4" id="Breif_education" name="Breif_education" placeholder="Breif summary of your education & experience" ></textarea>
                                     </div>
                                      <label for="Skillset">Enter Top 10 Skills</label> 
                                     <div class="form-group" id="bootstrapTagsInputForm" >
                                       <input type="text" class="form-control" name="topskill" id="input-tags" value="JSP,PHP,JAVA,MYSQL" placeholder="Enter one skill" />
                                     
                                    </div>
                                    <form id="defaultForm" method="post" class="form-horizontal">
    <div class="form-group">
        <label class="col-lg-3 control-label">Cities</label>
        <div class="col-lg-5">
            <input type="text" name="cities" id="aa" class="form-control" value="Amsterdam,Washington,Sydney,Beijing,Cairo" data-role="tagsinput" />
        </div>
    </div>
    <div class="form-group">
        <label class="col-lg-3 control-label">Cities 1</label>
        <div class="col-lg-5">
            <input type="text" name="cities1" id="aa1" class="form-control" value="Amsterdam1,Washington1,Sydney1,Beijing1,Cairo1" data-role="tagsinput" />
        </div>
    </div>
    <div class="form-group">
        <div class="col-lg-5 col-lg-offset-3">
            <button type="submit" class="btn btn-default">Validate</button>
        </div>
    </div>
</form>
                                </section>    
 </form> 
 <div id="wrapper">
			<h1>Selectize.js</h1>

			<div class="demo">
				<h2>Confirm Delete</h2>
				<div class="control-group">
					<label for="input-tags">Tags:</label>
					<input type="text" id="input-tags" class="demo-default" value="awesome,neat,yeah">
				</div>
				<script>
				$('#input-tags').selectize({
				    persist: false,
				    createOnBlur: true,
				    create: true
				});
				</script>
			</div>
		</div>                                  
</body>
</html>