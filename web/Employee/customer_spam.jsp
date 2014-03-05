<%-- 
    Document   : customer_spam
    Created on : Nov 22, 2013, 4:14:13 PM
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
        <title> This is where page of advertisements targeted customer is </title>
    </head>
    <body>
        <h1>These are the products i recommend for this user</h1>
        <c:forEach var="adID" items="${person.employeeClient.getUserRecommendationList(param.user)}">
            <a href='advertisement_page.jsp?advertisement_id=<c:out value='${adID}'/>'>
                <p><p>
                    <c:out value="${person.employeeClient.getAdvertisementName(adID)}"/>
            </a>
        </c:forEach>
        <a href="customer_recommendations.jsp">>Back</a>
    </body>
    <p align="center"><a href="/Facebook/documentation.html">Documentation</a> | <a href="/Facebook/usersguide.html">User's Guide</a></p>
</html>
