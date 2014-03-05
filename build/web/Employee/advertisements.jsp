<%-- 
    Document   : advertisements
    Created on : Nov 21, 2013, 5:57:00 PM
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
              if(p == null || p instanceof UserSessionBean) {
                  response.sendRedirect(request.getContextPath()+"/login.jsp");
              } 
        %>
        <title>Displaying all advertisements</title>
    </head>
    <body>
        <p>There are this many advertisements ${person.employeeClient.countAds()}</p>
        <a href="${pageContext.request.contextPath}/Employee/advertisement_create.jsp">Create An Advertisement</a>
        <a href="${pageContext.request.contextPath}/Employee/employee_home.jsp">Back</a>
        <h1>Select an Advertisement to view or delete : </h1>
        
        <c:forEach var="adID" items="${person.employeeClient.getAllAdvertisementIds()}">
            <a href='advertisement_page.jsp?advertisement_id=<c:out value="${adID}"/>'>
                <c:out value="${person.employeeClient.getAdvertisementName(adID)}"/>
            </a> 
            <br/>
        </c:forEach>
    </body>
    <p align="center"><a href="/Facebook/documentation.html">Documentation</a> | <a href="/Facebook/usersguide.html">User's Guide</a></p>
</html>
