/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import user.Message;
import controller.SQLManager;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import user.AdItem;
import user.Circle;
import user.Comment;
import user.Page;
import user.Post;
import user.Purchase;
import user.SearchedUser;

/**
 * Used to call DB for Users
 * @author Kal
 */
public class UserClient extends Client{

    private long userID;
    
    public UserClient(){
        super();
    }
    
    public UserClient(long userID) throws SQLException {
        super(userID, AccountType.USER);
        this.userID = userID;
    }
 
    //Transactions

    public void setUserID(long userID) {
        this.userID = userID;
    }
    
    
    public long getUserID(){ 
        return this.userID;
    }
    
    public String getFirstName() throws SQLException {
        Connection con = sqlManager.getConnection();
        
        String query = "SELECT First_Name FROM user WHERE User_Id = ?";
        PreparedStatement ps = con.prepareStatement(query);    
        ps.setLong(1, userID);
        ResultSet rs = ps.executeQuery();
        rs.next();
        String firstName = rs.getString(1);
        con.close();
        
        return firstName;
    }

    public String getLastName() throws SQLException {
        Connection con = sqlManager.getConnection();
        
        String query = "SELECT Last_Name FROM user WHERE User_Id = ?";
        PreparedStatement ps = con.prepareStatement(query);    
        ps.setLong(1, userID);
        ResultSet rs = ps.executeQuery();
        rs.next();
        String lastName = rs.getString(1);
       
        con.close();
        
        return lastName;    
    }
    
    public ArrayList<Long> getAccountNumbers(long userID) throws SQLException {
        
        ArrayList<Long> accountNumbers = new ArrayList<Long>();
        Connection con = sqlManager.getConnection();
        
        String query = "SELECT Account_Number FROM user_has_account WHERE User_Id = ?";
        PreparedStatement ps = con.prepareStatement(query);
        ps.setLong(1, userID);
        
        ResultSet rs = ps.executeQuery();
        
        while(rs.next()) {
            accountNumbers.add(rs.getLong("Account_Number"));
        }
        
        con.close();
        
        return accountNumbers;
    }
    
    public String getAddress () throws SQLException {
        Connection con = sqlManager.getConnection();
        
        String query = "SELECT Address FROM user WHERE User_Id = ?";
        PreparedStatement ps = con.prepareStatement(query);    
        ps.setLong(1, userID);
        ResultSet rs = ps.executeQuery();
        rs.next();
        String address = rs.getString(1);
       
        con.close();
        
        return address;
    }

    public long getZipCode () throws SQLException {
        Connection con = sqlManager.getConnection();
        
        String query = "SELECT Zip_Code FROM user WHERE User_Id = ?";
        PreparedStatement ps = con.prepareStatement(query);    
        ps.setLong(1, userID);
        ResultSet rs = ps.executeQuery();
        rs.next();
        long zipCode = rs.getLong(1);
       
        con.close();
        
        return zipCode;
    }
    
    public String getCity () throws SQLException {
        Connection con = sqlManager.getConnection();
        
        String query = "SELECT City FROM user WHERE User_Id = ?";
        PreparedStatement ps = con.prepareStatement(query);    
        ps.setLong(1, userID);
        ResultSet rs = ps.executeQuery();
        rs.next();
        String city = rs.getString(1);
       
        con.close();
        
        return city;        
    }
    
    public String getState () throws SQLException {
        Connection con = sqlManager.getConnection();
        
        String query = "SELECT State FROM user WHERE User_Id = ?";
        PreparedStatement ps = con.prepareStatement(query);    
        ps.setLong(1, userID);
        ResultSet rs = ps.executeQuery();
        rs.next();
        String state = rs.getString(1);
       
        con.close();
        
        return state;         
    }
    
    public Date getDateOfBirth () throws SQLException {
        Connection con = sqlManager.getConnection();
        
        String query = "SELECT DateOfBirth FROM user WHERE User_Id = ?";
        PreparedStatement ps = con.prepareStatement(query);    
        ps.setLong(1, userID);
        ResultSet rs = ps.executeQuery();
        rs.next();
        Date dateOfBirth = rs.getDate(1);
       
        con.close();
        
        return dateOfBirth;             
    }
    
    public long getTelephone () throws SQLException {
        Connection con = sqlManager.getConnection();
        
        String query = "SELECT Telephone FROM user WHERE User_Id = ?";
        PreparedStatement ps = con.prepareStatement(query);    
        ps.setLong(1, userID);
        ResultSet rs = ps.executeQuery();
        rs.next();
        long telephone = rs.getLong(1);
       
        con.close();
        
        return telephone;       
    }
    
    public String getEmail () throws SQLException {
        Connection con = sqlManager.getConnection();
        
        String query = "SELECT Email FROM user WHERE User_Id = ?";
        PreparedStatement ps = con.prepareStatement(query);    
        ps.setLong(1, userID);
        ResultSet rs = ps.executeQuery();
        rs.next();
        String email = rs.getString(1);
       
        con.close();
        
        return email;  
    }
    
    public String getGender ( ) throws SQLException {
        Connection con = sqlManager.getConnection();
        
        String query = "SELECT Gender FROM user WHERE User_Id = ?";
        PreparedStatement ps = con.prepareStatement(query);    
        ps.setLong(1, userID);
        ResultSet rs = ps.executeQuery();
        rs.next();
        String gender = rs.getString(1);
       
        con.close();
        
        return gender;  
    }
    
    public String getCircleName (long circleId) throws SQLException {
        Connection con = sqlManager.getConnection();
        
        String query = "SELECT Circle_Name FROM circle C WHERE C.Circle_Id = ?";
        PreparedStatement ps = con.prepareStatement(query);    
        ps.setLong(1, circleId);
        ResultSet rs = ps.executeQuery();
        rs.next();
        String name = rs.getString(1);
        
        con.close();
        
        return name; 
    }
    
    public ArrayList<Long> getOwnerOfCircleIds () throws SQLException {
        Connection con = sqlManager.getConnection();
        ArrayList<Long> circleIds = new ArrayList<Long> ();
        
        String query = "SELECT Circle_Id from circle WHERE Owner_Of_Circle = ?";
        PreparedStatement ps = con.prepareStatement(query);
        ps.setLong(1, userID);
        ResultSet rs = ps.executeQuery();
        
        while(rs.next())
        {
            circleIds.add(rs.getLong(1));
        }        
        
        con.close();
        
        return circleIds;
        
    }
    
