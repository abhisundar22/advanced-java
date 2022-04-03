<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@page import="com.javatpoint.dao.UserDao"%>  
    
    
    <jsp:useBean id="u" class="com.javatpoint.bean.User"></jsp:useBean>  
    <jsp:setProperty property="*" name="u"/> 
    
    
<%  
UserDao.delete(u);  
response.sendRedirect("viewusers.jsp");  
%> 