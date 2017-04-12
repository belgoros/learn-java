package com.sca.basic.variables;

public class PlayingObjects {

    public static void main(String[] args) {
        User user = new User();
        user.setLastName("Dupont");
        System.out.println("User name set to: " + user.getLastName());
        changeUserName(user);
        System.out.println("User name changed for: " + user.getLastName());
    }

    private static void changeUserName(User user) {
        user.setLastName("Pignon");
    }
}