    public boolean isInCircle(long circleID) throws SQLException {
        return this.isInCircle(userID, circleID);
    }
    
    public ArrayList<Long> getCircleIds () throws SQLException {
        Connection con = sqlManager.getConnection();
        ArrayList <Long> circleIds = new ArrayList<Long>();
        
        String query = "SELECT Circle_Id FROM addedto A WHERE User_Id = ?";
        PreparedStatement ps = con.prepareStatement(query);    
        ps.setLong(1, userID);
        ResultSet rs = ps.executeQuery();
        while(rs.next()) {
            circleIds.add(rs.getLong(1));
        }
        
        con.close();
        
        return circleIds; 
    }
    
    public ArrayList<Long> getCircleIds (long otherUser) throws SQLException {
        Connection con = sqlManager.getConnection();
        ArrayList <Long> circleIds = new ArrayList<Long>();
        
        String query = "SELECT Circle_Id FROM addedto A WHERE User_Id = ?";
        PreparedStatement ps = con.prepareStatement(query);    
        ps.setLong(1, otherUser);
        ResultSet rs = ps.executeQuery();
        while(rs.next()) {
            circleIds.add(rs.getLong(1));
        }
        
        con.close();
        
        return circleIds; 
    }    
    
    public ArrayList<Long> getPageIds (long circleID) throws SQLException {
        Connection con = sqlManager.getConnection();
        ArrayList <Long> circleIds = new ArrayList<Long>();
        
        String query = "SELECT Page_Id FROM page P WHERE Associated_Circle_Id = ?";
        PreparedStatement ps = con.prepareStatement(query);    
        ps.setLong(1, circleID);
        ResultSet rs = ps.executeQuery();
        while(rs.next()) {
            circleIds.add(rs.getLong(1));
        }
       
        con.close();
        
        return circleIds;  
    }
    
    public String getPostContent (long postID) throws SQLException {
        Connection con = sqlManager.getConnection();
        
        String query = "SELECT Content FROM post P WHERE Post_Id = ?";
        PreparedStatement ps = con.prepareStatement(query);    
        ps.setLong(1, postID);
        ResultSet rs = ps.executeQuery();
        rs.next();        
        String content = rs.getString(1);
        
        con.close();
        
        return content;             
    }
    
    public ArrayList<Long> getPostIds (long pageID) throws SQLException {
        Connection con = sqlManager.getConnection();
        ArrayList <Long> postIds = new ArrayList<Long>();
        
        String query = "SELECT Post_Id FROM post P WHERE Page = ?";
        PreparedStatement ps = con.prepareStatement(query);    
        ps.setLong(1, pageID);
        ResultSet rs = ps.executeQuery();
        while(rs.next()) {
            postIds.add(rs.getLong(1));
        }
       
        con.close();        
        return postIds;
    }
    
    public ArrayList<Long> getCommentIds (long postId) throws SQLException {
        Connection con = sqlManager.getConnection();
        ArrayList <Long> commentIds = new ArrayList<Long>();
        
        String query = "SELECT Comment_Id FROM comment C WHERE Post = ?";
        PreparedStatement ps = con.prepareStatement(query);    
        ps.setLong(1, postId);
        ResultSet rs = ps.executeQuery();
        while(rs.next()) {
            commentIds.add(rs.getLong(1));
        }
        
        con.close(); 
        return commentIds;   
    }
    
    public String getCommentContent(long commentId) throws SQLException {
        Connection con = sqlManager.getConnection();
        
        String query = "SELECT Content FROM comment C WHERE Comment_Id = ?";
        PreparedStatement ps = con.prepareStatement(query);    
        ps.setLong(1, commentId);
        ResultSet rs = ps.executeQuery();
        rs.next();
        String commentContent = rs.getString(1);
        
        con.close();        
        return commentContent;       
    }
    
    public ArrayList<Long> getConversationPartners() throws SQLException {
        ArrayList<Long> convoPartners = new ArrayList<Long> ();
        
        //Get all the people that they sent to
        
        String queryPeopleTheyTalkTo = "(SELECT Receiver AS Friend FROM message WHERE Sender = ?)"
                 +"union (SELECT Sender AS Friend FROM message WHERE Receiver = ?)";
        
        Connection con = sqlManager.getConnection();
        PreparedStatement ps = con.prepareStatement(queryPeopleTheyTalkTo);
        
        ps.setLong(1, userID);
        ps.setLong(2, userID);
        
        ResultSet rs = ps.executeQuery();
        
        while(rs.next()) {
            convoPartners.add(rs.getLong(1)); //Only 1 column anyway
        }
        
        con.close();
        return convoPartners;
    }
    
    public ArrayList<Message> getMessagesWithUser(long otherUserID) throws SQLException {
        
        ArrayList<Message> messages = new ArrayList<Message> ();
        
        //Get the messages given a user ID
        String query = "(SELECT * FROM message WHERE Receiver = ? AND Sender = ?) union"
                + "(SELECT * FROM message WHERE Receiver = ? AND Sender = ? ORDER BY Date DESC)";
        
        Connection con = sqlManager.getConnection();
        PreparedStatement ps = con.prepareStatement(query);
        
        ps.setLong(1, userID);
        ps.setLong(2, otherUserID);
        
        ps.setLong(3, otherUserID);
        ps.setLong(4, userID);
                
        ResultSet rs = ps.executeQuery();
        
        while(rs.next()) {
            String message = rs.getString("Content");
            String subject = rs.getString("Subject");
            long sender = rs.getLong("Sender");
            long reciever = rs.getLong("Receiver");
            Date date = rs.getDate("Date");
            long messageID = rs.getLong("Message_ID");
            
            Message msg = new Message(messageID, date, sender, reciever, message, subject);
            
            messages.add(msg);
        }
        
        con.close();
        
        return messages;
    }
    
    public String getFirstName(long userIDS) throws SQLException {
        Connection con = sqlManager.getConnection();
        
        String query = "SELECT First_Name FROM user U WHERE U.User_Id = ?";
                
        PreparedStatement ps = con.prepareStatement(query);        
        ps.setLong(1, userIDS);
        
        ResultSet rs = ps.executeQuery();
        
        rs.next();
        String firstName = rs.getString(1);
        
        con.close();
        return firstName;
    }
    
