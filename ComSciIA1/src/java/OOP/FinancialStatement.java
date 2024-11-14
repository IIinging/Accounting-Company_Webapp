/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package OOP;

/**
 *
 * @author IngIng
 */
public class FinancialStatement {
    private String company;
    private int year;
    private String excelStatement;
    private String vatSummary;
    private String pdfStatement;
    private String pnd50;
    private String excelProfitAndInterest;
    private int ID;

    public FinancialStatement(String company, int year, String excelStatement, String vatSummary, String pdfStatement, String pnd50, String excelProfitAndInterest, int ID) {
        this.company = company;
        this.year = year;
        this.excelStatement = excelStatement;
        this.vatSummary = vatSummary;
        this.pdfStatement = pdfStatement;
        this.pnd50 = pnd50;
        this.excelProfitAndInterest = excelProfitAndInterest;
        this.ID = ID;
    }

    // Getter methods
    public String getCompany() {
        return company;
    }
    
    public int getYear() {
        return year;
    }

    public String getExcelStatement() {
        return excelStatement;
    }

    public String getVatSummary() {
        return vatSummary;
    }

    public String getPdfStatement() {
        return pdfStatement;
    }

    public String getPnd50() {
        return pnd50;
    }

    public String getExcelProfitAndInterest() {
        return excelProfitAndInterest;
    }
    
    public int getID(){
        return ID;
    }

    // Setter methods
    public void setYear(int year) {
        this.year = year;
    }

    public void setExcelStatement(String excelStatement) {
        this.excelStatement = excelStatement;
    }

    public void setVatSummary(String vatSummary) {
        this.vatSummary = vatSummary;
    }

    public void setPdfStatement(String pdfStatement) {
        this.pdfStatement = pdfStatement;
    }

    public void setPnd50(String pnd50) {
        this.pnd50 = pnd50;
    }

    public void setExcelProfitAndInterest(String excelProfitAndInterest) {
        this.excelProfitAndInterest = excelProfitAndInterest;
    }
}
