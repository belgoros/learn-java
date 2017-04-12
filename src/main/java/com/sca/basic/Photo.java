package com.sca.basic;

public class Photo implements Publishable {

    private String author;

    @Override
    public void publish() {
        System.out.println("It is a photo");
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    @Override
    public String getOwner() {
        return author;
    }
}
