

$(document).ready(function() { 	
	
	var url = window.location.href;
	var pidTemp= url.split('?')[1].split('=')[1];
	$("input[name='pid']").val(pidTemp);
	//alert('url:'+ url+ ',param:'+ param);//param:  pid=3
	$.ajax({type:'get',url:'/passmanage/passinfo/selectpassinfodetail',data:{pid:pidTemp},success:function(data){
		$("input[name='cid']").val(data.cid);//存
		$("input[name='title']").val(data.title);
		$("input[name='account']").val(data.account);
		$("input[name='password']").val(data.password);
		$("input[name='url']").val(data.url);
		$("textarea").val(data.comment);
	}});
	
	

	$("#btn-save").hide();
	$("#btn-update").click(function(){
		$("#btn-save").toggle();
		$(this).toggle();
		
		$("form input,textarea").removeAttr("readonly").change(function(){
			$("input[name='changesign']").val('1');
		});
	});
	
	$("#btn-save").click(function(){
		$("#btn-update").toggle();
		$(this).toggle();
		
		$("form input,textarea").attr("readonly","readonly");
		
		if($("input[name='changesign']").val()== '0'){
			return false;
		}
		
		$.ajax(
			{	
				type:"post",
				url:"/passmanage/passinfo/updatepassinfo",
				data:{pid:$("input[name='pid']").val(),
					title:$("input[name='title']").val(),
					account:$("input[name='account']").val(),
					password:$("input[name='password']").val(),
					url:$("input[name='url']").val(),
					comment:$("textarea").val(),
					cid:$("input[name='cid']").val()},//取
					
				success:function(returnData){
					location.reload();
				}
		});
	});
	
	
	
	
	
	
	

});//End document ready functions




