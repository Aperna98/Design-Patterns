package Platform;

import java.util.*;
import Observer.Observer;

public class Follower implements Observer {
    private String name;
    private List<String> inbox = new ArrayList<>();

    public Follower(String name) {
        this.name = name;
    }

    @Override
    public void update(String message) {
        inbox.add(message);
        System.out.println(name + " received: " + message);
    }

    public String getName() {
        return name;
    }

    public void showInbox() {
        if (inbox.isEmpty())
            System.out.println(name + "'s inbox is empty.");
        else
            inbox.forEach(System.out::println);
    }
}