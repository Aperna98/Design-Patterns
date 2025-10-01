import java.util.*;

import ChatRoom.User;

public class Main {
    private final Scanner sc = new Scanner(System.in);
    private final Map<String, FirewallProxy> servers = new HashMap<>();

    public static void main(String[] args) {
        new Main().run();
    }

    private void run() {
        System.out.println("=== Firewall System ===");
        boolean running = true;
        while (running) {
            printMenu();
            String choice = sc.nextLine().trim();
            switch (choice) {
                case "1" -> createServer();
                case "2" -> accessServer();
                case "3" -> addUser();
                case "4" -> removeUser();
                case "5" -> listServers();
                case "6" -> running = false;
                default -> System.out.println("Invalid choice!");
            }
        }
        System.out.println("Exiting system...");
    }

    private void printMenu() {
        System.out.println("\n1. Create Server");
        System.out.println("2. Access Server");
        System.out.println("3. Add User");
        System.out.println("4. Remove User");
        System.out.println("5. List Servers");
        System.out.println("6. Exit\n");
        System.out.print("Enter choice: ");
    }

    private void createServer() {
        System.out.print("Server name: ");
        String sName = sc.nextLine().trim();
        if (servers.containsKey(sName)) {
            System.out.println("Server already exists!");
            return;
        }

        Set<String> allowed = new HashSet<>();
        System.out.print("Number of allowed users: ");
        int n;
        try {
            n = Integer.parseInt(sc.nextLine());
        } catch (Exception e) {
            System.out.println("Invalid number!");
            return;
        }

        for (int i = 0; i < n; i++) {
            System.out.print("User " + (i + 1) + ": ");
            allowed.add(sc.nextLine().trim());
        }

        servers.put(sName, new FirewallProxy(new Server(sName), allowed));
        System.out.println("Server " + sName + " created.");
    }

    private void accessServer() {
        String sName = ask("Server name: ");
        FirewallProxy proxy = servers.get(sName);
        if (proxy != null) {
            String uName = ask("User name: ");
            new User(uName).requestAccess(proxy);
        } else
            System.out.println("Server not found!");
    }

    private void addUser() {
        String sName = ask("Server name: ");
        FirewallProxy proxy = servers.get(sName);
        if (proxy != null) {
            String uName = ask("User to add: ");
            proxy.addUser(uName);
        } else
            System.out.println("Server not found!");
    }

    private void removeUser() {
        String sName = ask("Server name: ");
        FirewallProxy proxy = servers.get(sName);
        if (proxy != null) {
            String uName = ask("User to remove: ");
            proxy.removeUser(uName);
        } else
            System.out.println("Server not found!");
    }

    private void listServers() {
        if (servers.isEmpty())
            System.out.println("No servers created.");
        else
            servers.forEach((name, proxy) -> proxy.listUsers());
    }

    private String ask(String msg) {
        System.out.print(msg);
        return sc.nextLine().trim();
    }
}