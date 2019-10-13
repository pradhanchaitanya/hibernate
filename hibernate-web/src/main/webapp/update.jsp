<%@page import="com.lti.training.hibernate.entity.Customer"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<%
Customer c = (Customer)session.getAttribute("cust"); 
%>
<form action="updateservlet" method="post">
Email:<input type="text" name="email" value="<%=c.getEmail() %>"/><br>
Name:<input type="text" name="name" value="<%=c.getName() %>"/><br>
City:<input type="text" name="city" value="<%=c.getCity() %>"/><br>
<button type="submit">update</button>
</form>
</body>
</html>