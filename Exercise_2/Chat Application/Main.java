import java.util.*;
import MessageAdapter.*;
import ChatRoom.*;

public class Main {
    private static final Scanner sc = new Scanner(System.in);
    private static final ChatRoomManager manager = ChatRoomManager.getInstance();
    private static ClientCommunicator comm;

    public static void main(String[] args) {
        setCommType();
        boolean running = true;
        while (running) {
            System.out.println(
                    "\n1.Create Room 2.Join Room 3.Public Msg 4.Private Msg 5.Leave Room 6.Delete Room 7.List Rooms 8.Exit");
            switch (sc.nextInt()) {
                case 1 -> createRoom();
                case 2 -> joinRoom();
                case 3 -> publicMsg();
                case 4 -> privateMsg();
                case 5 -> leaveRoom();
                case 6 -> deleteRoom();
                case 7 -> manager.listRooms();
                case 8 -> running = false;
            }
        }
    }

    private static void setCommType() {
        System.out.println("Choose Comm Type: 1.HTTP 2.WebSocket");
        comm = (sc.nextInt() == 1) ? new HttpAdapter(new HttpService()) : new WebSocketAdapter(new WebSocketService());
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
            r.addUser(new User(sc.next()));
        } else
            System.out.println("Room not found.");
    }

    private static void publicMsg() {
        System.out.print("Room ID: ");
        String rid = sc.next();
        ChatRoom r = manager.getRoom(rid);
        if (r == null) {
            System.out.println("Room not found.");
            return;
        }

        System.out.print("Sender: ");
        String sender = sc.next();
        sc.nextLine();
        System.out.print("Message: ");
        String msg = sc.nextLine();
        r.broadcast(sender, msg);
        comm.sendMessage(msg);
    }

    private static void privateMsg() {
        System.out.print("Room ID: ");
        String rid = sc.next();
        ChatRoom r = manager.getRoom(rid);
        if (r == null) {
            System.out.println("Room not found.");
            return;
        }

        System.out.print("Sender: ");
        String sender = sc.next();
        System.out.print("Receiver: ");
        String receiver = sc.next();
        sc.nextLine();
        System.out.print("Message: ");
        String msg = sc.nextLine();

        r.sendPrivate(sender, receiver, msg);
    }

    private static void leaveRoom() {
        System.out.print("Room ID: ");
        String rid = sc.next();
        ChatRoom r = manager.getRoom(rid);
        if (r == null) {
            System.out.println("Room not found.");
            return;
        }

        System.out.print("User Name: ");
        r.removeUser(sc.next());
    }

    private static void deleteRoom() {
        System.out.print("Room ID: ");
        manager.deleteRoom(sc.next());
    }
}