    public String getLastName(long userIDS) throws SQLException {
        Connection con = sqlManager.getConnection();
        
        String query = "SELECT Last_Name FROM user U WHERE U.User_Id = ?";
        PreparedStatement ps = con.prepareStatement(query);        
        ps.setLong(1, userIDS);
        
        ResultSet rs = ps.executeQuery();
        
        rs.next();
        String lastName = rs.getString(1);
        
        con.close();
        return lastName; 
        
    }
    
    public int insertMessage(Message msg) throws SQLException {
        Connection con = sqlManager.getConnection();
        con.setAutoCommit(false);
        String query = "INSERT INTO message (Message_Id, Sender, Receiver, Subject, Content, Date) VALUES (?,?,?,?,?,?)";
                
        PreparedStatement ps = con.prepareStatement(query);
        
        ps.setLong(1, msg.getMessageID());
        ps.setLong(2, msg.getSender());
        ps.setLong(3, msg.getReciever());
        ps.setString(4, msg.getSubject());
        ps.setString(5, msg.getMessage());
        ps.setDate(6, msg.getDate());
        int retval = ps.executeUpdate();
        
        if(retval < 0) {
            con.rollback();
        }
        else{
            con.commit();
        }
        con.close();
        return retval;
    }
    
    public long getNextMessageID() throws SQLException {
        Connection con = sqlManager.getConnection();
        
        String maxQ = "SELECT MAX(Message_Id)+1 FROM message";
        PreparedStatement maxS = con.prepareStatement(maxQ);
        
        ResultSet rs = maxS.executeQuery();
        rs.next();
        
        long nextId = rs.getLong(1);
        con.close();
        return nextId;
    }
    
    public int deleteMessageByID(long messageID) throws SQLException {
        Connection con = sqlManager.getConnection();
        
        String query = "DELETE FROM message WHERE Message_Id = ?";
        PreparedStatement ps = con.prepareStatement(query);
        ps.setLong(1, messageID);
        
        int retval = ps.executeUpdate();

        con.close();
        return retval;
    }
    
    public Circle getCircle(long circleID) throws SQLException {
        Connection con = sqlManager.getConnection();
        
        String query = "SELECT * FROM circle WHERE Circle_Id = ?";
        PreparedStatement ps = con.prepareStatement(query);
        ps.setLong(1, circleID);
        
        ResultSet rs = ps.executeQuery();
        rs.next();
        
        String circleName = rs.getString("Circle_Name");
        String type = rs.getString("Type");
        long ownerOfCircle = rs.getLong("Owner_Of_Circle");

        Circle circle = new Circle(circleID, circleName, ownerOfCircle, type);
        
        con.close();
        return circle;
    }
    
    public ArrayList<Post> getPosts(long pageID) throws SQLException {
        Connection con = sqlManager.getConnection();
        ArrayList<Post> posts = new ArrayList<Post>();
        String query = "SELECT * FROM post WHERE Page=? ORDER BY Date DESC";
        PreparedStatement ps = con.prepareStatement(query);
        ps.setLong(1, pageID);
        
        ResultSet rs = ps.executeQuery();
        while(rs.next()) {
            Date date = rs.getDate("Date");
            String content = rs.getString("Content");
            long id = rs.getLong("Post_Id");
            long author = rs.getLong("Author");
            long likeCount = rs.getLong("Like_Count");
            long page = rs.getLong("Page");
            long commentCount = rs.getLong("Comment_Count");
            
            Post post = new Post(id, date, content, commentCount, page, author, likeCount);
            posts.add(post);
        }
        
        con.close();
        return posts;
    }    
    
    public String getFullName(long userIDs) throws SQLException {
        String firstNameByQ = this.getFirstName(userIDs);
        String lastNameByQ = this.getLastName(userIDs);
        
        return firstNameByQ + " " + lastNameByQ;
    }
    
    public ArrayList<Comment> getComments(long postID) throws SQLException {
        Connection con = sqlManager.getConnection();
        ArrayList<Comment> comments = new ArrayList<Comment>();
        String query = "SELECT * FROM comment WHERE Post=? ORDER BY Date DESC";
        PreparedStatement ps = con.prepareStatement(query);
        ps.setLong(1, postID);
        
        ResultSet rs = ps.executeQuery();
        while(rs.next()) {
            Date date = rs.getDate("Date");
            String content = rs.getString("Content");
            long post = rs.getLong("Post");
            long author = rs.getLong("Author");
            long likeCount = rs.getLong("Like_Count");
            long id = rs.getLong("Comment_Id");
            
            Comment comment = new Comment(id, date, content, post, author, likeCount);
            comments.add(comment);
        }
        
        con.close();
        return comments;
    }
    
    public boolean userLikesComment(long commentID) throws SQLException {
        Connection con = sqlManager.getConnection();
        
        String query = "SELECT * FROM user_likes_comment WHERE User = ? AND Comment = ?";
        PreparedStatement ps = con.prepareStatement(query);
        ps.setLong(1, userID);
        ps.setLong(2, commentID);
        
        ResultSet rs = ps.executeQuery();
        
        if (!rs.next()){
            //Empty!
            con.close();
            return false;
        } else {
            //There was a row
            con.close();
            return true;
        }
    }
    
    public int unlikeComment(long commentID) throws SQLException {
        Connection con = sqlManager.getConnection();
        con.setAutoCommit(false);
        
        String query2 = "UPDATE comment SET Like_Count = Like_Count - 1 WHERE Comment_Id = ?";
        PreparedStatement ps = con.prepareStatement(query2);
        ps.setLong(1, commentID);    
        ps.executeUpdate();
        
        String query = "DELETE FROM user_likes_comment WHERE User = ? AND Comment = ?";
        PreparedStatement ps2 = con.prepareStatement(query);
        ps2.setLong(1, userID);
        ps2.setLong(2, commentID);
        
        int retval = ps2.executeUpdate();
        
        if(retval < 0) {
            con.rollback();
        } else{
            con.commit();
        }
        
        con.close();
        return retval;
        
    }

    public int likeComment(long commentID) throws SQLException {
        Connection con = sqlManager.getConnection();
        con.setAutoCommit(false);
        
        String query2 = "UPDATE comment SET Like_Count = Like_Count + 1 WHERE Comment_Id = ?";
        PreparedStatement ps = con.prepareStatement(query2);
        ps.setLong(1, commentID);    
        ps.executeUpdate();
        
        String query = "INSERT INTO user_likes_comment (User, Comment) VALUES(?, ?)";
        PreparedStatement ps2 = con.prepareStatement(query);
        ps2.setLong(1, userID);
        ps2.setLong(2, commentID);
        
        int retval = ps2.executeUpdate();
        
        if(retval < 0) {
            con.rollback();
        } else{
            con.commit();
        }
        
        con.close();
        return retval;
    }
    
