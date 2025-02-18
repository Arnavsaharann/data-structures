package com.bridgelabz.linkedlist.levelone;

import java.util.ArrayList;

public class SocialMediaFriendConnections {
    public static void main(String[] args) {
        UserList list = new UserList();


        list.addUser(101,"Arnav", 21 );
        list.addUser(102,"Mayank", 21 );
        list.addUser(103,"Vibhor", 21 );
        list.addUser(104,"arpit", 21 );
        list.addUser(105,"rupesh", 21 );

        list.addFriend(101,102);
        list.addFriend(101,103);
        list.addFriend(101,104);
        list.addFriend(101,105);

        list.displayAllFriendsOfUser(101);

        System.out.println("---------------------------------");

        list.displayAllFriendsOfUser(102);

        list.removeFriend(101,103);

        System.out.println("---------------------------------");

        list.displayAllFriendsOfUser(101);

        System.out.println("---------------------------------");

        list.displayAllFriendsOfUser(103);

    }
}


class UserNode{
    private int userID;
    private String name;
    private int age;
    private ArrayList<Integer>friends;
    UserNode next;

    public UserNode(int userID, String name, int age){
        this.userID = userID;
        this.name = name;
        this.age = age;
        this.friends = new ArrayList<>();
        this.next = null;
    }

    public int getUserID() {
        return userID;
    }

    public int getAge() {
        return age;
    }

    public String getName() {
        return name;
    }

    public ArrayList<Integer> getFriends() {
        return friends;
    }

    public void setFriends(int friend) {
        friends.add(friend);
    }

    public void deleteFriends(int friend){
        friends.remove(Integer.valueOf(friend));
    }
}

class UserList{
    UserNode head;

    public void addUser(int userID, String name, int age){
        UserNode user = new UserNode(userID,name,age);

        if(head == null){
            head = user;
        }else{
            UserNode temp = head;
            while(temp.next != null){
                temp = temp.next;
            }
            temp.next = user;
        }
    }

    public  UserNode findUser(int userID) {
        UserNode temp = head;
        while (temp != null) {
            if (temp.getUserID() == userID) return temp;
            temp = temp.next;
        }
        return null;
    }

    public void addFriend(int userID1, int userID2){
        UserNode user1 = findUser(userID1);
        UserNode user2 = findUser(userID2);

        if (user1 == null || user2 == null) {
            System.out.println("One or both users not found.");
            return;
        }

        user1.setFriends(user2.getUserID());
        user2.setFriends(user1.getUserID());

    }

    public void removeFriend(int userID1, int userID2){
        UserNode user1 = findUser(userID1);
        UserNode user2 = findUser(userID2);

        if (user1 == null || user2 == null) {
            System.out.println("One or both users not found.");
            return;
        }
        user1.deleteFriends(user2.getUserID());
        user2.deleteFriends(user1.getUserID());

        System.out.println("Friend connection removed between " + user1.getName() + " and " + user2.getName());
    }

    public void displayAllFriendsOfUser(int id){
        UserNode temp = findUser(id);
        if (temp == null) { // Check if user exists before accessing friends
            System.out.println("User not found.");
            return;
        }

        ArrayList<Integer> friendList = temp.getFriends(); // Retrieve friends' IDs

        if (friendList.isEmpty()) {
            System.out.println("This user has no friends.");
            return;
        }

        System.out.println("The friends for user ID :" + id);
        for(int i = 0; i < temp.getFriends().size(); i++){
            displayUser(friendList.get(i));
            System.out.println();
        }
    }

    public void displayUser(int id){
        UserNode temp = findUser(id);
        System.out.println("The User ID is: " + temp.getUserID());
        System.out.println("The name is: " + temp.getName());
        System.out.println("The age is: " + temp.getAge());
    }
}