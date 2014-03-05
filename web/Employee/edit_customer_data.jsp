<%-- 
    Document   : edit_customer_data
    Created on : Nov 21, 2013, 1:29:49 AM
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
        <title>Edit Customer Data</title>
    
    </head>
    <body>
        <h1>Edit/View customer data</h1>
        <p>Leave the textfield alone if you do not wish to change</p>
    <p1>Clear the textfield to delete corresponding data</p1>

    <form action="${pageContext.request.contextPath}/EditCustomerInfoServlet">

        <p> Address : <input type="text" name="address" maxlength="50" value="${person.employeeClient.getUserAddress(param.user_id)}" /> </p>       
        <p> City : <input type="text" name="city" maxlength="50" value="${person.employeeClient.getUserCity(param.user_id)}"/> </p>
        <p> State : <input type="text" name="state" maxlength="2" value=${person.employeeClient.getUserState(param.user_id)}></p>
        <p> Zip Code : <input type="text" name="zipcode" value=${person.employeeClient.getUserZipCode(param.user_id)}> ** Only numbers</p>
        <p> Telephone: <input type="text" name="telephone" value=${person.employeeClient.getUserTelephone(param.user_id)}> ** Only numbers </p> 
        <p> Email Address: <input type="text" name="email" value=${person.employeeClient.getUserEmail(param.user_id)}> 
        <p> Rating: <input type="text" name="rating" value=${person.employeeClient.getUserRating(param.user_id)}> 
        <p> <input type="submit" value="Edit" /></p>
        <input type="hidden" name="user_ID" value="${param.user_id}"/>

    </form>
    <h1>Accounts under this user:</h1>
    <c:forEach var="accounts" items="${person.employeeClient.getAccountsOfUser(param.user_id)}">
        <p>${accounts} Credit cards under this account</p>
        <c:forEach var="card" items="${person.employeeClient.getCreditCardsOfAccount(accounts)}">
            <a href='credit_card_page.jsp?card_number=<c:out value="${card}"/>'>
                <c:out value="${card}"/>
            </a> 
            <br/>
        </c:forEach>
    </c:forEach>
    <ul>
        <li><a href="edit_customer_selection.jsp">Back</a></li>
    </ul>
</body>
<p align="center"><a href="/Facebook/documentation.html">Documentation</a> | <a href="/Facebook/usersguide.html">User's Guide</a></p>
</html>