    public long getNextCommentID() throws SQLException {
        Connection con = sqlManager.getConnection();
        
        String maxQ = "SELECT MAX(Comment_Id)+1 FROM comment";
        PreparedStatement maxS = con.prepareStatement(maxQ);
        
        ResultSet rs = maxS.executeQuery();
        rs.next();
        
        long nextId = rs.getLong(1);
        con.close();
        
        return nextId;
    }

    public int insertComment(Comment comment) throws SQLException {
        Connection con = sqlManager.getConnection();
        
        //Turn autocommit off
        con.setAutoCommit(false);
        
        //Insert content        
        String insertQ = "INSERT INTO comment (Comment_Id, Date, Content, Post, Author, Like_Count) "
                + "VALUES(?,?,?,?,?,?)";
        PreparedStatement ps = con.prepareStatement(insertQ);
        
        ps.setLong(1, comment.getCommentID());
        ps.setDate(2, comment.getDate());
        ps.setString(3, comment.getContent());
        ps.setLong(4, comment.getPostID());
        ps.setLong(5, comment.getAuthor());
        ps.setLong(6, comment.getLikeCount());
        
        //Try to insert
        int retval = ps.executeUpdate();                
        
        //Update Commentcount
        
        String updateCountQ = "UPDATE post SET Comment_Count = Comment_Count + 1";
        PreparedStatement ps2 = con.prepareStatement(updateCountQ);
        int retval2 = ps2.executeUpdate();
        
        if(retval2 < 0 || retval < 0) {
            //If any of the updates failed.. we rollback
            con.rollback();
            con.close();
            throw new SQLException("Failed to post, try again");
        } else {
            con.commit();
            con.close();
        }
        
        return retval2 + retval;
    }

    public boolean userLikesPost(long postIDLong) throws SQLException {
        Connection con = sqlManager.getConnection();
        
        String query = "SELECT * FROM user_likes_post WHERE User = ? AND Post = ?";
        PreparedStatement ps = con.prepareStatement(query);
        ps.setLong(1, userID);
        ps.setLong(2, postIDLong);
        
        ResultSet rs = ps.executeQuery();
        
        if (!rs.next()){
            //Empty!
            con.close();
            return false;
        } else {
            //There was a row
            con.close();
            return true;
        }
    }
 
    public int unlikePost(long postID) throws SQLException {
        Connection con = sqlManager.getConnection();
        con.setAutoCommit(false);
        
        String query2 = "UPDATE post SET Like_Count = Like_Count - 1 WHERE Post_Id = ?";
        PreparedStatement ps = con.prepareStatement(query2);
        ps.setLong(1, postID);    
        ps.executeUpdate();
        
        String query = "DELETE FROM user_likes_post WHERE User = ? AND Post = ?";
        PreparedStatement ps2 = con.prepareStatement(query);
        ps2.setLong(1, userID);
        ps2.setLong(2, postID);
        
        int retval = ps2.executeUpdate();
        
        if(retval < 0) {
            con.rollback();
        } else{
            con.commit();
        }
        
        con.close();
        return retval;
        
    }

    public int likePost(long postID) throws SQLException {
        Connection con = sqlManager.getConnection();
        con.setAutoCommit(false);
        
        String query2 = "UPDATE post SET Like_Count = Like_Count + 1 WHERE Post_Id = ?";
        PreparedStatement ps = con.prepareStatement(query2);
        ps.setLong(1, postID);    
        ps.executeUpdate();
        
        String query = "INSERT INTO user_likes_post (User, Post) VALUES(?, ?)";
        PreparedStatement ps2 = con.prepareStatement(query);
        ps2.setLong(1, userID);
        ps2.setLong(2, postID);
        
        int retval = ps2.executeUpdate();
        
        if(retval < 0) {
            con.rollback();
        } else{
            con.commit();
        }
        
        con.close();
        return retval;
    }
    
    public boolean isAuthorOfPost(long postID) throws SQLException {
        Connection con = sqlManager.getConnection();
        String query = "SELECT * FROM post WHERE Author = ? AND Post_Id = ?";
        
        PreparedStatement ps = con.prepareCall(query);
        ps.setLong(1, userID);
        ps.setLong(2, postID);
        
        ResultSet rs = ps.executeQuery();
        
        if(!rs.next()) {
            con.close();
            return false;            
        } else {
            con.close();
            return true;
        }
    }
    
    public boolean isOwnerOfCircle(long circleID) throws SQLException {
        Connection con = sqlManager.getConnection();
        String query = "SELECT * FROM circle WHERE Owner_Of_Circle = ? AND Circle_Id = ?";
        
        PreparedStatement ps = con.prepareCall(query);
        ps.setLong(1, userID);
        ps.setLong(2, circleID);
        
        ResultSet rs = ps.executeQuery();
        
        if(!rs.next()) {
            con.close();
            return false;            
        } else {
            con.close();
            return true;
        }
    }
    
    public boolean isAuthorOfComment(long commentID) throws SQLException {
        Connection con = sqlManager.getConnection();
        String query = "SELECT * FROM comment WHERE Author = ? AND Comment_Id = ?";
        
        
        PreparedStatement ps = con.prepareCall(query);
        ps.setLong(1, userID);
        ps.setLong(2, commentID);
        
        ResultSet rs = ps.executeQuery();
        
        if(!rs.next()) {
            con.close();
            return false;            
        } else {
            con.close();
            return true;
        }
    }

    public long getPostOfComment(long commentID) throws SQLException {
        String query = "SELECT Post FROM comment WHERE Comment_Id = ?";        
        Connection con = sqlManager.getConnection();
        PreparedStatement ps = con.prepareStatement(query);
        ps.setLong(1, commentID);
        
        ResultSet rs = ps.executeQuery();
        rs.next();
        long post = rs.getLong(1);
                con.close();

        return post;
    }
    
