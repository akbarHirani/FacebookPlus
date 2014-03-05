/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;
import java.util.ArrayList;
import java.util.Hashtable;
import java.util.Set;

/**
 *
 * @author Kal
 */
public class EmployeeClient extends Client {

    //Don't use empty constructor
    public EmployeeClient(long personID) {
        super(personID, AccountType.EMPLOYEE);
    }

    //Put methods here
    public String getFirstName() throws SQLException {
        Connection con = sqlManager.getConnection();

        String query = "SELECT First_Name FROM person p,employee e WHERE e.Employee_Id= ? AND e.SSN = p.SSN";
        PreparedStatement ps = con.prepareStatement(query);
        ps.setLong(1, personID);
        ResultSet rs = ps.executeQuery();
        rs.next();
        String firstName = rs.getString(1);
        con.close();

        return firstName;
    }

    public String getLastName() throws SQLException {
        Connection con = sqlManager.getConnection();

        String query = "SELECT Last_Name FROM person p,employee e WHERE e.Employee_Id= ? AND e.SSN = p.SSN";
        PreparedStatement ps = con.prepareStatement(query);
        ps.setLong(1, personID);
        ResultSet rs = ps.executeQuery();
        rs.next();
        String lastName = rs.getString(1);

        con.close();

        return lastName;
    }

    public long getEmployeeID() throws SQLException {
        return personID;
    }

    public void deleteAdvertisement(long advertisementID) throws SQLException {
        Connection con = sqlManager.getConnection();
        String query = "DELETE FROM advertisement WHERE Advertisement_Id = ?";
        PreparedStatement ps = con.prepareStatement(query);
        ps.setLong(1, advertisementID);
        ps.executeUpdate();
        con.close();
    }

    public void createAdvertisement(String itemName, String type, String company, String content, long unitPrice, long numberOfAvailableUnits, Date date) throws SQLException {
        Connection con = sqlManager.getConnection();
        String query = "INSERT INTO advertisement VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?)";
        long AdvertisementId = getNextAdvertisementId();
        PreparedStatement ps = con.prepareStatement(query);
        ps.setLong(1, AdvertisementId);//ad id
        ps.setLong(2, getEmployeeSSN());//employee field of advertisement is the employee's ssn
        ps.setString(3, type);
        ps.setDate(4, date);//date
        ps.setString(5, company);//company
        ps.setString(6, itemName);//name
        ps.setString(7, content);//content
        ps.setLong(8, unitPrice);//price
        ps.setLong(9, numberOfAvailableUnits);//quantity

        ps.executeUpdate();
        con.close();
    }

    /**
     *
     * @return @throws SQLException
     */
    public ArrayList<Long> getAllAdvertisementIds() throws SQLException {
        ArrayList<Long> ads = new ArrayList<Long>();
        Connection con = sqlManager.getConnection();
        String query = "SELECT Advertisement_Id FROM advertisement";
        PreparedStatement ps = con.prepareStatement(query);
        ResultSet rs = ps.executeQuery();
        while (rs.next()) {
            long a = rs.getLong("Advertisement_Id");
            ads.add(a);
        }
        con.close();
        return ads;
    }

    public long getNextAdvertisementId() throws SQLException {
        Connection con = sqlManager.getConnection();
        String query = "SELECT MAX(Advertisement_Id) FROM advertisement";
        PreparedStatement ps = con.prepareStatement(query);
        ResultSet rs = ps.executeQuery();
        rs.next();
        long id = rs.getLong(1);
        id += 1;
        con.close();
        return id;
    }

    public String getAdvertisementName(long advertisementID) throws SQLException {
        Connection con = sqlManager.getConnection();
        String query = "SELECT Item_Name FROM advertisement WHERE Advertisement_Id = ?";
        PreparedStatement ps = con.prepareStatement(query);
        ps.setLong(1, advertisementID);
        ResultSet rs = ps.executeQuery();
        String name = "not found, getAdvertisementName() attempted to find " + advertisementID;
        if (rs.next()) {
            name = rs.getString(1);
        }
        con.close();
        return name;
    }

