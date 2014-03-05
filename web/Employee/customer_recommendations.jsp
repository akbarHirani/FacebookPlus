<%-- 
    Document   : customer_recommendations
    Created on : Nov 21, 2013, 1:30:16 AM
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
        <title>Recommendations to Customers</title>
    </head>
    <body>
        <h1>SELECT AN USER</h1>
        <ul>
            <p>By selecting a user,you are viewing the products that you recommend by their preferences.
               you can only recommend products that are under your supervision<p>
            
            <li><a href="employee_home.jsp">Back</a></li>
        </ul>
        <c:forEach var="acc" items="${person.employeeClient.getAllUserIds()}">
            <a href='customer_spam.jsp?user=<c:out value="${acc}"/>'>
                ${acc}     
            </a> 
            <br/>
        </c:forEach>
    </body>
    <p align="center"><a href="/Facebook/documentation.html">Documentation</a> | <a href="/Facebook/usersguide.html">User's Guide</a></p>
</html>
