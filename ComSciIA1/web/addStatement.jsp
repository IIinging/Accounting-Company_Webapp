<%-- 
    Document   : addStatement
    Created on : Jan 4, 2024, 12:07:33 PM
    Author     : IngIng
--%>
<%@page import="OOP.Company"%>
<%@page import="OOP.JOconnection"%>
<%@page import="OOP.CompanyDAO"%>
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
        <h1>Add Financial Statement</h1>
        <form accept-charset="UTF-8" action="UploadStatement" method="POST" enctype="multipart/form-data" target="_blank">

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
            <label for="FormControlSelect2">Select Year</label>
            <select class="form-control" id="FormControlSelect2" name="Year" required="required">
                <option>Select</option>
<%
    for(int i = 2000; i < 2100; i++) {
%>              
                <option><%= i %></option>
<%
    }
%>
            </select>
          </div>
            
          <hr>
          <div class="form-group mt-3">
            <label class="mr-2">Upload Statement.Excel:</label>
            <input type="file" name="statementExcel">
          </div>
          <hr>
          
          <hr>
          <div class="form-group mt-3">
            <label class="mr-2">Upload Statement.PDF:</label>
            <input type="file" name="statementPDF">
          </div>
          <hr>
          
          <hr>
          <div class="form-group mt-3">
            <label class="mr-2">Upload VAT Summary:</label>
            <input type="file" name="VAT">
          </div>
          <hr>
          
          <hr>
          <div class="form-group mt-3">
            <label class="mr-2">Upload PND50:</label>
            <input type="file" name="PND">
          </div>
          <hr>
          
          <hr>
          <div class="form-group mt-3">
            <label class="mr-2">Upload ProfitAndInterest.Excel:</label>
            <input type="file" name="profit">
          </div>
          <hr>
          
          <button type="submit" class="btn btn-primary">Submit</button>
        </form>
    </div> 
    </body>
</html>
