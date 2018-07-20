package com.sca.basic;

/**
 * Created by z28scamb on 07/06/2016.
 */
public class Message {

    private String member;

    public Message(String member) {
        this.member = member;
    }

    public static Message fromMember(String member) {
        return new Message(member);
    }

    public void normalize() {
        System.out.println("calling normalize on Message instance");
    }

    @Override
    public String toString() {
        return "Message from " + getMember();
    }

    public String getMember() {
        return member;
    }
}
