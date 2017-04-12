package com.sca.jaxb;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * Created by ZFTC0418 on 03/03/2015.
 */
@XmlRootElement(name = "BatchSemiStructuredLine")
@XmlAccessorType(XmlAccessType.FIELD)
public class BatchSemiStructuredLine implements BatchEntity {
    /**
     * line4 attribute tag
     */
    public static final String LINE4_TAG = "line4";

    /**
     * line5 attribute tag
     */
    public static final String LINE5_TAG = "line5";

    /**
     * line6 attribute tag
     */
    public static final String LINE6_TAG = "line6";

    @XmlElement
    private String line4;

    @XmlElement
    private String line5;

    @XmlElement
    private String line6;

    public String getLine4() {
        return line4;
    }

    public void setLine4(final String line4) {
        this.line4 = line4;
    }

    public String getLine5() {
        return line5;
    }

    public void setLine5(final String line5) {
        this.line5 = line5;
    }

    public String getLine6() {
        return line6;
    }

    public void setLine6(final String line6) {
        this.line6 = line6;
    }

    @Override
    public String toString() {
        return "BatchSemiStructuredLine{" +
                "line4='" + line4 + '\'' +
                ", line5='" + line5 + '\'' +
                ", line6='" + line6 + '\'' +
                '}';
    }

    @Override
    public void setValuesFromCSV(final String[] values) {

    }
}
