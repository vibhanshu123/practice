<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<jsp:useBean id="employee" class="hello.Employee"/>
<jsp:setProperty property="*" name="employee"/>
<h1>
NAME :<jsp:getProperty property="name" name="employee"/><BR>
EMPLOYEEID:<jsp:getProperty property="employeeId" name="employee"/>
ROLE:<jsp:getProperty property="role" name="employee"/>
DEPARTMENT:<jsp:getProperty property="department" name="employee"/>
SALARY:<jsp:getProperty property="salary" name="employee"/>
</h1>

</body>
</html>