<%-- 
    Document   : my_messages
    Created on : Nov 20, 2013, 3:40:19 PM
    Author     : Kal
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
        <script src="http://code.jquery.com/jquery-latest.min.js" type="text/javascript"></script>        
        <script>
            $(document).ready(function() {
                $('.numOnlyField').keyup(function() {
                    if (/\D/g.test(this.value))
                    {
                        // Filter non-digits from input value.
                        this.value = this.value.replace(/\D/g, '');
                    }           
                });
            });
        </script>
        <title>Messages</title>
    </head>
    <body>
        <a href="./account_home.jsp">Back to home</a> <br/>
        <h1>Your Recent Conversation Partners: </h1>
        
        <!-- List all the people they talked with -->
        <c:forEach items="${person.userClient.getConversationPartners()}" var="partner" >
            <a href="${pageContext.request.contextPath}/user/messaging.jsp?partner=<c:out value="${partner}" />">
                <c:out value="${person.userClient.getFirstName(partner)}" />
                <c:out value="${person.userClient.getLastName(partner)}" />
            </a>
                <br/>
        </c:forEach>
        <br />        
        
        <h1>Chat with:</h1>
        <form method="get" action="${pageContext.request.contextPath}/user/messaging.jsp">
            Friend's User ID: <input class="numOnlyField" type="text" name="partner"/>
            <input type="submit" value="Talk to"/>
        </form>
                       
    </body>
    <p align="center"><a href="/Facebook/documentation.html">Documentation</a> | <a href="/Facebook/usersguide.html">User's Guide</a></p>    
</html>
