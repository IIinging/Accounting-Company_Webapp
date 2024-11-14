package Servlet;

import OOP.JOconnection;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.MultipartConfig;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import jakarta.servlet.http.Part;
//Upload file to mySQL code from https://github.com/Java-Hub18/Servlet-JSP/tree/11ba5e0f8d56be4e8a847ec3d4df1f99623ae2c0/ServletUploadDownloadFile
@WebServlet(name = "UploadComReg", urlPatterns = {"/UploadComReg"})
@MultipartConfig(fileSizeThreshold = 1024 * 1024 * 10, // 10 MB
        maxFileSize = 1024 * 1024 * 1000, // 1 GB
        maxRequestSize = 1024 * 1024 * 1000)   	// 1 GB
public class UploadComReg extends HttpServlet {

    PrintWriter out = null;
    PreparedStatement ps = null;

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/plain;charset=UTF-8");
        try {
            out = response.getWriter();
            request.getSession(false);
            String folderName = "Files";
            String uploadPath = request.getServletContext().getRealPath("") + File.separator + folderName;
            File dir = new File(uploadPath);
            if (!dir.exists()) {
                dir.mkdirs();
            }
            Part cer = request.getPart("Certificate");
            Part boj = request.getPart("BOJ5");
            Part isic = request.getPart("ISIC");
            Part loan = request.getPart("LoanAgreement");
            String company = request.getParameter("Company");
            String user = request.getParameter("Accountant");
            String date = request.getParameter("date");
            
            String cerFileName = cer.getSubmittedFileName();
            String bojFileName = boj.getSubmittedFileName();
            String isicFileName = isic.getSubmittedFileName();
            String loanFileName = loan.getSubmittedFileName();
            
            InputStream isCer = cer.getInputStream();
            InputStream isBOJ = boj.getInputStream();
            InputStream isISIC = isic.getInputStream();
            InputStream isLoan = loan.getInputStream();
                
            Files.copy(isCer, Paths.get(uploadPath + File.separator + cerFileName), StandardCopyOption.REPLACE_EXISTING);
            Files.copy(isBOJ, Paths.get(uploadPath + File.separator + bojFileName), StandardCopyOption.REPLACE_EXISTING);
            Files.copy(isISIC, Paths.get(uploadPath + File.separator + isicFileName), StandardCopyOption.REPLACE_EXISTING);
            Files.copy(isLoan, Paths.get(uploadPath + File.separator + loanFileName), StandardCopyOption.REPLACE_EXISTING);

            try {
                JOconnection.JConnect();
                String sql = "insert into companyregistration(company, accountant, date, certificate, boj5, isic, loanAgreement) values(?, ?, ?, ?, ?, ?, ?)";
                ps=JOconnection.conn.prepareStatement(sql);
		ps.setString(1,company);
                ps.setString(2,user);
                ps.setString(3,date);
                ps.setString(4,cerFileName);
                ps.setString(5,bojFileName);
                ps.setString(6,isicFileName);
                ps.setString(7,loanFileName);
                
                int status = ps.executeUpdate();
                if (status > 0) {
                    System.out.println("File uploaded successfully...");
                    System.out.println("Uploaded Path: " + uploadPath);
                    response.sendRedirect("index2.jsp");                    
                }
            } catch (SQLException e) {
                out.println("Exception: " + e);
                System.out.println("Exception1: " + e);
            } catch (ClassNotFoundException ex) {
                java.util.logging.Logger.getLogger(UploadComReg.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
            } finally {
                try {
                    if (ps != null) {
                        ps.close();
                    }
                    if (JOconnection.conn != null) {
                        JOconnection.conn.close();
                    }
                } catch (SQLException e) {
                    out.println(e);
                }
            }

        } catch (IOException | ServletException e) {
            out.println("Exception: " + e);
            System.out.println("Exception2: " + e);
        }
    }

}