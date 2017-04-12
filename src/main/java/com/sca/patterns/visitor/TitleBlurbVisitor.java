package com.sca.patterns.visitor;

/**
 * Created by ZFTC0418 on 02/02/2015.
 */
public abstract class TitleBlurbVisitor {

    String titleBlurb;

    public String getTitleBlurb() {
        return this.titleBlurb;
    }

    public void setTitleBlurb(String blurbIn) {
        this.titleBlurb = blurbIn;
    }

    public abstract void visit(BookInfo bookInfo);

    public abstract void visit(DvdInfo dvdInfo);

    public abstract void visit(GameInfo gameInfo);
}
