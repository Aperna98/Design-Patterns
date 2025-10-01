import java.util.*;
import Platform.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        SocialPlatform sp = new SocialPlatform();

        while (true) {
            System.out.print(
                    "\nCommand (1.Add Influencer 2.Add Follower 3.Follow  4.Post  5.Show Followers  6.Show Inbox  7.List Influencers  8.Exit): ");
            int ch = sc.nextInt();
            sc.nextLine();

            switch (ch) {
                case 1 -> {
                    System.out.print("Name: ");
                    sp.addInfluencer(sc.nextLine());
                }

                case 2 -> {
                    System.out.print("Name: ");
                    sp.addFollower(sc.nextLine());
                }

                case 3 -> {
                    System.out.print("Influencer: ");
                    String i = sc.nextLine();
                    if (!sp.influencerExists(i)) {
                        System.out.println("Influencer not found.");
                        break;
                    }

                    System.out.print("Follower: ");
                    String f = sc.nextLine();
                    if (!sp.followerExists(f)) {
                        System.out.println("Follower not found.");
                        break;
                    }
                    sp.follow(i, f);
                }

                case 4 -> {
                    System.out.print("Influencer: ");
                    String i = sc.nextLine();
                    if (!sp.influencerExists(i)) {
                        System.out.println("Influencer not found.");
                        break;
                    }
                    System.out.print("Content: ");
                    String c = sc.nextLine();
                    sp.post(i, c);
                }

                case 5 -> {
                    System.out.print("Influencer: ");
                    sp.showFollowers(sc.nextLine());
                }

                case 6 -> {
                    System.out.print("Follower: ");
                    sp.showInbox(sc.nextLine());
                }

                case 7 -> sp.listInfluencers();

                case 8 -> {
                    System.out.println("Exiting...");
                    return;
                }

                default -> System.out.println("Invalid choice.");
            }
        }
    }
}