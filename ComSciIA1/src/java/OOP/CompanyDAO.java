/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package OOP;

/**
 *
 * @author IngIng
 */
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class CompanyDAO {

    // Method to retrieve all companies from the database and map to Company objects
    public ArrayList<Company> getAllCompanies() {
        ArrayList<Company> companyList = new ArrayList<>();
        try {
            JOconnection.JConnect(); // Establish connection using JOconnection class

            String selectquery = ("SELECT * FROM company");
            JOconnection.rslt = JOconnection.stmt.executeQuery(selectquery);

            while (JOconnection.rslt.next()) {
                Company companies = new Company(
                        JOconnection.rslt.getString("name"),
                        UserDAO.getUserByName(JOconnection.rslt.getString("employeeInCharge")), 
                        JOconnection.rslt.getString("phoneNumber"),
                        JOconnection.rslt.getInt("id")
                );

                companyList.add(companies);
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
        return companyList;
    }
    
    public static String getEmployeeByID(int id) {
        try {
            JOconnection.JConnect();

            String selectQuery = "SELECT EmployeeInCharge FROM company WHERE id = ?";
            try (PreparedStatement statement = JOconnection.conn.prepareStatement(selectQuery)) {
                statement.setInt(1, id);

                try (ResultSet resultSet = statement.executeQuery()) {
                    if (resultSet.next()) {
                        return resultSet.getString("employeeInCharge");
                    } else {
                        return null;
                    }
                }
            }
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
            return null;
        } finally {
            try {
                JOconnection.conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
    
    public static String getPhoneByID(int id) {
        try {
            JOconnection.JConnect();

            String selectQuery = "SELECT phoneNumber FROM company WHERE id = ?";
            try (PreparedStatement statement = JOconnection.conn.prepareStatement(selectQuery)) {
                statement.setInt(1, id);

                try (ResultSet resultSet = statement.executeQuery()) {
                    if (resultSet.next()) {
                        return resultSet.getString("phoneNumber");
                    } else {
                        return null;
                    }
                }
            }
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
            return null;
        } finally {
            try {
                JOconnection.conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
    
    public static String getNameByID(int id) {
        try {
            JOconnection.JConnect();

            String selectQuery = "SELECT name FROM company WHERE id = ?";
            try (PreparedStatement statement = JOconnection.conn.prepareStatement(selectQuery)) {
                statement.setInt(1, id);

                try (ResultSet resultSet = statement.executeQuery()) {
                    if (resultSet.next()) {
                        return resultSet.getString("name");
                    } else {
                        return null;
                    }
                }
            }
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
            return null;
        } finally {
            try {
                JOconnection.conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
    
    public static Company getCompanyByID(int id) {
        Company company = null;
        try {
            JOconnection.JConnect();

            String selectQuery = "SELECT * FROM company WHERE id = ?";
            try (PreparedStatement statement = JOconnection.conn.prepareStatement(selectQuery)) {
                statement.setInt(1, id);

                try (ResultSet resultSet = statement.executeQuery()) {
                    if (resultSet.next()) {
                        company = new Company();
                        company.setName(resultSet.getString("name"));
                        company.setEmployeeInCharge(UserDAO.getUserByName(resultSet.getString("employeeInCharge")));
                        company.setPhoneNumber(resultSet.getString("phoneNumber"));
                        company.setID(resultSet.getInt("id"));
                    }
                }
            }
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        } finally {
            try {
                JOconnection.conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        return company;
    }
    
}
