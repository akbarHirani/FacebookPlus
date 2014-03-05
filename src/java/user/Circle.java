/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package user;

/**
 *
 * @author Kal
 */
public class Circle {
    
    private long circleID;
    private String circleName;
    private long circleOwner;
    private String type;
    
    public Circle (long circleID, String circleName, long circleOwner, String type) {
        this.circleID = circleID;
        this.circleName = circleName;
        this.circleOwner = circleOwner;
        this.type = type;
    }

    /**
     * @return the circleID
     */
    public long getCircleID() {
        return circleID;
    }

    /**
     * @param circleID the circleID to set
     */
    public void setCircleID(long circleID) {
        this.circleID = circleID;
    }

    /**
     * @return the circleName
     */
    public String getCircleName() {
        return circleName;
    }

    /**
     * @param circleName the circleName to set
     */
    public void setCircleName(String circleName) {
        this.circleName = circleName;
    }

    /**
     * @return the circleOwner
     */
    public long getCircleOwner() {
        return circleOwner;
    }

    /**
     * @param circleOwner the circleOwner to set
     */
    public void setCircleOwner(long circleOwner) {
        this.circleOwner = circleOwner;
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
    
    
   
}
