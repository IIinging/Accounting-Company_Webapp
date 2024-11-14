/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package OOP;

/**
 *
 * @author IngIng
 */
public class CompanyRegistration {
    private String company;
    private User accountant;
    private String date;
    private String certificate;
    private String boj5;
    private String isic;
    private String loanAgreement;
    private int ID;

    // Constructor
    public CompanyRegistration(String company, User accountant, String Date,
                                String certificate, String boj5, String isic, String loanAgreement, int ID) {
        this.company = company;       
        this.accountant = accountant;
        this.date = Date;
        this.certificate = certificate;
        this.boj5 = boj5;
        this.isic = isic;
        this.loanAgreement = loanAgreement;
        this.ID = ID;
    }

    // Getter methods

    public User getAccountant() {
        return accountant;
    }

    public String getCompany() {
        return company;
    }

    public String getDate() {
        return date;
    }

    public String getCertificate() {
        return certificate;
    }

    public String getBoj5() {
        return boj5;
    }

    public String getIsic() {
        return isic;
    }

    public String getLoanAgreement() {
        return loanAgreement;
    }
    
    public int getID() {
        return ID;
    }

    // Setter methods

    public void setAccountant(User accountant) {
        this.accountant = accountant;
    }

    public void setCompany(String comp) {
        this.company = comp;
    }

    public void setDate(String Date) {
        this.date = Date;
    }

    public void setCertificate(String certificate) {
        this.certificate = certificate;
    }

    public void setBoj5(String boj5) {
        this.boj5 = boj5;
    }

    public void setIsic(String isic) {
        this.isic = isic;
    }

    public void setLoanAgreement(String loanAgreement) {
        this.loanAgreement = loanAgreement;
    }
}
