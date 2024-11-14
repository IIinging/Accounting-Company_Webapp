<%-- 
    Document   : addCompany
    Created on : Jan 4, 2024, 12:26:35 PM
    Author     : IngIng
--%>

<%@page import="OOP.JOconnection"%>
<%@page import="OOP.UserDAO"%>
<%@page import="OOP.User"%>
<%@page import="java.util.ArrayList" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<!-- Form template from https://getbootstrap.com/docs/4.0/components/forms/-->
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="css/bootstrap.css">
        <link rel="stylesheet" href="css/bootstrap-grid.css">
        <link rel="stylesheet" href="css/bootstrap-reboot.css">
    </head>
    <body>
        <div class="col-md-6 offset-md-3 mt-5">
            <h1>Add Company</h1>
            <form accept-charset="UTF-8" action="UploadCompany" method="POST" enctype="multipart/form-data" target="_blank">
                <div class="form-group">
                    <label for="Name" required="required">Company Name</label>
                    <input type="text" name="name" class="form-control" id="Name" placeholder="Enter company name" >
                </div>

                <div class="form-group">
                    <label for="FormControlSelect1">Select Employee</label>
                    <select class="form-control" id="FormControlSelect1" name="employee" required="required">
                        <option>Select</option>
                        <%
                            UserDAO userDAO = new UserDAO();
                            ArrayList<User> userList = userDAO.getAllUsers();
                            for(User user : userList) {
                        %>              
                        <option><%= user.getUsername() %></option>
                        <%
                            }
                        %>
                    </select>
                </div>

                <div class="form-group">
                    <label for="PhoneNum" required="required">Phone Number</label>
                    <input type="text" name="phoneNum" class="form-control" id="PhoneNum" placeholder="Enter phone number">
                </div>

                <button type="submit" class="btn btn-primary">Submit</button>
            </form>
        </div> 
    </body>
</html>
