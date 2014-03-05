<%-- 
    Document   : customer_mailing_list
    Created on : Nov 21, 2013, 1:30:05 AM
    Author     : Jacky
--%>
<%@page import="model.UserSessionBean"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <%
              Object p = request.getSession().getAttribute("person");
              if(p == null ||p instanceof UserSessionBean) {
                  response.sendRedirect(request.getContextPath()+"/login.jsp");
              } 
        %>
        <title>Customer Mailing list</title>
    <h1>Mailing List</h1>
</head>
<body>
    <c:forEach var="ssn" items="${person.employeeClient.getCustomerEmailList()}">
        <p>${ssn}</p>
    </c:forEach>

    <ul>
        <li><a href="employee_home.jsp">Back</a></li>
    </ul>
</body>
<p align="center"><a href="/Facebook/documentation.html">Documentation</a> | <a href="/Facebook/usersguide.html">User's Guide</a></p>
</html>
