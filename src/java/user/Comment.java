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
public class Comment {
    
    private String content;
    private long commentID;
    private Date date;
    private long author;
    private long postID;
    private long likeCount;
    
    public Comment (long commentID,  Date date, String content,long post, long author, long likeCount ){
        this.commentID = commentID;
        this.date = date;
        this.content = content;
        this.author = author;
        this.postID = post;        
        this.likeCount = likeCount;
    }
    
    //Used for inserts...
    public Comment (long commentID,  Date date, String content, long post, long author){
        this.commentID = commentID;
        this.date = date;
        this.content = content;
        this.author = author;
        this.postID = post;        
    }
    /**
     * @return the content
     */
    public String getContent() {
        return content;
    }

    /**
     * @param content the content to set
     */
    public void setContent(String content) {
        this.content = content;
    }

    /**
     * @return the commentID
     */
    public long getCommentID() {
        return commentID;
    }

    /**
     * @param commentID the commentID to set
     */
    public void setCommentID(long commentID) {
        this.commentID = commentID;
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
     * @return the author
     */
    public long getAuthor() {
        return author;
    }

    /**
     * @param author the author to set
     */
    public void setAuthor(long author) {
        this.author = author;
    }

    /**
     * @return the postID
     */
    public long getPostID() {
        return postID;
    }

    /**
     * @param postID the postID to set
     */
    public void setPostID(long postID) {
        this.postID = postID;
    }

    /**
     * @return the likeCount
     */
    public long getLikeCount() {
        return likeCount;
    }

    /**
     * @param likeCount the likeCount to set
     */
    public void setLikeCount(long likeCount) {
        this.likeCount = likeCount;
    }
    
}
