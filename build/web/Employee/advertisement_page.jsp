<%-- 
    Document   : advertisement_page
    Created on : Nov 21, 2013, 5:54:29 PM
    Author     : Jacky
--%>

<%@page import="model.UserSessionBean"%>
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
        <title>For single ad</title>
    <h1>Item name:${person.employeeClient.getAdvertisementName(param.advertisement_id)}</h1> 

</head>
<body>
    <p>Advertisement ID: ${param.advertisement_id}</p>
    <p>Employee: ${person.employeeClient.getAdvertisementEmployee(param.advertisement_id)}</p>
    <p>Item type: ${person.employeeClient.getAdvertisementType(param.advertisement_id)}</p> 
    <p>Company: ${person.employeeClient.getAdvertisementCompany(param.advertisement_id)}</p> 
    <p>Content: ${person.employeeClient.getAdvertisementContent(param.advertisement_id)}</p> 
    <p>Unit Price: ${person.employeeClient.getAdvertisementUnitPrice(param.advertisement_id)}</p> 
    <p>Available Units: ${person.employeeClient.getAdvertisementAvailableUnits(param.advertisement_id)}</p> 
    <p>Date Advertisement Created: ${person.employeeClient.getAdvertisementDate(param.advertisement_id)}</p>

    <form method="get" action="${pageContext.request.contextPath}/DeleteAdvertisementServlet" name="DeleteAdvertisement">
        <input type="hidden" name="advertisement_ID" value="${param.advertisement_id}"/>
        <input type="submit" value="Delete this advertisement" />
    </form>

</body>
<p align="center"><a href="/Facebook/documentation.html">Documentation</a> | <a href="/Facebook/usersguide.html">User's Guide</a></p>
</html>
