<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Shopping List</title>
<link href="//netdna.bootstrapcdn.com/bootstrap/3.0.3/css/bootstrap.min.css" rel="stylesheet"></head>
<link rel="stylesheet" href="css/home.css" />
<body>
	<center id="title"><h1>Shopping List</h1></center><br><br>
	<div id="forms">
		<form id="addForm" action="AddItemRemoveItem" method="post">
			Item: <textarea rows="1" cols="20" name="item"></textarea>
			Price: <textarea rows="1" cols="20" name="price"></textarea><br><br>
			<center>
				<input class="btn btn-medium" name="buttonType" type="submit" value="+ Item" />
				<input class="btn btn-medium" name="buttonType" type="submit" value="Remove Item" />
			</center>
		</form><br>
		<form id="displayForm" action="DisplayItem">
			<center><input class="btn btn-medium" type="submit" value="Display Items" /></center>
		</form>
	</div>
</body>
</html>