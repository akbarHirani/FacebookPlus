<%-- 
    Document   : account_history
    Created on : Nov 24, 2013, 1:08:04 PM
    Author     : Kal
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Account History</title>
    </head>
    <body>
        <a href="${pageContext.request.contextPath}/user/account_home.jsp">Account Home</a> <br/>        
        <h1>Transaction History</h1>
        <table border="1">
            <tr>
                <th>Transaction Id</th>
                <th>Date</th>           
                <th>Account</th>
                <th>Advertisement Id</th>
                <th>Quantity</th>                
            </tr>
            <c:forEach items="${person.userClient.getAllPurchases()}" var="purchase">
                <tr>
                    <td>${purchase.transId}</td>
                    <td>${purchase.date}</td>
                    <td>${purchase.accNum}</td>
                    <td>${purchase.adId}</td>
                    <td>${purchase.numUnits}</td>
                </tr>
            </c:forEach>
        </table>
    </body>
    <p align="center"><a href="/Facebook/documentation.html">Documentation</a> | <a href="/Facebook/usersguide.html">User's Guide</a></p>
</html>