    public int deleteCommentById(long commentID) throws SQLException {
        Connection con = sqlManager.getConnection();
        con.setAutoCommit(false);
       
        long parentPost = getPostOfComment(commentID);
        
        String query = "DELETE FROM comment WHERE Comment_Id = ?";
        PreparedStatement ps = con.prepareStatement(query);
        ps.setLong(1, commentID);
        
        int retval = ps.executeUpdate();
        
        String query2 = "UPDATE post SET Comment_Count = Comment_Count - 1 WHERE Post_Id = ?";
        PreparedStatement ps2 = con.prepareStatement(query2);
        ps2.setLong(1, parentPost);
        
        int retval2 = ps2.executeUpdate();
        
        if(retval < 0 || retval2 < 0 ){
            con.rollback();
            con.close();
            throw new SQLException("Atomicity failed");                        
        } 
        
        con.commit();
        con.close();
        return retval + retval2;
    }
 
    public int deletePostById(long postID) throws SQLException {
        Connection con = sqlManager.getConnection();
        con.setAutoCommit(false);
        
        String query = "DELETE FROM post WHERE Post_Id = ?";
        PreparedStatement ps = con.prepareStatement(query);
        ps.setLong(1, postID);
        
        int retval = ps.executeUpdate();
        
        long parentPage = this.getPageOfPost(postID);
        
        String query2 = "UPDATE page SET Post_Count = Post_Count - 1 WHERE Page_Id = ?";
        PreparedStatement ps2 = con.prepareStatement(query2);
        
        ps2.setLong(1, parentPage);
        
        int retval2 = ps2.executeUpdate();
        
        if(retval2 < 0){
            con.rollback();
            con.close();
            throw new SQLException("Atomicity failed");                        
        } 
        
        con.commit();
        con.close();
        return retval + retval2;
    }

    public int updateComment(long commentID, String newMessage) throws SQLException {
        Connection con = sqlManager.getConnection();
        
        String query = "UPDATE comment SET Content = ? WHERE Comment_Id = ?";
        PreparedStatement ps = con.prepareStatement(query);
        ps.setString(1, newMessage);
        ps.setLong(2, commentID);
        
        int retval = ps.executeUpdate();
         con.close();
       
        return retval;
    }

    public int updatePost(long postIDL, String newMessage) throws SQLException {
        Connection con = sqlManager.getConnection();
        
        String query = "UPDATE post SET Content = ? WHERE Post_Id = ?";
        PreparedStatement ps = con.prepareStatement(query);
        ps.setString(1, newMessage);
        ps.setLong(2, postIDL);
        
        int retval = ps.executeUpdate();
        
        con.close();
        return retval;    
    }

    public long getNextPostID() throws SQLException {
        Connection con = sqlManager.getConnection();
        
        String maxQ = "SELECT MAX(Post_Id)+1 FROM post";
        PreparedStatement maxS = con.prepareStatement(maxQ);
        
        ResultSet rs = maxS.executeQuery();
        rs.next();
        
        long nextId = rs.getLong(1);
        con.close();
        
        return nextId;    
    }

    public int insertPost(Post post) throws SQLException {
        Connection con = sqlManager.getConnection();
        
        //Turn autocommit off
        con.setAutoCommit(false);
        
        //Insert content        
        String insertQ = "INSERT INTO post (Post_Id, Date, Content, Comment_Count, Page, Author, Like_Count) "
                + "VALUES(?,?,?,?,?,?,?)";
        PreparedStatement ps = con.prepareStatement(insertQ);
        
        ps.setLong(1, post.getPostID());
        ps.setDate(2, post.getDate());
        ps.setString(3, post.getContent());
        ps.setLong(4, post.getCommentCount());
        ps.setLong(5, post.getPage());
        ps.setLong(6, post.getAuthor());
        ps.setLong(7, post.getLikeCount());
        
        //Try to insert
        int retval = ps.executeUpdate();                
        
        //Update Commentcount
        
        String updateCountQ = "UPDATE page SET Post_Count = Post_Count + 1";
        PreparedStatement ps2 = con.prepareStatement(updateCountQ);
        int retval2 = ps2.executeUpdate();
        
        if(retval2 < 0 || retval < 0) {
            //If any of the updates failed.. we rollback
            con.rollback();
            con.close();
            throw new SQLException("Failed to post, try again");
        } else {
            con.commit();
            con.close();
        }
        
        return retval2 + retval;
    }

    public long getNextCircleID() throws SQLException {
        Connection con = sqlManager.getConnection();
        
        String maxQ = "SELECT MAX(Circle_Id)+1 FROM circle";
        PreparedStatement maxS = con.prepareStatement(maxQ);
        
        ResultSet rs = maxS.executeQuery();
        rs.next();
        
        long nextId = rs.getLong(1);
        con.close();
        return nextId;
    }

    public int insertCircle(Circle circle) throws SQLException {
        //Add the circle, then the author to "Addedto", if fails. rollback...
        Connection con = sqlManager.getConnection();
        
        //Turn autocommit off
        con.setAutoCommit(false);
        
        //Insert content        
        String insertQ = "INSERT INTO circle (Circle_Id, Circle_Name, Owner_Of_Circle, Type) "
                + "VALUES(?,?,?,?)";
        PreparedStatement ps = con.prepareStatement(insertQ);
        
        ps.setLong(1, circle.getCircleID());
        ps.setString(2, circle.getCircleName());
        ps.setLong(3, circle.getCircleOwner());
        ps.setString(4, circle.getType());
        
        //Try to insert
        int retval = ps.executeUpdate();                
        
        //Update Commentcount
        
        String updateCountQ = "INSERT INTO addedto (Circle_Id, User_Id) VALUES (?, ?)";
        PreparedStatement ps2 = con.prepareStatement(updateCountQ);
        ps2.setLong(1, circle.getCircleID());
        ps2.setLong(2, circle.getCircleOwner());
        
        int retval2 = ps2.executeUpdate();
        
        if(retval2 < 0 || retval < 0) {
            //If any of the updates failed.. we rollback
            con.rollback();
            con.close();
            throw new SQLException("Failed to post, try again");
        } else {
            con.commit();
            con.close();
        }
        
        return retval2 + retval;
        
    }

    public long getNextPageId() throws SQLException {
        Connection con = sqlManager.getConnection();
        
        String maxQ = "SELECT MAX(Page_Id)+1 FROM page";
        PreparedStatement maxS = con.prepareStatement(maxQ);
        
        ResultSet rs = maxS.executeQuery();
        rs.next();
        
        long nextId = rs.getLong(1);
        con.close();
        return nextId;
    }

