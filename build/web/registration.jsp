<%-- 
    Document   : register
    Created on : Nov 9, 2013, 11:35:00 AM
    Author     : Kal
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Register</title>
        <script type="text/javascript">
            
            //Validate the form            
            function valiForm(){
                
                var flag = true;
                
                var phoneno_regex = /^\d{3}-\d{3}-\d{4}$/;  
                var date_regex = /^\d{4}-\d{2}-\d{2}$/;
                
                var errorMessage = "";
                
                var firstName = document.getElementById("firstName");
                var lastName = document.getElementsByName("lastName").item(0);
                var address = document.getElementsByName("address").item(0);
                var city = document.getElementsByName("city").item(0);
                var state = document.getElementsByName("state").item(0);
                var zipCode = document.getElementsByName("zipCode").item(0);
                var telephone = document.getElementsByName("telephone").item(0);
                var email = document.getElementsByName("email").item(0);
                var dateOfBirth = document.getElementsByName("dateOfBirth").item(0);
                
                if(!firstName.value) {
                    flag = false;
                    errorMessage += 'First Name is empty \n';
                } 
                
                if(!lastName.value) {
                    flag = false;
                    errorMessage += 'Last Name is empty \n';
                }                
                
                if(!city.value) {
                    flag = false;
                    errorMessage += "City is empty \n";
                }
                
                if(!state.value) {
                    flag = false;
                    errorMessage += "State is not selected \n";
                }
                
                if(!zipCode.value || isNaN(parseInt(zipCode.value)) || zipCode.value.length != 5){
                    flag = false;
                    errorMessage += "ZipCode is empty or not formatted properly \n"
                }
                
                if(!email.value) {
                    flag = false;
                    errorMessage += "Email is empty \n";
                }
                
                if(!telephone.value.match(phoneno_regex)) {
                    flag = false;
                    errorMessage += "Telephone is empty \n";
                }
                
                if(!dateOfBirth.value.match(date_regex)) {
                    flag = false;
                    errorMessage += "Date of Birth is not in correct format \n";
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
        <h1>User Registration Page</h1>
        <form method="post" onsubmit="return valiForm()" action="${pageContext.request.contextPath}/RegistrationServlet"  >
            First Name: <input type="text" maxLength="50" id="firstName" name="firstName" /> <br/> 
            Last Name: <input type="text" maxLength="50" name="lastName" /> <br/>
            Date of Birth : <input type="text" maxlength="10" name="dateOfBirth" /> **YEAR-MM-DD <br/>
            Address : <input type="text" maxlength="50" name="address" /> <br/>
            City : <input type="text" maxlength="50" name="city" /> <br/>
            State: 
            <select name="state" size="1">
                <option selected value="">State...</option>
                <option value="None">None</option>
                <option value="">-- UNITED STATES --</option>
                <option value="Alabama">Alabama</option>
                <option value="Alaska">Alaska</option>
                <option value="Arizona">Arizona</option>
                <option value="Arkansas">Arkansas</option>
                <option value="California">California</option>
                <option value="Colorado">Colorado</option>
                <option value="Connecticut">Connecticut</option>
                <option value="Delaware">Delaware</option>
                <option value="Florida">Florida</option>
                <option value="Georgia">Georgia</option>
                <option value="Hawaii">Hawaii</option>
                <option value="Idaho">Idaho</option>
                <option value="Illinois">Illinois</option>
                <option value="Indiana">Indiana</option>
                <option value="Iowa">Iowa</option>
                <option value="Kansas">Kansas</option>
                <option value="Kentucky">Kentucky</option>
                <option value="Louisiana">Louisiana</option>
                <option value="Maine">Maine</option>
                <option value="Maryland">Maryland</option>
                <option value="Massachusetts">Massachusetts</option>
                <option value="Michigan">Michigan</option>
                <option value="Minnesota">Minnesota</option>
                <option value="Mississippi">Mississippi</option>
                <option value="Missouri">Missouri</option>
                <option value="Montana">Montana</option>
                <option value="Nebraska">Nebraska</option>
                <option value="Nevada">Nevada</option>
                <option value="New Hampshire">New Hampshire</option>
                <option value="New Jersey">New Jersey</option>
                <option value="New Mexico">New Mexico</option>
                <option value="New York">New York</option>
                <option value="North Carolina">North Carolina</option>
                <option value="North Dakota">North Dakota</option>
                <option value="Ohio">Ohio</option>
                <option value="Oklahoma">Oklahoma</option>
                <option value="Oregon">Oregon</option>
                <option value="Pennsylvania">Pennsylvania</option>
                <option value="Rhode Island">Rhode Island</option>
                <option value="South Carolina">South Carolina</option>
                <option value="South Dakota">South Dakota</option>
                <option value="Tennessee">Tennessee</option>
                <option value="Texas">Texas</option>
                <option value="Utah">Utah</option>
                <option value="Vermont">Vermont</option>
                <option value="Virginia">Virginia</option>
                <option value="Washington">Washington</option>
                <option value="West Virginia">West Virginia</option>
                <option value="Wisconsin">Wisconsin</option>
                <option value="Wyoming">Wyoming</option>
                <option value="">-- CANADA --</option>
                <option value="Alberta">Alberta</option>
                <option value="British Columbia">British Columbia</option>
                <option value="Manitoba">Manitoba</option>
                <option value="New Brunswick">New Brunswick</option>
                <option value="Newfoundland and Labrador">Newfoundland and Labrador</option>
                <option value="Northwest Territories">Northwest Territories</option>
                <option value="Nova Scotia">Nova Scotia</option>
                <option value="Nunavut">Nunavut</option>
                <option value="Ontario">Ontario</option>
                <option value="Prince Edward Island">Prince Edward Island</option>
                <option value="Quebec">Quebec</option>
                <option value="Saskatchewan">Saskatchewan</option>
                <option value="Yukon Territory">Yukon Territory</option>
                <option value="">-- AUSTRALIA --</option>
                <option value="Australian Capital Territory">Australian Capital Territory</option>
                <option value="New South Wales">New South Wales</option>
                <option value="Northern Territory">Northern Territory</option>
                <option value="Queensland">Queensland</option>
                <option value="South Australia">South Australia</option>
                <option value="Tasmania">Tasmania</option>
                <option value="Victoria">Victoria</option>
                <option value="Western Australia">Western Australia</option>
            </select>
            <br/>
            Zip Code: <input type="text" maxlength="5" name="zipCode" /> <br/>
            Telephone: <input type="text" maxlength="12" name="telephone" /> **XXX-XXX-XXXX <br/>
            Email: <input type="text" maxlength="50" name="email" /> <br/>
            
            Gender: <input type="radio" name="gender" value="M"/> Male &nbsp; <input type="radio" name="gender" value="F" /> Female <br/>
            
            <input type="submit" value="Submit" />
            
        </form>
    </body>
    <p align="center"><a href="/Facebook/documentation.html">Documentation</a> | <a href="/Facebook/usersguide.html">User's Guide</a></p>
    
</html>
