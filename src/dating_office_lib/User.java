package dating_office_lib;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

import java.io.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

public class User {

    private static int id;
    private String name, surname, email,  gender, login, password, requirments, intelligence, birth, city;

    public User(String name, String surname, String email, String gender, String login, String password, String birth) {
        this.name = name;
        this.surname = surname;
        this.email = email;
        this.gender = gender;
        this.login = login;
        this.password = password;
        this.birth = birth;
        this.requirments = "";
        this.intelligence = "";
        this.city = "";
    }

    public String getFormatData() {
        return this.name + ":" + this.surname + ":" + this.email + ":" + this.gender + ":" + this.login + ":" + this.password + ":" + this.birth + ":" + this.requirments + ":" + this.intelligence + "\n";
    }

    public boolean write() throws Exception {
        File file =
                new File("userData.txt");
        String[] userData;
        Scanner sc = new Scanner(file);
        boolean userExists = false;
        while (sc.hasNextLine()) {
            userData = sc.nextLine().split(":");
            User acceptedUser = new User(userData[0],userData[1],userData[2],userData[3],userData[4],userData[5],userData[6]);

            if (this.login.equals(acceptedUser.login)) {
                userExists = true;
            }
        }
        sc.close();
        if (!userExists) {
            FileWriter writer = new FileWriter(file, true);
            writer.write(getFormatData());
            writer.close();
            return true;
        } else {
            return false;
        }

    }

    public  void updateReqInt(String requirments, String intelligence) throws Exception {
        File file =
                new File("userData.txt");
        File tempFile = new File("myTempFile.txt");

        BufferedReader reader = new BufferedReader(new FileReader(file));
        BufferedWriter writer = new BufferedWriter(new FileWriter(tempFile));
        this.requirments = requirments;
        this.intelligence = intelligence;
        String currentLine;
        while((currentLine = reader.readLine()) != null) {
            String email = currentLine.split(":")[2];

            if(email.equals(getFormatData().trim().split(":")[2])) {
                writer.write(getFormatData());
            } else {
                writer.write(currentLine + System.getProperty("line.separator"));
            }
        }

        writer.close();
        reader.close();
        if (!file.delete()) {
            System.out.println("Could not delete file");
            System.out.println(file.getAbsolutePath());
            return;
        }
        boolean successful = tempFile.renameTo(file);
        System.out.println(successful);
    }

    public  void updateInfo(String name, String surname, String birth, String city, String gender) throws Exception {
        File file =
                new File("userData.txt");
        File tempFile = new File("myTempFile.txt");

        this.name = name;
        this.surname = surname;
        this.birth = birth;
        this.city = city;
        this.gender = gender;

        BufferedReader reader = new BufferedReader(new FileReader(file));
        BufferedWriter writer = new BufferedWriter(new FileWriter(tempFile));

        String currentLine;
        while((currentLine = reader.readLine()) != null) {
            String email = currentLine.split(":")[2];

            if(email.equals(getFormatData().trim().split(":")[2])) {
                System.out.println("Tut");
                writer.write(getFormatData());
            } else {
                System.out.println("Tam");
                writer.write(currentLine + System.getProperty("line.separator"));
            }
        }

        writer.close();
        reader.close();
        if (!file.delete()) {
            System.out.println("Could not delete file");
            System.out.println(file.getAbsolutePath());
            return;
        }
        boolean successful = tempFile.renameTo(file);
        System.out.println(successful);
    }
    public void delete() throws Exception {
        File file =
                new File("userData.txt");
        File tempFile = new File("myTempFile.txt");
        BufferedReader reader = new BufferedReader(new FileReader(file));
        BufferedWriter writer = new BufferedWriter(new FileWriter(tempFile));
        String currentLine;
        while((currentLine = reader.readLine()) != null) {
            // trim newline when comparing with lineToRemove
            String trimmedLine = currentLine.trim();
            if(trimmedLine.equals(getFormatData().trim())) continue;
            writer.write(currentLine + System.getProperty("line.separator"));
        }
        writer.close();
        reader.close();
        if (!file.delete()) {
            System.out.println("Could not delete file");
            System.out.println(file.getAbsolutePath());
            return;
        }
        boolean successful = tempFile.renameTo(file);
        System.out.println(successful);
    }
//
//    static User getUserFromString(String name)
//    {
//        User thisUser=null;
//        int i=0;
//        while(i< Network.users.size())
//        {
//            if (Network.users.get(i).getName().equals(name))
//            {
//                thisUser= Network.users.get(i);
//            }
//            ++i;
//        }
//        return thisUser;
//    }
//
//    ArrayList<Message> getMessageList()
//    {
//        return this.messageList;
//    }
//
//    String getName()
//    {
//        return this.name;
//    }
//    void setName(String name)
//    {
//        this.name = name;
//    }
//    String getEmail()
//    {
//        return this.email;
//    }
//    void setEmail(String email)
//    {
//        this.email = email;
//    }
//
//    public String toString()
//    {
//        return this.getName()+" with email "+this.getEmail();
//    }
//
//    void sendMessage(String recieverName, String text)
//    {
//        String userWhoSends = this.getName();
//        Message newMessage= new Message(userWhoSends,recieverName, text);
//        this.messageList.add(newMessage);
//        System.out.println("Message sent successfully");
//    }
//
//    void deleteMessage(String recieverName, String text)
//    {
//        this.messageList.clear();
//        System.out.println("Messages have been deleted");
//    }
//
//    void getAllMessages() {
//        for (Message message: this.messageList) {
//            System.out.println(message.toString());
//        }
//    }
}
