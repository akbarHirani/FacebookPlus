<%-- 
    Document   : circle_members
    Created on : Nov 23, 2013, 3:28:24 PM
    Author     : Kal
--%>

<%@page import="model.UserSessionBean"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
        
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Members of ${person.userClient.getCircleName(param.circle_id)}</title>
        <script src="http://code.jquery.com/jquery-latest.min.js" type="text/javascript"></script>        
        <script>
            $(document).ready(function() {
                $('.userField').keyup(function() {
                    if (/\D/g.test(this.value))
                    {
                        // Filter non-digits from input value.
                        this.value = this.value.replace(/\D/g, '');
                    }           
                });
            });
        </script>
        
    </head>
    <body>
        <h1>${person.userClient.getCircleName(param.circle_id)}</h1>

        <h3>Current members:</h3>    
            
        <c:forEach var="member" items="${person.userClient.getMembersOfCircle(param.circle_id)}">
            ${person.userClient.getFullName(member)} -- ${member}
            <br/>            
        </c:forEach>

        <c:if test="${person.userClient.isOwnerOfCircle(param.circle_id)}">
            
            <a href="${pageContext.request.contextPath}/user/search_user.jsp?circle_id=${param.circle_id}">
                Search for a user
            </a> <br/>
        
            <h3>Add a new member:</h3>

            <form method="post" action="${pageContext.request.contextPath}/AddFriendToCircle">
                Friend's User ID:<input class="userField" type="text" name="friend_to_add"/>
                <input type="hidden" value="${param.circle_id}" name="circleToAddFriendTo"/> 
                <input type="submit" value="Add to circle"/>
            </form>      
                
            <h3>Remove a member: </h3>
            <form action="${pageContext.request.contextPath}/RemoveUserFromCircleServlet" method="post">
                User ID To Remove : <input class="userField" type="text" name="user_to_remove">
                <input type="hidden" value="${param.circle_id}" name="circle_id"/> 
                <input type="submit" value="Remove from circle"/>
            </form>
            
            <h3>Pending join requests: </h3>
            <c:forEach items="${person.userClient.getJoinRequests(param.circle_id)}" var="pendinguser">
                <form action="${pageContext.request.contextPath}/AcceptRequestServlet" method="post">
                    <input type="hidden" value="${pendinguser}" name="pending_user"/>
                    <input type="hidden" value="${param.circle_id}" name="circle_id"/>                     
                    ${person.userClient.getFirstName(pendinguser)} 
                    ${person.userClient.getLastName(pendinguser)}
                    &nbsp;                     
                    <input type="submit" value="Accept"/>
                </form> <br/>
            </c:forEach>
        </c:if>
            
            
            
    </body>
    <p align="center"><a href="/Facebook/documentation.html">Documentation</a> | <a href="/Facebook/usersguide.html">User's Guide</a></p>
</html>
