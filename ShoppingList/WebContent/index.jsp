<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Shopping List</title>
</head>
<body>
	<div id="forms">
		<form id="addForm" action="AddItem" method="post">
			Item: <textarea rows="1" cols="20" name="item"></textarea>
			Price: <textarea rows="1" cols="20" name="price"></textarea>
			<input type="submit" value="+ Item" />
		</form>
		<form id="displayForm" action="DisplayItem">
			<input type="submit" value="Display Items" />
		</form>
	</div>
</body>
</html>