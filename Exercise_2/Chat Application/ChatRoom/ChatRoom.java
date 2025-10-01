package ChatRoom;

import java.util.*;

public class ChatRoom {
    private String id;
    private List<User> users = new ArrayList<>();
    private List<String> history = new ArrayList<>();

    public ChatRoom(String id) {
        this.id = id;
    }

    public String getId() {
        return id;
    }

    public List<User> getUsers() {
        return users;
    }

    public void addUser(User u) {
        users.add(u);
        System.out.println(u.getName() + " joined " + id);
        showHistory();
    }

    public void broadcast(String msg) {
        history.add(msg);
        for (User u : users)
            u.update(msg);
    }

    private void showHistory() {
        if (history.isEmpty())
            return;
        System.out.println("--- Message History in " + id + " ---");
        history.forEach(System.out::println);
        System.out.println("------------------------------");
    }
}