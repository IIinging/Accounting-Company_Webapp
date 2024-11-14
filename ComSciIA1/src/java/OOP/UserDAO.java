package OOP; // Replace with your actual package name

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class UserDAO {

    public ArrayList<User> getAllUsers() {
        ArrayList<User> userList = new ArrayList<>();

        try {
            JOconnection.JConnect();

            String selectquery = "SELECT * FROM register";
            try (PreparedStatement statement = JOconnection.conn.prepareStatement(selectquery);
                 ResultSet resultSet = statement.executeQuery()) {

                while (resultSet.next()) {
                    User user = new User();
                    user.setFirstName(resultSet.getString("firstname"));
                    user.setLastName(resultSet.getString("lastname"));
                    user.setUsername(resultSet.getString("username"));
                    user.setEmail(resultSet.getString("email"));
                    user.setPassword(resultSet.getString("password"));
                    user.setMobileNum(resultSet.getString("mobileNum"));
                    user.setAccess(resultSet.getString("access"));
                    
                    userList.add(user);
                }
            }
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }

        return userList;
    }
    
    public static User getUserByName(String username) {
        User user = null;

        try {
            JOconnection.JConnect();

            String selectQuery = "SELECT * FROM register WHERE username = ?";
            try (PreparedStatement statement = JOconnection.conn.prepareStatement(selectQuery)) {
                statement.setString(1, username);

                try (ResultSet resultSet = statement.executeQuery()) {
                    if (resultSet.next()) {
                        user = new User();
                        user.setFirstName(resultSet.getString("firstName"));
                        user.setLastName(resultSet.getString("lastName"));
                        user.setUsername(resultSet.getString("username"));
                        user.setEmail(resultSet.getString("email"));
                        user.setPassword(resultSet.getString("password"));
                        user.setMobileNum(resultSet.getString("mobileNum"));
                        user.setAccess(resultSet.getString("access"));
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

        return user;
    }
    
    public static String getFirstNameByUsername(String user) {
        try {
            JOconnection.JConnect();

            String selectQuery = "SELECT firstname FROM register WHERE username = ?";
            try (PreparedStatement statement = JOconnection.conn.prepareStatement(selectQuery)) {
                statement.setString(1, user);

                try (ResultSet resultSet = statement.executeQuery()) {
                    if (resultSet.next()) {
                        return resultSet.getString("firstname");
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
    
    public static String getLastNameByUsername(String user) {
        try {
            JOconnection.JConnect();

            String selectQuery = "SELECT lastname FROM register WHERE username = ?";
            try (PreparedStatement statement = JOconnection.conn.prepareStatement(selectQuery)) {
                statement.setString(1, user);

                try (ResultSet resultSet = statement.executeQuery()) {
                    if (resultSet.next()) {
                        return resultSet.getString("lastname");
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
    
    public static String getAccessByUsername(String user) {
        try {
            JOconnection.JConnect();

            String selectQuery = "SELECT access FROM register WHERE username = ?";
            try (PreparedStatement statement = JOconnection.conn.prepareStatement(selectQuery)) {
                statement.setString(1, user);

                try (ResultSet resultSet = statement.executeQuery()) {
                    if (resultSet.next()) {
                        return resultSet.getString("access");
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
}