    public int insertPage(Page page) throws SQLException {
        Connection con = sqlManager.getConnection();
        
        //Insert content        
        String insertQ = "INSERT INTO page (Page_Id, Post_Count, Associated_Circle_Id)"
                + "VALUES(?,?,?)";
        PreparedStatement ps = con.prepareStatement(insertQ);
        
        ps.setLong(1, page.getPageID());
        ps.setLong(2, page.getPostCount());
        ps.setLong(3, page.getCircleID());
        
        //Try to insert
        int retval = ps.executeUpdate();    
        
        con.close();
        return retval;
    }

    private long getPageOfPost(long postID) throws SQLException {
        String query = "SELECT page FROM post WHERE Post_Id = ?";        
        Connection con = sqlManager.getConnection();
        PreparedStatement ps = con.prepareStatement(query);
        ps.setLong(1, postID);
        
        ResultSet rs = ps.executeQuery();
        rs.next();
        long page = rs.getLong(1);
        
        con.close();
        return page;
    }

    public void deleteCircleById(long circleIDL) throws SQLException {
        Connection con = sqlManager.getConnection();
        
        String query = "DELETE FROM circle WHERE Circle_Id = ?";
        PreparedStatement ps = con.prepareStatement(query);
        ps.setLong(1, circleIDL);
        
        int retval = ps.executeUpdate();
    }

    public boolean isInCircle(long friendToAdd, long circleToAddToL) throws SQLException {
        Connection con = sqlManager.getConnection();
        String query = "SELECT * FROM addedto WHERE User_Id = ? AND Circle_Id = ?";
        
        PreparedStatement ps = con.prepareCall(query);
        ps.setLong(1, friendToAdd);
        ps.setLong(2, circleToAddToL);
        
        ResultSet rs = ps.executeQuery();
        
        if(!rs.next()) {
            con.close();
            return false;            
        } else {
            con.close();
            return true;
        }
    }

    public int addUserToCircle(long friendToAddL, long circleToAddToL) throws SQLException {
        Connection con = sqlManager.getConnection();
        con.setAutoCommit(false);
        String query = "DELETE FROM circle_join_requests WHERE User_Id = ? AND Circle_Id = ?";
        PreparedStatement ps = con.prepareStatement(query);
        ps.setLong(1, friendToAddL);
        ps.setLong(2, circleToAddToL);
        
        int retval = ps.executeUpdate();       
        
        String query2 = "INSERT INTO addedto (Circle_Id, User_Id) VALUES (?,?)";
        
        PreparedStatement ps2 = con.prepareStatement(query2);        
        ps2.setLong(1, circleToAddToL);
        ps2.setLong(2, friendToAddL);
        
        int retval2= ps2.executeUpdate();
        
        if(retval2 < 0) {
            con.rollback();
            con.close();
            return -1;
        }
        
        con.commit();
        con.close();
        return 1;
    }
    
    public ArrayList<Long> getMembersOfCircle(long circleID) throws SQLException {
        Connection con = sqlManager.getConnection();
        String query = "SELECT User_Id FROM addedto WHERE Circle_Id = ?";
        
        ArrayList<Long> members = new ArrayList<Long> ();
        
        PreparedStatement ps = con.prepareStatement(query);        
        ps.setLong(1, circleID);
        
        ResultSet rs = ps.executeQuery();
        
        while(rs.next()) {
            members.add(rs.getLong(1));
        }
        
        con.close();
        return members;
        
    }

    public ArrayList<SearchedUser> searchUsersLike(String firstName, String lastName) throws SQLException {
        ArrayList<SearchedUser> searchedUsers = new ArrayList<SearchedUser> (); 
        
        Connection con = sqlManager.getConnection();
        String query = "SELECT U.User_Id, U.First_Name, U.Last_Name FROM user U"
                + " WHERE U.First_Name LIKE ? AND U.Last_Name LIKE ?";
        
        PreparedStatement ps = con.prepareStatement(query);
        ps.setString(1,"%" + firstName + "%");
        ps.setString(2,"%" + lastName + "%");

        ResultSet rs = ps.executeQuery();

        while(rs.next()) {            
            SearchedUser su = new SearchedUser(rs.getLong("User_Id"),
                    rs.getString("First_Name"),
                    rs.getString("Last_Name")
                    );
            searchedUsers.add(su);
        }
        
        con.close();
        return searchedUsers;
    }

    public int updateCircleName(String newCircleName, long circleID) throws SQLException {
        Connection con = sqlManager.getConnection();
        String query = "UPDATE circle SET Circle_Name = ? WHERE Circle_Id = ?";
        
        PreparedStatement ps = con.prepareStatement(query);
        ps.setString(1, newCircleName);
        ps.setLong(2, circleID);
        
        int retval = ps.executeUpdate();
        
        con.close();
        return retval;
    }
    
    public ArrayList<AdItem> getSuggestedItems() throws SQLException {
        
        ArrayList<AdItem> items = new ArrayList<AdItem> ();
        Connection con = sqlManager.getConnection();
        String query = "SELECT A.* FROM Advertisement A WHERE A.Type IN (SELECT C.Preference FROM user_preferences C WHERE C.Id = ?)";
        
        PreparedStatement ps = con.prepareStatement(query);
        ps.setLong(1, userID);
        
        ResultSet rs = ps.executeQuery();
        
        while(rs.next()) {
            long adID = rs.getLong("Advertisement_Id");
            long employee = rs.getLong("Employee");
            String type= rs.getString("Type");
            Date date = rs.getDate("Date");
            String company = rs.getString("Company");
            String itemName = rs.getString("Item_Name");
            String content = rs.getString("Content");
            long unitprice = rs.getLong("Unit_Price");
            long availUnits = rs.getLong("Available_Units");
            
            AdItem adItem = new AdItem(adID, employee, type, date, company, itemName, content, unitprice, availUnits);
            
            items.add(adItem);
        }
        
        con.close();
        return items;
    }
    
