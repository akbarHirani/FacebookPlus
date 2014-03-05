/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package user;

/**
 *
 * @author Kal
 */
public class Page {
    
    private long pageID;
    private long postCount;
    private long circleID;
    
    public Page(long pageID, long postCount, long circleID) {
        this.pageID = pageID;
        this.postCount = postCount;
        this.circleID = circleID;
    }

    /**
     * @return the pageID
     */
    public long getPageID() {
        return pageID;
    }

    /**
     * @param pageID the pageID to set
     */
    public void setPageID(long pageID) {
        this.pageID = pageID;
    }

    /**
     * @return the postCount
     */
    public long getPostCount() {
        return postCount;
    }

    /**
     * @param postCount the postCount to set
     */
    public void setPostCount(long postCount) {
        this.postCount = postCount;
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
    
}
