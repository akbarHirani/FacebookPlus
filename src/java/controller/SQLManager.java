/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.UserClient;

/**
 *
 * @author Kal
 */
public final class SQLManager {
   
   // JDBC driver name and database URL
   static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";  
   static final String DB_SCHEMA = "jacliang";
   static final String DB_SERVER = "localhost";
   static final String DB_URL = "jdbc:mysql://"+DB_SERVER+"/"+DB_SCHEMA;

   //  Database credentials
   static final String USER = "root";
   static final String PASS = "root";
   
   //0 Means no rows affected, else something got effected
   private int executeUpdate(String query, String[] values) throws SQLException {
       Connection con = null;
       int returnValue = 0;
       
       try{
            Class.forName(JDBC_DRIVER);
            
            con = DriverManager.getConnection(
                         "jdbc:mysql://localhost:3306/jacliang",
                         USER,
                         PASS);
            PreparedStatement pstmt = con.prepareStatement(query);
            
            for(int i = 1; i <= values.length; i++){
                System.out.println(values[i]);
                pstmt.setString(i, values[i]);            
            }
            
            returnValue = pstmt.executeUpdate();
                    
            con.close();
            return returnValue;
       }finally{
            con.close();
            return returnValue;
       }       
//        }catch (SQLException e){
//            return 0;
//        }catch (ClassNotFoundException e) {
//            return 0;
//        }catch (Exception e){
//            return 0;
//        }finally{
//            return returnValue;
//       }
               
   }
   
   public Connection getConnection(){
       Connection con = null;
       
       try {
           
            Class.forName(JDBC_DRIVER);
            
            con = DriverManager.getConnection(
                         "jdbc:mysql://localhost:3306/jacliang",
                         USER,
                         PASS);
            
       } catch (ClassNotFoundException ex) {
            Logger.getLogger(SQLManager.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException e){
            Logger.getLogger(SQLManager.class.getName()).log(Level.SEVERE, null, e);
       }
       
       return con;
   }
   
   private ResultSet executeQuery(String query, Object[] values) {
       Connection con = null;
       ResultSet rs = null;
       
       try{
            Class.forName(JDBC_DRIVER);
            
            con = DriverManager.getConnection(
                         "jdbc:mysql://localhost:3306/jacliang",
                         USER,
                         PASS);
            PreparedStatement pstmt = con.prepareStatement(query);
            
            for(int i = 1; i <= values.length; i++){
                System.out.println(values[i]);
                pstmt.setString(i, (String) values[i]);
            }
            
            rs = pstmt.executeQuery();            
            con.close();
            
        }catch (SQLException e){
            return null;
        }catch (ClassNotFoundException e) {
            return null;
        }catch (Exception e){
            return null;
        }
        
        return rs;
        
   }

    public int testRegister() throws SQLException{
        Connection con = getConnection();
        if(con == null) {
           return -1;
        }
        
        Statement stmt = con.createStatement();
        return stmt.executeUpdate("INSERT INTO person (Last_Name, First_Name, SSN) VALUES ('Smolka', 'Scott', 123456789)");
    }

    int registerPerson(long SSN, String firstName, String lastName, String address, String city, String state, long zipCode, String gender, long telephone, String email, Date dateOfBirth) throws SQLException {
        
        String preparedQuery = "INSERT INTO person VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";        
        Connection con = getConnection();
        int retval;
        
        PreparedStatement ps = con.prepareStatement(preparedQuery);
        ps.setLong(1, SSN);
        ps.setString(2, firstName);
        ps.setString(3, lastName);
        ps.setString(4, address);
        ps.setString(5, city);
        ps.setString(6, state);
        ps.setLong(7, zipCode);
        ps.setLong(8, telephone);
        ps.setString(9, email);
        ps.setString(10, gender);
        ps.setDate(11, dateOfBirth);
        
        retval = ps.executeUpdate();
        
        return retval;
    }
    
    public long registerUser(String firstName, String lastName, String address, String city, String state, long zipCode, String gender, long telephone, String email, Date dateOfBirth) throws SQLException {
        String userQuery = "INSERT INTO user (User_Id, Rating, First_Name, Last_Name, Address, "
                + "City, State, Zip_Code, Telephone, Email, Gender, DateOfBirth) VALUES (?,?,?,?,?,?,?,?,?,?,?,?)";
        
        Connection con = getConnection();
        UserClient uClient = new UserClient();
        int retval;
        PreparedStatement userps = con.prepareStatement(userQuery);
        long nextUserID = uClient.getNextUserID();
        PreparedStatement ps = con.prepareStatement(userQuery);
        
        ps.setLong(1, nextUserID);
        ps.setLong(2, 0); //Default rating is 0
        ps.setString(3, firstName);
        ps.setString(4, lastName);
        ps.setString(5, address);
        ps.setString(6, city);
        ps.setString(7, state);
        ps.setLong(8, zipCode);
        ps.setLong(9, telephone);
        ps.setString(10, email);
        ps.setString(11, gender);
        ps.setDate(12, dateOfBirth);
        
        retval = ps.executeUpdate();
        if(retval > 0) {
            con.close();
            return nextUserID;
        }else {
            con.close();
            return -1;
        }
    }

}