    public AdItem getAdItemById(long adId) throws SQLException {
        Connection con = sqlManager.getConnection();
        String query = "SELECT * FROM advertisement A WHERE A.Advertisement_Id = ?";
        
        PreparedStatement ps = con.prepareStatement(query);
        ps.setLong(1, adId);
        
        ResultSet rs = ps.executeQuery();
        rs.next();
        
        long adID = rs.getLong("Advertisement_Id");
        long employee = rs.getLong("Employee");
        String type= rs.getString("Type");
        Date date = rs.getDate("Date");
        String company = rs.getString("Company");
        String itemName = rs.getString("Item_Name");
        String content = rs.getString("Content");
        long unitprice = rs.getLong("Unit_Price");
        long availUnits = rs.getLong("Available_Units");

        AdItem adItem = new AdItem(adID, employee, type, date, company, itemName, content, unitprice, availUnits);

        return adItem;
    }

    public long getNextPurchaseId() throws SQLException {
        Connection con = sqlManager.getConnection();
        
        String maxQ = "SELECT MAX(Transaction_Id)+1 FROM purchase";
        PreparedStatement maxS = con.prepareStatement(maxQ);
        
        ResultSet rs = maxS.executeQuery();
        rs.next();
        
        long nextId = rs.getLong(1);
        con.close();
        return nextId;
    }

    public int addPurchase(Purchase purchase) throws SQLException {
        //Add the circle, then the author to "Addedto", if fails. rollback...
        Connection con = sqlManager.getConnection();
        
        //Turn autocommit off
        con.setAutoCommit(false);
        
        //Insert content        
        String insertQ = "INSERT INTO purchase (Transaction_Id, Date, Advertisement, Number_Of_Units, Account, User)"
                + "VALUES(?,?,?,?,?,?)";
        PreparedStatement ps = con.prepareStatement(insertQ);
        
        ps.setLong(1, purchase.getTransId());
        ps.setDate(2, purchase.getDate());
        ps.setLong(3, purchase.getAdId());
        ps.setLong(4, purchase.getNumUnits());
        ps.setLong(5, purchase.getAccNum());
        ps.setLong(6, purchase.getUser());
        
        //Try to insert
        int retval = ps.executeUpdate();                
        
        //Update Ad avail unit count
        String updateCountQ = "UPDATE advertisement SET Available_Units = Available_Units - ? WHERE Advertisement_Id = ?";
        PreparedStatement ps2 = con.prepareStatement(updateCountQ);
        ps2.setLong(1, purchase.getNumUnits());
        ps2.setLong(2, purchase.getAdId());
        
        int retval2 = ps2.executeUpdate();
        
        if(retval2 < 0 || retval < 0) {
            //If any of the updates failed.. we rollback
            con.rollback();
            con.close();
            throw new SQLException("Failed to post, try again");
        } else {
            con.commit();
            con.close();
        }
        
        return retval2 + retval;
    }
    
    public ArrayList<AdItem> getBestSellerAdItems() throws SQLException {
        ArrayList<AdItem> items = new ArrayList<AdItem> ();
        Connection con = sqlManager.getConnection();
        String query = "SELECT A.* FROM Advertisement A INNER JOIN AdvertisementSales S ON A.Advertisement_Id = S.Advertisement WHERE A.Available_Units > 0";

        PreparedStatement ps = con.prepareStatement(query);        
        ResultSet rs = ps.executeQuery();
        
        while(rs.next()) {
            long adID = rs.getLong("Advertisement_Id");
            long employee = rs.getLong("Employee");
            String type= rs.getString("Type");
            Date date = rs.getDate("Date");
            String company = rs.getString("Company");
            String itemName = rs.getString("Item_Name");
            String content = rs.getString("Content");
            long unitprice = rs.getLong("Unit_Price");
            long availUnits = rs.getLong("Available_Units");
            
            AdItem adItem = new AdItem(adID, employee, type, date, company, itemName, content, unitprice, availUnits);
            
            items.add(adItem);
        }
        con.close();
        return items;        
    }
    
    public ArrayList<Purchase> getAllPurchases() throws SQLException {
        Connection con = sqlManager.getConnection();
        ArrayList<Purchase> purchases = new ArrayList<Purchase> ();
        String query= "SELECT P.* FROM Purchase P INNER JOIN user_has_account A ON (P.User,P.Account) = (A.User_Id,A.Account_Number) WHERE P.User = ?";
        PreparedStatement ps = con.prepareStatement(query);
        ps.setLong(1, userID);
        
        ResultSet rs = ps.executeQuery();
        
        while(rs.next()) {

            long transId = rs.getLong("Transaction_Id");
            Date date = rs.getDate("Date");
            long ad = rs.getLong("Advertisement");
            long num = rs.getLong("Number_Of_Units");
            long acc = rs.getLong("Account");
            long user = rs.getLong("User");
            
            Purchase p = new Purchase(transId, date, ad, num, acc, user);

            purchases.add(p);
        }
        con.close();
        return purchases;
    }    

    public long getNextAccountId() throws SQLException {
        Connection con = sqlManager.getConnection();
        
        String maxQ = "SELECT MAX(Account_Number)+1 FROM account";
        PreparedStatement maxS = con.prepareStatement(maxQ);
        
        ResultSet rs = maxS.executeQuery();
        rs.next();
        
        long nextId = rs.getLong(1);
        con.close();
        return nextId;
    }
    
    public int addAccount(long ccnumberL) throws SQLException {
        Connection con = sqlManager.getConnection();
        con.setAutoCommit(false);
        
        String query = "INSERT INTO account (Credit_Card_Number, Account_Creation_Date, Account_Number)"
                + " VALUES(?,?,?)";
        
        PreparedStatement ps = con.prepareStatement(query);
        
        //Get max number
        long accId = getNextAccountId();
        
        ps.setLong(1, ccnumberL);
        ps.setDate(2, new Date(System.currentTimeMillis()));
        ps.setLong(3, accId);
        
        int retval = ps.executeUpdate();
        
        //Attach the account id to the user
        String utoaquery = "INSERT INTO user_has_account (User_Id, Account_Number) VALUES(?,?)";
        PreparedStatement useraccps = con.prepareStatement(utoaquery);
        
        useraccps.setLong(1, userID);
        useraccps.setLong(2, accId);
        
        int retval2 = useraccps.executeUpdate();
        
        if(retval2 < 0 || retval < 0) {
            con.rollback();
            con.close();
            
            return -1;
        }
        
        con.commit();
        con.close();
        return 1;
        
        
    }

    public int updateCCNumber(long accId, long ccNumL) throws SQLException {
         Connection con = sqlManager.getConnection();
        
        String query = "UPDATE account SET Credit_Card_Number = ? WHERE Account_Number = ?";
        PreparedStatement ps = con.prepareStatement(query);
        ps.setLong(1, ccNumL);
        ps.setLong(2, accId);
        
        int retval = ps.executeUpdate();
       
        con.close();
        return retval;
    }
    
