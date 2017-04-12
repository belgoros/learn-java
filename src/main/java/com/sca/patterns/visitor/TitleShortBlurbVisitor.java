package com.sca.patterns.visitor;

/**
 * Created by ZFTC0418 on 02/02/2015.
 */
public class TitleShortBlurbVisitor extends TitleBlurbVisitor {
    @Override
    public void visit(BookInfo bookInfo) {
        this.setTitleBlurb("SB-Book: " + bookInfo.getTitleName());

    }

    @Override
    public void visit(DvdInfo dvdInfo) {
        this.setTitleBlurb("SB-DVD: " + dvdInfo.getTitleName());

    }

    @Override
    public void visit(GameInfo gameInfo) {
        this.setTitleBlurb("SB-Game: " + gameInfo.getTitleName());

    }
}
