<%-- 
    Document   : employee_page
    Created on : Dec 3, 2013, 1:07:54 PM
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
        <title>Employee Profile Page</title>
    </head>
    <body>
    <h>Id # : ${param.emp_id}</h>
    <p>First Name : ${person.employeeClient.getEmployeeFirstName(param.emp_id)}</p>
    <p>Last Name : ${person.employeeClient.getEmployeeLastName(param.emp_id)}</p>
    <p>Address : ${person.employeeClient.getEmployeeAddress(param.emp_id)}</p>
    <p>City : ${person.employeeClient.getEmployeeCity(param.emp_id)}</p>
    <p>State : ${person.employeeClient.getEmployeeState(param.emp_id)}</p>
    <p>Zip Code : ${person.employeeClient.getEmployeeZipcode(param.emp_id)}</p>
    <p>Telephone : ${person.employeeClient.getEmployeeTelephone(param.emp_id)}</p>
    <p>Start Date  :${person.employeeClient.getEmployeeStartDate(param.emp_id)}</p>
</body>
<p align="center"><a href="/Facebook/documentation.html">Documentation</a> | <a href="/Facebook/usersguide.html">User's Guide</a></p>
</html>
