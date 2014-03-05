<%-- 
    Document   : credit_card_page
    Created on : Dec 2, 2013, 7:03:42 PM
    Author     : Jacky
--%>

<%@page import="model.UserSessionBean"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <%
              Object p = request.getSession().getAttribute("person");
              if(p == null ||p instanceof UserSessionBean) {
                  response.sendRedirect(request.getContextPath()+"/login.jsp");
              } 
        %>
        <script type="text/javascript">

            //Validate the form            
            function valiForm() {
                var flag = true;
                var errorMessage = "";

                var number = document.getElementsByName("card").item(0);


                if (!number.value || isNaN(parseInt(number.value)) || number.value.length != 16) {
                    flag = false;
                    errorMessage += "Credit Card Number is empty or not formatted \n";
                }
                if (!flag) {
                    window.alert(errorMessage);
                    return false;
                } else {
                    window.alert("Edit Complete");
                    return true;
                }
            }
        </script>
    </head>
    <body>
        <form method="post" onsubmit="return valiForm()" action="${pageContext.request.contextPath}/CreditCardEditServlet">
            <p> Credit Card number: <input type="text" name="card" value=${param.card_number}> 
            <p> <input type="submit" value="Edit" /></p>
            <input type="hidden" name="cardNumber" value="${param.card_number}"/>

        </form>
        <form method="post" action="${pageContext.request.contextPath}/DeleteCardServlet">
            <p> <input type="submit" value="Delete" /></p>
        </form>
    </body>
    <p align="center"><a href="/Facebook/documentation.html">Documentation</a> | <a href="/Facebook/usersguide.html">User's Guide</a></p>
</html>
