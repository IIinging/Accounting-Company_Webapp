/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package OOP;

/**
 *
 * @author IngIng
 */
public class Company {

    private String name;
    private User employeeInCharge;
    private String phoneNumber;
    private int ID;

    public Company(){    
    }
    
    public Company(String name, User employeeInCharge, String phoneNumber, int id) {
        this.name = name;
        this.employeeInCharge = employeeInCharge;
        this.phoneNumber = phoneNumber;
        this.ID = id;
    }
    
    public String getName() {
        return name;
    }

    public User getEmployeeInCharge() {
        return employeeInCharge;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }
    
    public int getID() {
        return ID;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setEmployeeInCharge(User employeeInCharge) {
        this.employeeInCharge = employeeInCharge;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }
    
    public void setID(int id) {
        this.ID = id;
    }
    
}
