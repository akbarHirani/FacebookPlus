/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import controller.SQLManager;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 * General client for sql trans that anyone can do, ie for editing personal info
 * @author Kal
 */
public class Client {
    
    protected SQLManager sqlManager;
    protected long personID;
    public static enum AccountType {MANAGER, EMPLOYEE, USER};
    protected final AccountType type;
    
    public Client(long personID, AccountType type){
        sqlManager = new SQLManager();
        this.personID = personID;
        this.type = type;
    }
    
    public AccountType getType() {
        return type;
    }
    
    public Client() {
        sqlManager = new SQLManager (); 
        this.type = AccountType.USER;
    }
       
    protected SQLManager getSQLManager() {
        return this.sqlManager;
    }
   
    public int updateAddress(String address) throws SQLException {
        Connection con = sqlManager.getConnection();
        
        String query = "UPDATE person SET address=? WHERE SSN=?";
        PreparedStatement ps = con.prepareStatement(query);
        ps.setString(1, address);
        ps.setLong(2, personID);
        
        int retval = ps.executeUpdate();
        
        con.close();
        
        return retval;
    }
    
   
    public int updateState(String state) throws SQLException {
        Connection con = sqlManager.getConnection();
        
        String query = "UPDATE person SET state=? WHERE SSN=?";
        PreparedStatement ps = con.prepareStatement(query);
        ps.setString(1, state);
        ps.setLong(2, personID);
        
        int retval = ps.executeUpdate();
        
        con.close();
        
        return retval;
    }    
    
    public int updateCity(String city) throws SQLException {
        Connection con = sqlManager.getConnection();
        
        String query = "UPDATE person SET city=? WHERE SSN=?";
        PreparedStatement ps = con.prepareStatement(query);
        ps.setString(1, city);
        ps.setLong(2, personID);
        
        int retval = ps.executeUpdate();
        
        con.close();
        
        return retval;
    }    
    
    public int updateZipcode(long zipcode) throws SQLException {
        Connection con = sqlManager.getConnection();
        
        String query = "UPDATE person SET Zip_Code=? WHERE SSN=?";
        PreparedStatement ps = con.prepareStatement(query);
        ps.setLong(1, zipcode);
        ps.setLong(2, personID);
        
        int retval = ps.executeUpdate();
        
        con.close();
        
        return retval;
    }    
    
    public int updateEmail(String email) throws SQLException {
        Connection con = sqlManager.getConnection();
        
        String query = "UPDATE person SET Email_Address=? WHERE SSN=?";
        PreparedStatement ps = con.prepareStatement(query);
        ps.setString(1, email);
        ps.setLong(2, personID);
        
        int retval = ps.executeUpdate();
        
        con.close();
        
        return retval;
    }
    
    public int updateTelephone(long telephone) throws SQLException {
        Connection con = sqlManager.getConnection();
        
        String query = "UPDATE person SET Telephone=? WHERE SSN=?";
        PreparedStatement ps = con.prepareStatement(query);
        ps.setLong(1, telephone);
        ps.setLong(2, personID);
        
        int retval = ps.executeUpdate();
        
        con.close();
        
        return retval;
    }
    
}