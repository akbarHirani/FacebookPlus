<%-- 
    Document   : employee_list
    Created on : Dec 3, 2013, 1:07:26 PM
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
        <title>Employees</title>
    </head>
    <body>
        <a href="${pageContext.request.contextPath}/Employee/employee_home.jsp">Back</a>
        <p>Select an employee by their employee id to view their information:</p>
        <c:forEach var="empId" items="${person.employeeClient.getAllEmployeeIds()}">
            <a href='employee_page.jsp?emp_id=<c:out value="${empId}"/>'>
                <c:out value="${empId}"/>
            </a> 
            <br/>
        </c:forEach>
    </body>
    <p align="center"><a href="/Facebook/documentation.html">Documentation</a> | <a href="/Facebook/usersguide.html">User's Guide</a></p>
</html>
