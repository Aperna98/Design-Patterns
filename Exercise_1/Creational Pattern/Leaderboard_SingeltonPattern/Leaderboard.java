import java.util.*;

class Leaderboard {
    private static Leaderboard instance;
    private final List<Player> players = new ArrayList<>();

    private Leaderboard() {
    }

    public static Leaderboard getInstance() {
        if (instance == null)
            instance = new Leaderboard();
        return instance;
    }

    public boolean playerExists(String id) {
        return players.stream().anyMatch(p -> p.getId().equals(id));
    }

    public void addPlayer(String id, String name) {
        players.add(new Player(id, name));
        System.out.println("Player added!");
    }

    public void updateScore(String id, long score) {
        players.stream().filter(p -> p.getId().equals(id)).findFirst()
                .ifPresent(p -> p.setScore(score));
    }

    public void removePlayer(String id) {
        players.removeIf(p -> p.getId().equals(id));
    }

    public void showLeaderboard() {
        if (players.isEmpty()) {
            System.out.println("No players yet!");
            return;
        }
        System.out.println("\nLeaderboard:");
        players.stream()
                .sorted((a, b) -> Long.compare(b.getScore(), a.getScore()))
                .forEach(p -> System.out.println(p.getName() + " (" + p.getId() + ") : " + p.getScore()));
    }
}