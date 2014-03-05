<%-- 
    Document   : circle
    Created on : Nov 15, 2013, 5:36:41 PM
    Author     : Kal
--%>

<%@page import="model.UserClient"%>
<%@page import="model.UserSessionBean"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <script src="http://code.jquery.com/jquery-latest.min.js" type="text/javascript"></script>        
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title><c:out value="${person.getCircleName(param.circle_id)}" /></title>
        <style>
            .editPostForm {
                display :none;
            }
            
            #commentOptions {
                display : none;
            }
            
            #likeCommentCount {
                font-size: 75%;
                color:blue;
            }
            .likePost {
                font-size: 90%;
                color: blue;
            }
            #likePostCount {
                font-size: 90%;
                color: red;
            }
            
            #likeComment {
                font-size: 75%;
                color: red;
            }
            
            #postContent {
                font-size: 125%
            }
            
            #commentDiv {
                border: 1px solid black;
                margin-left : 10px;
                padding:10px;
            }
        </style>
        
        <script type="text/javascript">
        </script>
        
    </head>
    <body>
        <h1><c:out value="${person.getCircleName(param.circle_id)}" /></h1>
        
        <a href="${pageContext.request.contextPath}/user/circle_members.jsp?circle_id=${param.circle_id}">View members of circle</a> <br/>
        <a href="${pageContext.request.contextPath}/user/my_circles.jsp">Back to your circles</a>
        
        <%-- Deleting option --%>
        <c:if test="${person.userClient.isOwnerOfCircle(param.circle_id)}">
            <form method="post" action="${pageContext.request.contextPath}/DeleteCircleServlet">
                <input type="hidden" name="circle_id" value="${param.circle_id}" />
                <input type="submit" value="Delete Circle"/>
            </form>
        </c:if>
        
        <%-- If page is empty, add option --%>
        <c:if test="${person.getPageIds(param.circle_id).size() < 1}">
            <form method="post" action="${pageContext.request.contextPath}/AddPageServlet">
                <input type="submit" value="Add a page" />
                <input type="hidden" name="circle_id" value="${param.circle_id}" />
            </form>
        </c:if>
        
        <%-- If user is not in the circle, we give the join option --%>
        <c:if test="${!person.userClient.isOwnerOfCircle(param.circle_id) && !person.userClient.isInCircle(param.circle_id)}">
            <form method="post" action="${pageContext.request.contextPath}/RequestToJoinCircleServlet">
                <input type="submit" value="Join this circle" />
                <input type="hidden" name="circleIDtojoin" value="${param.circle_id}" />
            </form>
        </c:if>
        
        <c:if test="${person.userClient.isOwnerOfCircle(param.circle_id) || person.userClient.isInCircle(param.circle_id)}">
       
        <c:if test="${!person.userClient.isOwnerOfCircle(param.circle_id) && person.userClient.isInCircle(param.circle_id)}">
            <form method="post" action="${pageContext.request.contextPath}/UnjoinCircleServlet">
                <input type="submit" value="Unjoin this circle"/>
                <input type="hidden" name="circle_id" value="${param.circle_id}" />                
            </form>
        </c:if>
            
        <c:forEach items="${person.getPageIds(param.circle_id)}" var="pageId" >
            <hr />
            <h2>Page: </h2>
            <h4>Add new post: </h4>
            
            <form name="add_post" action="${pageContext.request.contextPath}/AddPostServlet">
                <textarea name="add_post_content" rows="20" cols="50"></textarea><br/>                
                <input type="submit" value="Post">
                <input type="hidden" name="page_id" value="${pageId}" />
                <input type="hidden" name="circle_id" value="${param.circle_id}" />
            </form>
            
            <h3>Posts: </h3> 
            <c:forEach items="${person.userClient.getPosts(pageId)}" var="post" >
                <p id="postAuthor"><c:out value="${person.userClient.getFullName(post.author)}"/> (${post.date}): </p>
                
                <div class="postContent"><c:out value="${post.content}" /></div>    

                <div class="likePost"> 
 
                <form method="get" action="${pageContext.request.contextPath}/PostCommentServlet">
                    <input type="hidden" name="post_id" value="${post.postID}" />
                    <input type="hidden" name="circle_id" value="${param.circle_id}" />
                    <input id="commentBox" name="postCommentContent" type="textbox" />
                    <input type="submit" value="Comment"/> 
                </form>

                <form method="get" action ="${pageContext.request.contextPath}/LikePostServlet">
                    <input type="hidden" name="post_id" value="${post.postID}" />
                    <input type="hidden" name="circle_id" value="${param.circle_id}" />
                     <c:choose>
                        <c:when test="${!person.userClient.userLikesPost(post.postID)}">
                            <input type="submit" id="likePost" value="Like"/>  
                        </c:when>
                        <c:otherwise>
                            <input type="submit" id="likePost" value="Unlike"/>  
                        </c:otherwise>         
                    </c:choose>
                    | <a id="likePostCount"> ${post.likeCount} Likes </a>
                </form>
                
                <c:choose>                                
                    <c:when test="${person.userClient.isAuthorOfPost(post.postID) || 
                                    person.userClient.isOwnerOfCircle(param.circle_id)}">

                        <a href="${pageContext.request.contextPath}/user/edit_post.jsp?post_id=${post.postID}&circle_id=${param.circle_id}">Edit</a>    

                        <form method="post" action="${pageContext.request.contextPath}/DeletePostServlet"> 
                            <input type="hidden" name="circle_id" value="${param.circle_id}" />
                            <input type="hidden" name="post_id" value="${post.postID}"/>                    
                            <input type="submit" name="delete_post" value="Delete Post"/>
                        </form>                                
                    </c:when>
                </c:choose>
                </div>
                <br/>
                    <c:forEach items="${person.userClient.getComments(post.postID)}" var="comment" >
                    <div id="commentDiv" >
                        <p id="commentAuthor"><c:out value="${person.userClient.getFullName(comment.author)}"/> (${comment.date}): </p>
                        
                        <p id="commentContent"><c:out value="${comment.content}" /></p>
                        
                            <form action="${pageContext.request.contextPath}/ToggleLikeServlet">
                                <input type="hidden" name="circle_id" value="${param.circle_id}" />
                                <input type="hidden" name="commentID" value="${comment.commentID}" />
                                <c:choose>
                                    <c:when test="${!person.userClient.userLikesComment(comment.commentID)}">
                                        <input type="submit" id="likeComment" value="Like"/>  
                                    </c:when>
                                    <c:otherwise>
                                        <input type="submit" id="likeComment" value="Unlike"/>  
                                    </c:otherwise>        
                                </c:choose> | 
                                <a id="likeCommentCount">${comment.likeCount} Likes</a>                                                               
                            </form>
                            

                                <c:choose>
                                    <c:when test="${person.userClient.isAuthorOfComment(comment.commentID) ||
                                                    person.userClient.isOwnerOfCircle(param.circle_id)}">
                                        <form method="post" name="delete_comment" action="${pageContext.request.contextPath}/DeleteCommentServlet"> 
                                            <input type="hidden" name="circle_id" value="${param.circle_id}" />
                                            <input type="hidden" name="comment_id" value="${comment.commentID}" />
                                            <input type="submit" name="delCommentSubmit" value="Delete Comment" />
                                        </form>
                                        <form method="post" name="edit_comment" action="${pageContext.request.contextPath}/EditCommentServlet">
                                            Change to: <input name="new_comment" id="editCommentBox" type="text" />
                                            <input type="hidden" name="circle_id" value="${param.circle_id}" />
                                            <input type="hidden" name="comment_id" value="${comment.commentID}" />
                                            <input type="submit" value="Modify"/>
                                        </form>
                                    </c:when>
                                </c:choose>

                    </div>
                    
                    <br/>
                    </c:forEach>
                
                <br/>
                
                <hr/>
            </c:forEach>           
            <hr/>
        </c:forEach>
        </c:if>
    </body>
    <p align="center"><a href="/Facebook/documentation.html">Documentation</a> | <a href="/Facebook/usersguide.html">User's Guide</a></p>    
</html>
