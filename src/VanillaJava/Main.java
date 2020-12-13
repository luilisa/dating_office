package VanillaJava;

import static VanillaJava.Network.*;
import static VanillaJava.Network.getUser;

public class Main {
    private static final java.util.logging.Logger log = java.util.logging.Logger
            .getLogger(Main.class.getName());
    public static void main(String[] args) {
        Network network = new Network();

        addUser("Katya", "katya@mail.ru");
        addUser("Luiza", "luiza@mail.ru");
        addUser("Misha", "misha@mail.ru");

        User user1 = getUser("Luiza");

        user1.sendMessage("Katya", "hi");
        user1.sendMessage("Katya", "whats up?");

        User user2 = getUser("Katya");

        if (user2.getName().equals("Katya")) {
            log.info("Katya is here");
        }

        user2.sendMessage("Misha", "hi");

        user1.getAllMessages();
        user2.getAllMessages();

        System.out.println(user1.toString() + "has sent  message to "+ user2.getName());
        System.out.println(user2.getName());
        user2.setName("Nastya");
        System.out.println(user1.getName());
        System.out.println(user2.getName());

    }
}

