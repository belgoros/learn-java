package com.sca.patterns.visitor;

/**
 * Created by ZFTC0418 on 02/02/2015.
 */
public class TitleLongBlurbVisitor extends TitleBlurbVisitor {
    @Override
    public void visit(BookInfo bookInfo) {
        this.setTitleBlurb("LB-Book: " +
                bookInfo.getTitleName() +
                ", Author: " +
                bookInfo.getAuthor());

    }

    @Override
    public void visit(DvdInfo dvdInfo) {
        this.setTitleBlurb("LB-DVD: " +
                dvdInfo.getTitleName() +
                ", starring " +
                dvdInfo.getStar() +
                ", encoding region: " +
                dvdInfo.getEncodingRegion());

    }

    @Override
    public void visit(GameInfo gameInfo) {
        this.setTitleBlurb("LB-Game: " +
                gameInfo.getTitleName());

    }
}
