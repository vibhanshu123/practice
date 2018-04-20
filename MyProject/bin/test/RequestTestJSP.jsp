<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Request testing tool</title>
</head>
<body>
<h1>
Hello
<% 

String name =request.getParameter("username");
out.println(name);


%>
</h1>
<%-- The following thing does the same work --%>
<h1>
hello <%=request.getParameter("username")%>
</h1>
</body>
</html>