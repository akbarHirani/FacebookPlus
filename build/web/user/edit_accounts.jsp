<%-- 
    Document   : edit_account
    Created on : Nov 24, 2013, 1:24:08 PM
    Author     : Kal
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <script src="http://code.jquery.com/jquery-latest.min.js" type="text/javascript"></script>
        <script type="text/javascript">
            
              
              function checkNotNull() {
                var ccnumber = document.getElementsByName("ccnumber").item(0);
                if(!ccnumber.value) {
                    $('#errorMessage').html("<b>Credit card number can't be null<b>");
                    return false;
                } else {
                    return true;
                }
            }  
        </script>
        <title>Modify an account</title>
    </head>
    <body>
        <h1>Delete an account</h1>
        <form action="${pageContext.request.contextPath}/DeleteAccountServlet">
            Account Numbers:
            <select name="account_to_delete">
                <c:forEach items="${person.accountNumbers}" var="accId">
                     <option>${accId}</option>                
                </c:forEach>
            </select>
            <input type="submit" value="Delete Account" />      
        </form>
         <br/>
         
        <h1>Change Credit Card Info:</h1>
        <h3>Current Info</h3>
        <table>
            <tr>
                <th>Account Number</th>
                <th>Credit Card Number</th>
            </tr>
            <c:forEach items="${person.accountNumbers}" var="accId">
                <tr>
                    <td>${accId}</td>
                    <td>${person.userClient.getCCNumber(accId)}</td>
                </tr>
            </c:forEach>
        </table>  
        
        <h3>To Change</h3>
         <form method="post" onsubmit="return checkNotNull()" action="${pageContext.request.contextPath}/EditAccountServlet">
            Account Numbers:
            <select name="account_to_edit">
                <c:forEach items="${person.accountNumbers}" var="accId">
                     <option>${accId}</option>                
                </c:forEach>
            </select>
            
             <br/>
            
            New CC Number: <input type="text" maxlength="20" name="ccnumber" />
            <input type="submit" value="Change CC Number" /> <br/>    
            <div id="errorMessage"></div>
         </form>
         <br/>
         
    </body>
    <p align="center"><a href="/Facebook/documentation.html">Documentation</a> | <a href="/Facebook/usersguide.html">User's Guide</a></p>    
</html>
