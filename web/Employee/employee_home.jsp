<%-- 
    Document   : employee_home
    Created on : Nov 20, 2013, 6:04:00 PM
    Author     : jacliang
    
    Associated JSPs:
    advertisement_create
    advertisement_delete
    customer_mailing_list
    customer_recommendations
    edit_customer_data
    employee_home

    Associated Servelets:
    advertisementCreationServelet
    EditCustomerInfoServelt
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
        <title>Employee Home</title>
        <style>
            li > a { font-size:200% }
        </style>
    </head>
    <body>
        <h1>Welcome to your employee account ! ${person.firstName}</h1>
        <ul>
            <li><a href="${pageContext.request.contextPath}/Employee/advertisements.jsp">Advertisements</a></li>
            <li><a href="${pageContext.request.contextPath}/Employee/record_transaction.jsp">Record Transaction</a></li>
            <li><a href="${pageContext.request.contextPath}/Employee/edit_customer_selection.jsp">Edit Customer Data</a></li>
            <li><a href="${pageContext.request.contextPath}/Employee/customer_mailing_list.jsp">Customer Mailing List</a></li>
            <li><a href="${pageContext.request.contextPath}/Employee/customer_recommendations.jsp">Customer Recommendations</a></li>
            <li><a href="${pageContext.request.contextPath}/Employee/employee_list.jsp">Employee Info</a></li>
            <li><a href="${pageContext.request.contextPath}/LogoutServlet">Log Out</a></li>
        </ul>
    </body>
    <p align="center"><a href="/Facebook/documentation.html">Documentation</a> | <a href="/Facebook/usersguide.html">User's Guide</a></p>
</html>
