package com.sca.patterns.visitor;

/**
 * Created by ZFTC0418 on 02/02/2015.
 */
public class DvdInfo extends AbstractTitleInfo {

    private String star;
    private char encodingRegion;

    public DvdInfo(String titleName,
                   String star,
                   char encodingRegion) {
        this.setTitleName(titleName);
        this.setStar(star);
        this.setEncodingRegion(encodingRegion);
    }

    public String getStar() {
        return this.star;
    }

    public void setStar(String starIn) {
        this.star = starIn;
    }

    public char getEncodingRegion() {
        return this.encodingRegion;
    }

    public void setEncodingRegion(char encodingRegionIn) {
        this.encodingRegion = encodingRegionIn;
    }

    @Override
    public void accept(TitleBlurbVisitor titleBlurbVisitor) {
        titleBlurbVisitor.visit(this);
    }
}
