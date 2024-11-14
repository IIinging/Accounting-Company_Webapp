/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package OOP;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.LinkedList;

/**
 *
 * @author IngIng
 */
public class ComRegDAO {
    public LinkedList<CompanyRegistration> getAllComReg() {
        LinkedList<CompanyRegistration> ComRegList = new LinkedList<>();
        try {
            JOconnection.JConnect(); // Establish connection using JOconnection class

            String selectquery = ("SELECT * FROM companyregistration");
            JOconnection.rslt = JOconnection.stmt.executeQuery(selectquery);

            while (JOconnection.rslt.next()) {
                CompanyRegistration ComReg = new CompanyRegistration(
                        JOconnection.rslt.getString("company"),
                        UserDAO.getUserByName(JOconnection.rslt.getString("accountant")), 
                        JOconnection.rslt.getString("date"),
                        JOconnection.rslt.getString("certificate"),
                        JOconnection.rslt.getString("boj5"),
                        JOconnection.rslt.getString("isic"),
                        JOconnection.rslt.getString("loanAgreement"),
                        JOconnection.rslt.getInt("id")
                );

                ComRegList.add(ComReg);
            }
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        } finally {
            try {
                JOconnection.conn.close(); // Close the connection in the finally block
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return ComRegList;
    }
}
