
$(document).ready(function(){

	var login = $('#loginform');
	var recover = $('#recoverform');
	var speed = 400;

	$('#to-recover').click(function(){
		
		$("#loginform").slideUp();
		$("#recoverform").fadeIn();
	});
	$('#to-login').click(function(){
		
		$("#recoverform").hide();
		$("#loginform").fadeIn();
	});
	$('#to-login2').click(function(){
		
		$("#registform").slideUp();
		$("#loginform").fadeIn();
	});
	$('#to-regist').click(function(){
		
		$("#loginform").slideUp();
		$("#registform").fadeIn();
	});
	$('#btn-login').click(function(){
		/*$.post("http://localhost:8091/passmanage/users/login",
		 {
			 username:$('#username').val(),password:$('#password').val()
		 });*/
		$("#loginform").submit();
	});
	$('#btn-regist').click(function(){
		$("#registform").submit();
	});
	
	
	
	/*$('#to-login').click(function(){
	
	});*/
    
    if($.browser.msie == true && $.browser.version.slice(0,3) < 10) {
        $('input[placeholder]').each(function(){ 
       
        var input = $(this);       
       
        $(input).val(input.attr('placeholder'));
               
        $(input).focus(function(){
             if (input.val() == input.attr('placeholder')) {
                 input.val('');
             }
        });
       
        $(input).blur(function(){
            if (input.val() == '' || input.val() == input.attr('placeholder')) {
                input.val(input.attr('placeholder'));
            }
        });
    });

        
        
    }
});