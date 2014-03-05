<%-- 
    Document   : new_account
    Created on : Nov 24, 2013, 1:24:41 PM
    Author     : Kal
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>New Account</title>
    </head>
    <body>
        <h1>New Account</h1>
        
        <form action="${pageContext.request.contextPath}/AddAccountServlet">
            Credit Card Number: <input type="text" name="ccnumber" maxlength="20" /> <br/>
            <input type="submit" value="Add new account" />
        </form>
    </body>
    <p align="center"><a href="/Facebook/documentation.html">Documentation</a> | <a href="/Facebook/usersguide.html">User's Guide</a></p>    
</html>
