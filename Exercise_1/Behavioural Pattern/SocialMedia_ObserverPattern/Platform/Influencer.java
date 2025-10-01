package Platform;

import java.util.*;
import Observer.Observer;

public class Influencer {
    private String name;
    private Set<Observer> followers = new HashSet<>();

    Influencer(String name) {
        this.name = name;
    }

    void addFollower(Observer f) {
        followers.add(f);
    }

    void post(String content) {
        String msg = name + " posted: " + content;
        System.out.println(msg);
        followers.forEach(f -> f.update(content));
    }

    void showFollowers() {
        if (followers.isEmpty())
            System.out.println(name + " has no followers.");
        else
            followers.forEach(f -> System.out.println(((Follower) f).getName()));
    }

    String getName() {
        return name;
    }
}