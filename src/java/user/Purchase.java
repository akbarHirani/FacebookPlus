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
public class Purchase {
    
    private long transId;
    private Date date;
    private long adId;
    private long numUnits;
    private long accNum;
    private long user;
    
    public Purchase(long transId, Date date, long adId, long numUnits, long accNum, long user){
        this.transId = transId;
        this.date = date;
        this.adId = adId;
        this.numUnits = numUnits;
        this.accNum = accNum;
        this.user = user;
    }

    /**
     * @return the transId
     */
    public long getTransId() {
        return transId;
    }

    /**
     * @param transId the transId to set
     */
    public void setTransId(long transId) {
        this.transId = transId;
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
     * @return the adId
     */
    public long getAdId() {
        return adId;
    }

    /**
     * @param adId the adId to set
     */
    public void setAdId(long adId) {
        this.adId = adId;
    }

    /**
     * @return the numUnits
     */
    public long getNumUnits() {
        return numUnits;
    }

    /**
     * @param numUnits the numUnits to set
     */
    public void setNumUnits(long numUnits) {
        this.numUnits = numUnits;
    }

    /**
     * @return the accNum
     */
    public long getAccNum() {
        return accNum;
    }

    /**
     * @param accNum the accNum to set
     */
    public void setAccNum(long accNum) {
        this.accNum = accNum;
    }

    /**
     * @return the user
     */
    public long getUser() {
        return user;
    }

    /**
     * @param user the user to set
     */
    public void setUser(long user) {
        this.user = user;
    }
}
