/**
 * 
 */

$(document)
		.ready(
				function() {
    $('table').find('tr').each(function(){
    	
    	
		var $td= $(this).closest('tr').children('td');
         var val= $td.eq(3).attr('value');
         
         
         if(val == 4){
        	 $td.eq(3).addClass('glyphicon glyphicon-arrow-up');
         }else if(val == 5){
        	 $td.eq(3).addClass('glyphicon glyphicon-arrow-down');
        	 
         } else if(val == 6)  {
        	 $td.eq(3).addClass('glyphicon glyphicon-arrow-right');
        	 
         }else{
        	 $td.eq(3).addClass('glyphicon glyphicon-arrow-left');
         }   
    });
    	
    });