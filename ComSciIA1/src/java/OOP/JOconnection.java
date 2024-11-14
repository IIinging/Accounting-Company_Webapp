package OOP;

import java.sql.*;
import java.util.*;
import java.io.*;
//template from https://github.com/y2kstack/Archives/blob/b8fe4d0b87efd27199828ffadb8d2b2622100ca5/_posts/2019-01-27-Project-part2-login-page.md

public class JOconnection {
    public static Connection conn;
    public static Statement stmt;
    public static ResultSet rslt;
    
    public static void JConnect() throws  ClassNotFoundException, SQLException {
        try{
            String username ="root"; 
            String password ="Ii18012006"; 

            Class.forName("com.mysql.cj.jdbc.Driver");
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/mydb",username,password);
            stmt = conn.createStatement();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        }
}

