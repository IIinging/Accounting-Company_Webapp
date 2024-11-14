package Servlet;

import OOP.JOconnection;
import java.io.IOException;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.MultipartConfig;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
//Upload file to mySQL code from https://github.com/Java-Hub18/Servlet-JSP/tree/11ba5e0f8d56be4e8a847ec3d4df1f99623ae2c0/ServletUploadDownloadFile

@WebServlet(name = "UploadCompany", urlPatterns = {"/UploadCompany"})
@MultipartConfig(fileSizeThreshold = 1024 * 1024 * 10, // 10 MB
        maxFileSize = 1024 * 1024 * 1000, // 1 GB
        maxRequestSize = 1024 * 1024 * 1000)   	// 1 GB
public class UploadCompany extends HttpServlet {

    PreparedStatement ps = null;

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/plain;charset=UTF-8");
        try {
 
            String name = request.getParameter("name");
            String employee = request.getParameter("employee");
            String phoneNum = request.getParameter("phoneNum");

            try {
                JOconnection.JConnect();
                String sql = "insert into company(name, employeeInCharge, phoneNumber) values(?, ?, ?)";
                ps=JOconnection.conn.prepareStatement(sql);
		ps.setString(1,name);
                ps.setString(2,employee);
                ps.setString(3,phoneNum);
                
                int status = ps.executeUpdate();
                if (status > 0) {
                    response.sendRedirect("index2.jsp");                    
                }
            } catch (SQLException e) {
                System.out.println("Exception1: " + e);
            } catch (ClassNotFoundException ex) {
                java.util.logging.Logger.getLogger(UploadCompany.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
            } finally {
                try {
                    if (ps != null) {
                        ps.close();
                    }
                    if (JOconnection.conn != null) {
                        JOconnection.conn.close();
                    }
                } catch (SQLException e) {
                    System.out.println(e);
                }
            }

        } catch (IOException e) {
            System.out.println("Exception2: " + e);
        }
    }

}