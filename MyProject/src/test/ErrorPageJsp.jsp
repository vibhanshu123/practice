<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@page isErrorPage="true"%> 
<%@page session="true"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h1>The following error occured</h1>
<b1>
<!-- Since the iserror page is set true we can use the implicit JSP OBJECT esception-->

<%out.print(exception) ;%>
</b1>
</body>
</html>