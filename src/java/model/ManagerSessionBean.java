/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author Kal
 */
public class ManagerSessionBean {
    private final ManagerClient managerClient;
        
    /**
     *
     */
    public ManagerSessionBean() {
        managerClient = new ManagerClient();
    }
    
    public ManagerSessionBean(long personID) {
        managerClient = new ManagerClient(personID);
    }
    //Getter's setters's and things that call the employeeClient 

}
