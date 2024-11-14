<%@page import="OOP.Company"%>
<%@page import="OOP.CompanyDAO"%>
<%@page import="OOP.CompanyRegistration"%>
<%@page import="OOP.ComRegDAO"%>
<%@page import="OOP.User"%>
<%@page import="java.util.ArrayList" %>
<%@page import="java.util.LinkedList" %>
<!DOCTYPE html>
<!-- Dashboard template from https://startbootstrap.com/template/sb-admin -->
<html lang="en">
    <head>
        <meta charset="utf-8" />
        <meta http-equiv="X-UA-Compatible" content="IE=edge" />
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no" />
        <meta name="description" content="" />
        <meta name="author" content="" />
        <title>Dashboard</title>
        <link href="https://cdn.jsdelivr.net/npm/simple-datatables@7.1.2/dist/style.min.css" rel="stylesheet" />
        <link href="css/bootstrap.css" rel="stylesheet" />
        <link href="css/bootstrap-grid.css" rel="stylesheet" />
        <link href="css/bootstrap-reboot.css" rel="stylesheet" />
        <link href="css/Home.css" rel="stylesheet" />
        <script src="https://use.fontawesome.com/releases/v6.3.0/js/all.js" crossorigin="anonymous"></script>
    </head>
    <body class="sb-nav-fixed">
        <nav class="sb-topnav navbar navbar-expand navbar-dark bg-dark">
            <!-- Navbar Brand-->
            <a class="navbar-brand ps-3" href="index2.html">Pattara</a>
            
            <!-- Sidebar Toggle-->
            <button class="btn btn-link btn-sm order-1 order-lg-0 me-4 me-lg-0" id="sidebarToggle"><i class="fas fa-bars"></i></button>
            <!-- Navbar-->
            <ul class="navbar-nav ms-auto me-4">
                <li class="nav-item dropdown">
                    <a class="nav-link dropdown-toggle" id="navbarDropdown" href="#" role="button" data-bs-toggle="dropdown" aria-expanded="false"><i class="fas fa-user fa-fw"></i></a>
                    <ul class="dropdown-menu dropdown-menu-end" aria-labelledby="navbarDropdown">
                        <li><a class="dropdown-item" href="index.html">Logout</a></li>
                    </ul>
                </li>
            </ul>
        </nav>
        <div id="layoutSidenav">
            <div id="layoutSidenav_nav">
                <nav class="sb-sidenav accordion sb-sidenav-dark" id="sidenavAccordion">
                    <div class="sb-sidenav-menu">
                        <div class="nav">
                            <div class="sb-sidenav-menu-heading">Core</div>
                            <a class="nav-link" href="index2.jsp">
                                <div class="sb-nav-link-icon"><i class="fas fa-tachometer-alt"></i></div>
                                Dashboard
                            </a>
                            
<%
    User login = (User) session.getAttribute("login");
    if (login.isManager() || login.isAdmin()){
%>
                            <div class="sb-sidenav-menu-heading">Function</div>
                            <a class="nav-link collapsed" href="#" data-bs-toggle="collapse" data-bs-target="#collapseLayouts" aria-expanded="false" aria-controls="collapseLayouts">
                                <div class="sb-nav-link-icon"><i class="fas fa-columns"></i></div>
                                Add
                                <div class="sb-sidenav-collapse-arrow"><i class="fas fa-angle-down"></i></div>
                            </a>
                            <div class="collapse" id="collapseLayouts" aria-labelledby="headingOne" data-bs-parent="#sidenavAccordion">
                                <nav class="sb-sidenav-menu-nested nav">
                                    <a class="nav-link" href="addCompany.jsp">Add company</a>
                                    <a class="nav-link" href="addComReg.jsp">Add company registration</a>
                                    <a class="nav-link" href="addStatement.jsp">Add financial statement</a>
                                </nav>
                            </div>
<%
    }
    if (login.isAdmin()){
%>
                            <div class="sb-sidenav-menu-heading">Manage</div>
                            <a class="nav-link" href="User.jsp">
                                <div class="sb-nav-link-icon"><i class="fas fa-table"></i></div>
                                Users
                            </a>
<%
    }
%>                            
                        </div>
                    </div>
                </nav>
            </div>
            <div id="layoutSidenav_content">
                <main>
                    <div class="container-fluid px-4">
                        <h1 class="mt-4">Dashboard</h1>
                        
