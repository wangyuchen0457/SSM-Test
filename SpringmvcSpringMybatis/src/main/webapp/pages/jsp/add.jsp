<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>增加商店信息</title>
</head>
<body>
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
				<input type="text" id="ShopType" name="ShopType" value="" tabindex="3"/>
				<br/>
				<label for="ShopPassword">ShopPassword:</label>
				<input type="text" id="ShopPassword" name="ShopPassword" value="" tabindex="4"/>
				<br/>
				<label for="Note">Note:</label>
				<input type="text" id="Note" name="Note" value="" tabindex="5"/>
				<br/>
				<div id="buttons">
				<input id="reset" type="reset" tabindex="6"/>
				<input id="submit" type="submit" tabindex="7" value="Add Shop Info"/>
				</div>
			</fieldset>
		</form>
</body>
</html>