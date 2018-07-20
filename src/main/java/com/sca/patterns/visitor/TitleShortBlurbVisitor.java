package com.sca.patterns.visitor;

/**
 * Created by ZFTC0418 on 02/02/2015.
 */
public class TitleShortBlurbVisitor extends TitleBlurbVisitor {
    @Override
    public void visit(BookInfo bookInfo) {
        setTitleBlurb("SB-Book: " + bookInfo.getTitleName());

    }

    @Override
    public void visit(DvdInfo dvdInfo) {
        setTitleBlurb("SB-DVD: " + dvdInfo.getTitleName());

    }

    @Override
    public void visit(GameInfo gameInfo) {
        setTitleBlurb("SB-Game: " + gameInfo.getTitleName());
    }
}
