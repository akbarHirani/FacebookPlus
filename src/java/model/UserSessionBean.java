/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.io.Serializable;
import java.sql.Date;
import java.sql.SQLException;
import javax.ejb.Stateless;
import java.util.ArrayList;
/**
 *
 * @author Kal
 */

@Stateless
public class UserSessionBean implements Serializable{

    /*
     * Logout  
     * Home
     * Circles
     * Messages
     * Shopping
     * Your Transactions
     * 
     */
    
    private long personID;
    private String firstName;
    private String lastName;
    private ArrayList<Long> accountNumbers;
    private UserClient userClient;
    
    private long currentAccount;
    private long userID;
    
    private String city;
    private String state;
    private String email;
    private long zipCode;
    private long telephone;
    private Date dateOfBirth;
    private String gender;
    
    public UserSessionBean() {
        userClient = new UserClient();
    }
    
    public UserSessionBean (long personID) throws SQLException { 
        userClient = new UserClient(personID);
    }
    public ArrayList<Long> getAccountNumbers() throws SQLException {        
        return userClient.getAccountNumbers(userID);
    }

    public void setAccountIds(ArrayList<Long> accountNumbers) {
        this.accountNumbers = accountNumbers;
    }
    
    
    public void setPersonID (long personID) {
        this.personID = personID;
    }
    
    public long getPersonID () {
        return this.personID;
    }

    /**
     * @return the firstName
     */
    public String getFirstName() {
        return firstName;
    }

    /**
     * @param firstName the firstName to set
     */
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    /**
     * @return the lastName
     */
    public String getLastName() {
        return lastName;
    }

    /**
     * @param lastName the lastName to set
     */
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    /**
     * @return the userID
     */
    public long getUserID() {
        return userID;
    }

    /**
     * @param userID the userID to set
     */
    public void setUserID(long userID) {
        this.userID = userID;
    }
    
    public String getAddress() throws SQLException {
        return this.userClient.getAddress();
    }

    public UserClient getUserClient() {
        return this.userClient;
    }

    /**
     * @return the city
     */
    public String getCity() throws SQLException {
        return userClient.getCity();
    }

    /**
     * @param city the city to set
     */
    public void setCity(String city) {
        this.city = city;
    }

    /**
     * @return the state
     */
    public String getState() throws SQLException {
        return userClient.getState();
    }

    /**
     * @param state the state to set
     */
    public void setState(String state) {
        this.state = state;
    }

    /**
     * @return the zipCode
     */
    public long getZipCode() throws SQLException {
        return userClient.getZipCode();
    }

    /**
     * @param zipCode the zipCode to set
     */
    public void setZipCode(long zipCode) {
        this.zipCode = zipCode;
    }

    /**
     * @return the telephone
     */
    public long getTelephone() throws SQLException {
        return userClient.getTelephone();
    }

    /**
     * @param telephone the telephone to set
     */
    public void setTelephone(long telephone) {
        this.telephone = telephone;
    }

    /**
     * @return the dateOfBirth
     */
    public Date getDateOfBirth() throws SQLException {
        return userClient.getDateOfBirth();
    }

    /**
     * @param dateOfBirth the dateOfBirth to set
     */
    public void setDateOfBirth(Date dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    /**
     * @return the email
     */
    public String getEmail() throws SQLException {
        return userClient.getEmail();
    }

    /**
     * @param email the email to set
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * @return the gender
     */
    public String getGender() throws SQLException {
        return userClient.getGender();
    }

    /**
     * @param gender the gender to set
     */
    public void setGender(String gender) {
        this.gender = gender;
    }
    
    public ArrayList<Long> getCircleIds() throws SQLException{
        return this.userClient.getCircleIds();
    }
    
    public String getCircleName(long circleId) throws SQLException {
        return this.userClient.getCircleName(circleId);
    }
   
    public ArrayList<Long> getPageIds(long circleId) throws SQLException {
        return this.userClient.getPageIds(circleId);
    }
    
    public ArrayList<Long> getPostIds(long pageID) throws SQLException {
        return this.userClient.getPostIds(pageID);
    }
    
    public String getPostContent(long postID) throws SQLException {
        return this.userClient.getPostContent(postID);
    }
    
    public String getCommentContent(long commentID) throws SQLException {
        return this.userClient.getCommentContent(commentID);
    }
    
    public ArrayList<Long> getCommentIds (long postID) throws SQLException {
        return this.userClient.getCommentIds(postID);
    } 

    public void setCurrentAccount(long accNum) {
        this.currentAccount = accNum;
    }
    
    public long getCurrentAccount() {
        return this.currentAccount;
    }
    
}

