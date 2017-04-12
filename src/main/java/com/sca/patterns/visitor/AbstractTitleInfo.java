package com.sca.patterns.visitor;

/**
 * Created by ZFTC0418 on 02/02/2015.
 */
public abstract class AbstractTitleInfo {
    private String titleName;

    public final String getTitleName() {
        return this.titleName;
    }

    public final void setTitleName(String titleNameIn) {
        this.titleName = titleNameIn;
    }

    public abstract void accept(TitleBlurbVisitor titleBlurbVisitor);
}
