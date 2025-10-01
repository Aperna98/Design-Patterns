package Platform;

import java.util.*;

public class SocialPlatform {
    private Map<String, Influencer> influencers = new HashMap<>();
    private Map<String, Follower> followers = new HashMap<>();

    public void addInfluencer(String name) {
        if (influencers.containsKey(name) || followers.containsKey(name)) {
            System.out.println("Username already taken.");
            return;
        }
        influencers.put(name, new Influencer(name));
        System.out.println("Influencer added: " + name);
    }

    public void addFollower(String name) {
        if (influencers.containsKey(name) || followers.containsKey(name)) {
            System.out.println("Username already taken.");
            return;
        }
        followers.put(name, new Follower(name));
        System.out.println("Follower added: " + name);
    }

    public void follow(String inf, String fol) {
        Influencer i = influencers.get(inf);
        Follower f = followers.get(fol);
        if (i == null)
            System.out.println("Influencer not found.");
        else if (f == null)
            System.out.println("Follower not found.");
        else {
            i.addFollower(f);
            System.out.println(fol + " now follows " + inf);
        }
    }

    public void post(String inf, String content) {
        Influencer i = influencers.get(inf);
        if (i == null)
            System.out.println("Influencer not found.");
        else
            i.post(content);
    }

    public void showFollowers(String inf) {
        Influencer i = influencers.get(inf);
        if (i == null)
            System.out.println("Influencer not found.");
        else
            i.showFollowers();
    }

    public void showInbox(String fol) {
        Follower f = followers.get(fol);
        if (f == null)
            System.out.println("Follower not found.");
        else
            f.showInbox();
    }

    public void listInfluencers() {
        if (influencers.isEmpty())
            System.out.println("No influencers yet.");
        else
            influencers.keySet().forEach(System.out::println);
    }

    public boolean influencerExists(String name) {
        return influencers.containsKey(name);
    }

    public boolean followerExists(String name) {
        return followers.containsKey(name);
    }

}