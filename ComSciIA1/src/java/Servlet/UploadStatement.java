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

@WebServlet(name = "UploadStatement", urlPatterns = {"/UploadStatement"})
@MultipartConfig(fileSizeThreshold = 1024 * 1024 * 10, // 10 MB
        maxFileSize = 1024 * 1024 * 1000, // 1 GB
        maxRequestSize = 1024 * 1024 * 1000)   	// 1 GB
public class UploadStatement extends HttpServlet {

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
            Part stex = request.getPart("statementExcel");
            Part stpdf = request.getPart("statementPDF");
            Part vat = request.getPart("VAT");
            Part pnd = request.getPart("PND");
            Part profit = request.getPart("profit");
            String company = request.getParameter("Company");
            int year = Integer.parseInt(request.getParameter("Year"));
            
            String stexFileName = stex.getSubmittedFileName();
            String stpdfFileName = stpdf.getSubmittedFileName();
            String vatFileName = vat.getSubmittedFileName();
            String pndFileName = pnd.getSubmittedFileName();
            String profitFileName = profit.getSubmittedFileName();
            
            InputStream isstex = stex.getInputStream();
            InputStream isstpdf = stpdf.getInputStream();
            InputStream isvat = vat.getInputStream();
            InputStream ispnd = pnd.getInputStream();
            InputStream isprofit = profit.getInputStream();
                
            Files.copy(isstex, Paths.get(uploadPath + File.separator + stexFileName), StandardCopyOption.REPLACE_EXISTING);
            Files.copy(isstpdf, Paths.get(uploadPath + File.separator + stpdfFileName), StandardCopyOption.REPLACE_EXISTING);
            Files.copy(isvat, Paths.get(uploadPath + File.separator + vatFileName), StandardCopyOption.REPLACE_EXISTING);
            Files.copy(ispnd, Paths.get(uploadPath + File.separator + pndFileName), StandardCopyOption.REPLACE_EXISTING);
            Files.copy(isprofit, Paths.get(uploadPath + File.separator + profitFileName), StandardCopyOption.REPLACE_EXISTING);

            try {
                JOconnection.JConnect();
                String sql = "insert into financialstatement(company, year, excelStatement, pdfStatement, vatSummary, pnd50, excelProfitAndInterest) values(?, ?, ?, ?, ?, ?, ?)";
                ps=JOconnection.conn.prepareStatement(sql);
		ps.setString(1,company);
                ps.setInt(2,year);
                ps.setString(3,stexFileName);
                ps.setString(4,stpdfFileName);
                ps.setString(5,vatFileName);
                ps.setString(6,pndFileName);
                ps.setString(7,profitFileName);
                
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
                java.util.logging.Logger.getLogger(UploadStatement.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
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