    public String getAdType(long advertisementID) throws SQLException {
        Connection con = sqlManager.getConnection();
        String query = "SELECT Item_Name FROM advertisement WHERE Advertisement_Id = ?";
        PreparedStatement ps = con.prepareStatement(query);
        ps.setLong(1, advertisementID);
        ResultSet rs = ps.executeQuery();
        rs.next();
        String type = rs.getString(1);
        con.close();
        return type;
    }

    public long countAds() throws SQLException {
        Connection con = sqlManager.getConnection();
        String query = "SELECT COUNT(Advertisement_Id) FROM advertisement";
        PreparedStatement ps = con.prepareStatement(query);
        ResultSet rs = ps.executeQuery();
        rs.next();
        long length = rs.getLong(1);
        con.close();
        return length;
    }

    public String getAdvertisementType(long advertisementID) throws SQLException {
        Connection con = sqlManager.getConnection();
        String query = "SELECT Type FROM advertisement WHERE Advertisement_Id = ?";
        PreparedStatement ps = con.prepareStatement(query);
        ps.setLong(1, advertisementID);
        ResultSet rs = ps.executeQuery();
        rs.next();
        String ret = rs.getString(1);
        con.close();
        return ret;
    }

    public String getAdvertisementEmployee(long advertisementID) throws SQLException {
        Connection con = sqlManager.getConnection();
        String query = "SELECT Employee FROM advertisement WHERE Advertisement_Id = ?";
        PreparedStatement ps = con.prepareStatement(query);
        ps.setLong(1, advertisementID);
        ResultSet rs = ps.executeQuery();
        rs.next();
        String ret = rs.getString(1);
        con.close();
        return ret;
    }

    public String getAdvertisementCompany(long advertisementID) throws SQLException {
        Connection con = sqlManager.getConnection();
        String query = "SELECT Company FROM advertisement WHERE Advertisement_Id = ?";
        PreparedStatement ps = con.prepareStatement(query);
        ps.setLong(1, advertisementID);
        ResultSet rs = ps.executeQuery();
        rs.next();
        String ret = rs.getString(1);
        con.close();
        return ret;
    }

    public String getAdvertisementContent(long advertisementID) throws SQLException {
        Connection con = sqlManager.getConnection();
        String query = "SELECT Content FROM advertisement WHERE Advertisement_Id = ?";
        PreparedStatement ps = con.prepareStatement(query);
        ps.setLong(1, advertisementID);
        ResultSet rs = ps.executeQuery();
        rs.next();
        String ret = rs.getString(1);
        con.close();
        return ret;
    }

    public String getAdvertisementUnitPrice(long advertisementID) throws SQLException {
        Connection con = sqlManager.getConnection();
        String query = "SELECT Unit_Price FROM advertisement WHERE Advertisement_Id = ?";
        PreparedStatement ps = con.prepareStatement(query);
        ps.setLong(1, advertisementID);
        ResultSet rs = ps.executeQuery();
        rs.next();
        String ret = rs.getString(1);
        con.close();
        return ret;
    }

    public String getAdvertisementAvailableUnits(long advertisementID) throws SQLException {
        Connection con = sqlManager.getConnection();
        String query = "SELECT Available_Units FROM advertisement WHERE Advertisement_Id = ?";
        PreparedStatement ps = con.prepareStatement(query);
        ps.setLong(1, advertisementID);
        ResultSet rs = ps.executeQuery();
        rs.next();
        String ret = rs.getString(1);
        con.close();
        return ret;
    }

    public String getAdvertisementDate(long advertisementID) throws SQLException {
        Connection con = sqlManager.getConnection();
        String query = "SELECT Date FROM advertisement WHERE Advertisement_Id = ?";
        PreparedStatement ps = con.prepareStatement(query);
        ps.setLong(1, advertisementID);
        ResultSet rs = ps.executeQuery();
        rs.next();
        String ret = rs.getString(1);
        con.close();
        return ret;
    }

    /*
     * pulls up list of items that user has bought before via this account
     */
    /*
     *Extracts the types of the items that was bought
     */
    /*
     * Will have return type of ArrayList<Long> where the contents
     * of the list are advertisement ids with types that match those in preferences
     * Must consider if getUserPurchasePreferences () should return string or something else
     */
    public ArrayList<Long> suggestedAdvertisements(long user) throws SQLException {

        ArrayList<Long> suggested = new ArrayList<Long>();
        return suggested;
    }