    public long getCCNumber(long accId) throws SQLException {
        String query = "SELECT Credit_Card_Number FROM account WHERE Account_Number = ?";
        Connection con = sqlManager.getConnection();
        PreparedStatement ps = con.prepareStatement(query);
        ps.setLong(1, accId);
        
        ResultSet rs = ps.executeQuery();
        rs.next();
        long rslt = rs.getLong(1);
        con.close();
        return rslt;
        
    }

    public int deleteAccount(long accNumL) throws SQLException {
        String query = "DELETE FROM account WHERE Account_Number = ?";
        Connection con = sqlManager.getConnection();
        PreparedStatement ps = con.prepareStatement(query);
        
        ps.setLong(1, accNumL);
        int retval = ps.executeUpdate();
        con.close();
        return retval;
        
    }

    public int deleteUserFromCircle(long userIDDel, long circleID) throws SQLException {
        String query = "DELETE FROM addedto WHERE Circle_Id = ? AND User_Id = ?";
        Connection con = sqlManager.getConnection();
        PreparedStatement ps = con.prepareStatement(query);
        
        ps.setLong(1, circleID);
        ps.setLong(2, userIDDel);
        
        int retval = ps.executeUpdate();
        
        con.close();
        return retval;
    }

    public long getNextUserID() throws SQLException {
        Connection con = sqlManager.getConnection();
        
        String maxQ = "SELECT MAX(User_Id)+1 FROM user";
        PreparedStatement maxS = con.prepareStatement(maxQ);
        
        ResultSet rs = maxS.executeQuery();
        rs.next();
        
        long nextId = rs.getLong(1);
        con.close();
        return nextId;    
    }
    
    @Override
        public int updateAddress(String address) throws SQLException {
        Connection con = sqlManager.getConnection();
        
        String query = "UPDATE user SET address=? WHERE User_Id=?";
        PreparedStatement ps = con.prepareStatement(query);
        ps.setString(1, address);
        ps.setLong(2, userID);
        
        int retval = ps.executeUpdate();
        
        con.close();
        
        return retval;
    }
    
   
    @Override
    public int updateState(String state) throws SQLException {
        Connection con = sqlManager.getConnection();
        
        String query = "UPDATE user SET state=? WHERE User_Id=?";
        PreparedStatement ps = con.prepareStatement(query);
        ps.setString(1, state);
        ps.setLong(2, userID);
        
        int retval = ps.executeUpdate();
        
        con.close();
        
        return retval;
    }    
    
    @Override
    public int updateCity(String city) throws SQLException {
        Connection con = sqlManager.getConnection();
        
        String query = "UPDATE user SET city=? WHERE User_Id=?";
        PreparedStatement ps = con.prepareStatement(query);
        ps.setString(1, city);
        ps.setLong(2, userID);
        
        int retval = ps.executeUpdate();
        
        con.close();
        
        return retval;
    }    
    
    @Override
    public int updateZipcode(long zipcode) throws SQLException {
        Connection con = sqlManager.getConnection();
        
        String query = "UPDATE user SET Zip_Code=? WHERE User_Id=?";
        PreparedStatement ps = con.prepareStatement(query);
        ps.setLong(1, zipcode);
        ps.setLong(2, userID);
        
        int retval = ps.executeUpdate();
        
        con.close();
        
        return retval;
    }    
    
    @Override
    public int updateEmail(String email) throws SQLException {
        Connection con = sqlManager.getConnection();
        
        String query = "UPDATE user SET Email_Address=? WHERE User_Id=?";
        PreparedStatement ps = con.prepareStatement(query);
        ps.setString(1, email);
        ps.setLong(2, userID);
        
        int retval = ps.executeUpdate();
        
        con.close();
        
        return retval;
    }
    
    @Override
    public int updateTelephone(long telephone) throws SQLException {
        Connection con = sqlManager.getConnection();
        
        String query = "UPDATE user SET Telephone=? WHERE User_Id=?";
        PreparedStatement ps = con.prepareStatement(query);
        ps.setLong(1, telephone);
        ps.setLong(2, userID);
        
        int retval = ps.executeUpdate();
        
        con.close();
        
        return retval;
    }

    public void addCircleRequest(long circleIDL) throws SQLException {
        Connection con = sqlManager.getConnection();
        
        String query = "INSERT INTO circle_join_requests (Circle_Id, User_Id) VALUES (?,?)";
        PreparedStatement ps = con.prepareStatement(query);
        ps.setLong(1, circleIDL);
        ps.setLong(2, userID);
        
        int retval = ps.executeUpdate();
        
        con.close();
        if(retval < 0) {
            throw new SQLException("Something went wrong");
        }
    }
    
    public ArrayList<Long> getJoinRequests(long circleIDL) throws SQLException {
        
        Connection con = sqlManager.getConnection();
        ArrayList<Long> requests = new ArrayList<Long> ();
        String query = "SELECT User_Id FROM circle_join_requests WHERE Circle_Id = ?";
        PreparedStatement ps = con.prepareStatement(query);
        ps.setLong(1, circleIDL);
        
        ResultSet rs = ps.executeQuery();
        
        while(rs.next()) {
            requests.add(rs.getLong(1));
        }
        
        return requests;
    }

    public void removeRequest(long pUserID, long circleID) throws SQLException {
        Connection con = sqlManager.getConnection();     
        String query = "DELETE FROM circle_join_requests WHERE User_Id = ? AND Circle_Id = ?";
        PreparedStatement ps = con.prepareStatement(query);
        ps.setLong(1, pUserID);
        ps.setLong(2, circleID);
        
        int retval = ps.executeUpdate();
        
        if(retval < 0) {
            throw new SQLException("Failed to delete");
        }
    }

    public boolean isRequested(long circleIDL) throws SQLException {
        Connection con = sqlManager.getConnection();        
        String query = "SELECT * FROM circle_join_requests WHERE Circle_Id = ? AND User_Id = ?";
        PreparedStatement ps = con.prepareStatement(query);
        ps.setLong(2, userID);
        ps.setLong(1, circleIDL);
        
        ResultSet rs = ps.executeQuery();
        
        if(!rs.next()) {
            return false;
        } else {
            return true;
        }
    }
    
}
