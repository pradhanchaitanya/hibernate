
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
<h1><%=c.getId() %></h1>
<h1><%=c.getName() %></h1>
<h1><%=c.getEmail() %></h1>
<h1><%=c.getCity() %></h1>

</body>
</html>