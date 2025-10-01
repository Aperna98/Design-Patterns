import java.util.*;

public class FirewallProxy implements ServerAccess {
    private final Server server;
    private final Set<String> allowedUsers;

    public FirewallProxy(Server server, Set<String> allowedUsers) {
        this.server = server;
        this.allowedUsers = allowedUsers;
    }

    @Override
    public void accessServer(String userName) {
        if (allowedUsers.contains(userName))
            server.accessServer(userName);
        else
            System.out.println("ACCESS DENIED for " + userName + " to server " + server.getName());
    }

    public void addUser(String userName) {
        if (allowedUsers.add(userName))
            System.out.println(userName + " added to allowed users of " + server.getName());
        else
            System.out.println(userName + " is already allowed on " + server.getName());
    }

    public void removeUser(String userName) {
        if (allowedUsers.remove(userName))
            System.out.println(userName + " removed from allowed users of " + server.getName());
        else
            System.out.println(userName + " is not a permitted user of " + server.getName());
    }

    public void listUsers() {
        System.out.println("Allowed users for " + server.getName() + ": " + allowedUsers);
    }
}