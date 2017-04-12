package com.sca.patterns.visitor;

/**
 * Created by ZFTC0418 on 02/02/2015.
 */
public class GameInfo extends AbstractTitleInfo {
    public GameInfo(String titleName) {
        this.setTitleName(titleName);
    }

    @Override
    public void accept(TitleBlurbVisitor titleBlurbVisitor) {
        titleBlurbVisitor.visit(this);
    }
}
