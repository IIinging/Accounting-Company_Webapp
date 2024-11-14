<%@page import="OOP.JOconnection"%>
<%@page language="java" import="java.sql.*"%>
<%@page import="java.io.*"%>
<!--Sign up template from https://github.com/y2kstack/Archives/blob/b8fe4d0b87efd27199828ffadb8d2b2622100ca5/_posts/2019-01-26-Project-part1-signuppage.md-->
<%
    try {
        ResultSet rs = null;
        Class.forName("com.mysql.cj.jdbc.Driver");
        Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/mydb", "root", "Ii18012006");
        Statement stmt = con.createStatement();
        String firstname = request.getParameter("firstname");
        String lastname = request.getParameter("lastname");
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        String email = request.getParameter("email");
        String mobileNum = request.getParameter("mobileNum");
        String access = request.getParameter("access");

        JOconnection.JConnect();
        String checkUsernameQuery = "SELECT * FROM register WHERE username = ?";
        try (PreparedStatement checkUsernameStmt = JOconnection.conn.prepareStatement(checkUsernameQuery)) {
            checkUsernameStmt.setString(1, username);
            ResultSet resultSet = checkUsernameStmt.executeQuery();

            if (resultSet.next()) {
                // Username already exists, show an error message using JavaScript
%>
<script>
                    alert("Username already exists. Please choose another username.");
                    window.location.href = "signup.html"; 
</script>
<%
            } else {
                stmt.executeUpdate("insert into register values('" + firstname + "','" + lastname + "','" + username + "','" + password + "','" + email + "','" + mobileNum + "','" + access + "')");
                response.sendRedirect("index.html");
            }
        }

        con.close();
        stmt.close();
    } catch (ClassNotFoundException | SQLException e) {
        out.println(e.getMessage());
    }
%>
