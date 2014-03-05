<%-- 
    Document   : user_homepage
    Created on : Nov 13, 2013, 4:10:15 PM
    Author     : Kal
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Account Home</title>
        <style>
            li > a { font-size:200% }
        </style>
    </head>
    <body>
        <h1>Welcome to your account, ${person.firstName}</h1>
        <ul>
            <li><a href="${pageContext.request.contextPath}/user/account_selection.jsp">Account Selection Home</a></li>
            <li><a href="${pageContext.request.contextPath}/user/account_history.jsp">My Account History</a></li>
            <li><a href="${pageContext.request.contextPath}/user/my_circles.jsp">My Circles</a></li>
            <li><a href="${pageContext.request.contextPath}/account_information.jsp">Account Information</a></li>
            <li><a href="${pageContext.request.contextPath}/user/my_messages.jsp">Messages</a></li>
            <li><a href="${pageContext.request.contextPath}/user/shopping.jsp">Shopping</a></li>
            <li><a href="${pageContext.request.contextPath}/LogoutServlet">Log Out</a></li>
        </ul>
    </body>
    <p align="center"><a href="/Facebook/documentation.html">Documentation</a> | <a href="/Facebook/usersguide.html">User's Guide</a></p>    
</html>
