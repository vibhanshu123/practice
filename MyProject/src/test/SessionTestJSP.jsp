<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>SESSION TEST JSP</title>
</head>
<body>
<H1>
<%
String name=request.getParameter("userName");
session.setAttribute("user",name);

%>

Welcome <%=name %>
</H1>

</body>
</html>