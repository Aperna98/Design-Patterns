package ChatRoom;

import java.util.*;
import Observer.Observer;

public class User implements Observer {
    private String name;
    private List<String> privateMsgs = new ArrayList<>();

    public User(String n) {
        this.name = n;
    }

    public String getName() {
        return name;
    }

    public void receivePrivate(String msg) {
        privateMsgs.add(msg);
    }

    public void showPrivateMessages() {
        if (privateMsgs.isEmpty())
            System.out.println("No private messages.");
        else
            privateMsgs.forEach(System.out::println);
    }

    @Override
    public void update(String message) {
        System.out.println("[" + name + "] " + message);
    }
}
