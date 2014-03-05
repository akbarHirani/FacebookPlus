<%-- 
    Document   : shopping.jsp
    Created on : Nov 24, 2013, 10:52:28 AM
    Author     : Kal
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Shopping Page</title>
    </head>
    <body>
        <a href="account_home.jsp">Back to home</a>
        <h1>Your recommended items:</h1>            
        <table border="1">
            <tr>
                <th>Item Name</th>
                <th>Available Unit(s)</th>
                <th>Units to purchase</th>
            </tr>
            <c:forEach items="${person.userClient.getSuggestedItems()}" var="suggestedItem">
                <tr>
                    <td>${suggestedItem.itemName}</td>
                    <td>${suggestedItem.availUnits}</td>
                    <td>
                        <form action="${pageContext.request.contextPath}/BuyItemServlet">
                        <input type="hidden" value="${suggestedItem.adID}" name="adId" />
                        <input type="text" name="numUnitsToBuy_${suggestedItem.adID}" />                        
                        <input type="submit" value="Buy" />
                        </form>
                    </td>
                </tr>
            </c:forEach>
        </table>
        <br/>
        <h1>Best-Seller List of Items</h1>
                <table border="1">
            <tr>
                <th>Item Name</th>
                <th>Available Unit(s)</th>
                <th>Units to purchase</th>
            </tr>
            <c:forEach items="${person.userClient.getBestSellerAdItems()}" var="bestSellerItem">
                <tr>
                    <td>${bestSellerItem.itemName}</td>
                    <td>${bestSellerItem.availUnits}</td>
                    <td>
                        <form action="${pageContext.request.contextPath}/BuyItemServlet">
                        <input type="hidden" value="${bestSellerItem.adID}" name="adId" />
                        <input type="text" name="numUnitsToBuy_${bestSellerItem.adID}" />                        
                        <input type="submit" value="Buy" />
                        </form>
                    </td>
                </tr>
            </c:forEach>
        </table>
    </body>
    <p align="center"><a href="/Facebook/documentation.html">Documentation</a> | <a href="/Facebook/usersguide.html">User's Guide</a></p>    
</html>
