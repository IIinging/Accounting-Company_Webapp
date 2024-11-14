<%@page import="OOP.JOconnection"%>
<%@page import="OOP.UserDAO"%>
<%@page import="OOP.User"%>
<%@page language="java" import="java.sql.*"%>
<!-- Login template form https://github.com/y2kstack/Archives/blob/b8fe4d0b87efd27199828ffadb8d2b2622100ca5/_posts/2019-01-27-Project-part2-login-page.md -->
<%
try {
    String Username = request.getParameter("username");
    String Password = request.getParameter("password");

    JOconnection.JConnect();

    // Use a prepared statement to avoid SQL injection
    String selectQuery = "SELECT * FROM register WHERE username=? AND password=?";
    
    try (PreparedStatement pstmt = JOconnection.conn.prepareStatement(selectQuery)) {
        pstmt.setString(1, Username);
        pstmt.setString(2, Password);

        JOconnection.rslt = pstmt.executeQuery();

        if (JOconnection.rslt.next()) {
        User Login = UserDAO.getUserByName(Username);
        session.setAttribute("login", Login);
%>
<script>
    window.location.href="http://localhost:8089/ComSciIA1/index2.jsp";
</script>
<%
        } else {
%>
<script>
    alert("Your username or password is wrong. Please try again.");
    window.location.href="http://localhost:8089/ComSciIA1/index.html";
</script>
<%
        }
    }
} catch (ClassNotFoundException | SQLException e) {
    e.printStackTrace();
}
%>
