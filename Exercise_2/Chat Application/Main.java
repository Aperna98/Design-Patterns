import java.util.*;

import MessageAdapter.*;
import Observer.Observer;
import ChatRoom.*;

public class Main {
    private static final Scanner sc = new Scanner(System.in);
    private static final ChatRoomManager manager = ChatRoomManager.getInstance();
    private static ClientCommunicator comm;

    public static void main(String[] args) {
        setCommType();
        boolean running = true;
        while (running) {
            System.out.println("\n1.Create Room 2.Join Room 3.Public Msg 4.Private Msg 5.List Rooms 6.Exit");
            switch (sc.nextInt()) {
                case 1 -> createRoom();
                case 2 -> joinRoom();
                case 3 -> publicMsg();
                case 4 -> privateMsg();
                case 5 -> manager.listRooms();
                case 6 -> running = false;
            }
        }
    }

    private static void setCommType() {
        System.out.println("Choose Comm Type: 1.HTTP 2.WebSocket");
        int t = sc.nextInt();
        sc.nextLine();
        comm = (t == 1) ? new HttpAdapter(new HttpService()) : new WebSocketAdapter(new WebSocketService());
    }

    private static void createRoom() {
        System.out.print("Enter Room ID: ");
        System.out.println("Room Created: " + manager.createRoom(sc.next()).getId());
    }

    private static void joinRoom() {
        System.out.print("Room ID: ");
        String rid = sc.next();
        ChatRoom r = manager.getRoom(rid);
        if (r != null) {
            System.out.print("User Name: ");
            User u = new User(sc.next());
            r.addUser(u);
        } else {
            System.out.println("Room not found.");
        }
    }

    private static void publicMsg() {
        System.out.print("Room ID: ");
        String rid = sc.next();
        ChatRoom r = manager.getRoom(rid);
        if (r == null) {
            System.out.println("Room not found.");
        } else {
            System.out.print("Sender: ");
            String sender = sc.next();

            System.out.print("Message: ");
            sc.nextLine();

            String msg = sc.nextLine();
            r.broadcast(sender + ": " + msg);
            comm.sendMessage(msg);
        }

    }

    private static void privateMsg() {
        System.out.print("Sender: ");
        User a = new User(sc.next());

        System.out.print("Receiver: ");
        User b = new User(sc.next());

        System.out.print("Message: ");
        sc.nextLine();
        String msg = sc.nextLine();

        a.sendPrivateMessage(b, msg);
        System.out.println("Private message sent.\n");
        comm.sendMessage("Messages for " + b.getName() + ":");
        b.showPrivateMessages();
    }
}