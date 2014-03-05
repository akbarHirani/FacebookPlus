<%-- 
    Document   : user
    Created on : Dec 2, 2013, 10:35:09 PM
    Author     : Kal
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>User ${param.user}</title>
    </head>
    <body>
        <a href="./account_home.jsp">Back to account home</a><br/>
        <a href="./search_user.jsp">Back to search</a><br/>
        <h1>${person.userClient.getFirstName(param.user)}'s page</h1>
        
        <h3>His/her user ID is : </h3>
        ${param.user}
        
        <h3>Circles this person is in:</h3>
        <c:forEach items="${person.userClient.getCircleIds(param.user)}" var="circleId">
            <a href="${pageContext.request.contextPath}/user/circle.jsp?circle_id=<c:out value="${circleId}"/>">${person.userClient.getCircleName(circleId)}
            </a><br/>
        </c:forEach>
        
    </body>
    <p align="center"><a href="/Facebook/documentation.html">Documentation</a> | <a href="/Facebook/usersguide.html">User's Guide</a></p>    
</html>
