<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="java.util.*" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<h1>Display Items</h1>
	<ul>
		<%
			HttpSession sess = request.getSession();
			@SuppressWarnings("unchecked")
			Map<String, Integer> toPrint = (Map<String, Integer>) sess.getAttribute("map");
			System.out.println(toPrint);
			for (String key : toPrint.keySet()) {
				out.println("<li><a href=\"#\">" + key + ": $" + toPrint.get(key) + "</a></p></li>");
			}
		%>
	</ul>
</body>
</html>