<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>增加商店信息</title>
</head>
<body>
	<script src="pages/script/myValidate.js"></script>
	<script src="pages/script/validator.js"></script>
<form action="/SpringmvcSpringMybatis/add.do" method="post">
			<fieldset>
				<legend>Add a shop info</legend>
				<label for="shopName">Shop Name:</label>
				<input type="text" id="shopName" name="shopName" value="" tabindex="1"/>
				<br/>
				<label for="shopNo">Shop No:</label>
				<input type="text" id="shopNo" name="shopNo" value="" tabindex="2"/>
				<br/>
				<label for="ShopType">ShopType:</label>
				<input type="text" id="shopType" name="shopType" value="" tabindex="3"/>
				<br/>
				<label for="Note">Note:</label>
				<input type="text" id="Note" name="Note" value="" tabindex="4"/>
				<br/>
				<div id="buttons">
				<input id="reset" type="reset" tabindex="5"/>
				<input id="submit" type="submit" tabindex="6" value="Add Shop Info"/>
				</div>
			</fieldset>
		</form>
</body>
</html>