<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>IncludeTest</title>
</head>
<body>
<%@ include file="header.html" %>
<%@ include file="IncludeMe.jsp" %>
<CENTER>
<h1>hello <%=name %></h1>
<br>this page uses a static header,footer and a jsp</br>
</CENTER>
<%
for(int i=0;i<10;i++){
	out.print("<br>");
}
%>

<%@ include file="footer.html" %>
</body>
</html>