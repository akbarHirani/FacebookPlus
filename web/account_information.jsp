<%-- 
    Document   : account_information
    Created on : Nov 15, 2013, 4:27:34 PM
    Author     : Kal
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Account Information</title>
        <style>
            a {
                color:green;
                font-size:200%;
            }
            
            
        </style>
        <script type="text/javascript">
            
            //Validate the form            
            function validateForm(){
                
                var flag = true;
                
                var phoneno_regex = /^\d{10}$/;  
                var email_regex = /^([0-9a-zA-Z]([-\.\w]*[0-9a-zA-Z])*@([0-9a-zA-Z][-\w]*[0-9a-zA-Z]\.)+[a-zA-Z]{2,9})$/;

                var errorMessage = "";

                var zipcode = document.getElementsByName("zipcode").item(0);
                var telephone = document.getElementsByName("telephone").item(0);
                var email = document.getElementsByName("email").item(0);

                if(telephone.value && !telephone.value.match(phoneno_regex)) {
                    flag = false;
                    errorMessage += "Telephone should be numbers only, no dashes \n";
                }
                
                if(email.value && !email.value.match(email_regex)){
                    flag = false;
                    errorMessage += "Email is incorrectly formatted ie : XXXX@YYY.ZZZ \n";
                }
               
                if(zipcode.value && (isNaN(parseInt(zipcode.value)) || zipcode.value.length != 5)){
                    flag = false;
                    errorMessage += "Zip Code is not formatted properly \n"
                }
                
                if(!flag) {
                    window.alert(errorMessage);
                    return false;
                } else {
                    return true;
                }
            }
        </script>
    </head>
    <body>
        <h1>Account Information</h1>
        
        <p> First Name : ${person.firstName} </p>
        
        <p> Last Name : ${person.lastName} </p>

        <p> User ID : ${person.userID} </p>
        
        <p> Address : ${person.address} </p>
        
        <p> City: ${person.city} </p>
        
        <p> State: ${person.state} </p>
        
        <p> Zip Code: ${person.zipCode} </p>
        
        <p> Telephone: ${person.telephone}</p>
        
        <p> Email: ${person.email} </p>
            
        <p> Date of Birth: ${person.dateOfBirth} </p>
        
        <p> Gender: ${person.gender} </p>
        
        <h2>Edit your information:</h2>
        
        <form action="${pageContext.request.contextPath}/EditInfoServlet" onsubmit="return validateForm()">

            <p> Address : <input type="text" name="address" maxlength="50" /> </p>       

            <p> City : <input type="text" name="city" maxlength="50"/> </p>

            <p> State : <input type="text" name="state" /></p>

            <p> Zip Code : <input type="text" name="zipcode" /> </p>

            <p> Telephone: <input type="text" name="telephone" /> ** Only numbers </p> 

            <p> Email Address: <input type="text" name="email" /> 

            <p> <input type="submit" value="Edit" /></p>
            
        </form>
        <a href="/Facebook/user/account_home.jsp">Home</a> <br />
    </body>
    <p align="center"><a href="/Facebook/documentation.html">Documentation</a> | <a href="/Facebook/usersguide.html">User's Guide</a></p>    
</html>
