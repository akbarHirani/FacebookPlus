/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 * Bean for a employee's login session
 * 
 * @author Kal
 * @coauthor Jacky
 */
public class EmployeeSessionBean {
    
    private long personID;
    private String firstName;
    private String lastName;
    private long employeeID;
    
    private EmployeeClient employeeClient;
    
    public EmployeeSessionBean (long personID){
        this.personID = personID;
        employeeClient = new EmployeeClient(personID);        
    }
    
    
    //Getter's setters's and things that call the employeeClient 

    /**
     * @return the personID
     */
    public long getPersonID() {
        return personID;
    }

    /**
     * @param personID the personID to set
     */
    public void setPersonID(long personID) {
        this.personID = personID;
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
     * @return the employeeClient
     */
    public EmployeeClient getEmployeeClient() {
        return employeeClient;
    }

    /**
     * @return the employeeID
     */
    public long getEmployeeID() {
        return employeeID;
    }

    /**
     * @param employeeID the employeeID to set
     */
    public void setEmployeeID(long employeeID) {
        this.employeeID = employeeID;
    }
}
