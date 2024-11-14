/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package OOP;

public class User {

    private String firstName;
    private String lastName;
    private String username;
    private String email;
    private String password;
    private String mobileNum;
    private String accessLevel;

    public User() {
    }

    // Constructor with all fields
    public User(String firstName, String lastName, String username, String email, String password, String mobileNum, String access) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.username = username;
        this.email = email;
        this.password = password;
        this.mobileNum = mobileNum;
        this.accessLevel = access;
    }

    // Setters
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setMobileNum(String mobileNum) {
        this.mobileNum = mobileNum;
    }

    public void setAccess(String Access) {
        this.accessLevel = Access;
    }

    // Getters
    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getUsername() {
        return username;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public String getMobileNum() {
        return mobileNum;
    }
    
    public String getAccess() {
        return accessLevel;
    }

    public boolean isAdmin() {
        return "Admin".equals(accessLevel);
    }

    public boolean isManager() {
        return "Manager".equals(accessLevel);
    }
}