    public long getEmployeeSSN() throws SQLException {
        String query = "SELECT SSN FROM employee WHERE Employee_Id = ? ";
        Connection con = sqlManager.getConnection();
        PreparedStatement ps = con.prepareStatement(query);
        ps.setLong(1, personID);
        ResultSet rs = ps.executeQuery();
        rs.next();
        return rs.getLong(1);
    }

    public long getNextTransactionId() throws SQLException {
        Connection con = sqlManager.getConnection();
        String query = "SELECT MAX(Transaction_Id) FROM purchase";
        PreparedStatement ps = con.prepareStatement(query);
        ResultSet rs = ps.executeQuery();
        rs.next();
        long id = rs.getLong(1);
        id += 1;
        con.close();
        return id;
    }

    public void recordTransaction(long nextTransactionId, long advertisement, Date dateOfCreation, long units, long acc, long uID) throws SQLException {
        Connection con = sqlManager.getConnection();
        String query = "INSERT INTO purchase VALUES(?, ?, ?, ?, ?, ?)";
        PreparedStatement ps = con.prepareStatement(query);
        ps.setLong(1, nextTransactionId);
        ps.setDate(2, dateOfCreation);
        ps.setLong(3, advertisement);
        ps.setLong(4, units);
        ps.setLong(5, acc);
        ps.setLong(6, uID);
        ps.executeUpdate();

        long quantity_in_stock = Long.parseLong(getAdvertisementAvailableUnits(advertisement));
        long updated_quantity_in_stock = quantity_in_stock + units;

        query = "UPDATE advertisement SET Available_Units = ? WHERE Advertisement_Id = ?";
        ps = con.prepareStatement(query);
        ps.setLong(1, updated_quantity_in_stock);
        ps.setLong(2, advertisement);
        ps.executeUpdate();

        con.close();
    }

    public long getUserFromAccount(long account) throws SQLException {
        String query = "SELECT User_Id FROM user_has_account WHERE Account_Number= ?";
        Connection con = sqlManager.getConnection();
        PreparedStatement ps = con.prepareStatement(query);
        ps.setLong(1, account);
        ResultSet rs = ps.executeQuery();
        rs.next();
        long user = rs.getLong(1);
        con.close();
        return user;
    }
    // long is id, string is type

    public Hashtable<Long, String> getAllMyAdvertisements() throws SQLException {
        Hashtable<Long, String> ads = new Hashtable<Long, String>();
        String query = "SELECT Advertisement_Id FROM advertisement WHERE Employee = ? ";
        Connection con = sqlManager.getConnection();
        PreparedStatement ps = con.prepareStatement(query);
        ps.setLong(1, getEmployeeSSN());
        ResultSet rs = ps.executeQuery();
        while (rs.next()) {
            long ad = rs.getLong(1);
            ads.put(ad, getAdvertisementType(ad));
        }
        con.close();
        return ads;
    }

    public void setUserAddress(long user, String address) throws SQLException {
        Connection con = sqlManager.getConnection();
        String query = "UPDATE user SET Address = ? WHERE User_Id = ? ";
        PreparedStatement ps = con.prepareStatement(query);
        ps.setString(1, address);
        ps.setLong(2, user);
        ps.executeUpdate();
        con.close();
    }

    public void setUserRating(long user, long newRating) throws SQLException {
        String query = "UPDATE user SET Rating= ? WHERE User_Id = ? ";
        Connection con = sqlManager.getConnection();
        PreparedStatement ps = con.prepareStatement(query);
        ps.setLong(1, newRating);
        ps.setLong(2, user);
        ps.executeUpdate();
        con.close();
    }

    public void setUserCity(long user, String city) throws SQLException {
        Connection con = sqlManager.getConnection();
        String query = "UPDATE user SET City = ? WHERE User_Id = ? ";
        PreparedStatement ps = con.prepareStatement(query);
        ps.setString(1, city);
        ps.setLong(2, user);
        ps.executeUpdate();
        con.close();
    }

