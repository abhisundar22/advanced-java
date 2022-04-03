<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<%@page import="com.javatpoint.dao.UserDao,com.javatpoint.bean.*,java.util.*"%>  
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>  
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<%! String data="Employee Website"; %>  
<h1>View user form</h1>
Current Time: <%= java.util.Calendar.getInstance().getTime() %>  
<%=data %>
<%
List<User> list= UserDao.getAllRecords();
request.setAttribute("list",list);  
%>

<table border="1" width="90%"> 
 
<tr><th>Name</th><th>Password</th><th>Edit</th><th>Delete</th></tr> 
 
<c:forEach items="${list}" var="u"> 
 
<tr><td>${u.getName()}</td><td>${u.getPassword()}</td>  
 
<td><a href="editform.jsp?nameBesant=${u.getName()}">Edit</a></td>  

<td><a href="deleteuser.jsp?name=${u.getName()}">Delete</a></td></tr>  

</c:forEach>  
</table>  

</body>
</html>