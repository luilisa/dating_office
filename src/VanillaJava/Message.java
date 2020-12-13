package VanillaJava;

import java.util.Date;

public class Message {
    private Date timestamp;
    private String text;
    private User sender;
    private User reciever;

    Message(String senderName, String recieverName, String words)
    {
        this.timestamp = new Date();
        this.text=words;
        this.sender=User.getUserFromString(senderName);
        this.reciever = User.getUserFromString(recieverName);
    }

    public String toString()
    {
        return this.text+ " from "+this.sender+" that created at "+this.getDateAsString();
    }

    String getDateAsString()
    {
        return this.timestamp.toString();
    }

    String getText()
    {
        return this.text;
    }


}