<%-- 
    Document   : my_circles
    Created on : Nov 15, 2013, 5:11:58 PM
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
            
            function addCircleValidate() {
                var circle_name_create = document.getElementsByName("circle_name_create").item(0);
                var type = document.getElementsByName("type").item(0);
                
            }
        </script>
        <title>My Circles</title>
    </head>
    <body>
        <a href="account_home.jsp">Back to Account Home</a> <br/>
        
        <h1>Owner of : </h1>
        <c:forEach var="ownerCircleId" items="${person.userClient.getOwnerOfCircleIds()}">
            <a href='circle.jsp?circle_id=<c:out value="${ownerCircleId}"/>'>
                <c:out value="${person.userClient.getCircleName(ownerCircleId)}"/>
            </a> | Circle ID : ${ownerCircleId}
            <br/>        
        </c:forEach>

        <h3>Pending Join Requests:</h3>
        
        <h1>Member in :</h1>
        <c:forEach var="memberId" items="${person.getCircleIds()}">
            <a href='circle.jsp?circle_id=<c:out value="${memberId}"/>'>
                <c:out value="${person.userClient.getCircleName(memberId)}"/>
            </a> | Circle ID : ${memberId}
            <br/>
        </c:forEach>
            
        <h2>Create a new Circle</h1>
        
        <form action="${pageContext.request.contextPath}/InsertCircleServlet">
            Circle Name: <input type="text" name="circle_name_create"/> <br/>
            Type: <input type="text" name="type"/> <br/>
            <input type="submit" value="Create"/>
        </form>
        
        <h2>Join a circle</h2>
        
        <p>Ask your friend for their circle ID</p>
        
        <form method="post" action="${pageContext.request.contextPath}/RequestToJoinCircleServlet">
            <input class="numOnlyField" type="text" name="circleIDtojoin"/>
            <input type="submit" value="Request to Join"/>
        </form>
        
        <h2>Search for a person</h3>
        
        <a href="${pageContext.request.contextPath}/user/search_user.jsp">Search for a user</a>
            
        <h2>Add friend to a circle</h2>
        
        <form method="post" action="${pageContext.request.contextPath}/AddFriendToCircle">
            Circle:

            <select name="circleToAddFriendTo">
                <c:forEach var="ownerCircleId" items="${person.userClient.getOwnerOfCircleIds()}">
                    <option value="${ownerCircleId}">${person.userClient.getCircleName(ownerCircleId)}</option>
                    <br/>        
                </c:forEach>
            </select>
                
            <br/>
                
            Friend's User ID :<input class="numOnlyField" type="text" name="friend_to_add"/>
            <input type="submit" value="Add to circle"/>
        </form>
            
            
        <h2>Rename a circle</h2>
                
        <form method="post" action="${pageContext.request.contextPath}/RenameCircleServlet">
            Circle:

            <select name="circleToRename">
                <c:forEach var="ownerCircleId" items="${person.userClient.getOwnerOfCircleIds()}">
                    <option value="${ownerCircleId}">${person.userClient.getCircleName(ownerCircleId)}</option>
                    <br/>        
                </c:forEach>
            </select>
                
            <br/>
                
            New Circle Name: <input type="text" name="new_circle_name"/>
            <input type="submit" value="Rename Circle"/>
        </form>
        
        
    </body>
    <p align="center"><a href="/Facebook/documentation.html">Documentation</a> | <a href="/Facebook/usersguide.html">User's Guide</a></p>    
</html>
