<%-- 
    Document   : messaging
    Created on : Nov 20, 2013, 4:59:30 PM
    Author     : Kal
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <style>
            #message {
                border:red 1px dashed;
                margin: 5px;
                font-size:20px;
                font: arial;
            }
            
            #metamessage {
                font: arial;
                font-size: 12px;
            }
        </style>
        
        <title>Messages with ${param.partner}</title>        
        
    </head>
    <body>
        <a href="./account_home.jsp">Back to home</a> <br/>
        <a href="./my_messages.jsp">Back to your messages</a><br/>
        <h1>Your messages with ${person.userClient.getFirstName(param.partner)}</h1>
        <c:forEach items="${person.userClient.getMessagesWithUser(param.partner)}" var="message">
            
            <div id="metamessage">
                <p>From : ${person.userClient.getFirstName(message.sender)} ${person.userClient.getLastName(message.sender)} | 
                    To: ${person.userClient.getFirstName(message.reciever)} ${person.userClient.getLastName(message.reciever)} |
                    Subject: ${message.subject}</p>
            </div>
            
            <div id="message">
                <p><c:out value="${message.message}"/></p>
            </div>
            
            <form method="get" action="${pageContext.request.contextPath}/DeleteMessageServlet" name="DeleteMessage">
                <input type="hidden" name="messageID" value="${message.messageID}"/>
                <input type="hidden" name="partner" value="${param.partner}"/>
                <input type="submit" value="Delete"/>
            </form>
            
        </c:forEach>
        
        <form method="post" action="${pageContext.request.contextPath}/SendMessageServlet" name="SendMessage">
            <input type="hidden" name="reciever" value="${param.partner}" />
            <input type="hidden" name="sender" value="${person.userID}" />
            
            Subject: 
            <input type="text" maxlength="100" name="subject" />
            <br />                        
            
            <textarea rows="20" cols="50" name="content" ></textarea>             
            <br />
            
            <input type="submit" value="Send" />
        </form>
    </body>
</html>
