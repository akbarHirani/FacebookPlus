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
public class Post {
    
    private long postID;
    private Date date;
    private String content;
    private long commentCnt;
    private long page;
    private long author;
    private long likeCnt;

    public Post (long postID, Date date, String content, long commentCnt, long page, long author, long likeCnt) {
        this.postID = postID;
        this.date = date;
        this.content = content;
        this.commentCnt = commentCnt;
        this.page = page;
        this.author = author;
        this.likeCnt = likeCnt;
    }
    
    /**
     * @return the postID
     */
    public long getPostID() {
        return postID;
    }

    /**
     * @return the date
     */
    public Date getDate() {
        return date;
    }

    /**
     * @return the content
     */
    public String getContent() {
        return content;
    }

    /**
     * @return the commentCnt
     */
    public long getCommentCount() {
        return commentCnt;
    }

    /**
     * @return the page
     */
    public long getPage() {
        return page;
    }

    /**
     * @return the author
     */
    public long getAuthor() {
        return author;
    }

    /**
     * @return the likeCnt
     */
    public long getLikeCount() {
        return likeCnt;
    }
    
}
