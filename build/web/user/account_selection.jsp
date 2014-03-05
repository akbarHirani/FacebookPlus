<%-- 
    Document   : account_selection
    Created on : Nov 13, 2013, 4:13:47 PM
    Author     : Kal
--%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
        <title>Select your account</title>
    </head>
    <body>
        <h1>Hello ${person.firstName} ${person.lastName}!</h1>
        <p>Your accounts: <br />
            <c:forEach var="i" items="${person.accountNumbers}">
                <a href='${pageContext.request.contextPath}/AccountLoginServlet?account_number=<c:out value="${i}"/>'> Account Number : <c:out value="${i}" /> </a><br />
            </c:forEach>
        </p>
        
        <a href="new_account.jsp">Create a new account</a> <br/>
        <a href="edit_accounts.jsp">Modify your accounts</a> <br/>
    </body>
    <p align="center"><a href="/Facebook/documentation.html">Documentation</a> | <a href="/Facebook/usersguide.html">User's Guide</a></p>    
</html>