    public void setUserState(long user, String state) throws SQLException {
        Connection con = sqlManager.getConnection();
        String query = "UPDATE user SET State = ? WHERE User_Id = ? ";
        PreparedStatement ps = con.prepareStatement(query);
        ps.setString(1, state);
        ps.setLong(2, user);
        ps.executeUpdate();
        con.close();
    }

    public void setUserZipcode(long user, long zipcode) throws SQLException {
        Connection con = sqlManager.getConnection();
        String query = "UPDATE user SET Zip_Code = ? WHERE User_Id = ? ";
        PreparedStatement ps = con.prepareStatement(query);
        ps.setLong(1, zipcode);
        ps.setLong(2, user);
        ps.executeUpdate();
        con.close();
    }

    public void setUserTelephone(long user, long telephone) throws SQLException {
        Connection con = sqlManager.getConnection();

        String query = "UPDATE user SET Telephone = ? WHERE User_Id = ? ";
        PreparedStatement ps = con.prepareStatement(query);
        ps.setLong(1, telephone);
        ps.setLong(2, user);
        ps.executeUpdate();
        con.close();
    }

    public void setUserEmail(long user, String email) throws SQLException {
        Connection con = sqlManager.getConnection();

        String query = "UPDATE user SET Email = ? WHERE User_Id = ? ";
        PreparedStatement ps = con.prepareStatement(query);
        ps.setString(1, email);
        ps.setLong(2, user);
        ps.executeUpdate();
        con.close();
    }

    public ArrayList<Long> getAllUserIds() throws SQLException {
        ArrayList<Long> users = new ArrayList<Long>();
        Connection con = sqlManager.getConnection();
        String query = " SELECT User_Id FROM user";
        PreparedStatement ps = con.prepareStatement(query);
        ResultSet rs = ps.executeQuery();
        while (rs.next()) {
            long uID = rs.getLong(1);
            users.add(uID);;
        }
        con.close();
        return users;
    }
    /*get address is called in the edit_customer_data.jsp...however the url specifies a*/

    public String getUserAddress(long user) throws SQLException {
        Connection con = sqlManager.getConnection();
        String query = "SELECT Address FROM user WHERE User_Id = ?";
        PreparedStatement ps = con.prepareStatement(query);
        ps.setLong(1, user);
        ResultSet rs = ps.executeQuery();
        rs.next();

        String address = rs.getString(1);
        con.close();
        return address;
    }

    public String getUserCity(long user) throws SQLException {
        Connection con = sqlManager.getConnection();
        String query = "SELECT City FROM user WHERE User_Id = ?";
        PreparedStatement ps = con.prepareStatement(query);
        ps.setLong(1, user);
        ResultSet rs = ps.executeQuery();
        rs.next();
        String city = rs.getString(1);
        con.close();
        return city;
    }

    public String getUserState(long user) throws SQLException {
        Connection con = sqlManager.getConnection();
        String query = "SELECT State FROM user WHERE User_Id = ?";
        PreparedStatement ps = con.prepareStatement(query);
        ps.setLong(1, user);
        ResultSet rs = ps.executeQuery();
        rs.next();
        String state = rs.getString(1);
        con.close();
        return state;
    }

    public long getUserZipCode(long user) throws SQLException {
        Connection con = sqlManager.getConnection();
        String query = "SELECT Zip_Code FROM user WHERE User_Id = ?";
        PreparedStatement ps = con.prepareStatement(query);
        ps.setLong(1, user);
        ResultSet rs = ps.executeQuery();
        rs.next();
        long zipcode = rs.getLong(1);
        con.close();
        return zipcode;
    }

    public long getUserTelephone(long user) throws SQLException {
        Connection con = sqlManager.getConnection();
        String query = "SELECT Telephone FROM user WHERE User_Id = ?";
        PreparedStatement ps = con.prepareStatement(query);
        ps.setLong(1, user);
        ResultSet rs = ps.executeQuery();
        rs.next();
        long telephone = rs.getLong(1);
        con.close();
        return telephone;
    }

