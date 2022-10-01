package main.java.LowLevelDesign.FriendshipService;

import java.util.*;

public class FriendshipService {


    Map<String, Set<String>> followers, followings;

    FriendshipService() {
        followers = new HashMap<>();
        followings = new HashMap<>();
    }

    List<String> getFollowers(String user_id) {
        if (!followers.containsKey(user_id)) {
            return new ArrayList<>();
        }

        return new ArrayList<>(followers.get(user_id));
    }

    List<String> getFollowings(String user_id) {
        if (!followings.containsKey(user_id)) {
            return new ArrayList<>();
        }

        return new ArrayList<>(followings.get(user_id));
    }

    void follow(String to_user_id, String from_user_id) {
        if (!followers.containsKey(to_user_id)) {
            followers.put(to_user_id, new TreeSet<>());
        }

        followers.get(to_user_id).add(from_user_id);


        if (!followings.containsKey(from_user_id)) followings.put(from_user_id, new TreeSet<>());

        followings.get(from_user_id).add(to_user_id);
    }

    void unFollow(String to_user_id, String from_user_id) {
        if (followers.containsKey(to_user_id)) followers.get(to_user_id).remove(from_user_id);

        if (followings.containsKey(from_user_id)) followings.get(from_user_id).remove(to_user_id);

    }


    public static void main(String[] args) {

        FriendshipService friendshipService = new FriendshipService();
        friendshipService.follow("jerry_532", "sheila_567");

        System.out.println("Followers of jerry :");
        friendshipService.getFollowers("jerry_532").forEach(System.out::println);

        System.out.println("Followings of shiela :");
        friendshipService.getFollowings("sheila_567").forEach(System.out::println);

        friendshipService.unFollow("jerry_532", "sheila_567");

        System.out.println("Followers of jerry :");
        friendshipService.getFollowers("jerry_532").forEach(System.out::println);

        System.out.println("Followings of shiela :");
        friendshipService.getFollowings("sheila_567").forEach(System.out::println);


    }


}
