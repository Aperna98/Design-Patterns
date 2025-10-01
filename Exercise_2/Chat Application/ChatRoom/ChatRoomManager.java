package ChatRoom;
import java.util.*;

public class ChatRoomManager {
    private static final ChatRoomManager instance = new ChatRoomManager();
    private Map<String, ChatRoom> rooms = new HashMap<>();

    private ChatRoomManager() {}
    public static ChatRoomManager getInstance() { return instance; }

    public ChatRoom createRoom(String id) {
        return rooms.computeIfAbsent(id, ChatRoom::new);
    }

    public ChatRoom getRoom(String id) { return rooms.get(id); }

    public void listRooms() {
        if (rooms.isEmpty()) { System.out.println("No rooms available."); return; }
        rooms.values().forEach(r -> {
            System.out.println("Room: " + r.getId());
            if (r.getUsers().isEmpty()) System.out.println("  (no users yet)");
            else r.getUsers().forEach(u -> System.out.println("  - " + u.getName()));
        });
    }
}