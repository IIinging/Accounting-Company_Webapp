/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package OOP;

import java.sql.SQLException;
import java.util.LinkedList;

/**
 *
 * @author IngIng
 */
public class StatementDAO {
    public LinkedList<FinancialStatement> getAllStatement() {
        LinkedList<FinancialStatement> StatementList = new LinkedList<>();
        try {
            JOconnection.JConnect(); // Establish connection using JOconnection class

            String selectquery = ("SELECT * FROM financialstatement");
            JOconnection.rslt = JOconnection.stmt.executeQuery(selectquery);

            while (JOconnection.rslt.next()) {
                FinancialStatement Statement = new FinancialStatement(
                        JOconnection.rslt.getString("company"),
                        Integer.parseInt(JOconnection.rslt.getString("year")), 
                        JOconnection.rslt.getString("excelStatement"),
                        JOconnection.rslt.getString("pdfStatement"),
                        JOconnection.rslt.getString("vatSummary"),
                        JOconnection.rslt.getString("pnd50"),
                        JOconnection.rslt.getString("excelProfitAndInterest"),
                        JOconnection.rslt.getInt("id")
                );

                StatementList.add(Statement);
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
        return StatementList;
    }
}
