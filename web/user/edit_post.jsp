<%-- 
    Document   : edit_post
    Created on : Nov 22, 2013, 6:46:07 PM
    Author     : Kal
--%>

<%@page import="model.UserClient"%>
<%@page import="model.UserSessionBean"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <%
            UserSessionBean usBean = (UserSessionBean) request.getSession().getAttribute("person");
            UserClient uClient = usBean.getUserClient();
            long circleID = Long.parseLong(request.getParameter("circle_id"));
            long postID = Long.parseLong(request.getParameter("post_id"));
            if(!uClient.isOwnerOfCircle(circleID) && !uClient.isInCircle(circleID)) {
                 response.sendRedirect(request.getContextPath() + "/user/my_circles.jsp");              
            }
            
            if(!uClient.isAuthorOfPost(postID)) {
                response.sendRedirect(request.getContextPath() + "user/circles.jsp?circle_id=" + circleID);
            }
        %>        
        <title>Edit the post:</title>
    </head>
    <body>
        <h1>Edit the post:</h1>
        
        <h3>Current Message: </h3>
        <p>${person.userClient.getPostContent(param.post_id)}</p>
        
        <h3>New Message: </h3>
        <p>
            <form class="postEditContainer" action="${pageContext.request.contextPath}/EditPostServlet">
                <textarea name="new_post" rows="20" cols="50"></textarea>
                <input class="editPostForm" type="submit" value="Modify Post"/>
                <input type="hidden" name="post_id" value="${param.post_id}" />
                <input type="hidden" name="circle_id" value="${param.circle_id}" />
            </form>
        </p>
  
    </body>
    <p align="center"><a href="/Facebook/documentation.html">Documentation</a> | <a href="/Facebook/usersguide.html">User's Guide</a></p>    
</html>
