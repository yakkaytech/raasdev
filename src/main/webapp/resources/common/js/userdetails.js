$(document).ready(function() {
	 $('#edit').click(function(e){ 
	 e.preventDefault();
	$("#editul").addClass('hide');
	$("#showul").removeClass('hide');
	$("#upload-button").removeClass('hide');
});
	 
$('#add').click(function(){
var $table = $('.table');
var $rows = $('tbody > tr', $table);
var skillvalue=document.getElementById('inskill').value;
var flag = false;
$("table tbody").find('tr').each(function (i) {
var  skills= $(this).find('td').find('input').eq(0).val();
    if (skills == skillvalue) {
        flag = true;
    }
})
		//appending data to  table
    
        if (skillvalue == "") {
            
            toastr["warning"]("Enter the skill")
           
        } else {
        	if (flag) {
   	    	 toastr["info"]("You have already this skill!")

   	       } else{
             var indis=('<tr class="item"><td class="col-md-3 text-center"><input type="text"  name="inputskill" id="inputskill" class="inputskill" value="'+skillvalue+'"/></td><td class="col-md-1 text-center"><input type="text" name="" list="option" id="inputyear" class="inputyear" value=""/><datalist id="option"><select> <c:forEach items="${yearexp}" var="rec"><option>${rec.yearexp}</option></c:forEach></select></datalist></td><td class="col-md-4 text-center"><input type="text" name="" list="options" id="inputexp"   class="inputexp" value=""/><datalist id="options"><select> <c:forEach items="${level}" var="rec"><option>${rec.explevel}</option></c:forEach></select></datalist></td><td class="col-md-4 text-center" id="delete"><a><i class="glyphicon glyphicon-remove"></i></a></td></tr>');				
			  $("#skill_body").append(indis);
			  enableAutoComplete($("[name^=inputskill]"));
   	      }
		}
    
});
$("#skilledit").click(function(){
	$("table tbody").find('tr').find('td').find('#inputyear').removeClass('hide');
	$("table tbody").find('tr').find('td').find('#inputexp').removeClass('hide');
	$("table tbody").find('tr').find('td').find('#yecodespan').addClass('hide');
	$("table tbody").find('tr').find('td').find('#elcodespan').addClass('hide');
});


$("#skill_body").on('click','#delete',function(e) {
			var user_id = document.getElementById('editul').getElementsByTagName("li")[0].innerHTML;
			
			var $td = $(this).closest('tr').children('td').find('input');

			var topskill = $td.eq(0).val();
			
			var experience = $td.eq(1).val();
			
			var level = $td.eq(2).val();
			var r = confirm("You want delete the skill!");
			if (r == true) {
		        txt = "You pressed OK!";
		        $(this).closest('tr').remove();
			       

			    } 
				
             });

	
	
   
	
	$('#save').click(function(e){ 
	
	var user_id = document.getElementById('editul').getElementsByTagName("li")[0].innerHTML;
	var file = $("#new-event")[0].files[0];
	var roleid = []; 
	var array=[];
	var fd=new FormData(document.getElementById("userdetails"));

	    
	$.ajax({
		url : "userupdate?user_id="+ user_id + "&file=" + file,
	    type : "POST",
		enctype : "multipart/form-data",
		contentType :"application/json;charset=utf-8",
		data :new FormData(document.getElementById("userdetails")),							
		datatype : 'json',
			processData : false,
			contentType : false,
			async : false,
			success : function(data) {
                    
                    
			},
			error : function(xhr,
					ajaxOptions,
					thrownError) {

				console.log(xhr.status);
				console.log(thrownError);

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
   
       
$("#skillsave")
	.click(
			function() {
                var user_id = document.getElementById('editul').getElementsByTagName("li")[0].innerHTML;
				var $table = $('.table');
				var $rows = $('tbody > tr', $table);
				var array = [];
				var headers = [];
				var flag = false;
				var flg=false;
				var length=$('table tbody tr').length;
				$("table tbody").find('tr').each(function (i) {
					var  skills= $(this).find('td').find('input').eq(0).val();
					var  exp= $(this).find('td').find('input').eq(1).val();
					var  level= $(this).find('td').find('input').eq(2).val();
					
			        if (skills == "") {
			            flag = true;
			        }else if(exp == ""){
			        	flag=true;
			        }else if(level == ""){
			        	flag=true;	
			        }
			    })
			    if (flag){
                         toastr["warning"]("Enter Years of Experience and Expertise Level !")
                     }else{ 
				          if(length > 5){
				        	  toastr["info"]("Allowed to enter only 5 skills!")
				          }
				       else{
					     $($rows).find('td input:text').each(function(index,item) {
                         headers[index] = $(item).attr("name");
									});
					        $($rows).has('td').each(function()
							{
						      var arrayItem = {};
						            $('td input',$(this)).each(function(index,item) {
                                     var skillval = $(item).val();
                                     arrayItem[headers[index]] = $(item).val();   
                                    });
                             array.push(arrayItem);
                        
							});
					       
                       
					
				   $.ajax({ url :
					 "saveskill?user_id="+ user_id,
					  type : "POST", contentType
					  :'application/json;charset=utf-8',
					  data :JSON.stringify(array),
					  dataType : 'json', async : false,
						  
						  success : function(data) {
						     
						  }
						  
						  });
				
                        }
				    
                      }
				});
      
  

}); 
   
