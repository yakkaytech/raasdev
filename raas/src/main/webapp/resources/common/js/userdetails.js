$(document).ready(function() {
	//$('#profile-pic').load(document.URL+'#profile-pic');
	//$( "#upload-button" ).load(window.location.href +"#upload-button");
	//$('div#upload-button').load('http://somewhere.com #newContent');
	//$("#container").load(location.href+"#container");
	
	
	$('#edit').click(function(e){ 
		 e.preventDefault();
		 alert("edit");
		var text1 = document.getElementById('editul').getElementsByTagName("li")[0].innerHTML;
		var text2 = document.getElementById('editul').getElementsByTagName("li")[1].innerHTML;
		var text3 = document.getElementById('editul').getElementsByTagName("li")[2].innerHTML;
		var text4 = document.getElementById('editul').getElementsByTagName("li")[3].innerHTML;
		$("#editul").addClass('hide');
		$("#showul").removeClass('hide');
		$("#upload-button").removeClass('hide');
		//$('#editTaskModal').modal('show');
		
		
});
	 
	
	var skillSid = 1;
	$('#add').click(function(e){
		enableAutoComplete($("[name^=inputskill]:last"));
		var skillvalue=document.getElementById('inskill').value;alert(skillvalue);
        if(skillvalue == ""){
        	$("#inskill").addClass('has-error');
		}else if(skillvalue != ""){
		
			 var indis=('<tr class="item"><td class="col-md-3 text-center"><input type="text"  name="inputskill" id="inputskill" class="inputskill" value="'+skillvalue+'"/></td><td class="col-md-1 text-center"><input type="text" name="" list="option" id="inputyear" class="inputyear" value=""/><datalist id="option"><select> <c:forEach items="${yearexp}" var="rec"><option>${rec.yearexp}</option></c:forEach></select></datalist></td><td class="col-md-4 text-center"><input type="text" name="" list="options" id="inputexp"   class="inputexp" value=""/><datalist id="options"><select> <c:forEach items="${level}" var="rec"><option>${rec.explevel}</option></c:forEach></select></datalist></td><td class="col-md-4 text-center" id="delete"><a><i class="glyphicon glyphicon-remove"></i></a></td></tr>');				$("#skill_body").append(indis);
		}
			/*if(skillvalue == ""){
  		toastr.warning('Enter skill in the Textbox.Then click Add button')
 	}else if(skillvalue != ""){
 		//alert("not equal null");
 		var skillvalue=document.getElementById('inputskill').value;alert(skillvalue);
 		
 		var div = document.getElementById("topskillgroup");
	    var spans =document.getElementsByTagName("span");
	    
	   

	    for(var i=0;i<spans.length;i++)
	    {
	      var text=spans[i].innerText;
	    
	      
	     
          if(text == skillvalue){
        	  $('#inputskill').val("");
	    	 return toastr.warning('Allready You have ' +skillvalue+ ' skill')
	    	 
	    	  
	         }
		}
	    $('#inputskill').val("");
    	return $('<span class="tag label label-info" id="'+ (skillSid++) +'" value="'+skillvalue+'">'+skillvalue+'<span data-role="remove"></span></span>').appendTo('#topskillgroup'); 
        
  	    }*/
  	});
	$("#skilledit").click(function(){
		$("table tbody").find('tr').find('td').find('input').removeClass('hide');
		$("table tbody").find('tr').find('td').find('span').addClass('hide');
	});
	$('#topskillgroup').delegate('span.tag', 'click', function() {
	    //alert($(this).html());
	    var text = $(this).attr('value');alert(text);
	     $(this).remove();
	  });
	
	$("#skill_body")
	.on(
			'click',
			'#delete',
			function(e) {
				var user_id = document.getElementById(
						'editul').getElementsByTagName(
						"li")[0].innerHTML;
				alert(user_id);
				var $td = $(this).closest('tr').children('td').find('input');

				var skill = $td.eq(0).val();
				alert(skill);
				var experience = $td.eq(1).val();
				alert(experience);
				var level = $td.eq(2).val();
				alert(level);
				$(this).closest('tr').remove();

				$
						.ajax({
							url : "deleteskill?user_id="
									+ user_id,
							type : "POST",
							contentType : 'application/json;charset=utf-8',
							data : {
								inputskill : skill,
								
							},
							dataType : 'json',
							async : false,

							success : function(data) {
								alert(data);

							}

						});

			});

	
	
    $("#skillsave").click(function(){
		
//    	var table = $("table tbody");
//          table.find('tr').each(function (i) {
//   	         var  skillvalue = $(this).find('td').find('input').eq(0).val();alert(skillvalue);
//   	         var experience=$(this).find('td').find('input').eq(1).val();alert(experience);
//    	     var level=$(this).find('td').find('input').eq(2).val();alert(level);
//    	     $.ajax({
//    	    	  
//    	     });
//           }); 
    	
    	var array = [];
        var headers = [];
        $('.table th').each(function(index, item) {
            headers[index] = $(item).html();
        });
        $('.table tr').has('td input').each(function() {
            var arrayItem = {};
            $('td input', $(this)).each(function(index, item) {
                arrayItem[headers[index]] = $(item).val();
            });
            array.push(arrayItem);
        });
        
        var dt=JSON.stringify(array);
         alert(dt);  
         
     });

	
	$('#save').click(function(e){ 
		
		var file = $("#new-event")[0].files[0];
		alert("file name"+file.name);
		
		$.ajax({
			url : "userupdate?user_id="+ user_id + "&file=" + file,
		    type : "POST",
			enctype : "multipart/form-data",
			contentType :"application/json;charset=utf-8",
			data :new FormData(
					document
					.getElementById("userdetails")),								
			datatype : 'json',
			processData : false,
			contentType : false,
			async : false,
			success : function(data) {
                     alert("success");
                    
			},
			error : function(xhr,
					ajaxOptions,
					thrownError) {

				console.log(xhr.status);
				console
						.log(thrownError);

			}

		});
		
});
    
	 
    var readURL = function(input) {
        if (input.files && input.files[0]) {
            var reader = new FileReader();

            reader.onload = function (e) {
                $('.profile-pic').attr('src', e.target.result);
            }
    
            reader.readAsDataURL(input.files[0]);
        }
    }
    

    $(".file-upload").on('change', function(){
        readURL(this);
        
    });
    
    $("#upload-button").on('click', function() {
       $(".file-upload").click();
    });
    
    $("[name^=inputskill]").each(function(index) {
        enableAutoComplete($(this));
      });
    

    function enableAutoComplete($element) {
    	$element.autocomplete({    
            source : function(request, response) {
                $.ajax({
                        url : "getskills",
                        type : "POST",
                        data : {
                                term : request.term
                        },
                        dataType : "json",
                        success : function(data) {
                                response(data);
                               
                          }
                });
            }
          });
    }
      $("#inskill").autocomplete({ 
    	autoFocus: true,
        scroll: true,  
        source : function(request, response) {
        $.ajax({
                url : "getskills",
                type : "POST",
                data : {
                        term : request.term
                },
                dataType : "json",
                success : function(data) {
                        response(data);
                       
                  }
        });
    }
    });
   
      if (window.webshims) {
    	    webshims.setOptions('forms', {
    	        customDatalist: true
    	    });
    	    webshims.polyfill('forms');
    	}   
      
        
      $("#skillsave")
		.click(
				function() {
					alert("skillsave");
					var table = $("table tbody");
					table.find('tr').each(function(i) {
						// var skillvalue =
						// $(this).find('td').find('input').eq(0).val();alert(skillvalue);
						// var
						// experience=$(this).find('td').find('input').eq(1).val();alert(experience);
						// var
						// level=$(this).find('td').find('input').eq(2).val();alert(level);

					});

					var $table = $('.table');
					var $rows = $('tbody > tr', $table);
					var user_id = document.getElementById(
							'editul').getElementsByTagName(
							"li")[0].innerHTML;
					
					
					var array = [];
					var headers = [];
					
						$($rows)
								.find('td input:text')
								.each(
										function(index,
												item) {

											headers[index] = $(
													item)
													.attr(
															"name");
										});
						$($rows)
								.has('td input')
								.each(
										function() {
											var arrayItem = {};
											$('td input',
													$(this))
													.each(
															function(
																	index,
																	item) {

																var skillval = $(
																		item)
																		.val();
																arrayItem[headers[index]] = $(
																		item)
																		.val();
															});

											array
													.push(arrayItem);
										});

						alert(JSON.stringify(array
								.reverse()));
						
						 $.ajax({ url :
						 "saveskill?user_id="+ user_id,
						  type : "POST", contentType
						  :'application/json;charset=utf-8',
						  data :JSON.stringify(array),
						  dataType : 'json', async : false,
						  
						  success : function(data) {
						  alert(data);
						  }
						  
						  });
				

					

				});
      
  

}); 
   