    public long getUserRating(long user) throws SQLException {
        Connection con = sqlManager.getConnection();
        String query = "SELECT Rating FROM user WHERE User_Id = ?";
        PreparedStatement ps = con.prepareStatement(query);
        ps.setLong(1, user);
        ResultSet rs = ps.executeQuery();
        rs.next();
        long rating = rs.getLong(1);
        con.close();
        return rating;
    }

    public String getUserEmail(long user) throws SQLException {
        Connection con = sqlManager.getConnection();
        String query = "SELECT Email FROM user WHERE User_Id = ?";
        PreparedStatement ps = con.prepareStatement(query);
        ps.setLong(1, user);
        ResultSet rs = ps.executeQuery();
        rs.next();
        String email = rs.getString(1);
        con.close();
        return email;
    }

    //deleting user fields
    public void deleteUserAddress(long user) throws SQLException {
        Connection con = sqlManager.getConnection();
        String query = "UPDATE user SET Address = ? WHERE User_Id = ? ";
        PreparedStatement ps = con.prepareStatement(query);
        ps.setNull(1, Types.LONGNVARCHAR);
        ps.setLong(2, user);
        ps.executeUpdate();
        con.close();
    }

    public void deleteUserCity(long user) throws SQLException {
        Connection con = sqlManager.getConnection();
        String query = "UPDATE user SET City = ? WHERE User_Id = ? ";
        PreparedStatement ps = con.prepareStatement(query);
        ps.setNull(1, Types.LONGNVARCHAR);
        ps.setLong(2, user);
        ps.executeUpdate();
        con.close();
    }

    public void deleteUserState(long user) throws SQLException {
        Connection con = sqlManager.getConnection();
        String query = "UPDATE user SET State = ? WHERE User_Id = ? ";
        PreparedStatement ps = con.prepareStatement(query);
        ps.setNull(1, Types.LONGNVARCHAR);
        ps.setLong(2, user);
        ps.executeUpdate();
        con.close();
    }

    public void deleteUserEmail(long user) throws SQLException {
        Connection con = sqlManager.getConnection();
        String query = "UPDATE user SET Email_Address = ? WHERE User_Id = ? ";
        PreparedStatement ps = con.prepareStatement(query);
        ps.setNull(1, Types.LONGNVARCHAR);
        ps.setLong(2, user);
        ps.executeUpdate();
        con.close();
    }

    public void deleteUserTelephone(long user) throws SQLException {
        Connection con = sqlManager.getConnection();

        String query = "UPDATE user SET Telephone = ? WHERE User_Id = ? ";
        PreparedStatement ps = con.prepareStatement(query);
        ps.setNull(1, Types.BIGINT);
        ps.setLong(2, user);
        ps.executeUpdate();
        con.close();
    }

    public void deleteUserZipcode(long user) throws SQLException {
        Connection con = sqlManager.getConnection();
        String query = "UPDATE user SET Zip_Code = ? WHERE User_Id = ? ";
        PreparedStatement ps = con.prepareStatement(query);
        ps.setNull(1, Types.INTEGER);
        ps.setLong(2, user);
        ps.executeUpdate();
        con.close();
    }

    public void deleteUserRating(long user) throws SQLException {
        Connection con = sqlManager.getConnection();
        String query = "UPDATE user SET Rating = ? WHERE User_Id = ? ";
        PreparedStatement ps = con.prepareStatement(query);
        ps.setNull(1, Types.INTEGER);
        ps.setLong(2, user);
        ps.executeUpdate();
        con.close();
    }

    public ArrayList<String> getCustomerEmailList() throws SQLException {
        Connection con = sqlManager.getConnection();
        ArrayList<String> emails = new ArrayList<String>();
        String query = "SELECT Email FROM user";
        PreparedStatement ps = con.prepareStatement(query);
        ResultSet rs = ps.executeQuery();
        while (rs.next()) {
            emails.add(rs.getString(1));
        }
        con.close();
        return emails;
    }

