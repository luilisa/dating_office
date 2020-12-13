package VanillaJava;

import java.util.ArrayList;

public class User {
    private String name, email;
    private  ArrayList<Message> messageList;

    User(String name, String email) {
        this.name = name;
        this.email = email;
        this.messageList = new ArrayList<Message>();
    }

    static User getUserFromString(String name)
    {
        User thisUser=null;
        int i=0;
        while(i< Network.users.size())
        {
            if (Network.users.get(i).getName().equals(name))
            {
                thisUser= Network.users.get(i);
            }
            ++i;
        }
        return thisUser;
    }

    ArrayList<Message> getMessageList()
    {
        return this.messageList;
    }

    String getName()
    {
        return this.name;
    }
    void setName(String name)
    {
        this.name = name;
    }
    String getEmail()
    {
        return this.email;
    }
    void setEmail(String email)
    {
        this.email = email;
    }

    public String toString()
    {
        return this.getName()+" with email "+this.getEmail();
    }

    void sendMessage(String recieverName, String text)
    {
        String userWhoSends = this.getName();
        Message newMessage= new Message(userWhoSends,recieverName, text);
        this.messageList.add(newMessage);
        System.out.println("Message sent successfully");
    }

    void deleteMessage(String recieverName, String text)
    {
        this.messageList.clear();
        System.out.println("Messages have been deleted");
    }

    void getAllMessages() {
        for (Message message: this.messageList) {
            System.out.println(message.toString());
        }
    }
}
