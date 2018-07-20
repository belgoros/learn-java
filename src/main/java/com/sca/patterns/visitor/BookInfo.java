package com.sca.patterns.visitor;

/**
 * Created by ZFTC0418 on 02/02/2015.
 */
public class BookInfo extends AbstractTitleInfo {
    private String author;

    public BookInfo(String titleName, String author) {
        this.setTitleName(titleName);
        this.setAuthor(author);
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    @Override
    public void accept(TitleBlurbVisitor titleBlurbVisitor) {
        titleBlurbVisitor.visit(this);
    }
}