    public Hashtable<Long, String> getUserPurchaseHistory(long user) throws SQLException {
        Hashtable<Long, String> boughtItems = new Hashtable<Long, String>();
        String query = "SELECT Advertisement FROM purchase WHERE User = ? ";
        Connection con = sqlManager.getConnection();
        PreparedStatement ps = con.prepareStatement(query);
        ps.setLong(1, user);
        ResultSet rs = ps.executeQuery();
        while (rs.next()) {
            long ad_id = rs.getLong(1);
            String type = getAdvertisementType(ad_id);
            boughtItems.put(ad_id, type);
        }
        con.close();
        return boughtItems;
    }

    public ArrayList<Long> getUserRecommendationList(long user) throws SQLException {
        ArrayList<Long> rec = new ArrayList<Long>();
        Hashtable<Long, String> types = getUserPurchaseHistory(user);
        Hashtable<Long, String> myAds = getAllMyAdvertisements();
        Set<Long> myKeys = myAds.keySet();
        for (long key : myKeys) {
            String type = myAds.get(key);//gets type of the current ad
            if (types.containsValue(type)) {//types.contains means if something of the same type was bought
                rec.add(key);               //if so , then ad is something they might like,ergo add to list
            }
        }

        return rec;
    }

    public ArrayList<Long> getAccountsOfUser(long user) throws SQLException {
        ArrayList<Long> accounts = new ArrayList<Long>();
        String query = "SELECT Account_Number FROM user_has_account WHERE User_Id = ? ";
        Connection con = sqlManager.getConnection();
        PreparedStatement ps = con.prepareStatement(query);
        ps.setLong(1, user);
        ResultSet rs = ps.executeQuery();
        while (rs.next()) {
            accounts.add(rs.getLong(1));
        }
        con.close();
        return accounts;
    }

    public ArrayList<Long> getCreditCardsOfAccount(long account) throws SQLException {
        String query = "SELECT Credit_Card_Number FROM account WHERE Account_Number = ? ";
        ArrayList<Long> cards = new ArrayList<Long>();
        Connection con = sqlManager.getConnection();
        PreparedStatement ps = con.prepareStatement(query);
        ps.setLong(1, account);
        ResultSet rs = ps.executeQuery();
        while (rs.next()) {
            cards.add(rs.getLong(1));

        }
        con.close();
        return cards;
    }

    public long getCreditCardOwner(long creditCardNumber) throws SQLException {
        long user;
        String query = "SELECT Account_Number FROM account WHERE Credit_Card_Number = ? ";
        Connection con = sqlManager.getConnection();
        PreparedStatement ps = con.prepareStatement(query);
        ps.setLong(1, creditCardNumber);
        ResultSet rs = ps.executeQuery();
        rs.next();
        long account = rs.getLong(1);

        query = "SELECT User_Id FROM user_has_account WHERE Account_Number = ? ";
        ps = con.prepareStatement(query);
        ps.setLong(1, account);
        rs = ps.executeQuery();
        rs.next();
        user = rs.getLong(1);
        con.close();
        return user;
    }

    public void editCreditCard(long cardNumber, long newCardNumber) throws SQLException {
        Connection con = sqlManager.getConnection();

        String query = "UPDATE account SET Credit_Card_Number = ? WHERE Credit_Card_Number = ? ";
        PreparedStatement ps = con.prepareStatement(query);
        ps.setLong(1, newCardNumber);
        ps.setLong(2, cardNumber);
        ps.executeUpdate();
        con.close();
    }

    public void deleteCreditCard(long cardNumber) throws SQLException {
        Connection con = sqlManager.getConnection();

        String query = "UPDATE account SET Credit_Card_Number = ? WHERE Credit_Card_Number = ? ";
        PreparedStatement ps = con.prepareStatement(query);
        ps.setNull(1, Types.BIGINT);
        ps.setLong(2, cardNumber);
        ps.executeUpdate();
        con.close();
    }

    public ArrayList<Long> getAllEmployeeIds() throws SQLException {
        ArrayList<Long> ids = new ArrayList<Long>();
        Connection con = sqlManager.getConnection();
        String query = "SELECT Employee_Id FROM employee";
        PreparedStatement ps = con.prepareStatement(query);
        ResultSet rs = ps.executeQuery();
        while (rs.next()) {
            ids.add(rs.getLong(1));
        }
        con.close();
        return ids;
    }

