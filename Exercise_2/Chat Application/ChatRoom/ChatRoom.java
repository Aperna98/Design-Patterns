package ChatRoom;

import java.util.*;

public class ChatRoom {
    private String id;
    private Map<String, User> users = new HashMap<>();
    private List<String> history = new ArrayList<>();

    public ChatRoom(String id) {
        this.id = id;
    }

    public String getId() {
        return id;
    }

    public Collection<User> getUsers() {
        return users.values();
    }

    public boolean addUser(User u) {
        if (users.containsKey(u.getName())) {
            System.out.println("Username already exists in this room!");
            return false;
        }
        users.put(u.getName(), u);
        System.out.println(u.getName() + " joined " + id);
        showHistory();
        return true;
    }

    public void removeUser(String name) {
        if (users.remove(name) != null)
            System.out.println(name + " left " + id);
        else
            System.out.println("User not in this room!");
    }

    public void broadcast(String sender, String msg) {
        if (!users.containsKey(sender)) {
            System.out.println("User not in this room!");
            return;
        }
        String fullMsg = sender + ": " + msg;
        history.add(fullMsg);
        users.values().forEach(u -> u.update(fullMsg));
    }

    public void sendPrivate(String sender, String receiver, String msg) {
        if (!users.containsKey(sender) || !users.containsKey(receiver)) {
            System.out.println("Both users must be in the room!");
            return;
        }
        users.get(receiver).receivePrivate(sender + " -> " + msg);
        System.out.println("Private message sent.");
    }

    private void showHistory() {
        if (history.isEmpty())
            return;
        System.out.println("--- History in " + id + " ---");
        history.forEach(System.out::println);
        System.out.println("----------------------");
    }
}
