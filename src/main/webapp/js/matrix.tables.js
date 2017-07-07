
$(document).ready(function(){
	
	$('.data-table').dataTable({
		"bJQueryUI": true,
		"sPaginationType": "full_numbers",
		"sDom": '<""l>t<"F"fp>'
	});
	
	$('input[type=checkbox],input[type=radio],input[type=file]').uniform();
	
	$('select').select2();
	
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
	
	$.ajax({type:'post',url:'/passmanage/passinfo/selectpassinfobycid',data:{cid:3},success:function(data){
		$.each(data,function(index,obj){
			var txt1="<tr class='gradeA'><td>"+obj.title + "</td><td>"+ obj.account+ "</td><td>"
				+obj.password+"</td><td><input type='hidden' value='"+ obj.pid+ "' /></td></tr>";    // 以 HTML 创建新元素
//			var txt2=$("<p></p>").text("Text.");   // 以 jQuery 创建新元素
//			var txt3=document.createElement("p");  // 以 DOM 创建新元素
//			txt3.innerHTML="Text.";
			$("tbody").prepend(txt1);         // 追加新元素
		});
	}});
	
	/*$("tbody tr").each(function(){
		$(this).click(function(){
			alert('haha');
		});
	});*/
	$("tbody").on('click','tr.gradeA',function(){
			//alert('haha'+ $(this).find('input').val());
			location.href='/passmanage/tables-detail.html?pid='+ $(this).find('input').val();
	});
});
