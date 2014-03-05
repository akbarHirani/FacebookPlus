<%-- 
    Document   : advertisement_create
    Created on : Nov 21, 2013, 1:14:28 AM
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
        <title>Advertisement Creation</title>
        <script type="text/javascript">
            
            //Validate the form            
            function valiForm(){
                var flag = true;
                var errorMessage = "";
                
                var ItemName = document.getElementsByName("itemname");
                var type = document.getElementsByName("type").item(0);
                var company = document.getElementsByName("company").item(0);
                var content = document.getElementsByName("content").item(0);
                var unitPrice = document.getElementsByName("unitPrice").item(0);
                var availableUnits = document.getElementsByName("numberOfAvailableUnits").item(0);
                
                
                if(!ItemName.value) {
                    flag = false;
                    errorMessage += 'Item name is empty \n';
                } 
                
                if(!type.value) {
                    flag = false;
                    errorMessage += 'Type is empty \n';
                }
                
                if(!company.value  )  {
                    flag = false;
                    errorMessage += "Company is empty\n";
                } 
                
                if(!content.value) {
                    flag = false;
                    errorMessage += "Description is empty \n";
                }
                
                if((!unitPrice.value)|| Long.parse(unitPrice)<0) {
                    flag = false;
                    errorMessage += "Price is empty or not formatted \n";
                }
                
                if((!availableUnits.value) || isNaN(parseInt(availableUnits.value))||parseInt(availableUnits.value)<=0){
                    flag = false;
                    errorMessage += "quantity is empty or not formatted properly \n"
                }
                
                if(!flag) {
                    window.alert(errorMessage);
                    return false;
                } else {
                    window.alert("Insertion Complete");
                    return true;
                }
            }
        </script>
    </head>
    <body>
        <h1>Create an Advertisement:</h1>
        <form method="post" onsubmit="return valiForm()" action="${pageContext.request.contextPath}/AdvertisementCreationServlet">

             Item Name : <input type="text" name="itemName" maxlength="50" /> <br/>      

             Type : <input type="text" name="type" maxlength="50"/> <br/>

             Company : <input type="text" name="company" /><br/>

             Content : <input type="text" name="content" /> <br/>

             Unit Price: <input type="text" name="unitPrice" /> <br/> 

             Number of available units: <input type="text" name="numberOfAvailableUnits" /> <br/>

             <input type="submit" value="Submit" />

        </form>
        <ul>
            <li><a href="${pageContext.request.contextPath}/Employee/advertisements.jsp">Back</a></li>
        </ul>
    </body>
    <p align="center"><a href="/Facebook/documentation.html">Documentation</a> | <a href="/Facebook/usersguide.html">User's Guide</a></p>
</html>
