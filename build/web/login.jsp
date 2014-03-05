<%-- 
    Document   : login
    Created on : Nov 9, 2013, 12:05:44 PM
    Author     : Kal
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Login</title>
        <script type="text/javascript">

        </script>
    </head>
    <body>
        <h1>Login</h1>
        
        <form method="post" action="${pageContext.request.contextPath}/LoginServlet">

            Your Id : <input name="personID" type="text" maxlength="15"/> <br/>
            
            <br/>
            <input type="radio" name="type" value="user"/> User <br/>
            <input type="radio" name="type" value="employee"/> Employee <br/>
            <input type="radio" name="type" value="manager"/> Manager <br/>

            <input type="submit" value="Log In"/>

        </form>
    </body>
    <p align="center"><a href="/Facebook/documentation.html">Documentation</a> | <a href="/Facebook/usersguide.html">User's Guide</a></p>
    
</html>
