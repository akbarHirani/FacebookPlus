/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package user;

import java.sql.Date;

/**
 *
 * @author Kal
 */
public class AdItem {

    
    private long adID;
    private long employee;
    private String type;
    private Date date;
    private String company;
    private String itemName;
    private String content;
    private long unitPrice;
    private long availUnits;
    
    public AdItem(long adID, long employee, String type, Date date, String company, 
            String itemName, String content, long unitPrice, long availUnits) {
        
        this.adID = adID;
        this.employee = employee;
        this.type = type;
        this.date = date;
        this.company = company;
        this.itemName = itemName;
        this.content = content;
        this.unitPrice = unitPrice;
        this.availUnits = availUnits;        
        
    }

    /**
     * @return the adID
     */
    public long getAdID() {
        return adID;
    }

    /**
     * @param adID the adID to set
     */
    public void setAdID(long adID) {
        this.adID = adID;
    }

    /**
     * @return the employee
     */
    public long getEmployee() {
        return employee;
    }

    /**
     * @param employee the employee to set
     */
    public void setEmployee(long employee) {
        this.employee = employee;
    }

    /**
     * @return the type
     */
    public String getType() {
        return type;
    }

    /**
     * @param type the type to set
     */
    public void setType(String type) {
        this.type = type;
    }

    /**
     * @return the date
     */
    public Date getDate() {
        return date;
    }

    /**
     * @param date the date to set
     */
    public void setDate(Date date) {
        this.date = date;
    }

    /**
     * @return the company
     */
    public String getCompany() {
        return company;
    }

    /**
     * @param company the company to set
     */
    public void setCompany(String company) {
        this.company = company;
    }

    /**
     * @return the itemName
     */
    public String getItemName() {
        return itemName;
    }

    /**
     * @param itemName the itemName to set
     */
    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    /**
     * @return the content
     */
    public String getContent() {
        return content;
    }

    /**
     * @param content the content to set
     */
    public void setContent(String content) {
        this.content = content;
    }

    /**
     * @return the unitPrice
     */
    public long getUnitPrice() {
        return unitPrice;
    }

    /**
     * @param unitPrice the unitPrice to set
     */
    public void setUnitPrice(long unitPrice) {
        this.unitPrice = unitPrice;
    }

    /**
     * @return the availUnits
     */
    public long getAvailUnits() {
        return availUnits;
    }

    /**
     * @param availUnits the availUnits to set
     */
    public void setAvailUnits(long availUnits) {
        this.availUnits = availUnits;
    }
    
    
    
}
