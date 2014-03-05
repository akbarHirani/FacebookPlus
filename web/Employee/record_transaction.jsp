<%-- 
    Document   : record_transaction
    Created on : Nov 22, 2013, 3:06:33 PM
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
        <title> Recording transaction...</title>
        <script>
            //Validate the form            
            function valiForm() {
                var flag = true;
                var errorMessage = "";

                var ItemName = document.getElementsByName("advertisement").item(0);
                var type = document.getElementsByName("quantity").item(0);
                var company = document.getElementsByName("accountNumber").item(0);

                if (!ItemName.value) {
                    flag = false;
                    errorMessage += 'Item name is empty \n';
                }

                if ((!type.value)|| isNaN(parseInt(type.value))) {
                    flag = false;
                    errorMessage += 'Type is empty \n';
                }

                if (!company.value) {
                    flag = false;
                    errorMessage += "Company is empty\n";
                }

                if (!flag) {
                    window.alert(errorMessage);
                    return false;
                } else {
                    window.alert("Transaction Recorded");
                    return true;
                }
            }
        </script>
    </head>
    <body>
        <h1>Enter the transaction data: </h1>
        <form method="post" onsubmit="return valiForm()" action="${pageContext.request.contextPath}/TransactionServlet">
            Advertisement : <input type="text" name="advertisement" maxlength="50" /> <br/>      
            Number of Units : <input type="text" name="quantity" maxlength="50"/> <br/>
            Account : <input type="text" name="accountNumber" /><br/>
            <input type="submit" value="Submit" />
        </form>
        <ul>
            <li><a href="${pageContext.request.contextPath}/Employee/employee_home.jsp">Back</a></li>
        </ul>
    </body>
    <p align="center"><a href="/Facebook/documentation.html">Documentation</a> | <a href="/Facebook/usersguide.html">User's Guide</a></p>
</html>
