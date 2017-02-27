//��ʼ������
$(document).ready(function() {
	var username = getLocalStorage("username");
	if (!isNull(username)) {
		$('#username').val(username);
	}
});

//��¼
$("#btnLogin").click(function() {
	var username = $('#username').val();
	var password = $('#password').val();
	if (isNull(username)) {
		showmsg("�������ŵ���");
		return false;
	}
	if (isNull(password)) {
		showmsg("��������������");
		return false;
	}
	//����
	//password = $.md5(password);

	showLoadingDialog("��¼�У����Ժ�...");

	$.ajax({
		type : "POST",
		async : true,
		url : ctx + "/login.do",
		data : {
			"shopNo" : username,
			"password" : password
		},
		error : function() {
			hideLoadingDialog();
			showmsg("��¼�쳣");
		},
		success : function(res) {
			hideLoadingDialog();
			if (!isNull(res)) {
				//console.log(res.shopNo);
				//console.log(res);
				clearLocalStorage();
				setLocalStorage("username", res.shopNo);//���ڼ�ס�û����������
				setLocalStorage("shopNo", res.shopNo);
				setLocalStorage("shopId", res.id);
				setLocalStorage("shopInfo", JSON.stringify(res));

				showmsg("��ϲ�㣬��¼�ɹ���");

			} else {
				showmsg("�û������������");
			}
		}
	});
});
