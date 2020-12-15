package dating_office_lib;

import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
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
    public String img;
    File file =
            new File("userData.txt");
    public String email,  login, password, requirments, intelligence;
    private final SimpleStringProperty name, surname, gender, city, birth;


    public User(String name, String surname, String email, String gender, String login, String password, String birth, String city) {
        this.name = new SimpleStringProperty(name);
        this.surname = new SimpleStringProperty(surname);
        this.email = email;
        this.gender =  new SimpleStringProperty(gender);
        this.login = login;
        this.password = password;
        this.birth =  new SimpleStringProperty(birth);
        this.requirments = "";
        this.intelligence = "";
        this.city = new SimpleStringProperty(city);
        this.img = "file:///" + "pngwing.com.png";
    }

    public String getName() {
        return name.get();
    }
    public void setName(String fName) {
        name.set(fName);
    }

    public String getSurname() {
        return surname.get();
    }
    public void setSurname(String fName) {
        surname.set(fName);
    }

    public String getGender() {
        return gender.get();
    }
    public void setGender(String fName) {
        gender.set(fName);
    }

    public String getBirth() {
        return birth.get();
    }
    public void setBirth(String fName) {
        birth.set(fName);
    }

    public String getCity() {
        return city.get();
    }
    public void setCity(String fName) {
        city.set(fName);
    }

    public String getFormatData() {
        return getName() + ";" + getSurname() + ";" + this.email + ";" + getGender() + ";" + this.login + ";" + this.password + ";" + getBirth() + ";" + getCity() + ";" + this.requirments + ";" + this.intelligence  + ";" + this.img + "\n";
    }

    public static ObservableList<User> getUserData()  throws Exception  {
        String[] userData;
        File file =
                new File("userData.txt");
        ObservableList<User> data =
                FXCollections.observableArrayList();
        User acceptedUser = null;
        Scanner sc = new Scanner(file);
        boolean userExists = false;
        while (sc.hasNextLine()) {
            userData = sc.nextLine().split(";");
            acceptedUser = new User(userData[0],userData[1],userData[2],userData[3],userData[4],userData[5],userData[6], userData[7]);
            data.add(acceptedUser);

        }
        sc.close();
        return data;
    }

    public boolean write() throws Exception {
        String[] userData;
        Scanner sc = new Scanner(file);
        boolean userExists = false;
        while (sc.hasNextLine()) {
            userData = sc.nextLine().split(";");
            User acceptedUser = new User(userData[0],userData[1],userData[2],userData[3],userData[4],userData[5],userData[6], userData[7]);

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

    public static User getUserByNameSurname(String name, String surname) throws FileNotFoundException {
        File file =
                new File("userData.txt");
        String[] userData;
        Scanner sc = new Scanner(file);
        boolean userExists = false;
        while (sc.hasNextLine()) {
            userData = sc.nextLine().split(";");
            User acceptedUser = new User(userData[0],userData[1],userData[2],userData[3],userData[4],userData[5],userData[6], userData[7]);

            if ((name.equals(acceptedUser.getName())) && (surname.equals(acceptedUser.getSurname()))) {
                acceptedUser.requirments = userData[8];
                acceptedUser.intelligence = userData[9];
                acceptedUser.img = userData[10];
                return acceptedUser;
            }
        }
        sc.close();
        return null;
    }

    public static User findUser(String login) throws FileNotFoundException {
        File file =
                new File("userData.txt");
        String[] userData;
        Scanner sc = new Scanner(file);
        boolean userExists = false;
        while (sc.hasNextLine()) {
            userData = sc.nextLine().split(";");
            User acceptedUser = new User(userData[0],userData[1],userData[2],userData[3],userData[4],userData[5],userData[6], userData[7]);

            if ((login.equals(acceptedUser.login))) {
                acceptedUser.requirments = userData[8];
                acceptedUser.intelligence = userData[9];
                acceptedUser.img = userData[10];
                sc.close();
                return acceptedUser;
            }

        }
        sc.close();
        return null;
    }

    public  void updateReqInt(String requirments, String intelligence) throws Exception {
        File tempFile = new File("myTempFile.txt");

        BufferedReader reader = new BufferedReader(new FileReader(file));
        BufferedWriter writer = new BufferedWriter(new FileWriter(tempFile));
        this.requirments = requirments;
        this.intelligence = intelligence;
        String currentLine;
        while((currentLine = reader.readLine()) != null) {
            String email = currentLine.split(";")[2];
            System.out.println(1);
            if(email.equals(getFormatData().trim().split(";")[2])) {
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
        File tempFile = new File("myTempFile.txt");

        setName(name);
        setSurname(surname);
        setBirth(birth);
        setCity(city);
        setGender(gender);

        BufferedReader reader = new BufferedReader(new FileReader(file));
        BufferedWriter writer = new BufferedWriter(new FileWriter(tempFile));

        String currentLine;
        while((currentLine = reader.readLine()) != null) {
            String email = currentLine.split(";")[2];

            if(email.equals(getFormatData().trim().split(";")[2])) {
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

    public  void updatePic(String imgpath) throws Exception {
        File tempFile = new File("myTempFile.txt");
        this.img = imgpath;

        BufferedReader reader = new BufferedReader(new FileReader(file));
        BufferedWriter writer = new BufferedWriter(new FileWriter(tempFile));

        String currentLine;
        while((currentLine = reader.readLine()) != null) {
            String email = currentLine.split(";")[2];

            if(email.equals(getFormatData().trim().split(";")[2])) {
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
