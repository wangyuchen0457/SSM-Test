$("#btUpdate").click(function() {
	var id = $('#id').text();
	var shopName = $('#shopName').val();
	var shopNo = $('#shopNo').val();
	var shopType = $('#shopType').val();
	var note = $('#note').val();
/*	
	if (isNull(username)) {
		showmsg("请输入门店编号");
		return false;
	}
	if (isNull(password)) {
		showmsg("请输入您的密码");
		return false;
	}
	//加密
	//password = $.md5(password);

	showLoadingDialog("登录中，请稍后...");
*/
	$.ajax({
		type : "POST",
		async : true,
		url : ctx + "/updateById.do",
		data : {
			"id" : id,
			"shopNo" : shopNo,
			"shopName" : shopName,
			"shopType" : shopType,
			"note" : note,
		},
		error : function() {
			alert("修改失败");
		},
		success : function(shopInfo) {
			alert("修改成功！");
			window.location.href=ctx + '/show.do';

		}
	});
});
