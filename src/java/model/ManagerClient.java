/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author Kal
 */
public class ManagerClient extends Client {
   
    //Don't use this constructor
    public ManagerClient() {
        throw new UnsupportedOperationException("Not yet implemented");
    }       
    
    public ManagerClient (long personID) {
        super(personID, AccountType.EMPLOYEE);
    }
    
    //Insert methods here


}
