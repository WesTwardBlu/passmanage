
$(document).ready(function(){
	
	$('.data-table').dataTable({
		"bJQueryUI": true,
		"sPaginationType": "full_numbers",
		"sDom": '<""l>t<"F"fp>'
	});
	
	$("span.icon input:checkbox, th input:checkbox").click(function() {
		var checkedStatus = this.checked;
		var checkbox = $(this).parents('.widget-box').find('tr td:first-child input:checkbox');		
		checkbox.each(function() {
			this.checked = checkedStatus;
			if (checkedStatus == this.checked) {
				$(this).closest('.checker > span').removeClass('checked');
			}
			if (this.checked) {
				$(this).closest('.checker > span').addClass('checked');
			}
		});
	});	
	
	
	$.ajax({type:'post',url:'/passmanage/passinfo/selectpassinfo',success:function(data){
		$.each(data,function(index,obj){
			var txt1="<tr class='gradeA'><td>"+obj.title + "</td><td>"+ obj.account+ "</td><td>"
				+obj.password+"</td><td><input name='pid' type='hidden' value='"+ obj.pid+ "' /><input name='cid' type='hidden' value='"+ obj.cid+ "' /></td></tr>";    // 以 HTML 创建新元素
//			var txt2=$("<p></p>").text("Text.");   // 以 jQuery 创建新元素
//			var txt3=document.createElement("p");  // 以 DOM 创建新元素
//			txt3.innerHTML="Text.";
			$("tbody").prepend(txt1);         // 追加新元素
		});
	}});
	
	//给行tr增加点击事件
	$("tbody").on('click','tr.gradeA',function(){
			//alert('haha'+ $(this).find('input').val());
			location.href='/passmanage/index-detail.html?pid='+ $(this).find('input[name="pid"]').val();
	});
});