<%
    if (login.isManager() || login.isAdmin()){
%>                        
                        <div class="row">
                            <div class="col">
                                <div class="card bg-primary text-white mb-4">
                                    <div class="card-body">Add company</div>
                                    <div class="card-footer d-flex align-items-center justify-content-between">
                                        <a class="small text-white stretched-link" href="addCompany.jsp">Go</a>
                                        <div class="small text-white"><i class="fas fa-angle-right"></i></div>
                                    </div>
                                </div>
                            </div>
                            <div class="col">
                                <div class="card bg-warning text-white mb-4">
                                    <div class="card-body">Add company registration</div>
                                    <div class="card-footer d-flex align-items-center justify-content-between">
                                        <a class="small text-white stretched-link" href="addComReg.jsp">Go</a>
                                        <div class="small text-white"><i class="fas fa-angle-right"></i></div>
                                    </div>
                                </div>
                            </div>
                            <div class="col">
                                <div class="card bg-success text-white mb-4">
                                    <div class="card-body">Add financial statement</div>
                                    <div class="card-footer d-flex align-items-center justify-content-between">
                                        <a class="small text-white stretched-link" href="addStatement.jsp">Go</a>
                                        <div class="small text-white"><i class="fas fa-angle-right"></i></div>
                                    </div>
                                </div>
                            </div>
                        </div>
<%
    }
%>

                        <div class="card mb-4">
                            <div class="card-header">
                                <i class="fas fa-table me-1"></i>
                                Company List
                            </div>
                            <div class="card-body">
                                <table id="datatablesSimple">
                                    <thead>
                                        <tr>
                                            <th>Name</th>
                                            <th>Employee In Charge</th>
                                            <th>Phone Number</th>
                                            <th>Action</th>
                                        </tr>
                                    </thead>
                                    <tbody>
<%
    CompanyDAO companyDAO = new CompanyDAO();
    ArrayList<Company> companyList = companyDAO.getAllCompanies();
    for(Company company : companyList) {
%>
                                        <tr>
                                            <td><%= company.getName() %></td>
                                            <td><%= company.getEmployeeInCharge().getUsername()%></td>
                                            <td><%= company.getPhoneNumber()%></td>
                                            <td class="candidate-list-favourite-time text-right">
                                                <div class="btn-group" role="group">
                                                    <form action="CompanyView.jsp">
                                                        <button class="btn btn-info btn-sm me-1" data-toggle="tooltip" title="View" type="submit"
                                                            name="id" value="<%= company.getID() %>">
                                                            <i class="far fa-eye"></i>
                                                        </button>
                                                    </form>
<%
    if (login.isAdmin()){
%>   
                                                    <form action="DeleteCompany">
                                                        <button class="btn btn-danger btn-sm" data-toggle="tooltip" title="Delete"
                                                            name="id" value="<%= company.getID() %>">
                                                            <i class="far fa-trash-alt"></i>
                                                        </button>
                                                    </form>
<%
    }
%>                                                              
                                                </div>
                                            </td>
                                        </tr>
<%
    }
%>                                        
                                    </tbody>
                                </table>
                            </div>
                        </div>
                        
                        <div class="card mb-4">
                            <div class="card-header">
                                <i class="fas fa-table me-1"></i>
                                Company Registration List
                            </div>
                            <div class="card-body">
                                <table id="datatablesSimple1">
                                    <thead>
                                        <tr>
                                            <th>Company</th>
                                            <th>Accountant</th>
                                            <th>Date</th>
                                            <th>Certificate</th>
                                            <th>BOJ5</th>
                                            <th>ISIC</th>
                                            <th>Loan Agreement</th>
<%
    if (login.isAdmin()){
%>                                               
                                            <th>Action</th>
<%
    }
%>                                               
                                        </tr>
                                    </thead>
                                    <tbody>
<%
    ComRegDAO comregDAO = new ComRegDAO();
    LinkedList<CompanyRegistration> comregList = comregDAO.getAllComReg();
    for(CompanyRegistration comreg : comregList) {
%>
                                        <tr>
                                            <td><%= comreg.getCompany() %></td>
                                            <td><%= comreg.getAccountant().getUsername()%></td>
                                            <td><%= comreg.getDate()%></td>
                                            <td><a href="getFiles?fileName=<%= comreg.getCertificate()%>">Download</a></td>
                                            <td><a href="getFiles?fileName=<%= comreg.getBoj5()%>">Download</a></td>
                                            <td><a href="getFiles?fileName=<%= comreg.getIsic()%>">Download</a></td>
                                            <td><a href="getFiles?fileName=<%= comreg.getLoanAgreement()%>">Download</a></td>
<%
    if (login.isAdmin()){
%>                                               
                                            <td class="candidate-list-favourite-time text-right">
                                                    <form action="DeleteComReg">
                                                        <button class="btn btn-danger btn-sm" data-toggle="tooltip" title="Delete"
                                                            name="id" value="<%= comreg.getID() %>">
                                                            <i class="far fa-trash-alt"></i>
                                                        </button>
                                                    </form>
                                            </td>
<%
    }
%>                                             
                                        </tr>
<%
    }
%>                                        
                                    </tbody>
                                </table>
                            </div>
                        </div>
                    </div>
                </main>   
            </div>
        </div>
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.bundle.min.js" crossorigin="anonymous"></script>
        <script src="js/scripts.js"></script>
        <script src="https://cdn.jsdelivr.net/npm/simple-datatables@7.1.2/dist/umd/simple-datatables.min.js" crossorigin="anonymous"></script>
        <script src="js/datatables-simple-demo.js"></script>
        <script src="js/datatables-simple-demo_1.js"></script>
        
    </body>
</html>
