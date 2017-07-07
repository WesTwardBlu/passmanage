

$(document).ready(function() { 	

	/*$.ajax({type:'post',url:'/passmanage/passinfo/selectpassinfo',success:function(data){
		$.each(data,function(index,obj){
			var txt1="<tr class='gradeA'><td>"+obj.title + "</td><td>"+ obj.account+ "</td><td>"
				+obj.password+"</td><td><input type='hidden' value='"+ obj.pid+ "' /></td></tr>";    // 以 HTML 创建新元素
			$("tbody").prepend(txt1);         // 追加新元素
		});
	}});*/
	/*var url = window.location.href;
	var param= url.split('?')[1].split('=')[1];
	//alert('url:'+ url+ ',param:'+ param);//param:  pid=3
	$.ajax({type:'get',url:'/passmanage/passinfo/selectpassinfodetail',data:{pid:param},success:function(data){
		$("input[name='title']").val(data.title);
		$("input[name='account']").val(data.account);
		$("input[name='password']").val(data.password);
		$("input[name='url']").val(data.url);
		$("textarea").val(data.comment);
	}});*/
	
	/*$('#btn-regist').click(function(){
		$("#registform").submit();
	});*/
	
	$("#btn-save").click(function(){
		$.ajax({type:"post",
			url:"/passmanage/passinfo/insertpassinfo",
			data:{cid:$("select").val(),title:$("input[name='title']").val(),account:$("input[name='account']").val(),
				password:$("input[name='password']").val(),url:$("input[name='url']").val(),comment:$("textarea").val()},
			/*data:{cid:'3',title:'tencent',account:'8989',
				password:'090000',url:'www.tencentgame.com',comment:'tencentGame'},*/
			success:function(data){
				//alert(data);
				location.href= "/passmanage/addform.html";
		}});
	});

});//End document ready functions




