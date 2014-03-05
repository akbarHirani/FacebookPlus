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
public class Message {
    
    private long messageID;
    private long sender;
    private long reciever;
    private String message;
    private String subject;
    private Date date;
    
    public Message(long messageID, Date date, long sender, long reciever, String message, String subject) {
        this.messageID = messageID;
        this.date = date;
        this.message = message;
        this.subject = subject;
        this.sender = sender;
        this.reciever = reciever;
    }

    /**
     * @return the sender
     */
    public long getSender() {
        return sender;
    }

    /**
     * @param sender the sender to set
     */
    public void setSender(long sender) {
        this.sender = sender;
    }

    /**
     * @return the reciever
     */
    public long getReciever() {
        return reciever;
    }

    /**
     * @param reciever the reciever to set
     */
    public void setReciever(long reciever) {
        this.reciever = reciever;
    }

    /**
     * @return the message
     */
    public String getMessage() {
        return message;
    }

    /**
     * @param message the message to set
     */
    public void setMessage(String message) {
        this.message = message;
    }

    /**
     * @return the subject
     */
    public String getSubject() {
        return subject;
    }

    /**
     * @param subject the subject to set
     */
    public void setSubject(String subject) {
        this.subject = subject;
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
     * @return the messageID
     */
    public long getMessageID() {
        return messageID;
    }

    /**
     * @param messageID the messageID to set
     */
    public void setMessageID(long messageID) {
        this.messageID = messageID;
    }
       
}
