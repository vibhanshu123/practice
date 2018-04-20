<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>handling forward</title>
</head>
<body>
<br>welcome to our page!<br>
<%if ((request.getParameter("userName")==null)||(request.getParameter("userName")).length()==0){ 
%>
<jsp:forward page="HelloJSP.jsp"></jsp:forward>
<% }
          else{
        	  
%>
<h2> hello<%=request.getParameter("userName")%></h2>

<%} %>
</body>
</html>