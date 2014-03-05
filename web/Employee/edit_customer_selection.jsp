<%-- 
    Document   : edit_customer_selection
    Created on : Nov 23, 2013, 7:41:04 PM
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
        <title>Customer Data Selection</title>
    </head>
    <body>
        <h1>Select a user to edit or view their data:</h1>
        <c:forEach var="userID" items="${person.employeeClient.getAllUserIds()}">
            <a href='edit_customer_data.jsp?user_id=<c:out value="${userID}"/>'>
                <c:out value="${userID}"/>
            </a> 
            <br/>
        </c:forEach>
            <ul>
            <li><a href="employee_home.jsp">Back</a></li>
        </ul>
    </body>
    <p align="center"><a href="/Facebook/documentation.html">Documentation</a> | <a href="/Facebook/usersguide.html">User's Guide</a></p>
</html>
