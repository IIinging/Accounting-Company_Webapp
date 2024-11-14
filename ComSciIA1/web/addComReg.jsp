<%-- 
    Document   : addComReg
    Created on : Jan 4, 2024, 12:07:33?PM
    Author     : IngIng
--%>
<%@page import="OOP.Company"%>
<%@page import="OOP.JOconnection"%>
<%@page import="OOP.CompanyDAO"%>
<%@page import="OOP.UserDAO"%>
<%@page import="OOP.User"%>
<%@page import="java.util.ArrayList" %>
<%@ page language = "java" contentType="text/html; charsetISO-8859-1" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<!-- Form template from https://getbootstrap.com/docs/4.0/components/forms/-->
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="css/bootstrap.css">
        <link rel="stylesheet" href="css/bootstrap-grid.css">
        <link rel="stylesheet" href="css/bootstrap-reboot.css">
        <style>
            h1 {
                font-size: 20px;
                margin-top: 24px;
                margin-bottom: 24px;
              }

              img {
              height: 60px;
              }
        </style>
    </head>
    <body>
        <div class="col-md-6 offset-md-3 mt-5">
        <h1>Add Company Registration</h1>
        <form action="UploadComReg" method="post" enctype="multipart/form-data">

          <div class="form-group">
            <label for="FormControlSelect1">Select Company</label>
            <select class="form-control" id="FormControlSelect1" name="Company" required="required">
                <option>Select</option>
<%
    CompanyDAO companyDAO = new CompanyDAO();
    ArrayList<Company> companyList = companyDAO.getAllCompanies();
    for(Company company : companyList) {
%>              
                <option><%= company.getName() %></option>
<%
    }
%>
            </select>
          </div>
            
          <div class="form-group">
            <label for="FormControlSelect2">Select Accountant</label>
            <select class="form-control" id="FormControlSelect2" name="Accountant" required="required">
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
            <label for="Date" required="required">Date</label>
            <input type="date" name="date" class="form-control" id="Date">
          </div>
            
          <hr>
          <div class="form-group mt-3">
            <label class="mr-2">Upload Certificate:</label>
            <input type="file" name="Certificate">
          </div>
          <hr>
          
          <hr>
          <div class="form-group mt-3">
            <label class="mr-2">Upload BOJ5:</label>
            <input type="file" name="BOJ5">
          </div>
          <hr>
          
          <hr>
          <div class="form-group mt-3">
            <label class="mr-2">Upload ISIC:</label>
            <input type="file" name="ISIC">
          </div>
          <hr>
          
          <hr>
          <div class="form-group mt-3">
            <label class="mr-2">Upload Loan Agreement:</label>
            <input type="file" name="LoanAgreement">
          </div>
          <hr>
          
          <button type="submit" class="btn btn-primary">Submit</button>
        </form>
    </div> 
          
    </body>
</html>
