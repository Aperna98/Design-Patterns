import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Leaderboard board = Leaderboard.getInstance();
        int choice;

        do {
            System.out.println("\n1.Add 2.Update 3.Remove 4.Show 5.Exit");
            System.out.print("Choice: ");
            choice = Integer.parseInt(sc.nextLine());

            switch (choice) {
                case 1 -> {
                    System.out.print("ID: ");
                    String id = sc.nextLine();
                    if (board.playerExists(id)) {
                        System.out.println("ID already exists!");
                    } else {
                        System.out.print("Name: ");
                        String name = sc.nextLine();
                        board.addPlayer(id, name);
                    }
                }
                case 2 -> {
                    System.out.print("ID: ");
                    String id = sc.nextLine();
                    if (!board.playerExists(id)) {
                        System.out.println("No player with such ID!");
                    } else {
                        System.out.print("Score: ");
                        long score = Long.parseLong(sc.nextLine());
                        board.updateScore(id, score);
                        System.out.println("Score updated!");
                    }
                }
                case 3 -> {
                    System.out.print("ID: ");
                    String id = sc.nextLine();
                    if (!board.playerExists(id)) {
                        System.out.println("No player with such ID!");
                    } else {
                        board.removePlayer(id);
                        System.out.println("Player removed!");
                    }
                }
                case 4 -> board.showLeaderboard();
                case 5 -> System.out.println("Exiting...");
                default -> System.out.println("Invalid choice!");
            }
        } while (choice != 5);

        sc.close();
    }
}