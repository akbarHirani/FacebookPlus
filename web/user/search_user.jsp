<%-- 
    Document   : search_user
    Created on : Nov 23, 2013, 4:28:32 PM
    Author     : Kal
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
        <script src="http://code.jquery.com/jquery-latest.min.js" type="text/javascript"></script>
        <title>Search for user</title>
        
        <script type="text/javascript">
            $(document).ready(function() {                        
                 $('#submitSearch').click(function(e) {
                 var first_name = $('#first_name').val();   
                 var last_name = $('#last_name').val();
                 $.post('/Facebook/SearchUserServlet',
                    {first_name:first_name,
                     last_name:last_name,
                     circle_id:'${param.circle_id}'
                    },
                 function(responseText) { 
                        $('#searchResult').html(responseText);         
                    });
                });
            });
        </script>
    </head>
    <body>
        <a href="./my_circles.jsp">Back to your circles</a> <br/>
        <h1>Search for a user to add to your circle:</h1>
        <p>**************Note: use the ID to add the user via the previous page.</p>
        
        First Name: <input type="text" id="first_name" /> <br/>
        Last Name: <input type="text" id="last_name" />
        <input type="button" id="submitSearch" value="Search" />

        <div id="searchResult">
        </div>
        
    </body>
    <p align="center"><a href="/Facebook/documentation.html">Documentation</a> | <a href="/Facebook/usersguide.html">User's Guide</a></p>    
</html>