    public String getEmployeeFirstName(long employee) throws SQLException {
        Connection con = sqlManager.getConnection();

        String query = "SELECT First_Name FROM person p,employee e WHERE e.Employee_Id= ? AND e.SSN = p.SSN";
        PreparedStatement ps = con.prepareStatement(query);
        ps.setLong(1, employee);
        ResultSet rs = ps.executeQuery();
        //rs.next();
        String firstName = "N/A";
        while (rs.next()) {
            firstName = rs.getString(1);
        }
        con.close();

        return firstName;
    }

    public String getEmployeeLastName(long employee) throws SQLException {
        Connection con = sqlManager.getConnection();

        String query = "SELECT Last_Name FROM person p,employee e WHERE e.Employee_Id= ? AND e.SSN = p.SSN";
        PreparedStatement ps = con.prepareStatement(query);
        ps.setLong(1, employee);
        ResultSet rs = ps.executeQuery();
        //rs.next();
        String LastName = "N/A";
        while (rs.next()) {
            LastName = rs.getString(1);
        }
        con.close();

        return LastName;
    }

    public String getEmployeeAddress(long employee) throws SQLException {
        Connection con = sqlManager.getConnection();

        String query = "SELECT Address FROM person p,employee e WHERE e.Employee_Id= ? AND e.SSN = p.SSN";
        PreparedStatement ps = con.prepareStatement(query);
        ps.setLong(1, employee);
        ResultSet rs = ps.executeQuery();
        //rs.next();
        String address = "N/A";
        while (rs.next()) {
            address = rs.getString(1);
        }
        con.close();

        return address;
    }

    public String getEmployeeCity(long employee) throws SQLException {
        Connection con = sqlManager.getConnection();

        String query = "SELECT City FROM person p,employee e WHERE e.Employee_Id= ? AND e.SSN = p.SSN";
        PreparedStatement ps = con.prepareStatement(query);
        ps.setLong(1, employee);
        ResultSet rs = ps.executeQuery();
        //rs.next();
        String city = "N/A";
        while (rs.next()) {
            city = rs.getString(1);
        }
        con.close();

        return city;
    }

    public String getEmployeeState(long employee) throws SQLException {
        Connection con = sqlManager.getConnection();

        String query = "SELECT State FROM person p,employee e WHERE e.Employee_Id= ? AND e.SSN = p.SSN";
        PreparedStatement ps = con.prepareStatement(query);
        ps.setLong(1, employee);
        ResultSet rs = ps.executeQuery();
        //rs.next();
        String state = "N/A";
        while (rs.next()) {
            state = rs.getString(1);
        }
        con.close();

        return state;
    }

    public Long getEmployeeZipcode(long employee) throws SQLException {
        Connection con = sqlManager.getConnection();

        String query = "SELECT Zip_Code FROM person p,employee e WHERE e.Employee_Id= ? AND e.SSN = p.SSN";
        PreparedStatement ps = con.prepareStatement(query);
        ps.setLong(1, employee);
        ResultSet rs = ps.executeQuery();
        //rs.next();
        Integer x = 0;
        Long zip = x.longValue();
        while (rs.next()) {
            zip = rs.getLong(1);

        }
        con.close();

        return zip;
    }

    public Long getEmployeeTelephone(long employee) throws SQLException {
        Connection con = sqlManager.getConnection();

        String query = "SELECT Telephone FROM person p,employee e WHERE e.Employee_Id= ? AND e.SSN = p.SSN";
        PreparedStatement ps = con.prepareStatement(query);
        ps.setLong(1, employee);
        ResultSet rs = ps.executeQuery();
        //rs.next();
        Integer x = 0;
        Long zip = x.longValue();
        while (rs.next()) {
            zip = rs.getLong(1);

        }
        con.close();

        return zip;
    }

    public Date getEmployeeStartDate(long employee) throws SQLException {
        Date d;
        Connection con = sqlManager.getConnection();
        String query = "SELECT Start_Date FROM employee e WHERE e.Employee_Id= ? ";
        PreparedStatement ps = con.prepareStatement(query);
        ps.setLong(1, employee);
        ResultSet rs = ps.executeQuery();
        rs.next();
        d = rs.getDate(1);
        con.close();

        return d;
    }
}
